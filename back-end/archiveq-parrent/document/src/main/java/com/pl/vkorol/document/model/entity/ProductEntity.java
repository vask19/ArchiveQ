package com.pl.vkorol.document.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "products")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends Product{
    @Id
    @GeneratedValue(generator = "products_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "products_id_seq",sequenceName = "products_id_seq", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_parameters")
    private Category category;

    public ProductEntity(long id, String uid, boolean activate, String name, String mainDesc, String descHtml, float price, String[] imageUrls, String parameters, LocalDate createAt, Category category) {
        super(uid, activate, name, mainDesc, descHtml, price, imageUrls, parameters, createAt);
        this.category = category;
        this.id = id;
    }
}
