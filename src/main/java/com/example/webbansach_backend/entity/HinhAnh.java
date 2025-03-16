package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Entity
@Data
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_anh")
    private int maHinhAnh;
    @Column(name = "ten_hinh_anh",length = 256)
    private String tenHinhAnh;
    @Column(name = "la_icon",length = 256)
    private boolean laIcon;
    @Column(name = "duong_dan")
    private String duongDan;
    @Column(name = "du_lieu_anh")
    @Lob
    private String duLieuAnh;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinColumn(name = "ma_sach",nullable = false)//Quyển sách không bao giờ được null
    private Sach sach;
}
