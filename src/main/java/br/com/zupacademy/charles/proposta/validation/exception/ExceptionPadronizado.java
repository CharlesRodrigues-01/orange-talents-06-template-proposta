package br.com.zupacademy.charles.proposta.validation.exception;

import java.util.Collection;

public class ExceptionPadronizado {
    private Collection<String> mensagens;

    public ExceptionPadronizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }
}
