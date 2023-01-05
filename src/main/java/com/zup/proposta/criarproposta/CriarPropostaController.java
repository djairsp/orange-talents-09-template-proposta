package com.zup.proposta.criarproposta;

import com.zup.proposta.model.Proposta;
import com.zup.proposta.solicitacaoanalise.ResultadoAnalise;
import com.zup.proposta.solicitacaoanalise.SolicitacaoAnaliseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("proposta")
public class CriarPropostaController {

    private final Logger logger = LoggerFactory.getLogger(CriarPropostaController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SolicitacaoAnaliseInterface solicitacaoAnaliseInterface;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarProposta(@RequestBody @Valid CriarPropostaRequest request,
                                           UriComponentsBuilder uriComponentsBuilder){
        logger.info("Iniciando criação da Proposta");
        Proposta proposta = request.getModel();
        ResultadoAnalise resultadoAnalise = solicitacaoAnaliseInterface.buscaPeloDocumento(proposta.getCpfCnpj());
        logger.info("resultado da Analise {}", resultadoAnalise);
        proposta.setStatusProposta(resultadoAnalise);
        entityManager.persist(proposta);
        logger.info("Proposta salva com sucesso");
        return ResponseEntity.created(urlProposta(proposta, uriComponentsBuilder)).build();
    }

    private URI urlProposta(Proposta proposta, UriComponentsBuilder uriComponentsBuilder){
        return uriComponentsBuilder.path("/proposta/{id}").build(proposta.getId());
    }

}
