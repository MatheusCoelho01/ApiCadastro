package br.com.cadastrodepessoa.service.impl;

import br.com.cadastrodepessoa.entity.EnderecoEntity;
import br.com.cadastrodepessoa.repository.EnderecoRepository;
import br.com.cadastrodepessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public EnderecoEntity salvar(EnderecoEntity endereco) {
        return repository.findByNome("salvar");
    }

    @Transactional
    @Override
    public EnderecoEntity atualizar(Long id, EnderecoEntity endereco) {
        EnderecoEntity enderecoEntity = repository.findById(id).get();
        enderecoEntity.setId(endereco.getId() == null ? id : endereco.getId());
        return repository.findByNome("");
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EnderecoEntity buscar(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public EnderecoEntity buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }
}
