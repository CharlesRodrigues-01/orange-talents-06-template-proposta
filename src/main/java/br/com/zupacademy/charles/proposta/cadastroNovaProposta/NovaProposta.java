package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class NovaProposta {

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

    @Deprecated
    public NovaProposta(){}

    public NovaProposta(String nome, String email, String documento, String endereco, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getDocumento() { return documento; }

    public String getEndereco() { return endereco; }

    public BigDecimal getSalario() { return salario; }
}
