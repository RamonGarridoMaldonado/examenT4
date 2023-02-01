package com.rgarmal.exament4.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.exament4.model.Grupo;
import com.rgarmal.exament4.repository.GrupoRepository;
import com.rgarmal.exament4.services.*;


@Service
public class GruposServiceImpl implements GruposService {

    @Autowired
    GrupoRepository repository;

    @Override
    public List<Grupo> findAll() {
        return repository.findAll();

    }

    @Override
    public Grupo find(int codigo) {
        Optional<Grupo> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Grupo grupo) {
        repository.save(grupo);
        
    }

    @Override
    public void update(Grupo grupo) {
        repository.save(grupo);
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }
    
}
