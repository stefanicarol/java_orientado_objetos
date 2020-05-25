package ProjetosNaoOrientadosObjetos;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefani Carol
 */

public class cadastroProdutos extends javax.swing.JFrame {

     ArrayList<String> nome = new ArrayList();
     ArrayList<String> valor = new ArrayList(); 
     ArrayList<String> categoria = new ArrayList();
     
    public cadastroProdutos() {
        initComponents();
    }

     public void inserir(){
        taSaida.setText("");
        nome.add(tfNome.getText());
        valor.add(tfValor.getText()); 
        categoria.add ((String)cbCategoria.getSelectedItem());
        tfNome.setText(null);
        tfValor.setText(null);
        tfNome.requestFocus();
               //   taSaida.append(nome + "\n" +valor + categoria);      
    }
     public void imprimir(){
         taSaida.setText("");
         for (int i=0; i<nome.size(); i++){
            int pos = i;
            taSaida.append("Nome: " +nome.get(i)
                    +", Categoria: " + categoria.get(i)
                    +", Valor: R$" +valor.get(i)
                    +", Posição: "+ pos +"\n");
        }         
     }
      public void soma(){
         taSaida.setText("");
         double total = 0;
         for (int i=0; i<valor.size(); i++){
             total = total + Double.parseDouble(valor.get(i));
            
        }   taSaida.append("Valor Total: R$"+total);      
     }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btVerificar = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        taSaida.setColumns(20);
        taSaida.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        taSaida.setRows(5);
        taSaida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 60, 80), 2));
        jScrollPane1.setViewportView(taSaida);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 60, 80));
        jLabel1.setText("Nome :");

        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbCategoria.setForeground(new java.awt.Color(0, 60, 80));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione uma Categoria>", "Material Escolar", "Brinquedo", "Livro" }));
        cbCategoria.setToolTipText("");
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 60, 80));
        jLabel2.setText("Valor :");

        tfValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 60, 80), 2));

        tfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 60, 80), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 60, 80));
        jLabel4.setText("Categoria :");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 60, 80));
        jLabel5.setText("CADASTRO DE MATERIAIS");

        jSeparator1.setBackground(new java.awt.Color(0, 60, 80));
        jSeparator1.setForeground(new java.awt.Color(0, 60, 80));

        jSeparator2.setBackground(new java.awt.Color(0, 60, 80));
        jSeparator2.setForeground(new java.awt.Color(0, 60, 80));

        btVerificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btVerificar.setForeground(new java.awt.Color(0, 60, 80));
        btVerificar.setText("Inserir Produto");
        btVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificarActionPerformed(evt);
            }
        });

        btImprimir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btImprimir.setForeground(new java.awt.Color(0, 60, 80));
        btImprimir.setText("Imprimir Produtos");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 60, 80));
        jButton3.setText("Imprimir Valor Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)))))
                .addGap(0, 36, Short.MAX_VALUE))
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarActionPerformed
       if(cbCategoria.getSelectedItem().equals("<Selecione uma Categoria>")){
            JOptionPane.showMessageDialog(null, "Escolha uma categoria!");
        }else{
            inserir();
        }
    }//GEN-LAST:event_btVerificarActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
      
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_btImprimirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        soma();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btVerificar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
