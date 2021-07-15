package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaProposta;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Cartao {

    @Id
    @NotBlank
    private String id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
    private Set<Bloqueio> bloqueios = new HashSet<>();
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
    private Set<Avisos> avisos = new HashSet<>();
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
    private Set<CarteiraDigital> carteiras = new HashSet<>();
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
    private Set<Parcela> parcelas = new HashSet<>();
    @NotNull
    private BigDecimal limite;

    @Embedded
    private Vencimento vencimento;

    @OneToOne
    private NovaProposta proposta;

    @Deprecated
    public Cartao(){}

    public Cartao(@NotBlank String id, @NotNull LocalDateTime emitidoEm, @NotBlank String titular,
                  Collection<BloqueioResponse> bloqueios, Collection<AvisosResponse> avisos,
                  Collection<CarteiraDigitalResponse> carteiras, Collection<ParcelaResponse> parcelas,
                  BigDecimal limite, @NotNull VencimentoResponse vencimento) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios.addAll(bloqueios.stream().map(bloqueioResponse -> bloqueioResponse.toModel()).collect(Collectors.toSet()));
        this.avisos.addAll(avisos.stream().map(AvisosResponse::toModel).collect(Collectors.toSet()));
        this.carteiras.addAll(carteiras.stream().map(CarteiraDigitalResponse::toModel).collect(Collectors.toSet()));
        this.parcelas.addAll(parcelas.stream().map(ParcelaResponse::toModel).collect(Collectors.toSet()));
        this.limite = limite;
        this.vencimento = vencimento.toModel();
    }

    public String getId() { return id; }

    public LocalDateTime getEmitidoEm() { return emitidoEm; }

    public String getTitular() { return titular; }

    public Set<Bloqueio> getBloqueios() { return bloqueios; }

    public Set<Avisos> getAvisos() { return avisos; }

    public Set<CarteiraDigital> getCarteiras() { return carteiras; }

    public Set<Parcela> getParcelas() { return parcelas; }

    public BigDecimal getLimite() { return limite; }

    public Vencimento getVencimento() { return vencimento; }

    public NovaProposta getProposta() { return proposta; }

    public void propostaCriada(NovaProposta proposta) { this.proposta = proposta; }
}
