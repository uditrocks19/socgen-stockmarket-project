package com.stockapp.companyservice.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapp.companyservice.dtos.ExcelDataDto;
import com.stockapp.companyservice.entities.StockPrice;
import com.stockapp.companyservice.repositories.CompanyRepository;
import com.stockapp.companyservice.repositories.StockExchangeRepository;
import com.stockapp.companyservice.repositories.StockPriceRepository;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockPriceService {

    @Autowired
    public StockPriceRepository stockPriceRepository;

    @Autowired
    public StockExchangeRepository stockExchangeRepository;

    @Autowired
    public CompanyRepository companyRepository;

    public List<StockPrice> getStockPrice(){
        return stockPriceRepository.findAll();
    }

    public List<ExcelDataDto> addStockPrice(List<ExcelDataDto> excelDataDto) {
        List<ExcelDataDto> failedInserts = new ArrayList<>();
        for(ExcelDataDto excelData: excelDataDto) {
            try {
                StockPrice stockPrice= new StockPrice();
                stockPrice.setPrice(excelData.getPrice());
                stockPrice.setDate(excelData.getDate());
                stockPrice.setStockExchange(stockExchangeRepository.findByName(excelData.getStockExchangeName()).get());
                stockPrice.setCompany(companyRepository.findByCompanyCode(excelData.getCompanyCode()).get());
                stockPriceRepository.save(stockPrice);
            }
            catch(Exception e) {
                failedInserts.add(excelData);
            }
        }
        return failedInserts;
    }


    public List<StockPrice> getStockPricesForCompanyComparison(int companyId, int stockExchangeId, String from, String to)
            throws ParseException, ParseException {
        Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(from);
        Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(to);
        List<StockPrice> stockPrices = stockPriceRepository
                .findByCompanyIdAndStockExchangeId(companyId, stockExchangeId);
        return stockPrices.stream()
                .filter(stockPrice -> {
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("dd-MM-yyyy").parse(stockPrice.getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    assert date != null;
                    return date.after(fromDate) && date.before(toDate);
                })
                .collect(Collectors.toList());
    }

    public Boolean deleteByStockId(int id)
    {
        if(stockPriceRepository.findById(id).isPresent())
        {
            stockPriceRepository.deleteById(id);
            return true;
        }
        return false;
    }


}