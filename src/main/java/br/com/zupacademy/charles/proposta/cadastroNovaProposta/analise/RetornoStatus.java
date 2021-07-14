package br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.StatusProposta;

import javax.validation.constraints.NotNull;

public enum RetornoStatus {
    SEM_RESTRICAO(StatusProposta.ELEGIVEL),
    COM_RESTRICAO(StatusProposta.NAO_ELEGIVEL);

    private final StatusProposta statusProposta;
    RetornoStatus(@NotNull StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }
}
