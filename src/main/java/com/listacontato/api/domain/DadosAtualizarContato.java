package com.listacontato.api.domain;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarContato(

        @NotNull
        Long id,
        String nome,
        String telefone
) {}
