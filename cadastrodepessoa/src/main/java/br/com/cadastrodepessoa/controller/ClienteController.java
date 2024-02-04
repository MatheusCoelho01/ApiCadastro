package br.com.cadastrodepessoa.controller;

import br.com.cadastrodepessoa.entity.ClienteEntity;
import br.com.cadastrodepessoa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.Objects;

@RestController
@RequestMapping("/cadastro")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @PostMapping(path = "/nova-pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> salvar(@RequestBody ClienteEntity pessoa) {

        try {
            if (clienteService.salvar(pessoa) != null && Objects.nonNull(pessoa)) {
                return new ResponseEntity<>(clienteService.salvar(pessoa), HttpStatus.ACCEPTED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Objeto encontra-se nulo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/deletar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletar(@PathVariable(value = "id") Long id) {
        clienteService.deletar(id);
    }

    @GetMapping(path = "/buscar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteEntity buscar(@PathVariable(value = "id") Long id) {
        return clienteService.buscar(id);
    }

    @GetMapping(path = "/buscar-pessoa-nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteEntity buscar(@PathVariable(value = "nome") String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @PutMapping(path = "/atualizar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteEntity buscar(@PathVariable(value = "id") Long id, @RequestBody ClienteEntity pessoa) {
        return clienteService.atualizar(id, pessoa);
    }

}
