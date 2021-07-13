package com.example.summary.controller;

import java.util.List;
import java.util.stream.Collectors;

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
	public ResponseEntity<Summary> getDescriptionById(@RequestHeader(required=true)String key)
	{
		
		List<Summary> summary=summaryInterface.findAll();
                Summary temp=null;
		for(int i=0;i < summary.size();i++)
                {
			if (summary.get(i).getKey().equalsIgnoreCase(key)){
                          temp=summary.get(i);
                          System.out.println(temp.toString());
                          break;
                        }
                }
		//List<Summary> result=summary.stream().filter(item ->item.getKey().equalsIgnoreCase(key)).collect(Collectors.toList());
		return new ResponseEntity<>(temp,HttpStatus.OK);
	}
	
	@PostMapping("/saveDetails")
	public void saveDetails(@RequestBody Summary summary)
	{
	
		summaryInterface.save(new Summary(summary.getKey(),summary.getDesc()));
	}
}
