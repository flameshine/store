package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * Category entity.
 */

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends Persistable implements Serializable {

    private static final long serialVersionUID = -4767042454855773193L;

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;
}