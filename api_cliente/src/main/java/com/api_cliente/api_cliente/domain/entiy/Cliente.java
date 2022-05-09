package com.api_cliente.api_cliente.domain.entiy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@SecondaryTable(name = "endereco")
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "cpf")
    @NotBlank(message = "CPF é obrigatório")
    @Length(message="Nome com no máximo 14 caracteres",max=14)
    @CPF
    String cpf;

    @Column(name = "nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;

    @Column(name = "sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message="Nome com no máximo 1 caracteres",max=1)
    String sexo;

    @Column(name = "nascimento")
    Date nascimento;

    @Column(table = "endereco")
    @OneToOne
    Endereco endereco;
}
