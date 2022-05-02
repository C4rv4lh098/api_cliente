package com.api_cliente.api_cliente.domain.repository;

import com.api_cliente.api_cliente.domain.entiy.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
