package com.kumulus.desafio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kumulus.desafio.model.Endereco;
import com.kumulus.desafio.util.StringUtils;

@Service
public class CepService {

    private final String API_URL = "http://viacep.com.br/ws/{cep}/json/";

    public Endereco consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = API_URL.replace("{cep}", StringUtils.removerFormatacaoCep(cep));

        // Consulta a API pública usando RestTemplate
        return restTemplate.getForObject(apiUrl, Endereco.class);
    }
}