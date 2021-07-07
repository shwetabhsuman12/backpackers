package com.example.summary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.summary.model.Summary;

public interface SummaryInterface extends JpaRepository<Summary, String> {
	
}
