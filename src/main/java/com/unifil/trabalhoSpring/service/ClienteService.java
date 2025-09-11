package com.unifil.trabalhoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unifil.trabalhoSpring.repository.ClienteRepository;
import com.unifil.trabalhoSpring.repository.entity.Cliente;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    
    private ClienteRepository repository;
    
    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void createCliente(Cliente cliente) throws Exception {

        if(cliente.getCpf().isEmpty() || cliente.getEmail().isEmpty() || cliente.getSenha().isEmpty()){
            throw new Exception("Preencha todos os campos para validar o cliente!");
        }
        repository.save(cliente);
        
    }

    public Cliente searchCliente(String cpf) throws Exception {
        Cliente cliente = repository.findByCpf(cpf);
        if (cliente == null) {
            throw new Exception("Cliente não encontrado!");
        }
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public Cliente atualizarCliente(String cpf, Cliente cliente2) {
    Cliente cliente = repository.findByCpf(cpf);

    if (cliente == null) {
        throw new EntityNotFoundException("Cliente não encontrado!");
    }

    // Atualiza apenas os campos desejados
    cliente.setNome(cliente2.getNome());
    cliente.setEmail(cliente2.getEmail());
    cliente.setSenha(cliente2.getSenha());

    return repository.save(cliente);
    }
    
    public String apagarCliente(Long id) {
        try {
                repository.deleteById(id);
                return "Cliente eliminado com sucesso! rsts";
            }  catch (Exception e) {
                return "Não foi possivel eliminar o cliente";
            }
        }
    }

     
    

