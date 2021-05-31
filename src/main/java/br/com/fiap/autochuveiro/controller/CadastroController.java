package br.com.fiap.autochuveiro.controller;

import br.com.fiap.autochuveiro.model.Cadastro;
import br.com.fiap.autochuveiro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @RequestMapping(value = "/preencherCadastro", method = RequestMethod.GET)
    public String form() {
        return "form/cadastro";
    }

    @RequestMapping(value = "/preencherCadastro", method = RequestMethod.POST)
    public String form(Cadastro cadastro) {

        repository.save(cadastro);
        return "redirect:/preencherCadastro";
    }

    @RequestMapping("/cadastro")
    public ModelAndView listaCadastros() {
        ModelAndView mv = new ModelAndView("form/detalheCadastros");

        Iterable<Cadastro> cadastros = repository.findAll();
        mv.addObject("cadastros", cadastros);

        return mv;
    }

    @RequestMapping("/{codigo}")
    public ModelAndView detalhesCadastro(@PathVariable("codigo") long codigo) {
        Cadastro cadastro = repository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("cadastro/detalheCadastro");
        mv.addObject("cadastro", cadastro);

        return mv;
    }
}
