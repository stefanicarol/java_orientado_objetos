package ProvaG1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stéfani Carol
 */

public class FormProva extends javax.swing.JFrame {
 ArrayList <Object> funcionarios  = new ArrayList();
 ArrayList <Aluno> alunos  = new ArrayList();
 ArrayList <Aula> aulas  = new ArrayList();
 int cod = 1; 
   
    public FormProva() {
        initComponents();
        iniserirNoCodigo(); 
        desabilitarAula();
        desabilitar();
    }
    
     public void iniserirNoCodigo(){   
        funcionarios.add(new Professor("Matematica", 2500.00,10, "Adriana Ribeiro", 52, 1111, 6));
        funcionarios.add(new Professor("Matematica", 3550.00, 12, "Tatiana S.", 52, 2222, 6));
        funcionarios.add(new Professor("Matematica", 1100.00,110, "Daniela Almeida", 52, 3333, 6));
        funcionarios.add(new Professor("Portugues", 1200.00, 25, "Marcos Sena", 52, 4444, 6));
        funcionarios.add(new Professor("Portugues",  1250.00, 10,"Ana Carolina", 52, 5555, 6));
        funcionarios.add(new Professor("Ingles", 2500.00, 25, "Pedro Henrique", 52, 6666, 6));
        funcionarios.add(new Professor("Quimica", 1500.00, 25, "Miguel Santos", 52, 7777, 6));
        funcionarios.add(new Professor("Fisica", 900.00, 25, "Simony Gonçalves", 52, 8888, 6));
        funcionarios.add(new Professor("Geografia", 2500.00, 25,"Stela Moara", 52, 9999, 6));
        funcionarios.add(new Professor("Historia",3550.00, 25,"Scarlate Orrana", 52, 1010, 6));
        funcionarios.add(new Professor("Religiao", 1500.00, 15,"Silas Arruda", 52, 1011, 6));  
        funcionarios.add(new Diretor(3550.00, 45, "Maria Julia", 1012, 6));
        funcionarios.add(new Diretor(2500.00, 51, "Roberto Cabral", 1013, 6));
        alunos.add(new Aluno(7.0,8.0, "João Silva Souza", 52, 1013, 0));
        alunos.add(new Aluno(6.6,3.0, "Sandra Silva Souza", 52, 1014, 2));
        alunos.add(new Aluno( 6.0,10.0, "Joaquina Martins Anreu", 52, 1015, 4));
        alunos.add(new Aluno(6.0,10.0, "Felipe Souza", 52, 1016, 6));
        alunos.add(new Aluno(6.0,10.0, "Francisca Santos", 52, 1017, 10));
        alunos.add(new Aluno(6.0,10.0, "Maria Martins", 52, 1018, 12));  
     }
     
     
      /*** MÉTODO PREENCHER AS COMBOBOX -- ONDE, AO SELECIONAR A DISCIPLINA SÓ APARECERÃO NA PROXIMA CBX
       OS PROFESSORES QUE FORAM CADASTRADOS PARA AQUELA DISCIPLINA  ***/ 
     
    public void preencheCombosTurma(){
         cbxProfessorAula.removeAllItems();
         cbxAlunoAula.removeAllItems();
    for(Object p : funcionarios){        
         if(p instanceof Professor){ 
          if(((Professor) p).getDisciplinas().equals(cbxDisciplinaAula.getSelectedItem().toString())){     
              cbxProfessorAula.addItem(((Professor)p).getNome());                   
           }  
         }
       }   
    for(Aluno p : alunos){   
         if(p instanceof Aluno){ 
           cbxAlunoAula.addItem(((Aluno)p).getNome());           
       } 
      }
    }
    
    /***  MÉTODO CRIAR AULA DE REFORÇO  ***/  
    public void criarAula(){
    try{
        String d = cbxDisciplinaAula.getSelectedItem().toString();
        //Object p = funcionarios.get(cbxProfessorAula.getSelectedIndex());
        Aluno a = alunos.get(cbxAlunoAula.getSelectedIndex());
        int h =  Integer.parseInt(tfHoraAula.getText()); 
        for(Object p : funcionarios){ 
            if(p instanceof Professor){
                if(cbxProfessorAula.getSelectedItem().equals(((Professor) p).getNome())){
                    ((Professor) p).SalarioExtra(h);
                     aulas.add(new Aula(cod, d, (Pessoa) p, a, h));  
                }
           }
        }
        cod++;
         
        JOptionPane.showMessageDialog(null, "Aula Cadastrada com SUCESSO!");
    }catch (Exception exe) {
          JOptionPane.showMessageDialog(null, "INSIRA TODOS OS DADOS");
           System.out.println(exe);
        } 
   }
 
