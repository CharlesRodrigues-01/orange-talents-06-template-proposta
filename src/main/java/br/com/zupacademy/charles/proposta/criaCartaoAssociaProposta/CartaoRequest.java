package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaProposta;
import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaPropostaRepository;
import br.com.zupacademy.charles.proposta.cadastroNovaProposta.StatusProposta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartaoRequest {

    private final Logger logger = LoggerFactory.getLogger(CartaoRequest.class);

    private NovaPropostaRepository propostaRepository;
    private PropostaCartao propostaCartao;

    public CartaoRequest(NovaPropostaRepository propostaRepository, PropostaCartao propostaCartao) {
        this.propostaRepository = propostaRepository;
        this.propostaCartao = propostaCartao;
    }

    private List<NovaProposta> propostasAprovadas = new ArrayList<>();

    @Scheduled(fixedDelayString = "${chamada.cartao}")
    void buscaProposta() {
        propostasAprovadas = propostaRepository.findByStatusProposta(StatusProposta.ELEGIVEL);
        logger.info("Buscando propostas aprovadas ");
        propostasAprovadas.forEach(proposta -> {
            propostaCartao.vinculaCartaoProposta(proposta);
            logger.info("Listando aprovadas");
        });

    }
}
