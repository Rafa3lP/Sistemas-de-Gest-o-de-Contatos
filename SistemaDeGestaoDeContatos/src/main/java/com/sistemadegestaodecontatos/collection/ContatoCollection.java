package com.sistemadegestaodecontatos.collection;

import com.sistemadegestaodecontatos.model.Contato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContatoCollection implements Serializable{

    private ArrayList<Contato> contatos;

    public ContatoCollection() {
        contatos = new ArrayList<>();
    }

    public void add(Contato contato) throws RuntimeException {
        
        if (existe(contato)) {
            
            throw new RuntimeException("Contato já exite");
            
        }else if(contato != null) {
            
            if(telefoneCorreto(contato.getTelefone())){
                contatos.add(contato);
            }else {
                throw new RuntimeException("O telefone deve ter somente números e caracteres como () -");
            }
            
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato");
        }
    }
    
    public void remove(int posicao){
        contatos.remove(posicao);
    }

    public String toString(int posicao) {
        return contatos.get(posicao).getNome();
    }
    
    public void edit(int posicao, Contato novoContato) throws RuntimeException {
        
        if (existe(novoContato)) {
            
            throw new RuntimeException("Contato já exite");
            
        }else if(novoContato != null) {
            
            if(telefoneCorreto(novoContato.getTelefone())){
                contatos.set(posicao, novoContato);
            }else {
                throw new RuntimeException("O telefone deve ter somente números e caracteres como () -");
            }
            
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato");
        }
    }
    
    //nova função para retornar um contato da lista
    public Contato getContato(int pos) {
        return this.contatos.get(pos);
    }
    
    //movida e modificada função de verificar telefone
    private boolean telefoneCorreto(String telefone) {
        if(!telefone.matches("([0-9-()]+)")){
            return false;
        }
        return true;
    }
    
    //implementada essa função pois a contains faz comparação entre objetos utilizando equals
    private boolean existe(Contato contato) {
        for(Contato c: this.contatos) {
            if(c.toString().equals(contato.toString())) {
                return true;
            }
        }
        return false;
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }
}
