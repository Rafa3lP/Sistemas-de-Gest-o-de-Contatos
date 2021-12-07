package com.sistemadegestaodecontatos.model;

import java.io.Serializable;

public class Contato implements Serializable{
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return this.getNome() + " " + this.getTelefone();
    }
    
}
