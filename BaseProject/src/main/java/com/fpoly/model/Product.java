package com.fpoly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products") // Chỉ định tên bảng là "products"
@Data
@Builder
@NoArgsConstructor // Đảm bảo JPA có thể tạo đối tượng qua reflection
@AllArgsConstructor // Cung cấp constructor đầy đủ cho builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name is not blank")
    private String name;

    @NotNull(message = "price is not null")
    @Min(value = 0, message = "price >= 0")
    private Double price;
}