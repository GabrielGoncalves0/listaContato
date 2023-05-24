package com.listacontato.api.domain;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/contato")
public class ControllerContato {

    @Autowired
    RepositoryContato repositoryContato;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarContato(DadosCadastroContato dados, UriComponentsBuilder uriBuilder) {
        var contato = new Contato(dados);
        repositoryContato.save(contato);

        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(contato.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoContato(contato));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemContato>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repositoryContato.findAllByAtivoTrue(paginacao).map(DadosListagemContato::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var contato = repositoryContato.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoContato(contato));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var contato = repositoryContato.getReferenceById(id);
        contato.excluir();

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarContato dados){
        var contato = repositoryContato.getReferenceById(dados.id());
        contato.atualizarContato(dados);

        return ResponseEntity.ok(new DadosDetalhamentoContato(contato));
    }

}
