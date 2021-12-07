package com.sistemadegestaodecontatos.collection;

import com.sistemadegestaodecontatos.model.Contato;
import java.util.Comparator;

public class Comparador  implements Comparator<Contato>{        
    @Override
    public int compare(Contato contato, Contato outroContato){
        return contato.getTelefone().compareTo(outroContato.getTelefone());
    }
}