   /***  MÉTODO INSERIR PROFESSOR/DIRETOR/ALUNO  ***/  
     public void inserir(){
     try {
     if(existePessoa(Integer.parseInt(tfMatricula.getText()))== null){  
            int matricula = Integer.parseInt(tfMatricula.getText());
            int idade = Integer.parseInt(tfIdade.getText());
            int faltas = Integer.parseInt(tfFaltas.getText());
            String nome = tfNome.getText();
            if(rbDiretor.isSelected()){ 
                double salario = Double.parseDouble(tfSalario.getText());
                funcionarios.add(new Diretor( salario, idade, nome, matricula, faltas));
            }  
            else if(rbProfessor.isSelected()){
                double salario = Double.parseDouble(tfSalario.getText());
                String disciplina = cbxDisciplina.getSelectedItem().toString(); 
                int ValorHA = Integer.parseInt(tfValorHA.getText());  
                funcionarios.add(new Professor(disciplina, salario, ValorHA, nome, idade, matricula, faltas));
            }else{
                 double nota1 = Double.parseDouble(tfNota1.getText());
                 double nota2 = Double.parseDouble(tfNota2.getText());                 
                 alunos.add(new Aluno(nota1, nota2, nome, idade, matricula, faltas)); 
            }
            JOptionPane.showMessageDialog(null, "Cadastrado feito com SUCESSO!");
             limpar();
             
        } else{
            JOptionPane.showMessageDialog(null, "Já existe pessoa cadastrada com essa *MATRÍCULA*!");
        } 
        }catch (Exception exe) {
          JOptionPane.showMessageDialog(null, "INSIRA TODOS OS DADOS");
           System.out.println(exe); 
        } 
   } 
     
   /***  MÉTODO IMPRIMIR SE O ALUNO FOI APROVADO OU REPROVADO ***/    
     
   public void imprimeAprovado(){ 
      if(tfMatricula.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Digite a matrícula do Aluno!");
       }else{
             Pessoa p = existeAluno(Integer.parseInt(tfMatricula.getText())); 
           if(p != null){               
                  if(((Aluno)p).Aprovado() == true){
                         taSaida.append("\nAluno(a): " + ((Aluno)p).getNome() +" REPROVADO! ");
                  }else{ 
                        taSaida.append("\nAluno(a): " + ((Aluno)p).getNome() +" APROVADO! ");
                  }                 
           }
           else{
             JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
           }
       } 
    } 
   
   
    
   
   /***  MÉTODO IMPRIMIR RELATÓRIO DAS AULAS DE REFORÇO***/    
    private void imprimeaAulas() { 
         taSaida.setText("Aulas de Reforço: \n");
         for(Aula a : aulas){
              taSaida.append(a.toString()+"\n");
          
         }
   }
    
    
    
  /***  
        MÉTODO IMPRIMIR LISTA DE FUNCIONÁRIOS PROFESSOR / DIRETOR         
  ***/  
    
    public void imprimeFuncionarios(){
       for(Object p : funcionarios){  
           
                if(p instanceof Diretor){
                      taSaida.append("Diretor: " +p.toString()+"\n");
                 }  
                if(p instanceof Professor){
                       taSaida.append("Professor " + p.toString()+"\n");
                }  
         }
  }
    
    
    
    
    
    /***  MÉTODO IMPRIMIR LISTA DE ALUNOS ***/
    
    public void imprimeAlunos(){
      for(Aluno p : alunos){
              if(p instanceof Aluno){
                   taSaida.append(p.toString()+"\n");
               } 
           }
    }  
    
  /***  MÉTODO IMPRIMIR DADOS DE ALUNO, SENDO QUE DEVERÁ INSERIR A 
        MATRICULA NO CAMPO DE MATRICULA DO ALUNO QUE DESEJA IMPRIMIR ***/
    
    private void imprimeDadoAluno() {
        if(tfMatricula.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Digite a matrícula do Aluno!");
       }else{
           Pessoa p = existeAluno(Integer.parseInt(tfMatricula.getText())); 
           if(p != null){ 
              if(p instanceof Aluno){
                   taSaida.append(((Aluno)p).toString()+"\n");
               }  
           }
           else{
             JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
           }
       }
     }
 
