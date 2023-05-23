package com.listacontato.api.domain;

public record DadosListagemContato (Long id, String nome, String telefone){

public DadosListagemContato(Contato contato) {
    this(contato.getId(), contato.getNome(), contato.getTelefone());
    }
}
