package com.rgarmal.exament4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import com.rgarmal.exament4.model.*;
import com.rgarmal.exament4.services.GruposService;
import com.rgarmal.exament4.services.PermisosService;
import com.rgarmal.exament4.services.UsuariosService;
import java.util.ArrayList;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuariosService usuariosService;

    @Autowired
    GruposService gruposService;

    @Autowired 
    PermisosService permisosService;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        List<Usuario> usuarios = usuariosService.findAll();
        ModelAndView modelAndView = new ModelAndView("Usuarios/list");
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
        @PathVariable(name = "codigo", required = true) int codigo) {
            
        Usuario usuario = usuariosService.find(codigo);
        List<Grupo> grupos = gruposService.findAll();
        
        List<Permiso> permisos = permisosService.findAll();
        for (Permiso permiso : permisos) {
            if (usuario.getPermisos().contains(permiso)){
                permiso.setPerteneceUsuario(true);
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("grupos", grupos);
        modelAndView.addObject("permisos", permisos);

        modelAndView.setViewName("Usuarios/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Usuario usuario) {
        List<Permiso> permisos = permisosService.findAll();
        List<Grupo> grupos = gruposService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("permisos", permisos);
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("Usuarios/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Usuario usuario) {

        usuariosService.save(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario, @RequestParam(value="ck_permisos") int[] ck_permisos,HttpServletRequest request) {

        List<Permiso> permisos = usuario.getPermisos();
        if(permisos == null){
            permisos = new ArrayList<Permiso>();
        }

        for (int i : ck_permisos) {
            Permiso p = new Permiso(i);
            permisos.add(p);
        }
        String grupoSeleccionado= request.getParameter("sl_grupos");
        Grupo g = new Grupo(Integer.parseInt(grupoSeleccionado));

        usuario.setPermisos(permisos);
        usuario.setGrupo(g);
        usuariosService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }


    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        usuariosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
