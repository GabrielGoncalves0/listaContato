package com.listacontato.api.domain;

public record DadosDetalhamentoContato (

        Long id,
        String nome,
        String telefone
){
    public DadosDetalhamentoContato(Contato contato) {
        this(contato.getId(), contato.getNome(), contato.getTelefone());
    }
}
