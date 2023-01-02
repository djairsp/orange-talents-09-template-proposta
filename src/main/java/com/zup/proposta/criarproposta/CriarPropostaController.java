package com.zup.proposta.criarproposta;

import com.zup.proposta.model.Proposta;
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

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarProposta(@RequestBody @Valid CriarPropostaRequest request, UriComponentsBuilder uriComponentsBuilder){
        Proposta proposta = request.getModel();
        entityManager.persist(proposta);
        return ResponseEntity.created(urlProposta(proposta, uriComponentsBuilder)).build();
    }

    private URI urlProposta(Proposta proposta, UriComponentsBuilder uriComponentsBuilder){
        return uriComponentsBuilder.path("/proposta/{id}").build(proposta.getId());
    }

}
