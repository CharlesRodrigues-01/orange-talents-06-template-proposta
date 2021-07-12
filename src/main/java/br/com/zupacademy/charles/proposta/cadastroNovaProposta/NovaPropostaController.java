package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class NovaPropostaController {

    NovaPropostaRepository repository;

    public NovaPropostaController(NovaPropostaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaPropostaRequestDto requestDto,
                                       UriComponentsBuilder uriBuilder) {

        NovaProposta proposta = requestDto.toModel();
        repository.save(proposta);
        URI uri = uriBuilder.path("/propostas/{id}").build(proposta.getId());

        return ResponseEntity.created(uri).build();
    }
}
