package com.sistemadegestaodecontatos.presenter;

import com.sistemadegestaodecontatos.collection.ContatoCollection;
import com.sistemadegestaodecontatos.model.Contato;
import com.sistemadegestaodecontatos.view.IncluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarContatoPresenter {
    private IncluirContatoView view;
    private ContatoCollection contatos;
    private Contato contato;
    private int pos;
    
    public VisualizarContatoPresenter(ContatoCollection contatos, int posContato) {
        
        this.contatos = contatos;
        this.contato = contatos.getContato(posContato);
        this.pos = posContato;
        
        this.view = new IncluirContatoView();
        
        this.view.getTxtNome().setText(contato.getNome());
        this.view.getTxtTelefone().setText(contato.getTelefone());
        
        this.view.getBtnEditar().setVisible(true);
        this.view.getBtnEditar().setEnabled(true);
        this.view.getBtnSalvar().setEnabled(false);
        this.view.getTxtNome().setEditable(false);
        this.view.getTxtTelefone().setEditable(false);
        
        this.view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        this.view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditarContatoPresenter(view, contatos, pos);
            }
        });
        
        this.view.setVisible(true);
        
    }
    
    private void fechar() {
        this.view.dispose();
        new ConsultarContatosPresenter(contatos);
    }
    
}
