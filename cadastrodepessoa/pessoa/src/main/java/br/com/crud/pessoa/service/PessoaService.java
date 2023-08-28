package br.com.crud.pessoa.service;

import br.com.crud.pessoa.entity.PessoaEntity;

public interface PessoaService {

    PessoaEntity salvar(PessoaEntity pessoa);

    PessoaEntity atualizar(Long id, PessoaEntity pessoa);

    void deletar(Long id);

    PessoaEntity buscar(Long id);

    PessoaEntity buscarPorNome(String nome);
}
