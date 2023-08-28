package br.com.crud.pessoa.repository;

import br.com.crud.pessoa.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Long> {

    PessoaEntity findByNome(String nome);
}
