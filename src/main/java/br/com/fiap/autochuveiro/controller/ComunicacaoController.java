package br.com.fiap.autochuveiro.controller;

import br.com.fiap.autochuveiro.business.CalculoChuveiro;
import br.com.fiap.autochuveiro.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComunicacaoController {

    @Autowired
    private ConsumoRepository repository;

    @GetMapping("/chuveiro/{tempo}")
    public void detalhesCadastro(@PathVariable("tempo") long tempo) {
        CalculoChuveiro novoCalc = new CalculoChuveiro(String.valueOf(tempo));
        System.out.println("OK PREENCHIDO DB");

        repository.save(novoCalc.consumoCalculado());
    }
}
