package com.tabeldata.springhibernatequis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "buku_tabungan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BukuTabungan {

    @Id
    @Column(name = "kode_transaksi")
    private String kode;

    @Column(name = "tanggal_transaksi")
    private Date tanggalTransaksi;

    @Column(name = "debet")
    private BigDecimal debet;

    @Column(name = "kredit")
    private BigDecimal kredit;

    @Column(name = "saldo")
    private BigDecimal saldo;
}
