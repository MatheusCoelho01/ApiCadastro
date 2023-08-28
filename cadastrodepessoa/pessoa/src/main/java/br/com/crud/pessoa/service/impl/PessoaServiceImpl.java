package br.com.crud.pessoa.service.impl;

import br.com.crud.pessoa.entity.PessoaEntity;
import br.com.crud.pessoa.repository.PessoaRepository;
import br.com.crud.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public PessoaEntity salvar(PessoaEntity pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    @Transactional
    @Override
    public PessoaEntity atualizar(Long id, PessoaEntity pessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).get();
        pessoaEntity.setId(pessoa.getId() == null ? id : pessoa.getId());
        pessoaEntity.setNome(pessoa.getNome());
        return pessoaRepository.saveAndFlush(pessoaEntity);
    }

    @Override
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public PessoaEntity buscar(Long id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    public PessoaEntity buscarPorNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }
}
