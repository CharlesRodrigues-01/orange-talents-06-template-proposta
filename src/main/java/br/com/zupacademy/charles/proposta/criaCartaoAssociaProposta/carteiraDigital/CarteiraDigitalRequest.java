package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraDigitalRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String carteira;

    public CarteiraDigitalRequest(@NotBlank @Email String email, @NotBlank String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }

    public CarteiraDigital toModel(Cartao cartao) {
        return new CarteiraDigital(this.email,this.carteira, cartao);
    }
}
