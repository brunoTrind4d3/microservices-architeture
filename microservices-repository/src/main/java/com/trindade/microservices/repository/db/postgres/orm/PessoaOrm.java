package com.trindade.microservices.repository.db.postgres.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PESSOA")
public class PessoaOrm {

    @Id
    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "GENERO")
    private Integer genero;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ATIVO")
    private String ativo;
}
