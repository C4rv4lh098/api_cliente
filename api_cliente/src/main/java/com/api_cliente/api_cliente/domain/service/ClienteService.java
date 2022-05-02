package com.api_cliente.api_cliente.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.api_cliente.api_cliente.domain.dto.ClienteDto;
import com.api_cliente.api_cliente.domain.dto.ResponseDto;
import com.api_cliente.api_cliente.domain.entiy.Cliente;
import com.api_cliente.api_cliente.domain.enumeration.Status;
import com.api_cliente.api_cliente.domain.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente){
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMenssage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDto> getAllCliente(){
        List<ClienteDto> listAllClienteDTO = clienteRepository.findAll().stream()
        .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
        .collect(Collectors.toList());
        return listAllClienteDTO;
    }

    public List<ClienteDto> getAllClienteOrderByName(){
        List<ClienteDto> listAllClienteDTO = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
        .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
        .collect(Collectors.toList());
        return listAllClienteDTO;
    }

    public ClienteDto getClienteById(Long id){
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDto.class);
    }

    public ResponseDto updateCliente(Cliente cliente){
        responseDto.setId(clienteRepository.save(cliente).getId());
        if (cliente.getId() > 0 && clienteRepository.existsById(cliente.getId())) {
            clienteRepository.save(cliente);
            responseDto.setMenssage("Usuário alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMenssage("Usuário deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
}
