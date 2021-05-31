package br.com.fiap.autochuveiro.controller;

import br.com.fiap.autochuveiro.business.CalculoChuveiro;
import br.com.fiap.autochuveiro.model.Cadastro;
import br.com.fiap.autochuveiro.model.Consumo;
import br.com.fiap.autochuveiro.repository.CadastroRepository;
import br.com.fiap.autochuveiro.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private ConsumoRepository repository;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");

           Iterable<Consumo> listConsumo = repository.findAll();
           mv.addObject("lista", listConsumo);

         return mv;
    }



}
