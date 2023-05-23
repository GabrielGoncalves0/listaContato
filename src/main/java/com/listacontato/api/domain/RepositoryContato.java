package com.listacontato.api.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryContato extends JpaRepository<Contato, Long> {


    Page<Contato> findAllByAtivoTrue(Pageable paginacao);

}
