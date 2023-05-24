package com.listacontato.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    String telefone;

    Boolean ativo;

    public Contato(DadosCadastroContato dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.ativo = true;
    }


    public void atualizarContato(DadosAtualizarContato dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void excluir () {
        this.ativo = false;
    }
}
