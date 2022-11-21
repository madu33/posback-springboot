package com.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private Integer customer_id;
    private String customer_name;
    private String address;
    private Integer contact;
    private String membership_number;
    private String prod_name;
    private String expected_date;
    private String note;
}
