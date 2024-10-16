package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PincodeInfo;

public interface PincodeInfoRepository extends JpaRepository<PincodeInfo, Long> {
    Optional<PincodeInfo> findByPincodeAndDate(String pincode, LocalDate date);
}
