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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder encoder;
    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Gustavo Martins", "61209839024", "gustavo_mf1@hotmail.com", encoder.encode("123"));
        Tecnico tec2 = new Tecnico(null, "Bianca Bento", "21202832024", "bianca_mf1@hotmail.com", encoder.encode("123"));
        tec1.addPerfis(Perfil.ADMIN);
        tec2.addPerfis(Perfil.TECNICO);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "52543492046", "torvalds@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Zezin da Silva", "92543992046", "zezin@mail.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
