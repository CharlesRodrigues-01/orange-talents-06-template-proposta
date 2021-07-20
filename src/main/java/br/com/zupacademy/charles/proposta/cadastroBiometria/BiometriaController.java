package br.com.zupacademy.charles.proposta.cadastroBiometria;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    private final Logger logger = LoggerFactory.getLogger(BiometriaController.class);
    private CartaoRepository cartaoRepository;
      private BiometriaRepository biometriaRepository;

      public BiometriaController(CartaoRepository cartaoRepository,
                                 BiometriaRepository biometriaRepository) {
          this.cartaoRepository = cartaoRepository;
          this.biometriaRepository = biometriaRepository;
      }

      @PostMapping("/cartao/{id}")
      @Transactional
      public ResponseEntity<?> cadastrar( @RequestBody @Valid BiometriaRequest request,
                                       @PathVariable("id") String id, UriComponentsBuilder builder) {

          boolean cartaoExistente = cartaoRepository.existsById(id);
          if (cartaoExistente) {
              logger.info("Cartão existe, salvando biometria");
              Biometria biometria = request.toModel(cartaoRepository, id);
              biometriaRepository.save(biometria);

              URI uri = builder.path("/biometria/cartao/{id}").buildAndExpand(biometria.getId()).toUri();

              return ResponseEntity.created(uri).build();
          }
          logger.warn("Este id não existe, biometria não cadastrada!");
          return ResponseEntity.notFound().build();
      }
}
