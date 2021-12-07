package com.sistemadegestaodecontatos.presenter;

import com.sistemadegestaodecontatos.collection.ContatoCollection;
import com.sistemadegestaodecontatos.model.Contato;
import com.sistemadegestaodecontatos.view.IncluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarContatoPresenter {
    private IncluirContatoView view;
    private ContatoCollection contatos;
    private int pos;
    
    public EditarContatoPresenter(IncluirContatoView view, ContatoCollection contatos, int pos) {
        this.pos = pos;
        this.view = view;
        this.contatos = contatos;
        view.getBtnEditar().setEnabled(false);
        this.view.getBtnSalvar().setEnabled(true);
        this.view.getTxtNome().setEditable(true);
        this.view.getTxtTelefone().setEditable(true);
        
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
        
    }
    
    private void salvar() {
        
        String nome = this.view.getTxtNome().getText();
        String telefone = this.view.getTxtTelefone().getText();
        
        Contato novoContato = new Contato(nome, telefone);
        
        try {
            
            this.contatos.edit(this.pos, novoContato);

            JOptionPane.showMessageDialog(view,
                    "Contato " + novoContato.getNome() + " salvo com sucesso!",
                    "Salvo com sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch(RuntimeException ex) {
            JOptionPane.showMessageDialog(view,
                ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
        
        this.view.dispose();
        new VisualizarContatoPresenter(contatos, pos);
        
    }
    
}
