package br.com.cadastrodepessoa.service;

import br.com.cadastrodepessoa.entity.EnderecoEntity;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService {

    EnderecoEntity salvar(EnderecoEntity endereco);

    EnderecoEntity atualizar(Long id, EnderecoEntity pessoa);

    void deletar(Long id);

    EnderecoEntity buscar(Long id);

    EnderecoEntity buscarPorNome(String nome);
}
