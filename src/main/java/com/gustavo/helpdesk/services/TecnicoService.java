package com.gustavo.helpdesk.services;

import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);

        return obj.orElse(null);
    }
}
