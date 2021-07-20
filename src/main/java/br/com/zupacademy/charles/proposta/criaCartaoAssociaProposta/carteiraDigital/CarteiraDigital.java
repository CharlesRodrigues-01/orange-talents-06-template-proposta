package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CarteiraDigital {

    @Id
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;

    @Deprecated
    public CarteiraDigital() {}

    public CarteiraDigital(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

    public CarteiraDigital(String email, String carteira, Cartao cartao) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.associadaEm = LocalDateTime.now();
        this.emissor = carteira;
        this.cartao = cartao;
    }

    public String getId() { return id; }

    public String getEmail() { return email; }

    public LocalDateTime getAssociadaEm() { return associadaEm; }

    public String getEmissor() { return emissor; }

    public Cartao getCartao() { return cartao; }
}
