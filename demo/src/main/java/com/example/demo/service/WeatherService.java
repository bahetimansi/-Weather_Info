package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LatLong;
import com.example.demo.model.PincodeInfo;
import com.example.demo.model.WeatherApiResponse;
import com.example.demo.model.WeatherInfo;
import com.example.demo.repository.PincodeInfoRepository;
import com.example.demo.repository.WeatherInfoRepository;

@Service
public class WeatherService {

	@Autowired
	private PincodeInfoRepository pincodeInfoRepository;

	@Autowired
	private WeatherInfoRepository weatherInfoRepository;

	@Autowired
	private ExternalApiService externalApiService; // Service for handling external API

	public List<WeatherInfo> getWeather(String pincode, LocalDate forDate) {
		// 1. Check if weather info already exists in DB
		Optional<PincodeInfo> pincodeInfoOpt = pincodeInfoRepository.findByPincodeAndDate(pincode, forDate);
		if (pincodeInfoOpt.isPresent()) {
			return weatherInfoRepository.findByPincodeInfo(pincodeInfoOpt.get());
		}

		// 2. Get lat/long via external API (Google Maps/Geocoding API)
		LatLong latLong = externalApiService.getLatLongForPincode(pincode);
		PincodeInfo pincodeInfo = new PincodeInfo(pincode, latLong.getLatitude(), latLong.getLongitude(), forDate);
		pincodeInfoRepository.save(pincodeInfo);

		// 3. Fetch weather from OpenWeather API using lat/long
		WeatherApiResponse weatherResponse = externalApiService.getWeatherForLatLong(latLong.getLatitude(),
				latLong.getLongitude(), forDate);
		WeatherInfo weatherInfo = new WeatherInfo(weatherResponse.getMain().getTemp(), weatherResponse.getMain().getHumidity(),
				weatherResponse.getWeather().get(0).getDescription(), pincodeInfo);
		List<WeatherInfo> list = new ArrayList<>();
		list.add(weatherInfo);
		weatherInfoRepository.save(weatherInfo);

		return list;
	}
}
