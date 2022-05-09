package com.api_cliente.api_cliente.domain.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "cep")
    @NotBlank(message = "CEP é obrigatório")
    @Length(message = "CEP com no máximo 9 caracteres", max=9)
    String cep;

    @Column(name = "rua")
    @NotBlank(message = "Rua é obrigatório")
    String rua;

    @Column(name = "bairro")
    @NotBlank(message = "Bairro é obrigatório")
    String bairro;

    @Column(name = "numero")
    @NotBlank(message = "Número é obrigatório")
    Integer numero;

    @Column(name = "cidade")
    @NotBlank(message = "Cidade é obrigatório")
    String cidade;

    @Column(name = "uf")
    @NotBlank(message = "UF é obrigatório")
    String uf;
}