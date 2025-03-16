package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Entity
@Data
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    private int maSach;
    @Column(name = "ten_Sach",length = 256)
    private String tenSach;
    @Column(name = "ten_tac_gia",length = 512)
    private String tenTacGia;
    @Column(name = "isbn",length = 256)
    private String ISBN;
    @Column(name = "mo_Ta", columnDefinition = "text")
    private String moTa;
    @Column(name = "gia_niem_yet")
    private double giaNiemYet;
    @Column(name = "gia_ban")
    private double giaBan;
    @Column(name = "so_luong")
    private int soLuong;
    @Column(name = "trung_binh_xep_hang")
    private double trungBinhXepHang;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "ma_sach"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")

    )
    List<TheLoai> danhSachTheLoai;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH,CascadeType.REMOVE
    })
    List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH,CascadeType.REMOVE
    })
    List<SuDanhGia> danhSachDanhGia;
    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    List<ChiTietDonHang> chiTietDonHang;
    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH,CascadeType.REMOVE
    })
    List<SachYeuThich> sachYeuThich;
}
