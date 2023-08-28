package br.com.crud.pessoa.controller;

import br.com.crud.pessoa.BaseTestes;
import br.com.crud.pessoa.service.PessoaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class PessoaControllerTest extends BaseTestes {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaService pessoaService;

    @Test
    public void teste_salvar_sucesso() {
        Mockito.when(pessoaService.salvar(Mockito.any())).thenReturn(mockPessoaEntity());
        ResponseEntity result = pessoaController.salvar(mockPessoaEntity());
        assertTrue(result.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void teste_salvar_error() {
        Mockito.when(pessoaService.salvar(null)).thenReturn(null);
        ResponseEntity result = pessoaController.salvar(null);
        assertTrue(result.getStatusCode().is4xxClientError());
    }

    @Test
    public void teste_salvar_error_internal_server_error() {
        Mockito.when(pessoaService.salvar(Mockito.any())).thenThrow(NullPointerException.class);
        ResponseEntity result = pessoaController.salvar(null);
        Assert.assertEquals("Objeto encontra-se nulo.", result.getBody());
        assertTrue(result.getStatusCode().is5xxServerError());
    }
}
