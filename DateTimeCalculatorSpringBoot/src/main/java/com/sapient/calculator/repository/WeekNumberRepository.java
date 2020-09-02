package com.sapient.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.calculator.entity.WeekNumber;

@Repository
public interface WeekNumberRepository extends JpaRepository<WeekNumber, Long> {

}
