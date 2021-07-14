package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class NovaPropostaController {

    private final Logger logger = LoggerFactory.getLogger(NovaPropostaController.class);
    NovaPropostaRepository repository;
    RetornoConsulta retornoConsulta;

    public NovaPropostaController(NovaPropostaRepository repository,RetornoConsulta retornoConsulta) {
        this.repository = repository;
        this.retornoConsulta = retornoConsulta;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaPropostaRequestDto requestDto,
                                       UriComponentsBuilder uriBuilder) {

        boolean documentoExistente = repository.existsByDocumento(requestDto.getDocumento());
        if(documentoExistente) {
            logger.warn("Documento da proposta já existe, proposta não criada!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        NovaProposta proposta = requestDto.toModel();
        repository.save(proposta);
        URI uri = uriBuilder.path("/propostas/{id}").build(proposta.getId());
        logger.info("Proposta criada com sucesso! Id = " + proposta.getId());
        retornoConsulta.resultadoAnalise(proposta);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(@PathVariable("id") Long id) {
        logger.info("Consulta às propostas");
        Optional<NovaProposta> proposta = repository.findById(id);

            if (proposta.isPresent()) {
                return ResponseEntity.ok(proposta.get().retornaConsulta());
        }
        return ResponseEntity.notFound().build();
    }
}
