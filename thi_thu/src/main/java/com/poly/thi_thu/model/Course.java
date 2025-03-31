package com.poly.thi_thu.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "KhoaHoc")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhoaHoc")
    private int id;

    @Column(name = "TenKhoaHoc")
    @NotBlank(message = "Course name is required")
    @NotNull(message = "Course name is required")
    private String name;

    @Column(name = "MoTa")
    @NotBlank(message = "Course description is required")
    @NotNull(message = "Course description is required")
    private String description;

    @Column(name = "NgayBatDau")
    @NotNull(message = "Start date is required")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "NgayKetThuc")
    @NotNull(message = "End date is required")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
