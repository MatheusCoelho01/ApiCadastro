package br.com.cadastrodepessoa.controller;

import br.com.cadastrodepessoa.entity.EnderecoEntity;
import br.com.cadastrodepessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



import java.util.Objects;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Qualifier("enderecoServiceImpl")
    @Autowired
    private EnderecoService service;

    @PostMapping(path = "/novo-endereco", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> salvar(@RequestBody EnderecoEntity endereco) {

        try {
            if (service.salvar(endereco) != null && Objects.nonNull(endereco)) {
                return new ResponseEntity<>(service.salvar(endereco), HttpStatus.ACCEPTED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Objeto encontra-se nulo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/deletar-endereco/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletar(@PathVariable(value = "id") Long id) {
        service.deletar(id);
    }

    @GetMapping(path = "/buscar-endereco/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoEntity buscar(@PathVariable(value = "id") Long id) {
        return service.buscar(id);
    }

    @GetMapping(path = "/buscar-pessoa-nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoEntity buscar(@PathVariable(value = "nome") String nome) {
        return service.buscarPorNome(nome);
    }

    @PutMapping(path = "/atualizar-pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoEntity buscar(@PathVariable(value = "id") Long id, @RequestBody EnderecoEntity endereco) {
        return service.atualizar(id, endereco);
    }

}
