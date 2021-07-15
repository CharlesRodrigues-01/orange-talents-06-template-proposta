package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class DetalhesPropostaController {

    NovaPropostaRepository repository;

    public DetalhesPropostaController(NovaPropostaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<NovaPropostaResponseDto> detalhaProposta(@PathVariable Long id) {
        Optional<NovaProposta> novaProposta = repository.findById(id);
        if (novaProposta.isPresent()) {
            return ResponseEntity.ok().body(new NovaPropostaResponseDto(novaProposta.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
