package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise.StatusAnaliseDeCliente;
import br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise.StatusAnaliseResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RetornoConsulta {

    private final Logger logger = LoggerFactory.getLogger(RetornoConsulta.class);

    private NovaPropostaRepository propostaRepository;
    private StatusAnaliseDeCliente analiseCliente;

    public RetornoConsulta(StatusAnaliseDeCliente analiseCliente, NovaPropostaRepository propostaRepository) {
        this.analiseCliente = analiseCliente;
        this.propostaRepository = propostaRepository;
    }

    public void resultadoAnalise(NovaProposta proposta){

        logger.info("Cliente foi para análise");
        try {
            StatusAnaliseResponse analiseResponse = analiseCliente.status(proposta.solicitaConsulta());
            logger.info("Documento elegível");
            proposta.resultadoDaAnalise(analiseResponse);
            propostaRepository.save(proposta);
        } catch (FeignException.UnprocessableEntity e) {
            logger.info("Documento não elegível ");
            proposta.alteraStatusProposta(StatusProposta.NAO_ELEGIVEL);
        }
    }
}
