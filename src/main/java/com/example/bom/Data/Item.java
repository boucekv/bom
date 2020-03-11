package com.example.bom.Data;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "my_item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    Long id;

    @Column(name = "item_name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    List<Bom> boms = new ArrayList<>();
}
