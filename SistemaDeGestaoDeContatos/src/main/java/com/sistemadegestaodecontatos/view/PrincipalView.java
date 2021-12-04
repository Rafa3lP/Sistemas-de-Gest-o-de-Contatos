package com.sistemadegestaodecontatos.view;

import javax.swing.JMenuItem;

public class PrincipalView extends javax.swing.JFrame {

  
    public javax.swing.JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    
    public javax.swing.JMenu getMbPrincipal() {
        return mbPrincipal;
    }

   
    public javax.swing.JMenuItem getMenFechar() {
        return menFechar;
    }

   
    public javax.swing.JMenuItem getMenNovoContato() {
        return menNovoContato;
    }

   
    public javax.swing.JMenuItem getNemListarContato() {
        return nemListarContato;
    }

   
    public PrincipalView() {
        initComponents();
        this.setLocationRelativeTo(this.getParent());
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mbPrincipal = new javax.swing.JMenu();
        menNovoContato = new javax.swing.JMenuItem();
        nemListarContato = new javax.swing.JMenuItem();
        menFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de pessoas");

        mbPrincipal.setText("Opção");

        menNovoContato.setText("Novo Contato");
        menNovoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menNovoContatoActionPerformed(evt);
            }
        });
        mbPrincipal.add(menNovoContato);

        nemListarContato.setText("Listar contatos");
        nemListarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nemListarContatoActionPerformed(evt);
            }
        });
        mbPrincipal.add(nemListarContato);

        menFechar.setText("Fechar o sistema");
        mbPrincipal.add(menFechar);

        jMenuBar1.add(mbPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menNovoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menNovoContatoActionPerformed
        
    }//GEN-LAST:event_menNovoContatoActionPerformed

    private void nemListarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nemListarContatoActionPerformed
        
    }//GEN-LAST:event_nemListarContatoActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mbPrincipal;
    private javax.swing.JMenuItem menFechar;
    private javax.swing.JMenuItem menNovoContato;
    private javax.swing.JMenuItem nemListarContato;
    // End of variables declaration//GEN-END:variables

}
