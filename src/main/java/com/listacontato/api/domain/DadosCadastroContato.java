package com.listacontato.api.domain;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroContato (
    @NotBlank
    String nome,
    @NotBlank
    String telefone
) {}
