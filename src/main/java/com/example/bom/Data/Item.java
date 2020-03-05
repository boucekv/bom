package com.example.bom.Data;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "my_item")
@Data
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    Long id;

    @Column(name = "item_name")
    String name;

    @Column(name = "description")
    String description;

    //todo add list of boms
}
