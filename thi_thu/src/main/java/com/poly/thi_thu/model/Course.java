package com.poly.thi_thu.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore // Bỏ qua trường này khi trả về JSON
    private List<Student> students; // 1 khóa học có nhiều học viên

}
