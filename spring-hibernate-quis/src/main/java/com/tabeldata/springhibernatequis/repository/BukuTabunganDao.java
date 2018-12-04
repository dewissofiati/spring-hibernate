package com.tabeldata.springhibernatequis.repository;

import com.tabeldata.springhibernatequis.entity.BukuTabungan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BukuTabunganDao {

    @Autowired
    private BukuTabunganRepository repository;

    public BukuTabungan save(BukuTabungan bt){
        return repository.save(bt);
    }

    public Optional<BukuTabungan> findById(Integer id){
        return repository.findById(id);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Iterable<BukuTabungan> findAll(){
        return repository.findAll();
    }
}
