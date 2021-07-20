package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarteiraDigitalRequest {

    @NotBlank
    @Email
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoCarteira carteira;

    public CarteiraDigitalRequest(@NotBlank @Email String email, @NotBlank TipoCarteira carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return carteira;
    }

    public CarteiraDigital toModel(Cartao cartao) {
        return new CarteiraDigital(this.email,this.carteira, cartao);
    }
}
