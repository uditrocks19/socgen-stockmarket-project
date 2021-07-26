package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.StockPrice;
import repositories.StockPriceRepository;

@Service
public class StockPriceService {

    @Autowired
    public StockPriceRepository stockPriceRepository;

    public List<StockPrice> getStockPrice(){
        return stockPriceRepository.findAll();
    }

    public List<ExcelDataDto> addStockPrice(List<ExcelDataDto> excelDataDto) {
        List<ExcelDataDto> failedInserts = new ArrayList<>();
        for(ExcelDataDto excelData: excelDataDto) {
            try {
                stockPriceRepository.addStockPrice(excelData.getCompanyId(), excelData.getExchangeId(), excelData.getPrice(), excelData.getTimestamp());
            }
            catch(Exception e) {
                failedInserts.add(excelData);
            }
        }
        return failedInserts;
    }

    public List<StockPrice> getStockPrice(int companyId, int stockId, String fromTime, String toTime){
        return stockPriceRepository.getStockPriceList(companyId, stockId, fromTime, toTime);
    }
}