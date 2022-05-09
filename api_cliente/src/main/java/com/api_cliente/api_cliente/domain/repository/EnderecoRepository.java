package com.api_cliente.api_cliente.domain.repository;

import com.api_cliente.api_cliente.domain.entiy.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{
    
}
