package com.chaves.aula.services;

import org.springframework.stereotype.Service;

@Service
public class PensionService {

    public Double discount(Double amount){
        return amount * 0.1;
    }
}
