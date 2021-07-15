package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise.StatusAnaliseRequest;
import br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise.StatusAnaliseResponse;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class NovaProposta {

    @Transient
    private final Logger logger = LoggerFactory.getLogger(NovaProposta.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String documento;
    @NotBlank
    @Column(nullable = false)
    private String endereco;
    @NotNull
    @Column(nullable = false)
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;
    @OneToOne
    private Cartao cartao;

    @Deprecated
    public NovaProposta(){}

    public NovaProposta(String nome, String email, String documento, String endereco, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.salario = salario;
    }

    public NovaProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
        logger.info("Valor da proposta " + statusProposta + nome);

    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDocumento() { return documento; }

    public String getEndereco() { return endereco; }

    public BigDecimal getSalario() { return salario; }

    public StatusProposta getStatusProposta() { return statusProposta; }

    public Cartao getCartao() { return cartao; }

    public void alteraStatusProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }

    public StatusAnaliseRequest solicitaConsulta() {
        logger.info("Preparando cliente para envio");
        return new StatusAnaliseRequest(this.getDocumento(),
                this.getNome(), this.getId().toString());
    }

   public void resultadoDaAnalise(StatusAnaliseResponse analiseClienteResponse) {
       this.statusProposta = analiseClienteResponse.getStatusProposta();
   }

    public StatusPropostaResponse retornaConsulta() {
        logger.info("Retornando status " + this.statusProposta);
        return new StatusPropostaResponse(this.statusProposta);
    }

    public void cartaoCriado(Cartao cartao) {
        this.cartao = cartao;
    }

}
