package com.zup.proposta.solicitacaoanalise;

import com.zup.proposta.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "solicitacao-analise", url = "http://localhost:9999", configuration = FeignClientConfig.class)
public interface SolicitacaoAnaliseInterface {

    @PostMapping("/api/solicitacao")
    ResultadoAnalise buscaPeloDocumento(@PathVariable("documento") String documento);
}
