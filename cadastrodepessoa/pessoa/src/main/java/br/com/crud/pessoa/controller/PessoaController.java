package br.com.crud.pessoa.controller;

import br.com.crud.pessoa.entity.PessoaEntity;
import br.com.crud.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(path = "/nova-pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> salvar(@RequestBody PessoaEntity pessoa) {

        try {
            if (pessoaService.salvar(pessoa) != null && Objects.nonNull(pessoa)) {
                return new ResponseEntity<>(pessoaService.salvar(pessoa),HttpStatus.ACCEPTED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Objeto encontra-se nulo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/deletar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletar(@PathVariable(value = "id") Long id) {
        pessoaService.deletar(id);
    }

    @GetMapping(path = "/buscar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaEntity buscar(@PathVariable(value = "id") Long id) {
        return pessoaService.buscar(id);
    }

    @GetMapping(path = "/buscar-pessoa-nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaEntity buscar(@PathVariable(value = "nome") String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    @PutMapping(path = "/atualizar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaEntity buscar(@PathVariable(value = "id") Long id, @RequestBody PessoaEntity pessoa) {
        return pessoaService.atualizar(id, pessoa);
    }
}
