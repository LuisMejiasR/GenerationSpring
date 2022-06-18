package com.example.services;

import com.example.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    //inyección de clases
    @Autowired
    ClienteRepository clienteRepository;
}
