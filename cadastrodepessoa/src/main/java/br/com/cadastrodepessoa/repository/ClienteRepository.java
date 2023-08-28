package br.com.cadastrodepessoa.repository;

import br.com.cadastrodepessoa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


    ClienteEntity findByNome(String nome);


}
