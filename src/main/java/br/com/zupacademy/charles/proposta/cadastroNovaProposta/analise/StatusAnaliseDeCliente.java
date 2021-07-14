package br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "status", url = "${status.api}")
public interface StatusAnaliseDeCliente {

    @RequestMapping(method = RequestMethod.POST, value = "/api/solicitacao", consumes = "application/json", produces = "application/json")
    StatusAnaliseResponse status(StatusAnaliseRequest request);
}
