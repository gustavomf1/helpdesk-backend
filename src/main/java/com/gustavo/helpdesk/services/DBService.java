package com.gustavo.helpdesk.services;

import com.gustavo.helpdesk.domain.Chamado;
import com.gustavo.helpdesk.domain.Cliente;
import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.domain.enums.Perfil;
import com.gustavo.helpdesk.domain.enums.Prioridade;
import com.gustavo.helpdesk.domain.enums.Status;
import com.gustavo.helpdesk.repositories.ChamadoRepository;
import com.gustavo.helpdesk.repositories.ClienteRepository;
import com.gustavo.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Gustavo Martins", "61209839024", "gustavo_mf1@hotmail.com", "123");
        tec1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "52543492046", "torvalds@mail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
