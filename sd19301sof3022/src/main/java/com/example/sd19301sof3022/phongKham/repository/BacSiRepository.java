package com.example.sd19301sof3022.phongKham.repository;

import com.example.sd19301sof3022.phongKham.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
    // Query method
    public List<BacSi> findBacSisByTenContainsOrderByLuongDesc(String ten);

    // @Query, JPQL
    @Query("""
            SELECT bs FROM BacSi bs
            WHERE bs.ten LIKE %:ten%
        """)
    public List<BacSi> timKiemTheoTen(@Param("ten") String ten);

    // Native query
    @Query(value = """
        SELECT * FROM bac_si bs 
        WHERE bs.ten LIKE %:ten%
        """, nativeQuery = true)
    public List<BacSi> timKiemTheoTenNative(@Param("ten") String ten);
}
