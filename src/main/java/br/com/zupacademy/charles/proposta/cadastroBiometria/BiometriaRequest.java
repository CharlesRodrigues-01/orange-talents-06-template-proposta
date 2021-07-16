package br.com.zupacademy.charles.proposta.cadastroBiometria;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoRepository;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import java.util.Base64;
import java.util.Optional;

public class BiometriaRequest {

    @NotBlank
    private String fingerprint;

    private String idCartao;

    public BiometriaRequest(@NotBlank String fingerprint, String idCartao) {
        this.fingerprint = fingerprint;
        this.idCartao = idCartao;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getIdCartao() { return idCartao; }

    public Biometria toModel(CartaoRepository cartaoRepository, String id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        Assert.state(cartao != null, "Este cartão não existe no banco de dados " + id);

        return new Biometria(cartao.get(), Base64.getEncoder().encodeToString(fingerprint.getBytes()));
    }

}
