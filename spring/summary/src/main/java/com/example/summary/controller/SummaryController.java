package com.example.summary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.summary.model.Summary;
import com.example.summary.repository.SummaryInterface;

@CrossOrigin(origins="http://localhost:5000")
@RestController
public class SummaryController {

	@Autowired
	SummaryInterface summaryInterface;
	
	@GetMapping("/getsummary")
	public ResponseEntity<List<Summary>> getDescription(@RequestHeader(required=true)String key)
	{
		
		List<Summary> summary=summaryInterface.findAll();
		return new ResponseEntity<>(summary,HttpStatus.OK);
	}
	
	@PostMapping("/saveDetails")
	public void saveDetails(@RequestBody Summary summary)
	{
	
		summaryInterface.save(new Summary(summary.getKey(),summary.getDesc()));
	}
}
