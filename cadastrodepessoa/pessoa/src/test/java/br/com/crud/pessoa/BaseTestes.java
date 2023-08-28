package br.com.crud.pessoa;

import br.com.crud.pessoa.entity.PessoaEntity;

public abstract class BaseTestes {

    protected PessoaEntity mockPessoaEntity() {
        PessoaEntity pessoa = PessoaEntity
                .builder()
                .id(1L)
                .nome("Juan Teste")
                .build();
        return pessoa;
    }
}
