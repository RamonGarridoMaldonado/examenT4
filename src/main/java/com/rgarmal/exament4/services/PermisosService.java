package com.rgarmal.exament4.services;
import com.rgarmal.exament4.model.*;
import java.util.List;

public interface PermisosService {
    public List<Permiso> findAll();
    public Permiso find(int codigo);
    public void save(Permiso permiso);
    public void update(Permiso permiso);
    public void delete(int codigo);
}
