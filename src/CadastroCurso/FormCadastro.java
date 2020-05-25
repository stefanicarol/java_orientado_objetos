 
package cadastrocurso; 
import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class FormCadastro extends javax.swing.JFrame {
   ArrayList <Curso> cursos  = new ArrayList();

    public FormCadastro() {
        initComponents();
        iniserirNoCodigo();
    }

     public void iniserirNoCodigo(){
        cursos.add(new Curso(1, 20 ,"MECANICA","RAFAEL"));
        cursos.add(new Curso(5, 30 ,"CROCHÊ","FRANCISCA"));
        cursos.add(new Informatica(2, 21 ,"JAVA","CAMILA"));
        cursos.add(new Informatica(3, 50 ,"PYTHON","JACKSON"));
        cursos.add(new Atendimento(4, 100 ,"INGLES","MADIA",3));
        cursos.add(new Atendimento(6, 80 ,"SECRETARIADO","LAURA",10));
       
   }
     
 
     
    public void inserir(){ 
      try {
        if(existeCurso(Integer.parseInt(tfCodigo.getText()))== null){ 
            if(existeCurso(tfTitulo.getText())== null){ 
            int cod = Integer.parseInt(tfCodigo.getText());
            int vagas = Integer.parseInt(tfVagas.getText());
            String titulo = tfTitulo.getText();
            String ministrante = tfMinistrante.getText();
            if(rbGeral.isSelected()){ 
                cursos.add(new Curso(cod, vagas, titulo, ministrante));
            }else if(rbPublico.isSelected()){
                 int externas = Integer.parseInt(tfExternas.getText());
                 cursos.add(new Atendimento(cod, vagas, titulo, ministrante, externas));
            }else{
                cursos.add(new Informatica(cod, vagas, titulo, ministrante));
            }
            JOptionPane.showMessageDialog(null, "Curso cadastrado com SUCESSO!");
             limpar();
            }else{
                JOptionPane.showMessageDialog(null, "*TÍTULO* de curso já existe!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "*CÓDIGO* de curso já existe!");
        } 
      }catch (Exception exe) {
          JOptionPane.showMessageDialog(null, "INSIRA OS DADOS");
           System.out.println(exe);
           return;

        }
    }
    
   public void imprimeTodos(){
       taSaida.setText("Todos os cursos: ");
       for(Curso c : cursos){
           taSaida.append("\n\t Código: " + c.getCodCurso() + ", Título: " + c.getTitulo() + ", Valor da Inscrição: R$"+ c.calculaInscricao()); 
       }
   }
    public void imprimeTipo(){
       taSaida.setText("Curso por tipo: "); 
       
        if(rbGeral.isSelected()){ 
           for(Curso c : cursos){
              if(c instanceof Curso){
                   taSaida.append("\nTítulo: " + c.getTitulo());
               } 
           }
        }else if(rbPublico.isSelected()){
           for(Curso c : cursos){
               if(c instanceof Atendimento){
                   taSaida.append("\nTítulo: " + c.getTitulo());
               } 
           }
        }else{
             for(Curso c : cursos){
               if(c instanceof Informatica){
                   taSaida.append("\nTítulo: " + c.getTitulo());
               } 
           }
        } 
   }
 
    
    
    public Curso existeCurso(int cod){
         for(Curso c : cursos){
            if(c.getCodCurso()==cod)
                 return c;
         }
          return null;
    }
    public Curso existeCurso(String titulo){
         for(Curso c : cursos){
            if(c.getTitulo().equals(titulo))
                 return c;
         }
          return null;
    }
   private void limpar() {
       tfCodigo.setText(null);
       tfVagas.setText(null);
       tfTitulo.setText(null);
       tfMinistrante.setText(null);
       tfExternas.setText(null);
       taSaida.setText(null);
       tfCodigo.requestFocus(); 
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTIPO = new javax.swing.ButtonGroup();
        buttonGroupIMPRIMIR = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbImprimir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfMinistrante = new javax.swing.JTextField();
        tfVagas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfExternas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        rbGeral = new javax.swing.JRadioButton();
        rbPratico = new javax.swing.JRadioButton();
        rbPublico = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        rbTipo = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        rbImprimir.setText("Imprimir");
        rbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbImprimirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Curso:"));

        jLabel1.setText("Código:");

        jLabel2.setText("Título:");

        jLabel3.setText("Ministrante:");

        jLabel4.setText("Vagas:");

        jLabel5.setText("Aulas Externas:");

        tfExternas.setEnabled(false);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroupTIPO.add(rbGeral);
        rbGeral.setSelected(true);
        rbGeral.setText("Geral");
        rbGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGeralActionPerformed(evt);
            }
        });

        buttonGroupTIPO.add(rbPratico);
        rbPratico.setText("Prático");
        rbPratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPraticoActionPerformed(evt);
            }
        });

        buttonGroupTIPO.add(rbPublico);
        rbPublico.setText("Atend. Público");
        rbPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPublicoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbGeral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbPratico)
                                .addGap(18, 18, 18)
                                .addComponent(rbPublico))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfExternas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfMinistrante, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbGeral)
                    .addComponent(rbPratico)
                    .addComponent(rbPublico)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMinistrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfExternas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        taSaida.setColumns(20);
        taSaida.setRows(5);
        taSaida.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado:"));
        jScrollPane1.setViewportView(taSaida);

        buttonGroupIMPRIMIR.add(rbTipo);
        rbTipo.setText("Por tipo");

        buttonGroupIMPRIMIR.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setText("Todos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(rbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTipo)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(538, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbImprimir)
                    .addComponent(rbTodos)
                    .addComponent(rbTipo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inserir();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbImprimirActionPerformed
         if(rbTodos.isSelected()){
           imprimeTodos();
       }else {
           imprimeTipo();
       }
    }//GEN-LAST:event_rbImprimirActionPerformed

    private void rbPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPublicoActionPerformed
        tfExternas.setEnabled(true);
    }//GEN-LAST:event_rbPublicoActionPerformed

    private void rbGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGeralActionPerformed
        tfExternas.setEnabled(false);
    }//GEN-LAST:event_rbGeralActionPerformed

    private void rbPraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPraticoActionPerformed
        tfExternas.setEnabled(false);
    }//GEN-LAST:event_rbPraticoActionPerformed

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
            java.util.logging.Logger.getLogger(FormCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupIMPRIMIR;
    private javax.swing.ButtonGroup buttonGroupTIPO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbGeral;
    private javax.swing.JButton rbImprimir;
    private javax.swing.JRadioButton rbPratico;
    private javax.swing.JRadioButton rbPublico;
    private javax.swing.JRadioButton rbTipo;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfExternas;
    private javax.swing.JTextField tfMinistrante;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JTextField tfVagas;
    // End of variables declaration//GEN-END:variables
}
