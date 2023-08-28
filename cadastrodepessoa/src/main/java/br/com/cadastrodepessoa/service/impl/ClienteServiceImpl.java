package br.com.cadastrodepessoa.service.impl;

import br.com.cadastrodepessoa.entity.ClienteEntity;
import br.com.cadastrodepessoa.repository.ClienteRepository;
import br.com.cadastrodepessoa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteEntity salvar(ClienteEntity pessoa) {
        return clienteRepository.saveAndFlush(pessoa);
    }

    @Transactional
    @Override
    public ClienteEntity atualizar(Long id, ClienteEntity pessoa) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).get();
        clienteEntity.setId(pessoa.getId() == null ? id : pessoa.getId());
        clienteEntity.setNome(pessoa.getNome());
        return clienteRepository.saveAndFlush(clienteEntity);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteEntity buscar(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public ClienteEntity buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
