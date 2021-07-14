package br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusAnaliseRequest {

    private final Logger logger = LoggerFactory.getLogger(StatusAnaliseRequest.class);

    private String idProposta;
    private String documento;
    private String nome;

    public StatusAnaliseRequest(String documento, String nome, String idProposta) {
        logger.info("Enviando proposta para análise ");
        this.idProposta = idProposta;
        this.documento = documento;
        this.nome = nome;
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
}
