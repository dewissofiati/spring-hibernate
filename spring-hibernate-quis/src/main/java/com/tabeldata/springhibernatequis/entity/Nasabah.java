package com.tabeldata.springhibernatequis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nasabah")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nasabah {

    @Id
    @Column(name = "id_nasabah", nullable = false)
    private String id;

    @Column(name = "nama_nasabah", nullable = false, length = 100)
    private String nama;

    @Column(name = "alamat_nasabah")
    private String alamat;

    @Column(name = "kota")
    private String kota;

    @Column(name = "kecamatan")
    private String kecamatan;

    @Column(name = "no_hp")
    private String noHp;

    @OneToOne
    @JoinColumn(name = "id_produk_tabungan", nullable = false)
    private ProdukTabungan produkTabungan;

    @OneToMany
    @JoinTable(
            name = "transaksi",
            joinColumns = @JoinColumn(name = "id_nasabah", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "kode_transaksi", nullable = false)
)
    private List<BukuTabungan> listTransaksi = new ArrayList<>();

}
