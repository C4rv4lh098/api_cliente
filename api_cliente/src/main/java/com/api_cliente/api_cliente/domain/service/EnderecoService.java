package com.api_cliente.api_cliente.domain.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.api_cliente.api_cliente.domain.dto.EnderecoDto;
import com.api_cliente.api_cliente.domain.dto.ResponseDto;
import com.api_cliente.api_cliente.domain.entiy.Endereco;
import com.api_cliente.api_cliente.domain.enumeration.Status;
import com.api_cliente.api_cliente.domain.repository.EnderecoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    EnderecoRepository enderecoRepository;

    public ResponseDto saveEndereco(Endereco endereco){
        responseDto.setId(enderecoRepository.save(endereco).getId());
        responseDto.setMenssage("Endereço salvo com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<EnderecoDto> getALLEndereco(){
        List<EnderecoDto> listALLEnderecoDTO = enderecoRepository.findAll().stream()
        .map(Endereco -> modelMapper.map(Endereco, EnderecoDto.class))
        .collect(Collectors.toList());
        return listALLEnderecoDTO;
    }

    public List<EnderecoDto> getAllEnderecoOrderByName(){
        List<EnderecoDto> listAllEnderecoDTO = enderecoRepository.findAll(Sort.by(Sort.Direction.ASC, "rua")).stream()
        .map(Endereco -> modelMapper.map(Endereco, EnderecoDto.class))
        .collect(Collectors.toList());
        return listAllEnderecoDTO;
    }

    public EnderecoDto getEnderecoById(Long id){
        return modelMapper.map(enderecoRepository.findById(id).get(), EnderecoDto.class);
    }

    public ResponseDto updateEndereco(Endereco endereco){
        responseDto.setId(enderecoRepository.save(endereco).getId());
        if (endereco.getId() > 0 && enderecoRepository.existsById(endereco.getId())) {
            enderecoRepository.save(endereco);
            responseDto.setMenssage("Endereço alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteEndereço(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            enderecoRepository.deleteById(id);
            responseDto.setMenssage("Endereço deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Endereço inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
}
