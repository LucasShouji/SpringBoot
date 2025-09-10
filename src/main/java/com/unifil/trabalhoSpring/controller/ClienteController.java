package com.unifil.trabalhoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.trabalhoSpring.repository.entity.Cliente;
import com.unifil.trabalhoSpring.service.ClienteService;

@RestController
@RequestMapping("clientes/")
public class ClienteController {
    
    private ClienteService service;

    @Autowired
    public ClienteController(ClienteService service){
        this.service = service;
    }

    @PostMapping("criarCliente")
    public String criarCliente(@RequestBody Cliente cliente) throws Exception {
        service.createCliente(cliente);
        return "Cliente criado com sucesso";
    }

    @GetMapping("procurarCliente/{cpf}")
    public Cliente procurarClientePorCpf(@PathVariable String cpf) throws Exception {
        return service.searchCliente(cpf);
    }

    @GetMapping("listarClientes")
    public List<Cliente> listarClientes(){
        return service.listarClientes();
    }

    @PutMapping("atualizarCliente/{cpf}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente2){
        try {
            Cliente cliente = service.atualizarCliente(cpf, cliente2);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}

    

