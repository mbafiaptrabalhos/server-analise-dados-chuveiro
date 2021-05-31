package br.com.fiap.autochuveiro.repository;

import br.com.fiap.autochuveiro.model.Cadastro;
import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository<Cadastro, Long> {

    Cadastro findByCodigo(long codigo);
}
