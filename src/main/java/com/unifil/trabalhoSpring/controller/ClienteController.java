package com.unifil.trabalhoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    //Rota para criar cliente
    @PostMapping("criarCliente")
    public String criarCliente(@RequestBody Cliente cliente) throws Exception {
        service.createCliente(cliente);
        return "Cliente criado com sucesso";
    }

    //Rota para procurar cliente com o cpf
    @GetMapping("procurarCliente/{cpf}")
    public Cliente procurarClientePorCpf(@PathVariable String cpf) throws Exception {
        return service.searchCliente(cpf);
    }

    //Rota para listar os clientes
    @GetMapping("listarClientes")
    public List<Cliente> listarClientes(){
        return service.listarClientes();
    }

    //Rota para atualizar os clientes via cpf
    @PutMapping("atualizarCliente/{cpf}")
    public Cliente atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente2) throws Exception {
    return service.atualizarCliente(cpf, cliente2);
    }

    //Rota para deletar um cliente via cpf
    @DeleteMapping("apagarCliente/{cpf}")
    public String apagarUSuario(@PathVariable String cpf) {
       return service.apagarCliente(cpf);
    }
}

    



    

