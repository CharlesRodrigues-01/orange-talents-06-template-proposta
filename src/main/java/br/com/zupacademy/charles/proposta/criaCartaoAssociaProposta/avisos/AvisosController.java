package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.ClienteRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.StatusCartao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/avisos")
public class AvisosController {

    private final Logger logger = LoggerFactory.getLogger(AvisosController.class);

    private CartaoRepository cartaoRepository;
    private AvisosRepository avisosRepository;
    private StatusCartao statuscartaoResource;

    public AvisosController(CartaoRepository cartaoRepository,
                            AvisosRepository avisosRepository,
                            StatusCartao statuscartaoResource){
        this.cartaoRepository = cartaoRepository;
        this.avisosRepository = avisosRepository;
        this.statuscartaoResource = statuscartaoResource;
    }

    @PostMapping("/cartao/{id}")
    @Transactional
    public ResponseEntity<?> cadastrarAvisos(@PathVariable("id") String idCartao, @RequestBody @Valid AvisosRequest avisosRequest,
                                             @RequestHeader("user-agent") String agent,
                                             HttpServletRequest request) {

        String ipCliente = request.getRemoteAddr();
        ClienteRequest clienteRequest = new ClienteRequest(ipCliente, agent);

        logger.info("Buscando cartão");
        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);

        if (cartao.isPresent()) {
            logger.info("Cartão existe");

            ResultadoAvisoResponse resultadoAvisoResponse = statuscartaoResource.avisaViagem(idCartao, avisosRequest);
            if (resultadoAvisoResponse.getResultado().equals("CRIADO")) {
                logger.info("Aviso criado pelo sistema, salvando no banco de dados");

                Avisos avisos = avisosRequest.toModel(cartao.get(), clienteRequest);
                avisosRepository.save(avisos);
                logger.info("Aviso salvo!");
                return ResponseEntity.ok().build();
            }
            logger.warn("Ops! O sistema externo não criou o aviso!");
            return ResponseEntity.badRequest().build();

        }
        logger.warn("Este cartão não existe ");
        return ResponseEntity.notFound().build();
    }
}
