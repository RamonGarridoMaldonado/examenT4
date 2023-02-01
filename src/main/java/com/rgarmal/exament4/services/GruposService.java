package com.rgarmal.exament4.services;
import com.rgarmal.exament4.model.*;
import java.util.List;

public interface GruposService {
    public List<Grupo> findAll();
    public Grupo find(int codigo);
    public void save(Grupo grupo);
    public void update(Grupo grupo);
    public void delete(int codigo);
}
