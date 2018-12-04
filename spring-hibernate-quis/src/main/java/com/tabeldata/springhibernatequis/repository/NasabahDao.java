package com.tabeldata.springhibernatequis.repository;

import com.tabeldata.springhibernatequis.entity.Nasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class NasabahDao {

    @Autowired
    private NasabahRepository repository;

    public Nasabah save(Nasabah n){
        return repository.save(n);
    }

    public Optional<Nasabah> findById(String id){
        return repository.findById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public Iterable<Nasabah> findAll(){
        return repository.findAll();
    }
}
