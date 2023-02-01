package com.rgarmal.exament4.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rgarmal.exament4.model.Permiso;
import com.rgarmal.exament4.model.Usuario;
import com.rgarmal.exament4.repository.PermisoRepository;
import com.rgarmal.exament4.repository.UsuarioRepository;
import com.rgarmal.exament4.services.*;

@Service
public class PermisosServiceImpl implements PermisosService {

    @Autowired
    PermisoRepository repository;

    @Override
    public List<Permiso> findAll() {
        return repository.findAll();
    }

    @Override
    public Permiso find(int codigo) {
        Optional<Permiso> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Permiso permiso) {
        repository.save(permiso);
        
    }

    @Override
    public void update(Permiso permiso) {
        repository.save(permiso);        
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
        
    }

    
    
}
