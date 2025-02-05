package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaProposta;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Bloqueio {

    @Transient
    private final Logger logger = LoggerFactory.getLogger(Bloqueio.class);
    @Id
    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private boolean ativo;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;
    @OneToOne(cascade = CascadeType.MERGE)
    private Cliente cliente;

    @Deprecated
    public Bloqueio() {
    }

    public Bloqueio(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public Bloqueio(boolean ativo, Cartao cartao, Cliente cliente, String sistemaResponsavel) {
        this.ativo = ativo;
        this.cartao = cartao;
        this.cliente = cliente;
        this.bloqueadoEm = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.sistemaResponsavel = sistemaResponsavel;
    }

   public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
