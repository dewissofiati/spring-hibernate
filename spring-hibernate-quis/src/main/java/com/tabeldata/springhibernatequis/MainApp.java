package com.tabeldata.springhibernatequis;

import com.tabeldata.springhibernatequis.entity.BukuTabungan;
import com.tabeldata.springhibernatequis.entity.Nasabah;
import com.tabeldata.springhibernatequis.entity.ProdukTabungan;
import com.tabeldata.springhibernatequis.repository.BukuTabunganDao;
import com.tabeldata.springhibernatequis.repository.NasabahDao;
import com.tabeldata.springhibernatequis.repository.ProdukTabunganDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class MainApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class,args);

		ProdukTabunganDao produkTabunganDao = applicationContext.getBean(ProdukTabunganDao.class);
		ProdukTabungan p001 = produkTabunganDao.save(
			new ProdukTabungan(
			"001",
			"TabunganKu",
			3.5,
			new BigDecimal(1000),
			new BigDecimal(100000)
		));

		ProdukTabungan p002 = produkTabunganDao.save(
			new ProdukTabungan(
			"002",
			"Tabungan Mapan",
			4.0,
			new BigDecimal(4500),
			new BigDecimal(500000)
			));

		ProdukTabungan p003 = produkTabunganDao.save(
			new ProdukTabungan(
			"003",
			"Tabungan Umroh",
			2.5,
			new BigDecimal(100),
			new BigDecimal(100000)
		));

		BukuTabunganDao bukuTabunganDao = applicationContext.getBean(BukuTabunganDao.class);
		List<BukuTabungan> listTransaksi = new ArrayList<>();

		BukuTabungan transaksi1 = new BukuTabungan(1,
				"001",
				LocalDate.of(2017,8,1),
				new BigDecimal(250000),
				BigDecimal.ZERO,
				new BigDecimal(250000)
		); transaksi1 = bukuTabunganDao.save(transaksi1);

		BukuTabungan transaksi2 = new BukuTabungan(2,
				"001",
				LocalDate.of(2017,8,20),
				new BigDecimal(250000),
				BigDecimal.ZERO,
				new BigDecimal(500000)
		); transaksi2 = bukuTabunganDao.save(transaksi2);

		BukuTabungan transaksi3 = new BukuTabungan(3,
				"001",
				LocalDate.of(2017,8,21),
				new BigDecimal(50000),
				BigDecimal.ZERO,
				new BigDecimal(550000)
		); transaksi3 = bukuTabunganDao.save(transaksi3);


		BukuTabungan transaksi4 = new BukuTabungan(4,
				"002",
				LocalDate.of(2017,8,21),
				BigDecimal.ZERO,
				new BigDecimal(250000),
				new BigDecimal(250000)
		); transaksi4 = bukuTabunganDao.save(transaksi4);


		listTransaksi.add(transaksi1);
		listTransaksi.add(transaksi2);
		listTransaksi.add(transaksi3);
		listTransaksi.add(transaksi4);
		
		NasabahDao nasabahDao = applicationContext.getBean(NasabahDao.class);
		nasabahDao.save(new Nasabah(
				"001",
				"Sulaeman Hasim",
				"Jl. Bojongsoang no 110",
				"Bandung",
				"Ciparay",
				"081123123543",
			p001,
			listTransaksi
		));
	}
}