 /***  MÉTODO IMPRIMIR DADOS DE PROFESSOR SENDO QUE DEVERÁ INSERIR A 
        MATRICULA NO CAMPO DE MATRICULA DO PROFESSOR OU DIRETOR QUE DESEJA IMPRIMIR ***/
    
    
    private void imprimeSalarioProfessor() { 
        if(tfMatricula.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Digite a matrícula Funcional do Professor!");
       }else{
           Pessoa p = existeFuncionario(Integer.parseInt(tfMatricula.getText()));  
           if((Pessoa) p != null){ 
               if(p instanceof Professor){
                double salario = ((Funcionario)p).SalarioLiquido(); 
                taSaida.append( p.getNome()+"\n");
                taSaida.append("Salário Fixo R$ "+ salario +"\n" );
                taSaida.append("Extra Aulas de Reforço R$ " + ((Funcionario)p).getHoraExtra());
             } 
           } 
           else{
             JOptionPane.showMessageDialog(null, "Matrícula Funcional não encontrada!");
           }
         }
      } 
    
    /***  MÉTODO IMPRIMIR SALARIO DIRETOR***/
    
    
    private void imprimeSalarioDiretor() { 
        if(tfMatricula.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Digite a matrícula Funcional do Diretor!");
       }else{
           Pessoa p = existePessoa(Integer.parseInt(tfMatricula.getText()));  
           if((Pessoa) p != null){ 
               if(p instanceof Diretor){
                double salario = ((Funcionario)p).SalarioLiquido(); 
                taSaida.append( p.getNome()+"\n");
                taSaida.append("Salário R$ "+ salario +"\n" ); 
             } 
           } 
           else{
             JOptionPane.showMessageDialog(null, "Matrícula Funcional não encontrada!");
           }
         }
      } 
    
    
     /***  MÉTODO IMPRIMIR TODOS OS PROFESSORES DE UMA DETERMINADA DISCIPLINA
           SENDO QUE DEVERÁ SER SELECIONADO NO COMBOBOX QUAL A DISCIPLINA ***/
    
   private void imprimeDisciplinas() { 
        for(Object p : funcionarios){  
             if(p instanceof Professor){
             if(((Professor)p).getDisciplinas().equals(cbxDisciplina.getSelectedItem().toString())){             
              taSaida.append(((Professor)p).getNome()+"\n"); 
             } 
         }
      }
   }
   
   /***  MÉTODO QUE IMPRIME A MAIOR MÉDIA DOS ALUNOS CADASTRADOS ***/
   
   private void imprimeMedia(){
     double maiorMedia = 0;
     for(Pessoa p : alunos){          
           if(maiorMedia < ((Aluno) p).Media()){
           maiorMedia = ((Aluno) p).Media();             
         }
      }taSaida.append("Maior Média: " +maiorMedia);
    }
   
   
    /***  MÉTODO QUE VERIFICA SE EXISTE UMA PESSOA CADASTRADA
          COM A MESMA MATRICULA  ***/  
   
   
    public Pessoa existePessoa(int matricula){
         for(Object p : funcionarios){
             if(p instanceof Professor){
             if(((Professor) p).getMatricula()== matricula){
                 return (Pessoa) p;
                 }
             }  
             if(p instanceof Diretor){
             if(((Diretor) p).getMatricula()== matricula){
                 return (Pessoa) p;
                 }
             }  
         }
         for(Pessoa p : alunos){ 
            if(p.getMatricula() == matricula)
                 return p; 
        }
          return null;
    } 
    
    
    /***  MÉTODO QUE VERIFICA SE EXISTE UM ALUNO CADASTRADA
          COM A MESMA MATRICULA  ***/  
    
    public Pessoa existeAluno(int matricula){
         for(Pessoa p : alunos){ 
            if(p.getMatricula() == matricula)
                 return p; 
        }
          return null;
    }
    
    /***  MÉTODO QUE VERIFICA SE EXISTE UM FUNCIONARIO CADASTRADA
          COM A MESMA MATRICULA  ***/
    
    public Pessoa existeFuncionario(int matricula){
         for(Object p : funcionarios){
             if(p instanceof Funcionario){
             if(((Professor) p).getMatricula()== matricula){
                 return (Pessoa) p;
                }
             }   
         }
          return null;
    } 
   
    
    
