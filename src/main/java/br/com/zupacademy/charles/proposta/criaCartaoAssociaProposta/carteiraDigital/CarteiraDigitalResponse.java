package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital.CarteiraDigital;

import java.time.LocalDateTime;

public class CarteiraDigitalResponse {

    private String id;
    private String email;
    private String associadaEm;
    private String emissor;

    public CarteiraDigitalResponse(String id, String email, String associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

    public String getId() { return id; }

    public String getEmail() { return email; }

    public String getAssociadaEm() { return associadaEm; }

    public String getEmissor() { return emissor; }

    public CarteiraDigital toModel() {
        return new CarteiraDigital(this.id, this.email, LocalDateTime.parse(this.associadaEm), this.emissor);
    }
}
