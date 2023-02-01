package com.rgarmal.exament4.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rgarmal.exament4.model.Usuario;
import com.rgarmal.exament4.repository.UsuarioRepository;
import com.rgarmal.exament4.services.*;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario find(int codigo) {
        Optional<Usuario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
        
    }

    @Override
    public void update(Usuario usuario) {
        repository.save(usuario);        
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
        
    }
    
}
