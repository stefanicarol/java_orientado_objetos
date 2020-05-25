import java.util.ArrayList;
import javax.swing.JOptionPane;
 /**
 *
 * @author Stefani Carol
 */
public class verificaVelocidade extends javax.swing.JFrame {
     ArrayList<String> velocidadeCarro = new ArrayList(); 
     private double velocidadeMaxima;
   
    public verificaVelocidade() {
        initComponents();
    }
    public void setVelocidadeMaxima(double velocidadeMaxima) {
       velocidadeMaxima = velocidadeMaxima;
    } 
    public void verificar(){ 
        taSaida.setText("");        
        if(!tfVelCarro.getText().equals("")&& rbNao.isSelected()&& velocidadeMaxima!=0.0){      
                double velCarro = Double.parseDouble(tfVelCarro.getText()); 
            if(velCarro > velocidadeMaxima && rbNao.isSelected()){
                double multa = ((velCarro - velocidadeMaxima)*10);
                taSaida.append("Velocidade Máxima : " + velocidadeMaxima + "\n" 
                        + "Velocidade do Carro : " + velCarro + "\n" 
                        + "Multa : "+ multa + "\n" );
            }
            else{
                JOptionPane.showMessageDialog(null, "Velocidade permitida, não pagará multa!");
            }
        }else if(velocidadeMaxima==0.0){
                JOptionPane.showMessageDialog(null, "Insira a Velocidade Máxima e clique em ***Alterar Vel. Máxima***");
        }
        else if(tfVelCarro.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Insira a Velocidade do Carro!");
        }else{
                JOptionPane.showMessageDialog(null, "Indique se é ou não ambulância!");
        }
     }

    public void armazenar(){  
        double cont = 0;
        double media;
        taSaida.setText("");
        
       if(tfVelCarro.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Indique uma velocidade...");       
       } else{
            velocidadeCarro.add(tfVelCarro.getText());
            for(int i=0;i<velocidadeCarro.size();i++){
                taSaida.append(velocidadeCarro.get(i) + "\n");
                cont = cont + Double.parseDouble(velocidadeCarro.get(i));
            }       
            tfVelCarro.setText("");
            tfVelCarro.requestFocus();
            media=cont/velocidadeCarro.size();
            taSaida.append("Média :"+media+ "\n");    
       }
           
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfVelMax = new javax.swing.JTextField();
        btInserirVel = new javax.swing.JButton();
        tfVelCarro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btAlterarVel = new javax.swing.JButton();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Velocidade Máxima:");

        btInserirVel.setText("Inserir Vel. na Lista");
        btInserirVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirVelActionPerformed(evt);
            }
        });

        jLabel2.setText("Velocidade do Carro:");

        btAlterarVel.setText("Alterar Vel. Máxima");
        btAlterarVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarVelActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSim);
        rbSim.setText("Sim");

        buttonGroup1.add(rbNao);
        rbNao.setText("Não");

        jLabel3.setText("É ambulância?");

        btVerificar.setText("Verificar");
        btVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificarActionPerformed(evt);
            }
        });

        taSaida.setColumns(20);
        taSaida.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        taSaida.setRows(5);
        taSaida.setText("Saída:");
        taSaida.setName(""); // NOI18N
        jScrollPane1.setViewportView(taSaida);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 60, 80));
        jLabel4.setText("VELOCIDADE CARROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(tfVelMax, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterarVel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfVelCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btInserirVel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(rbSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNao))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfVelMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterarVel))
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVelCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btInserirVel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSim)
                    .addComponent(rbNao)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addComponent(btVerificar)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarActionPerformed
            if(rbSim.isSelected() ){
                    JOptionPane.showMessageDialog(null, "Ambulância, sem controle de velocidade!");
              taSaida.setText("");
            }else{
                verificar();
            }

    }//GEN-LAST:event_btVerificarActionPerformed

    private void btInserirVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirVelActionPerformed
           armazenar();
    }//GEN-LAST:event_btInserirVelActionPerformed

    private void btAlterarVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarVelActionPerformed
           if(tfVelMax.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Indique uma velocidade Máxima...");       
       }else{
            velocidadeMaxima = Double.parseDouble(tfVelMax.getText());
           }
    }//GEN-LAST:event_btAlterarVelActionPerformed

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
            java.util.logging.Logger.getLogger(verificaVelocidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verificaVelocidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verificaVelocidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verificaVelocidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verificaVelocidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarVel;
    private javax.swing.JButton btInserirVel;
    private javax.swing.JButton btVerificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfVelCarro;
    private javax.swing.JTextField tfVelMax;
    // End of variables declaration//GEN-END:variables

  
}
