package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaProposta;
import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaPropostaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PropostaCartao {

    private final Logger logger = LoggerFactory.getLogger(PropostaCartao.class);

    private NovaPropostaRepository propostaRepository;
    private CartaoRepository cartaoRepository;
    private StatusCartao statuscartaoResource;

    public PropostaCartao(StatusCartao statuscartaoResource, CartaoRepository cartaoRepository,
                          NovaPropostaRepository propostaRepository){
        this.statuscartaoResource = statuscartaoResource;
        this.cartaoRepository = cartaoRepository;
        this.propostaRepository = propostaRepository;
    }

    @Transactional
    public void vinculaCartaoProposta(NovaProposta proposta) {

        if (proposta == null) return;
        logger.info("Existe proposta, buscar cartão");
        if (proposta.getCartao() == null) {
            logger.info("Buscando cartão");
            CartaoResponse cartaoResponse = statuscartaoResource.analisaCartao(proposta.solicitaConsulta());

            Cartao cartao = cartaoResponse.toModel();
            logger.info("Salvando cartão");
            cartao.propostaCriada(proposta);
            cartaoRepository.save(cartao);
            logger.info("Atrelando cartão à proposta");
            proposta.cartaoCriado(cartao);
            propostaRepository.save(proposta);
        }
    }
}
