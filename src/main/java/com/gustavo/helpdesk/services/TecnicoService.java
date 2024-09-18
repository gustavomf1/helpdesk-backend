package com.gustavo.helpdesk.services;

import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.repositories.TecnicoRepository;
import com.gustavo.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }
}
