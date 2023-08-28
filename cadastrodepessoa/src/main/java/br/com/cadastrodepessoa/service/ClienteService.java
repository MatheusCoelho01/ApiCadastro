package br.com.cadastrodepessoa.service;

import br.com.cadastrodepessoa.entity.ClienteEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {


    ClienteEntity salvar(ClienteEntity pessoa);

    ClienteEntity atualizar(Long id, ClienteEntity pessoa);

    void deletar(Long id);

    ClienteEntity buscar(Long id);

    ClienteEntity buscarPorNome(String nome);
}

