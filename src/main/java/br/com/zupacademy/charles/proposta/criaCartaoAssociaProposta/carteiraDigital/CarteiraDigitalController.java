package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.StatusCartao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/carteiras")
public class CarteiraDigitalController {

    private final Logger logger = LoggerFactory.getLogger(CarteiraDigitalController.class);

    private CartaoRepository cartaoRepository;
    private StatusCartao statuscartaoResource;
    private CarteiraDigitalRepository carteiraDigitalRepository;

    public CarteiraDigitalController(CartaoRepository cartaoRepository, StatusCartao statuscartaoResource,
                                     CarteiraDigitalRepository carteiraDigitalRepository) {
        this.cartaoRepository = cartaoRepository;
        this.statuscartaoResource = statuscartaoResource;
        this.carteiraDigitalRepository = carteiraDigitalRepository;
    }

    @PostMapping("/cartao/{id}")
    @Transactional
    public ResponseEntity<?> cadastrarCarteira(@PathVariable("id") String idCartao,
                                               @RequestBody @Valid CarteiraDigitalRequest request,
                                               UriComponentsBuilder uriBuilder) {

        logger.info("Buscando cartão e carteira");
        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        Optional<CarteiraDigital> carteiraexiste = carteiraDigitalRepository.findByCarteiraAtiva(idCartao, request.getCarteira());

        if(carteiraexiste.isPresent()) return ResponseEntity.unprocessableEntity().build();

        if (cartao.isPresent()) {
            logger.info("Cartão existe");

            ResultadoAssociacao resultadoAssociacao = statuscartaoResource.solicitaAssociacao(idCartao, request);
            if (resultadoAssociacao.getResultado().equals("ASSOCIADA")) {

                CarteiraDigital carteiraDigital = request.toModel(cartao.get());
                carteiraDigitalRepository.save(carteiraDigital);
                logger.info("Carteira associada e salva!");

                URI uri = uriBuilder.path("/carteiras/{id}").build(carteiraDigital.getId());
                return ResponseEntity.created(uri).build();
            }
            logger.warn("Ops! O sistema externo não associou a carteira!");
            return ResponseEntity.badRequest().build();
        }
        logger.warn("Este cartão não existe ");
        return ResponseEntity.notFound().build();
    }
}
