package com.sapient.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.calculator.entity.DateFromPhrase;

@Repository
public interface DateFromPhraseRepository extends JpaRepository<DateFromPhrase, Long> {

}
