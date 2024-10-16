package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PincodeInfo;
import com.example.demo.model.WeatherInfo;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {
    List<WeatherInfo> findByPincodeInfo(PincodeInfo pincodeInfo);
}
