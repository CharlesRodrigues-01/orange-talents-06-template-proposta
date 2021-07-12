package br.com.zupacademy.charles.proposta.validation;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.NovaPropostaRequestDto;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClientGroupSequenceProvider implements DefaultGroupSequenceProvider<NovaPropostaRequestDto> {

    @Override
    public List<Class<?>> getValidationGroups(NovaPropostaRequestDto requestDto) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(NovaPropostaRequestDto.class);

        if(pessoaFisicaSelecionada(requestDto)) {
            groups.add(requestDto.getTipoDocumento().getGroup());
        }
        return groups;
    }

    protected boolean pessoaFisicaSelecionada(NovaPropostaRequestDto requestDto) {
        return requestDto != null && requestDto.getTipoDocumento() != null;
    }
}
