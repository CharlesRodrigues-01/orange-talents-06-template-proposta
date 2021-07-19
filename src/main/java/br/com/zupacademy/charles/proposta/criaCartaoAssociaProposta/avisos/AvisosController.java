package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.Cliente;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.CartaoRequest;
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

    private final Logger logger = LoggerFactory.getLogger(CartaoRequest.class);

    private CartaoRepository cartaoRepository;
    private AvisosRepository avisosRepository;

    public AvisosController(CartaoRepository cartaoRepository,
                            AvisosRepository avisosRepository){
        this.cartaoRepository = cartaoRepository;
        this.avisosRepository = avisosRepository;
    }

    @PostMapping("/cartao/{id}")
    @Transactional
    public ResponseEntity<?> cadastrarAvisos(@PathVariable("id") String idCartao, @RequestBody @Valid AvisosRequest avisosRequest,
                                             @RequestHeader("user-agent") String agent,
                                             HttpServletRequest request) {

        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        String ipCliente = request.getRemoteAddr();
        Cliente cliente = new Cliente(ipCliente, agent);

        boolean cartaoExiste = cartaoRepository.existsById(idCartao);
        logger.info("Buscando cartão e bloqueios");

        if (cartaoExiste) {

            Avisos avisos = avisosRequest.toModel(cartao.get(), cliente);
            avisosRepository.save(avisos);
            return ResponseEntity.ok().build();
        }
        logger.warn("Este cartão não existe " + idCartao);

        return ResponseEntity.notFound().build();
    }
}
