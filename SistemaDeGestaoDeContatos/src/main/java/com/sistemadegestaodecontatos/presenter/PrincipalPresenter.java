package com.sistemadegestaodecontatos.presenter;

import com.sistemadegestaodecontatos.collection.ContatoCollection;
import com.sistemadegestaodecontatos.persistence.Serialization;
import com.sistemadegestaodecontatos.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PrincipalPresenter {

    private PrincipalView viewPrincipal;
    private ConsultarContatosPresenter viewListar;
    private IncluirContatoPresenter viewInlcuir;
    private ContatoCollection contatos;
    private Serialization serializacao;

    public PrincipalPresenter() {
        viewPrincipal = new PrincipalView();
        serializacao = new Serialization();

        contatos = new ContatoCollection();

        leSerializacao();

        JMenuItem novoContato = viewPrincipal.getMenNovoContato();
        novoContato.addActionListener((ActionEvent clicado) -> {
            viewInlcuir = new IncluirContatoPresenter(contatos);
        });

        JMenuItem listaContato = viewPrincipal.getNemListarContato();
        listaContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clicado) {
                viewListar = new ConsultarContatosPresenter(contatos);
            }
        });

        JMenuItem fechar = viewPrincipal.getMenFechar();
        fechar.addActionListener((ActionEvent clicado) -> {
            criaSerializacao();
            System.exit(0);
        });

        viewPrincipal.setVisible(true);
    }

    private void leSerializacao() {
        if (serializacao.lerArquivo() != null) {
            contatos = serializacao.lerArquivo();
        }
    }

    private void criaSerializacao() {
        serializacao.criarArquivo(contatos);
    }
}
