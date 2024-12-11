package br.com.alura.Screenmatch.service;

import br.com.alura.Screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper(); //objeto do jackson que faz a conversão


    @Override
    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe); //lê o json e transforma na classe atribuida no parâmetro
    }
}
