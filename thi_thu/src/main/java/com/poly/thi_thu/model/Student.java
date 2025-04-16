package com.poly.thi_thu.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "HocVien")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHocVien")
    private int id;

    @Column(name = "TenHocVien")
    @NotBlank(message = "Full name is required")
    @NotNull(message = "Full name is required")
    private String fullname;

    @Column(name = "NgaySinh")
    @NotNull(message = "Date of birth is required")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name = "GioiTinh")
    private Boolean gender;

    @Column(name = "Email")
    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    private String email;

    @Column(name = "SoDienThoai")
    @NotBlank(message = "Phone number is required")
    @NotNull(message = "Phone number is required")
    private String phoneNumber;

    @Column(name = "DiaChi")
    @NotBlank(message = "Address is required")
    @NotNull(message = "Address is required")
    private String address;

    @ManyToOne()
    @JoinColumn(name = "MaKhoaHoc") // Khóa ngoại tham chiếu đến bảng KhoaHoc
    private Course course; // Khóa học mà học viên tham gia

}
