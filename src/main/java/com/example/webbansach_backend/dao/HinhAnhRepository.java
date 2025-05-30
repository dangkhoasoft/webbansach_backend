package com.example.webbansach_backend.dao;

import com.example.webbansach_backend.entity.DonHang;
import com.example.webbansach_backend.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Integer> {
}
