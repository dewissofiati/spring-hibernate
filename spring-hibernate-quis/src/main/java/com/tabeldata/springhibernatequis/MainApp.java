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

//		SpringApplication.run(MainApp.class, args);

		ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class,args);

		ProdukTabunganDao bean = applicationContext.getBean(ProdukTabunganDao.class);
		bean.save(new ProdukTabungan(
			"001",
			"TabunganKu",
			3.5,
			new BigDecimal(1000),
			new BigDecimal(100000)
		));

		bean.save(new ProdukTabungan(
			"002",
			"Tabungan Mapan",
			4.0,
			new BigDecimal(4500),
			new BigDecimal(500000)
			));

		bean.save(new ProdukTabungan(
				"003",
				"Tabungan Umroh",
				2.5,
				new BigDecimal(100),
				new BigDecimal(100000)
		));

		NasabahDao beanNas = applicationContext.getBean(NasabahDao.class);
		beanNas.save(new Nasabah(
				"001",
				"Sulaeman Hasim",
				"Jl. Bojongsoang no 110",
				"Bandung",
				"Ciparay",
				"081123123543"
		));

		BukuTabunganDao beanBuk = applicationContext.getBean(BukuTabunganDao.class);
		List<BukuTabungan> listTransaksi = new ArrayList<>();

		BukuTabungan trans1 = new BukuTabungan(
				"001",
				LocalDate.of(2017,8,1),
				new BigDecimal(250000),
				BigDecimal.ZERO,
				new BigDecimal(250000)
		); trans1 = beanBuk.save(trans1);

		BukuTabungan trans2 = new BukuTabungan(
				"001",
				LocalDate.of(2017,8,20),
				new BigDecimal(250000),
				BigDecimal.ZERO,
				new BigDecimal(500000)
		); trans2 = beanBuk.save(trans2);

		BukuTabungan trans3 = new BukuTabungan(
				"001",
				LocalDate.of(2017,8,21),
				new BigDecimal(50000),
				BigDecimal.ZERO,
				new BigDecimal(550000)
		); trans3 = beanBuk.save(trans3);


		BukuTabungan trans4 = new BukuTabungan(
				"002",
				LocalDate.of(2017,8,21),
				BigDecimal.ZERO,
				new BigDecimal(250000),
				new BigDecimal(250000)
		); trans4 = beanBuk.save(trans4);


		listTransaksi.add(trans1);
		listTransaksi.add(trans2);
		listTransaksi.add(trans3);
		listTransaksi.add(trans4);
	}
}
