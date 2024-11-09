package br.com.cadastrodepessoa.repository;

import br.com.cadastrodepessoa.entity.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
