package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.GeocodeResponse;
import com.example.demo.model.LatLong;
import com.example.demo.model.WeatherApiResponse;

@Service
public class ExternalApiService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.openweather.key}")
	private String externalApiKey;

	public LatLong getLatLongForPincode(String pincode) {
		// Call OpenWeather Geocoding API
		
		String apiUrl = "https://api.openweathermap.org/geo/1.0/zip?zip=" + pincode + ",IN&appid=" + externalApiKey;
		ResponseEntity<GeocodeResponse> response = restTemplate.getForEntity(apiUrl, GeocodeResponse.class);
		return new LatLong(response.getBody().getLat(), response.getBody().getLon());
	}

	public WeatherApiResponse getWeatherForLatLong(double lat, double lon, LocalDate date) {
		String weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
				+ "&appid={API_KEY}";
		ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(weatherApiUrl,
				WeatherApiResponse.class);
		return response.getBody();
	}
}
