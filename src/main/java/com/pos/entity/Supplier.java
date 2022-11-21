package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
    @Id
    private Integer supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_contact;
    private String contact_person;
    private String note;
}
