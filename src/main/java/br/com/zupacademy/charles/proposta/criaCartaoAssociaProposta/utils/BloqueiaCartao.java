package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.Bloqueio;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.BloqueioRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.BloqueioRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.StatusBloqueioResponse;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.ClienteBloqueioRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BloqueiaCartao {

    private final Logger logger = LoggerFactory.getLogger(CartaoRequest.class);

    private BloqueioRepository bloqueioRepository;
    private CartaoRepository cartaoRepository;

    public BloqueiaCartao(BloqueioRepository bloqueioRepository, CartaoRepository cartaoRepository) {
        this.bloqueioRepository = bloqueioRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @Transactional
    public void insereBloqueio(String id, StatusBloqueioResponse statusBloqueioResponse,
                                 ClienteBloqueioRequest clienteBloqueioRequest, BloqueioRequest bloqueioRequest) {
        logger.info("Preparando para salvar bloqueio, buscando cartão");

        Optional<Cartao> cartao = cartaoRepository.findById(id);
        statusBloqueioResponse.desativaCartao();

        if (!statusBloqueioResponse.isCartaoAtivo()) {
            logger.info("Cartão bloqueado salvando bloqueio");

            Bloqueio bloqueio = statusBloqueioResponse.atualizaSituacaoBloqueio(cartao.get(), clienteBloqueioRequest,
                                                                                bloqueioRequest);
            logger.info("Gerando bloqueio");

            bloqueioRepository.save(bloqueio);
        }
    }

}
