package com.Group3tatastrive.VetPawtner.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")  // matching your table name
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(name = "product_name")
    private String name;
    @Column(columnDefinition = "Text")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(columnDefinition = "INT default 0")
    private int stock=0;
    @Column(length = 50)
    private String category;
    @Column(name = "imageurl" ,length = 255)
    private String image_url;


}