    /***  MÉTODO LIMPAR ***/
   public void limpar(){
        tfSalario.setText(null);
        tfValorHA.setText(null);
        tfMatricula.setText(null);
        tfNome.setText(null);
        tfIdade.setText(null);
        tfFaltas.setText(null);       
        tfSalario.requestFocus();
        tfNota1.setText(null);
        tfNota2.setText(null); 
        tfNome.requestFocus();
    }  
   public void desabilitarAula(){ 
            cbxDisciplinaAula.setEnabled(false);
            cbxProfessorAula.setEnabled(false);      
            cbxAlunoAula.setEnabled(false);
            tbAula.setEnabled(false); 
            atualizar1.setEnabled(false); 
            tfHoraAula.setEnabled(false); 
  }
  public void desabilitar(){ 
            btInserir.setEnabled(false);
            tfMatricula.requestFocus();           
            tfMatricula.setEnabled(false);
            tfNome.setEnabled(false); 
            tfIdade.setEnabled(false); 
            tfFaltas.setEnabled(false);
            tfSalario.setEnabled(false);
            tfNota1.setEnabled(false);
            tfNota2.setEnabled(false);
            tfValorHA.setEnabled(false);
            cbxDisciplina.setEnabled(false); 
  }
  public void habilitar(){
            btInserir.setEnabled(true); 
            buttonGroup2.clearSelection();            
            tfNome.setEnabled(true); 
            tfIdade.setEnabled(true); 
            tfFaltas.setEnabled(true); 
            tfMatricula.setEnabled(true); 
            tfValorHA.setEnabled(true); 
            tfSalario.setEnabled(true);
            tfNota1.setEnabled(false);
            tfNota2.setEnabled(false);
            cbxDisciplina.setEnabled(true); 
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbAluno = new javax.swing.JRadioButton();
        rbProfessor = new javax.swing.JRadioButton();
        rbDiretor = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        tfNota1 = new javax.swing.JTextField();
        tfNota2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxDisciplina = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tfValorHA = new javax.swing.JTextField();
        btInserir = new javax.swing.JButton();
        tfFaltas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfIdade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cbxDisciplinaAula = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Série3 = new javax.swing.JLabel();
        cbxProfessorAula = new javax.swing.JComboBox<>();
        atualizar1 = new javax.swing.JButton();
        tbAula = new javax.swing.JButton();
        cbxAlunoAula = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        tfHoraAula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbAula = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rbSalario = new javax.swing.JRadioButton();
        rbDisciplinas = new javax.swing.JRadioButton();
        rbSalarioDiretor = new javax.swing.JRadioButton();
        rbListaTodos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbAprovado = new javax.swing.JRadioButton();
        rbDadoAluno = new javax.swing.JRadioButton();
        rbMedia = new javax.swing.JRadioButton();
        rbListaAlunos = new javax.swing.JRadioButton();
        btImprimir = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        rbAulas = new javax.swing.JRadioButton();

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO :"));

        buttonGroup1.add(rbAluno);
        rbAluno.setText("ALUNO");
        rbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlunoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbProfessor);
        rbProfessor.setText("PROFESSOR");
        rbProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProfessorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbDiretor);
        rbDiretor.setText("DIRETOR");
        rbDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDiretorActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));

        jLabel2.setText("Nota 1 :");

        jLabel3.setText("Nota 2 :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Diretor / Professor"));

        jLabel6.setText("Salário :");

        jLabel8.setText("Disciplina :");

        cbxDisciplina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portugues", "Matematica", "Quimica", "Fisica", "Ingles", "Religiao", "Historia", "Geografia" }));
        cbxDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDisciplinaActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor Hora/Aula:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfSalario)
                        .addComponent(cbxDisciplina, 0, 143, Short.MAX_VALUE))
                    .addComponent(tfValorHA, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btInserir.setText("INSERIR ");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        jLabel4.setText("Faltas :");

        jLabel9.setText("Nome :");

        jLabel10.setText("Idade :");

        jLabel11.setText("Matrícula :");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Aula de Reforço :"));

        cbxDisciplinaAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portugues", "Matematica", "Quimica", "Fisica", "Ingles", "Religiao", "Historia", "Geografia" }));

        jLabel13.setText("Disciplina:");

        Série3.setText("Professor:");

        cbxProfessorAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProfessorAulaActionPerformed(evt);
            }
        });

        atualizar1.setText("✓");
        atualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizar1ActionPerformed(evt);
            }
        });

        tbAula.setText("CRIAR AULA");
        tbAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAulaActionPerformed(evt);
            }
        });

        cbxAlunoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlunoAulaActionPerformed(evt);
            }
        });

        jLabel16.setText("Aluno:");

        jLabel1.setText("Hora/Aula:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Série3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel16))
                            .addComponent(jLabel13))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxDisciplinaAula, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAlunoAula, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cbxProfessorAula, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(atualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(210, 210, 210))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbAula, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHoraAula, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDisciplinaAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProfessorAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Série3)
                    .addComponent(atualizar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAlunoAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfHoraAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbAula)
                .addGap(66, 66, 66))
        );

        buttonGroup1.add(rbAula);
        rbAula.setText("AULA");
        rbAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbAula, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbProfessor)
                            .addComponent(rbDiretor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAluno)
                            .addComponent(rbAula))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btInserir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("RELATÓRIOS :"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Diretor / Professor :"));

        buttonGroup2.add(rbSalario);
        rbSalario.setText("Salário Professor");
        rbSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalarioActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbDisciplinas);
        rbDisciplinas.setText("Professor por Disciplina");
        rbDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisciplinasActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbSalarioDiretor);
        rbSalarioDiretor.setText("Salário Diretor");
        rbSalarioDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalarioDiretorActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbListaTodos);
        rbListaTodos.setText("Lista Funcionários");
        rbListaTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListaTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbListaTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbDisciplinas, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(rbSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(rbSalarioDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbSalario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSalarioDiretor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDisciplinas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbListaTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno :"));

        buttonGroup2.add(rbAprovado);
        rbAprovado.setText("Aprovado");
        rbAprovado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAprovadoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbDadoAluno);
        rbDadoAluno.setText("Dados Aluno");
        rbDadoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDadoAlunoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbMedia);
        rbMedia.setText("Maior Média");
        rbMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMediaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbListaAlunos);
        rbListaAlunos.setText("Lista Alunos");
        rbListaAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListaAlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rbDadoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbListaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAprovado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDadoAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbListaAlunos)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        btImprimir.setText("IMPRIMIR");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        taSaida.setColumns(20);
        taSaida.setRows(5);
        taSaida.setBorder(javax.swing.BorderFactory.createTitledBorder("Saídas  :"));
        jScrollPane1.setViewportView(taSaida);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Aulas :"));

        buttonGroup2.add(rbAulas);
        rbAulas.setText("Relatório de Aulas");
        rbAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAulasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAulas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btImprimir)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMediaActionPerformed
            desabilitarAula();
            desabilitar(); 
            limpar();
            buttonGroup1.clearSelection();  
    }//GEN-LAST:event_rbMediaActionPerformed

    private void rbAprovadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAprovadoActionPerformed
            desabilitarAula();            
            rbListaTodos.setSelected(false);
            desabilitar(); 
            limpar();
            buttonGroup1.clearSelection(); 
            tfMatricula.setEnabled(true);
    }//GEN-LAST:event_rbAprovadoActionPerformed

    private void rbDadoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDadoAlunoActionPerformed
            desabilitarAula();             
            desabilitar(); 
            limpar();
            buttonGroup1.clearSelection();
            tfMatricula.setEnabled(true);
    }//GEN-LAST:event_rbDadoAlunoActionPerformed

    private void rbListaAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListaAlunosActionPerformed
           desabilitarAula();
           buttonGroup1.clearSelection();     
           desabilitar(); 
    }//GEN-LAST:event_rbListaAlunosActionPerformed

    private void rbProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProfessorActionPerformed
            habilitar(); 
            desabilitarAula();
    }//GEN-LAST:event_rbProfessorActionPerformed

    private void rbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlunoActionPerformed
            desabilitarAula();
            habilitar();   
            limpar(); 
            tfNota1.setEnabled(true);
            tfNota2.setEnabled(true);            
            tfValorHA.setEnabled(false); 
            tfSalario.setEnabled(false);
            cbxDisciplina.setEnabled(false);
    }//GEN-LAST:event_rbAlunoActionPerformed

    private void rbDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDiretorActionPerformed
            desabilitarAula();
            habilitar(); 
            cbxDisciplina.setEnabled(false);
    }//GEN-LAST:event_rbDiretorActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
             inserir();
    }//GEN-LAST:event_btInserirActionPerformed

    private void rbSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalarioActionPerformed
            desabilitarAula();
            desabilitar(); 
            limpar();
            buttonGroup1.clearSelection();
            tfMatricula.setEnabled(true);
    }//GEN-LAST:event_rbSalarioActionPerformed

    private void rbDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisciplinasActionPerformed
            desabilitarAula();
            desabilitar(); 
            limpar();   
            buttonGroup1.clearSelection();   
            cbxDisciplina.setEnabled(true);            
    }//GEN-LAST:event_rbDisciplinasActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
      taSaida.setText(null);     
       if(rbAprovado.isSelected()){
           imprimeAprovado();
       }else if (rbListaAlunos.isSelected()){
           imprimeAlunos();
       }else if (rbMedia.isSelected()){
           imprimeMedia();
       }else if (rbDadoAluno.isSelected()){
           imprimeDadoAluno();
       }else if (rbSalario.isSelected()){
           imprimeSalarioProfessor();
       }else if (rbDisciplinas.isSelected()){
           imprimeDisciplinas();
       }else if (rbAulas.isSelected()){
           imprimeaAulas();
       }else if (rbSalarioDiretor.isSelected()){
           imprimeSalarioDiretor();
       }else{
            imprimeFuncionarios();
       }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void rbListaTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListaTodosActionPerformed
          desabilitarAula();
           desabilitar();
    }//GEN-LAST:event_rbListaTodosActionPerformed

    private void rbSalarioDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalarioDiretorActionPerformed
            desabilitarAula();
            desabilitar(); 
            limpar();
            buttonGroup1.clearSelection();
            tfMatricula.setEnabled(true);
 
    }//GEN-LAST:event_rbSalarioDiretorActionPerformed

    private void cbxDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDisciplinaActionPerformed

    private void cbxAlunoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlunoAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAlunoAulaActionPerformed

    private void rbAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAulaActionPerformed
            desabilitar(); 
            tfHoraAula.setEnabled(true); 
            cbxDisciplinaAula.setEnabled(true);
            cbxProfessorAula.setEnabled(true);      
            cbxAlunoAula.setEnabled(true);  
            tbAula.setEnabled(true); 
            atualizar1.setEnabled(true); 
            btInserir.setEnabled(false); 
  
    }//GEN-LAST:event_rbAulaActionPerformed

    private void tbAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAulaActionPerformed
        criarAula();
    }//GEN-LAST:event_tbAulaActionPerformed

    private void atualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizar1ActionPerformed
        preencheCombosTurma();
    }//GEN-LAST:event_atualizar1ActionPerformed

    private void cbxProfessorAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProfessorAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProfessorAulaActionPerformed

    private void rbAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAulasActionPerformed
            desabilitar();         
            desabilitarAula();
    }//GEN-LAST:event_rbAulasActionPerformed

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
            java.util.logging.Logger.getLogger(FormProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Série3;
    private javax.swing.JButton atualizar1;
    private javax.swing.JToggleButton btImprimir;
    private javax.swing.JButton btInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxAlunoAula;
    private javax.swing.JComboBox<String> cbxDisciplina;
    private javax.swing.JComboBox<String> cbxDisciplinaAula;
    private javax.swing.JComboBox<String> cbxProfessorAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAluno;
    private javax.swing.JRadioButton rbAprovado;
    private javax.swing.JRadioButton rbAula;
    private javax.swing.JRadioButton rbAulas;
    private javax.swing.JRadioButton rbDadoAluno;
    private javax.swing.JRadioButton rbDiretor;
    private javax.swing.JRadioButton rbDisciplinas;
    private javax.swing.JRadioButton rbListaAlunos;
    private javax.swing.JRadioButton rbListaTodos;
    private javax.swing.JRadioButton rbMedia;
    private javax.swing.JRadioButton rbProfessor;
    private javax.swing.JRadioButton rbSalario;
    private javax.swing.JRadioButton rbSalarioDiretor;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JButton tbAula;
    private javax.swing.JTextField tfFaltas;
    private javax.swing.JTextField tfHoraAula;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNota1;
    private javax.swing.JTextField tfNota2;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfValorHA;
    // End of variables declaration//GEN-END:variables

   
}
