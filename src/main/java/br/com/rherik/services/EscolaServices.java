package br.com.rherik.services;

import br.com.rherik.exception.ResourceNotFoundException;
import br.com.rherik.model.Escola;
import br.com.rherik.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class EscolaServices {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    EscolaRepository repository;

    private Logger logger = Logger.getLogger(EscolaServices.class.getName());

    public List <Escola> findAll(){
        return repository.findAll();
    }

    public Escola findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso encontrado para esse ID"));
    }

    public Escola deletar(Long id){

        logger.info("Deletando escola " + id);
        Escola entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso encontrado para esse ID"));
        repository.delete(entity);
        return entity;
    }

    public Escola postar(Escola escola){
        return repository.save(escola);
    }

    public Escola atualizar(Escola escola){
        Escola entity = repository.findById(escola.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso encontrado para esse ID"));
        entity.setName(escola.getName());
        entity.setFundacao(escola.getFundacao());
        entity.setTitulos(escola.getTitulos());

        return repository.save(escola);
    }
}
