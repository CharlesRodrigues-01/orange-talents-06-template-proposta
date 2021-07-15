package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class CartaoResponse {

    private final Logger logger = LoggerFactory.getLogger(CartaoResponse.class);

    @NotBlank
    private String id;
    @NotBlank
    private String emitidoEm;
    @NotBlank
    private String titular;
    private List<BloqueioResponse> bloqueios = new ArrayList<>();
    private List<AvisosResponse> avisos = new ArrayList<>();
    private List<CarteiraDigitalResponse> carteiras = new ArrayList<>();
    private List<ParcelaResponse> parcelas = new ArrayList<>();
    @NotNull
    private int limite;
    @NotNull
    private VencimentoResponse vencimento;
    @NotBlank
    private String idProposta;

    public CartaoResponse(@NotBlank String id, @NotBlank String emitidoEm, @NotBlank String titular,
                          List<BloqueioResponse> bloqueios, List<AvisosResponse> avisos,
                          List<CarteiraDigitalResponse> carteiras, List<ParcelaResponse> parcelas,
                          @NotNull int limite, @NotNull VencimentoResponse vencimento,
                          @NotBlank String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios.addAll(bloqueios);
        this.avisos.addAll(avisos);
        this.carteiras.addAll(carteiras);
        this.parcelas.addAll(parcelas);
        this.limite = limite;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    public String getId() { return id; }

    public String getEmitidoEm() { return emitidoEm; }

    public String getTitular() { return titular; }

    public List<BloqueioResponse> getBloqueios() { return bloqueios; }

    public List<AvisosResponse> getAvisos() { return avisos; }

    public List<CarteiraDigitalResponse> getCarteiras() { return carteiras; }

    public List<ParcelaResponse> getParcelas() { return parcelas; }

    public int getLimite() { return limite; }

    public VencimentoResponse getVencimento() { return vencimento; }

    public String getIdProposta() { return idProposta; }

    public Cartao toModel() {
        logger.info("Inicio da converção de CartaoResponso para Model");

        return new Cartao(this.id, LocalDateTime.parse(this.emitidoEm, ISO_LOCAL_DATE_TIME), this.titular,
                this.bloqueios, this.avisos, this.carteiras, this.parcelas,
                new BigDecimal(this.limite), this.vencimento);
    }
}

