package br.com.zupacademy.charles.proposta.validation;

public enum Tipo {

    PF ("Física", "CPF", "000.000.000-00", Cpf.class),
    PJ ("Juridica", "CNPJ", "00.000.000/000-00", Cnpj.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private final Class<?> group;

    Tipo(String descricao, String documento, String mascara, Class<?> group) {
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public String getMascara() {
        return mascara;
    }

    public Class<?> getGroup() {
        return group;
    }
}
