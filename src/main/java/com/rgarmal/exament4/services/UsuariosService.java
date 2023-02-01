package com.rgarmal.exament4.services;
import com.rgarmal.exament4.model.*;
import java.util.List;

public interface UsuariosService {
    public List<Usuario> findAll();
    public Usuario find(int codigo);
    public void save(Usuario Departamento);
    public void update(Usuario Departamento);
    public void delete(int codigo);
}
