package com.listacontato.api.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryContato extends JpaRepository <Contato, Long> {
}
