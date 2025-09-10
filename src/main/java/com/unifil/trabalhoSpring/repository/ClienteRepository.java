package com.unifil.trabalhoSpring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.unifil.trabalhoSpring.repository.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public Cliente findByEmail(String email);
    public Cliente findByCpf(String cpf);
    public List<Cliente> findAll();
}
