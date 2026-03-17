package com.tienda2.controller;

import com.tienda2.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final CategoriaService categoriaService;

    public ConsultaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

@GetMapping("/listado")
public String listado(Model model) {
    return "/consultas/listado";
}

@GetMapping("/inactivas")
public String inactivas(Model model) {
    var categorias = categoriaService.consultaDerivada();
    model.addAttribute("categorias", categorias);
    return "/consultas/listado";
}

    
}
