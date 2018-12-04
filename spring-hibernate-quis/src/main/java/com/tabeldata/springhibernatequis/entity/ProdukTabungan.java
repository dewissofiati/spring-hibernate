package com.tabeldata.springhibernatequis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produk_tabungan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdukTabungan {

    @Id
    @Column(name = "id_produk_tabungan", nullable = false)
    private String idProduk;

    @Column(name = "nama_tabungan", nullable = false, length = 50)
    private String namaTabungan;

    @Column(name = "bunga_per_anum")
    private double bungaPerAnum;

    @Column(name = "biaya_admin")
    private BigDecimal biayaAdmin;

    @Column(name = "setoran_awal_min")
    private BigDecimal setoranAwalMin;
}
