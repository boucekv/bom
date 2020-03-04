package com.example.bom.Data;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "my_bom")
@Data
public class Bom {

    @Id
    @GeneratedValue
    @Column(name = "bom_id")
    Long id;

    @Column(name = "bom_name")
    String name;

    @Column(name = "quantity")
    Integer quantity;

    //todo add parent id
    //todo add child id
}

