package com.udit.excelservice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.udit.excelservice.dto.ExcelDataDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
@CrossOrigin(origins = "http://localhost:4200")
public class ExcelController {


    @PostMapping("/stock")
    public ResponseEntity addStockPrice(@RequestBody List<ExcelDataDto> excelDataDtos){
        String url = "http://localhost:9191/company/company/StockPrice";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList failedRequests = restTemplate.postForEntity(url, excelDataDtos, ArrayList.class).getBody();
        assert failedRequests != null;
        return failedRequests.size()==0? ResponseEntity.ok(failedRequests): ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failedRequests);
    }
}