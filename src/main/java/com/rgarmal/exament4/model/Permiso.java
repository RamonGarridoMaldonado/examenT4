package com.rgarmal.exament4.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Permiso {
    @Id
    @GeneratedValue
    int codigo;

    String descripcion;

    @Transient
    private boolean perteneceUsuario;

    @ManyToMany(mappedBy = "permisos")
    private List<Usuario> usuarios;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPerteneceUsuario() {
        return perteneceUsuario;
    }

    public void setPerteneceUsuario(boolean perteneceUsuario) {
        this.perteneceUsuario = perteneceUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Permiso(int codigo) {
        this.codigo = codigo;
    }

    public Permiso() {
    }

    
}
