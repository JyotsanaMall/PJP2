package com.sapient.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.calculator.entity.DayOfWeek;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long>{

}
