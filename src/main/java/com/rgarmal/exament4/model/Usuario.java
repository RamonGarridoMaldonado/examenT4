package com.rgarmal.exament4.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.MapsId;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    int codigo;

    @Column(unique=true)
    String nombre;

    @Column(unique=true)
    String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @MapsId("producto_codigo")
    private Grupo grupo;

    @ManyToMany
	@JoinTable(
		name="usuario_permiso"
		, joinColumns={
			@JoinColumn(name="usuario_codigo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permiso_codigo")
			}
		)
    private List<Permiso> permisos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }   
}
