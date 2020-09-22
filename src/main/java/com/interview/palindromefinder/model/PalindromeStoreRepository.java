package com.interview.palindromefinder.model;

import com.interview.palindromefinder.domain.PalindromeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalindromeStoreRepository extends JpaRepository<PalindromeEntity, Integer> {
}
