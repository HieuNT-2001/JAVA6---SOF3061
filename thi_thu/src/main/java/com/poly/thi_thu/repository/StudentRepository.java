package com.poly.thi_thu.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.thi_thu.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods can be defined here if needed
    @Query(value = "SELECT c.MaKhoaHoc, c.TenKhoaHoc, c.MoTa, c.NgayBatDau, c.NgayKetThuc, s.MaHocVien, s.TenHocVien "
            + "FROM HocVien s "
            + "JOIN KhoaHoc c "
            + "ON c.MaKHoaHoc = s.MaKHoaHoc ", nativeQuery = true)
    List<Map<String, Object>> getAllWithCourse();
}
