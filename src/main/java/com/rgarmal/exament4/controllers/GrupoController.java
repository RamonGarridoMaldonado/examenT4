package com.rgarmal.exament4.controllers;

import java.util.List;

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

import com.rgarmal.exament4.model.*;
import com.rgarmal.exament4.services.GruposService;

@Controller
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    GruposService gruposService;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        List<Grupo> grupos = gruposService.findAll();
        ModelAndView modelAndView = new ModelAndView("Grupos/list");
        modelAndView.addObject("grupos", grupos);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Grupo grupo = gruposService.find(codigo);
        List<Usuario> usuarios = grupo.getUsuarios();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", grupo);
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.setViewName("Grupos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Grupo grupo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", new Grupo());
        modelAndView.setViewName("Grupos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Grupo grupo) {

        gruposService.save(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Grupo grupo) {

        gruposService.update(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());
        return modelAndView;
    }


    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        gruposService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
