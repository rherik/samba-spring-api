package br.com.rherik.controllers;

import br.com.rherik.services.EscolaServices;
import br.com.rherik.model.Escola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    private EscolaServices service;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Escola findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Escola> findAll(){
        return service.findAll();
    }
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Escola postar(@RequestBody Escola escola){
        return service.postar(escola);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Escola atualizar(@RequestBody Escola escola){
        return service.atualizar(escola);
    }
    @RequestMapping(value = "/{id}",
    method = RequestMethod.DELETE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Escola deletar(@PathVariable("id") Long id){

        return service.deletar(id);
    }
}
