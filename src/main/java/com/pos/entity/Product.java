package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer product_id;
    private Integer product_code;
    private String gen_name;
    private String product_name;
    private Double cost;
    private Double a_price;
    private Double price;
    private Double profit;
    private String supplier;
    private Integer onHand_qty;
    private Integer qty;
    private Integer qty_sold;
    private String expiry_date;
    private String date_arrival;
}
