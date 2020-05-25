package ControleLivros;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author stefa
 */
public class FormControle extends javax.swing.JFrame {
  /***
  * LEMBRETE IMPORTANTE:
  * "new ArrayList" cria o ArrayList
  *  e livros é uma variavel que recebe a referência de um ArrayList
  ***/
       
    ArrayList<Livro> livros = new ArrayList();
    
 
    public FormControle() {
        initComponents();
        iniserirNoCodigo();
       
    }
    
    //String titulo, String categoria, String codigo,  float valorCompra
    public void iniserirNoCodigo(){
        livros.add(new Livro("Livro de Port", "didático","1",10));
        livros.add(new Livro("Livro de Mat", "infantil","2",20));
        livros.add(new Livro("Livro de Geo", "didático","3",25));
        livros.add(new Livro("Livro de Hist", "didático","4",12));
        livros.add(new Livro("Livro de Ingles", "outras","5",17));
   }
    
    
    public void limpar(){
       tfTitulo.setText(null);
       tfTitulo.requestFocus();
       tfCodigo.setText(null);
       tfValor.setText(null);
    }
    public Livro existeLivro(String codigo){
        for (Livro l : livros){
            if(l.getCodigo().equals(codigo))
                return l;
        }
         return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        tff = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btInserir = new javax.swing.JButton();
        btImprimirLivro = new javax.swing.JButton();
        btImprimirCategoria = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROLE DE LIVROS");

        taSaida.setColumns(20);
        taSaida.setRows(5);
        taSaida.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado:"));
        jScrollPane1.setViewportView(taSaida);

        tff.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Livros :"));
        tff.setToolTipText("");
        tff.setName("ssss"); // NOI18N

        tfTitulo.setText(" ");

        jLabel1.setText("Código:");

        jLabel4.setText("Título:");

        jLabel5.setText("Valor:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "didático", "infantil", "outras" }));
        cbCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Categoria:");

        btInserir.setText("Inserir Livro");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tffLayout = new javax.swing.GroupLayout(tff);
        tff.setLayout(tffLayout);
        tffLayout.setHorizontalGroup(
            tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tffLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tffLayout.createSequentialGroup()
                        .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValor)
                            .addComponent(tfTitulo))))
                .addGap(23, 23, 23))
            .addGroup(tffLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tffLayout.setVerticalGroup(
            tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btInserir)
                .addGap(24, 24, 24))
        );

        btImprimirLivro.setText("Imp. Livro");
        btImprimirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirLivroActionPerformed(evt);
            }
        });

        btImprimirCategoria.setText("Imp. Categoria");
        btImprimirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirCategoriaActionPerformed(evt);
            }
        });

        btRelatorio.setText("Relatório");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btImprimirCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btImprimirLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addComponent(tff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRelatorio)
                    .addComponent(btImprimirLivro)
                    .addComponent(btImprimirCategoria))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tff.getAccessibleContext().setAccessibleName("Informações:");
        tff.getAccessibleContext().setAccessibleDescription(" ");

        getAccessibleContext().setAccessibleName("TESTE");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
           if(existeLivro(tfCodigo.getText())==null){
                    Livro l = new Livro();
                    l.setCodigo(tfCodigo.getText());
                    l.setTitulo(tfTitulo.getText());
                    l.setCategoria(cbCategoria.getSelectedItem().toString());
                    l.setValorVenda(Float.parseFloat(tfValor.getText()));
                    livros.add(l);
                    limpar();
           }else{
               JOptionPane.showMessageDialog(null, "Código já cadastrado!");
           }
    }//GEN-LAST:event_btInserirActionPerformed

    private void btImprimirLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirLivroActionPerformed
       if(tfCodigo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Digite o Código!");
       }else{
           Livro l = existeLivro(tfCodigo.getText());
           if(l != null){
              tfTitulo.setText(l.getTitulo());
              tfValor.setText(Double.toString(l.getvalorCompra()));
              cbCategoria.getModel().setSelectedItem(l.getCategoria());
           }
           else{
             JOptionPane.showMessageDialog(null, "Código não encontrado!");
           }
       }
    }//GEN-LAST:event_btImprimirLivroActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        taSaida.setText("Livros Cadastrados: \n");
                   float total=0; 
                   float lucro=0;
                   for(Livro l : livros){
                       taSaida.append("Cód : "+l.getCodigo() 
                               + ", Titulo: "  + l.getTitulo() 
                               + ", Categ: " + l.getCategoria() 
                               + ", Compra: R$" + l.getvalorCompra() 
                               + ", Venda: R$" + l.valorVenda() 
                               + "\n");
                        total+=l.getvalorCompra();
                        lucro+=l.valorVenda();
                   }
                taSaida.append("Valor Total Gasto com a compra de livros da: R$"+ total+ "\n");
                taSaida.append("Valor Total se vender todos os livros da: R$"+ lucro+ "\n");
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void btImprimirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirCategoriaActionPerformed
         taSaida.setText("Livros Cadastrados por Categoria: \n"); 
            for (Livro l : livros){
                    if(l.getCategoria().equals(cbCategoria.getSelectedItem().toString())){
                       taSaida.append("Cód : "+l.getCodigo() + ", Titulo: " + l.getTitulo() + "\n");
                    } 
             }
    }//GEN-LAST:event_btImprimirCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(FormControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormControle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimirCategoria;
    private javax.swing.JButton btImprimirLivro;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JTextField tfValor;
    private javax.swing.JPanel tff;
    // End of variables declaration//GEN-END:variables
}
