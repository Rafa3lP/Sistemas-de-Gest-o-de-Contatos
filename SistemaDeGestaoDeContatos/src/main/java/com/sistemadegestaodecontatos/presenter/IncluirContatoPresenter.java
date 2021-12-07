package com.sistemadegestaodecontatos.presenter;

import com.sistemadegestaodecontatos.collection.ContatoCollection;
import com.sistemadegestaodecontatos.model.Contato;
import com.sistemadegestaodecontatos.view.IncluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class IncluirContatoPresenter {

    private IncluirContatoView view;
    private ContatoCollection Arraycontatos;

    public IncluirContatoPresenter(ContatoCollection contatos) {
        this.Arraycontatos = contatos;
        view = new IncluirContatoView();
        
        //esconder o botao editar
        this.view.getBtnEditar().setVisible(false);

        JButton fecha = view.getBtnFechar();
        fecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clicado) {
                fechar();
            }
        });

        JButton salva = view.getBtnSalvar();
        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clicado) {
                salvar();
                //fechar();
            }
        });
        view.setVisible(true);
    }
    /*
    * possivel violação do Princípio de Responsabilidade Única (SRP)
    * onde a classe incluirContatosPresenter Tembém tem o papel de visualizar 
    * e editar um contato
    */
    /*public IncluirContatoPresenter(ContatoCollection contatos, int posicao) {
        this.Arraycontatos = contatos;
        view = new IncluirContatoView();

        JButton fecha = view.getBtnFechar();
        fecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clicado) {
                fechar();
            }
        });

        JButton salva = view.getBtnSalvar();
        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clicado) {
                try {
                    editar(posicao);
                    fechar();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view,
                            "Informe apenas numeros",
                            "Caracteres invalidos",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        view.setVisible(true);
    }

    private void editar(int posicao) {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        Contato contato = new Contato(nome, telefone);

        Arraycontatos.edit(posicao, contato);
    }*/

    private void fechar() {
        view.dispose();
    }

    private void salvar() {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        Contato contato = new Contato(nome, telefone);
        
        try {
            
            Arraycontatos.add(contato);

            JOptionPane.showMessageDialog(view,
                    "Contato " + contato.getNome() + " salvo com sucesso!",
                    "Salvo com sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            
            this.view.getTxtNome().setText("");
            this.view.getTxtTelefone().setText("");
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(view,
                ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /*
    * possivel violação do principio da responsabilidade unica (SRP)
    * onde a verificação do tipo de telefone deveria ser feita por ContatosCollection
    *
    private void verificaTipoTelefone(String telefone) {
        int primeiroContato = Integer.parseInt(telefone);
    }*/
}
