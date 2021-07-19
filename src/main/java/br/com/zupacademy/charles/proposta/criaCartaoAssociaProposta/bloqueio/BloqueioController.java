package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.ClienteRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.BloqueiaCartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.CartaoRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.StatusCartao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/bloqueio")
public class BloqueioController {

    private final Logger logger = LoggerFactory.getLogger(CartaoRequest.class);

    private CartaoRepository cartaoRepository;
    private StatusCartao statuscartaoResource;
    private BloqueiaCartao bloqueiaCartao;
    private BloqueioRepository bloqueioRepository;

    public BloqueioController(CartaoRepository cartaoRepository, BloqueiaCartao bloqueiaCartao,
                              StatusCartao statuscartaoResource, BloqueioRepository bloqueioRepository) {
        this.cartaoRepository = cartaoRepository;
        this.bloqueiaCartao = bloqueiaCartao;
        this.statuscartaoResource = statuscartaoResource;
        this.bloqueioRepository = bloqueioRepository;
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<?> bloquearCartao(@PathVariable("id") String idCartao,
                                            @RequestHeader("user-agent") String agent,
                                            HttpServletRequest request) {

        String ipCliente = request.getRemoteAddr();
        ClienteRequest clienteRequest = new ClienteRequest(ipCliente, agent);
        BloqueioRequest bloqueioRequest = new BloqueioRequest("Porposta");
        logger.info("Buscando cartão e bloqueios");
        boolean cartaoExiste = cartaoRepository.existsById(idCartao);
        Optional<Bloqueio> bloqueioExiste = bloqueioRepository.findByCartaoAtivo(idCartao, false);

        if(bloqueioExiste.isPresent()) return ResponseEntity.unprocessableEntity().build();

        if (cartaoExiste) {
            logger.info("Cartão existe e não está bloqueado, solicitando bloqueio");
            StatusBloqueioResponse statusBloqueioResponse = statuscartaoResource.solicitaBloqueio(idCartao,
                    bloqueioRequest);

            bloqueiaCartao.insereBloqueio(idCartao, statusBloqueioResponse, clienteRequest,bloqueioRequest);

            return ResponseEntity.ok().build();
        }
        logger.warn("Este cartão não existe " + idCartao);

        return ResponseEntity.notFound().build();
    }
}
