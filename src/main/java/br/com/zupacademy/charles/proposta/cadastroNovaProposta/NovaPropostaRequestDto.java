package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import br.com.zupacademy.charles.proposta.annotations.UniqueValue;
import br.com.zupacademy.charles.proposta.validation.ClientGroupSequenceProvider;
import br.com.zupacademy.charles.proposta.validation.Cnpj;
import br.com.zupacademy.charles.proposta.validation.Cpf;
import br.com.zupacademy.charles.proposta.validation.Tipo;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@GroupSequenceProvider(ClientGroupSequenceProvider.class)
public class NovaPropostaRequestDto {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @CPF(groups = Cpf.class)
    @CNPJ(groups = Cnpj.class)
    private String documento;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipoDocumento;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;

    public NovaPropostaRequestDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String documento,
                                  @NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.salario = salario;
    }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDocumento() { return documento; }

    public Tipo getTipoDocumento() { return tipoDocumento; }

    public String getEndereco() { return endereco; }

    public BigDecimal getSalario() { return salario; }

    public NovaProposta toModel() {
        return new NovaProposta(nome, email, documento, endereco, salario);
    }
}
