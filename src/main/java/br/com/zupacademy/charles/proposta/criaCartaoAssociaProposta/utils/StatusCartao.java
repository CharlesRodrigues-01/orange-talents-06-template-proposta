package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.utils;

import br.com.zupacademy.charles.proposta.cadastroNovaProposta.analise.StatusAnaliseRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos.AvisosRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos.ResultadoAvisoResponse;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.BloqueioRequest;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.StatusBloqueioResponse;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cartao", url = "${cartao.conta}")
public interface StatusCartao {
    @RequestMapping(method = RequestMethod.POST, value = "/api/cartoes", consumes = "application/json", produces = "application/json")
    CartaoResponse analisaCartao(StatusAnaliseRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/api/cartoes/{id}/bloqueios", consumes = "application/json", produces = "application/json")
    StatusBloqueioResponse solicitaBloqueio(@PathVariable("id") String id, BloqueioRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/api/cartoes/{id}/avisos", consumes = "application/json", produces = "application/json")
    ResultadoAvisoResponse avisaViagem(@PathVariable("id") String id, AvisosRequest request);

}
