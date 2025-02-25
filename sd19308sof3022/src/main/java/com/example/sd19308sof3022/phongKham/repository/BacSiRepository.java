package com.example.sd19308sof3022.phongKham.repository;

import com.example.sd19308sof3022.phongKham.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
    // Query method
    public List<BacSi> findBacSisByTenContainsOrderByLuongDesc(String ten);

    //Query, JPQL
    @Query(value = """
            SELECT bs FROM BacSi bs
            WHERE bs.luong < :max AND bs.luong > :min
            """)
    public List<BacSi> timKiemTheoKhoangLuong(@Param("min") Integer min,@Param("max") Integer max);

    //Query, Native query
    @Query(value = """
                SELECT * FROM bac_si
                WHERE luong < :max AND luong > :min
            """, nativeQuery = true)
    public List<BacSi> timKiemTheoKhoangLuongNative(@Param("min") Integer min, @Param("max") Integer max);
}
