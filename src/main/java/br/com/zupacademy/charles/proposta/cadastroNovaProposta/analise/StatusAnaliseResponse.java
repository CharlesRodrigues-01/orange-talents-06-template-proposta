package br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.StatusProposta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StatusAnaliseResponse {

    private final Logger logger = LoggerFactory.getLogger(StatusAnaliseRequest.class);

    private String idProposta;
    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotNull
    private RetornoStatus resultadoSolicitacao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    public StatusAnaliseResponse(String documento, String nome, RetornoStatus resultadoSolicitacao, String idProposta) {
        this.idProposta = idProposta;
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public RetornoStatus getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public StatusProposta getStatusProposta() {
        if (resultadoSolicitacao.equals(RetornoStatus.SEM_RESTRICAO)) {
            statusProposta = StatusProposta.ELEGIVEL;
            return statusProposta;
        } else{
        statusProposta = StatusProposta.NAO_ELEGIVEL;
        return statusProposta;
    }}
}
