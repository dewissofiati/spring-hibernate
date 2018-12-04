package com.tabeldata.springhibernatequis.repository;

import com.tabeldata.springhibernatequis.entity.ProdukTabungan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProdukTabunganDao {

    @Autowired
    private ProdukTabunganRepository repository;

    public ProdukTabungan save(ProdukTabungan pt){
        return repository.save(pt);
    }

    public Optional<ProdukTabungan> findById(Integer id){
        return repository.findById(id);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Iterable<ProdukTabungan> findAll(){
        return repository.findAll();
    }
}
