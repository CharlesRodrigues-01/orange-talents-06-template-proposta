package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.ClienteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BloqueiaCartao {

    private final Logger logger = LoggerFactory.getLogger(BloqueiaCartao.class);

    private BloqueioRepository bloqueioRepository;
    private CartaoRepository cartaoRepository;

    public BloqueiaCartao(BloqueioRepository bloqueioRepository, CartaoRepository cartaoRepository) {
        this.bloqueioRepository = bloqueioRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @Transactional
    public void insereBloqueio(String id, StatusBloqueioResponse statusBloqueioResponse,
                               ClienteRequest clienteRequest, BloqueioRequest bloqueioRequest) {
        logger.info("Preparando para salvar bloqueio, buscando cartão");

        Optional<Cartao> cartao = cartaoRepository.findById(id);
        statusBloqueioResponse.desativaCartao();

        if (!statusBloqueioResponse.isCartaoAtivo()) {
            logger.info("Cartão bloqueado salvando bloqueio");

            Bloqueio bloqueio = statusBloqueioResponse.atualizaSituacaoBloqueio(cartao.get(), clienteRequest,
                                                                                bloqueioRequest);
            logger.info("Gerando bloqueio");

            bloqueioRepository.save(bloqueio);
        }
    }

}
