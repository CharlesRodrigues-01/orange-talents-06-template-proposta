package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import javax.persistence.Id;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class BloqueioResponse {

    @Id
    private String id;
    private String bloqueadoEm;
    private String sistemaResponsavel;
    private boolean ativo;

    public BloqueioResponse(String id, String bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public String getId() { return id; }

    public String getBloqueadoEm() { return bloqueadoEm; }

    public String getSistemaResponsavel() { return sistemaResponsavel; }

    public boolean isAtivo() { return ativo; }

    public Bloqueio toModel() {
        return new Bloqueio(this.id, LocalDateTime.parse(this.bloqueadoEm, ISO_LOCAL_DATE_TIME),
                            this.sistemaResponsavel, this.ativo);
    }
}
