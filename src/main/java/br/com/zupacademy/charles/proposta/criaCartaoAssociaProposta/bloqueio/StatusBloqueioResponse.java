package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.ClienteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusBloqueioResponse {

    private final Logger logger = LoggerFactory.getLogger(StatusBloqueioResponse.class);

    private String resultado;
    private boolean cartaoAtivo = true;

    public String getResultado() { return resultado; }

    public boolean isCartaoAtivo() { return cartaoAtivo; }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void desativaCartao() {
        if(resultado.equals("BLOQUEADO")){
            cartaoAtivo = false;
        }
    }

    public Bloqueio atualizaSituacaoBloqueio(Cartao cartao, ClienteRequest clienteRequest,
                                             BloqueioRequest sistemaResponsavel) {
        logger.info("Convertendo para model ");
        return new Bloqueio(this.cartaoAtivo, cartao, clienteRequest.toModel(), sistemaResponsavel.getSistemaResponsavel());
    }
}
