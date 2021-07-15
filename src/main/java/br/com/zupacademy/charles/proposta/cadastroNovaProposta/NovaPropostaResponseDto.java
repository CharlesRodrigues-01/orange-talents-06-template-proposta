package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

public class NovaPropostaResponseDto {

    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private StatusProposta statusProposta;

    public NovaPropostaResponseDto(NovaProposta proposta) {
        this.id = proposta.getId();
        this.nome = proposta.getNome();
        this.email = proposta.getEmail();
        this.endereco = proposta.getEndereco();
        this.statusProposta = proposta.getStatusProposta();
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getEndereco() { return endereco; }

    public StatusProposta getStatusProposta() { return statusProposta; }

}
