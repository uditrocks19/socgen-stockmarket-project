package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dto.ExcelDataDto;

@RestController
@RequestMapping("/excel")
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