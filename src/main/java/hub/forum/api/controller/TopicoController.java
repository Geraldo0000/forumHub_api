package hub.forum.api.controller;

import hub.forum.api.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tópico duplicado: já existe um tópico com o mesmo título e mensagem.");
        }
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));


    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar( @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/buscar")
    public Page<DadosListagemTopico> buscarPorCursoEAno(
            @RequestParam String curso,
            @RequestParam int ano,
            @PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.ASC) Pageable paginacao) {
        return repository.findByCursoAndAno(curso, ano, paginacao).map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoTopico buscarPorId(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado."));
        return new DadosDetalhamentoTopico(topico);
    }



    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado."));

        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tópico duplicado: já existe um tópico com o mesmo título e mensagem.");
        }

        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado.");
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }







}
