package entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockPrice {

    @Id
    @GeneratedValue
    private int id;

    private double price;

    private Timestamp timestamp;

    @ManyToOne
    private Stock stock;

    public StockPrice() {
        super();
    }

    public StockPrice( double price, Timestamp timestamp, Stock stock) {
        super();
       
        this.price = price;
        this.timestamp = timestamp;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

  

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}