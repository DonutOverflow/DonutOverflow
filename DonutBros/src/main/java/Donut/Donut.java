package Donut;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Donut {
    @Id
    @SequenceGenerator(
            name = "Donut_sequence",
            sequenceName = "Donut_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Donut_sequence"
    )
    private Long id;
    private String type;
    private String size;
    private Float price;

    public Donut() {
    }
    public Donut(Long id, String type, String size, Float price) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public Float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
