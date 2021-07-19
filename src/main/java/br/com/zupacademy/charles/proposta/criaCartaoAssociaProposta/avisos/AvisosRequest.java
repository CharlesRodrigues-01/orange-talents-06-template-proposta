package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.Cliente;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils.CartaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvisosRequest {

    private final Logger logger = LoggerFactory.getLogger(CartaoRequest.class);

    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate validoAte;

    public AvisosRequest(@NotBlank String destino, @NotNull LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public Avisos toModel(Cartao cartao, Cliente cliente) {
        logger.info("Convertendo para model ");

        return new Avisos(this.validoAte, this.destino, cliente, cartao);
    }
}
