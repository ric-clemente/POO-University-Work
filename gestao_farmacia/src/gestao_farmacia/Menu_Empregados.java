package gestao_farmacia;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */

 public class Menu_Empregados {
     
     JTable tabela = new JTable();
     JFrame moldura = new JFrame();
     
     //Colunas da tabela Empregados
     Object[] colunas = {"Id","Nome","Cargo","Salario","Em Actividade","Ultima Actividade"};
     
     DefaultTableModel modelo = new DefaultTableModel();
     
     //Acede ao conteudo do ficheiro empregados.csv
     gestao_farmacia.Le_ficheiro le_empregados = new  gestao_farmacia.Le_ficheiro("empregados.csv");
     
     //Da o numero de linhas que o ficheiro tem
     int tamanho=le_empregados.getDados_tamanho();
      
     Menu_Empregados(){
        
         
        modelo.setColumnIdentifiers(colunas);
        
        // Insere o modelo criado na tabela
        tabela.setModel(modelo);
        
        // Modifica a cor , fundo , tamanho e cor do tipo de letra e tamanho de cada celula da tabela
        tabela.setBackground(Color.LIGHT_GRAY);
        tabela.setForeground(Color.black);
        Font fonte = new Font("",1,15);
        tabela.setFont(fonte);
        tabela.setRowHeight(30);
        
        //Criação das etiquetas para dar nome as Colunas da tabela
        JLabel etiqueta_Id = new JLabel("Id:");
        JLabel etiqueta_Nome = new JLabel("Nome:");
        JLabel etiqueta_Cargo = new JLabel("Cargo:");
        JLabel etiqueta_Salario = new JLabel("Salario:");
        JLabel etiqueta_Activo = new JLabel("Actividade:");
        
        //Etiqueta adicional
        JLabel etiqueta_Operacoes = new JLabel("Operações:");
        
        //Etiqueta criada para dar a confirmacao que o salario foi pago apos carregar no botao Pagar Salario
        JLabel etiqueta_Confirmacao = new JLabel("Salário Pago!");
        
        //Criacao de campos de texto para receber os valores da tabela
        JTextField campo_texto_Id = new JTextField();
        JTextField campo_texto_Nome = new JTextField();
        JTextField campo_texto_Cargo = new JTextField();
        JTextField campo_texto_Salario = new JTextField();
        
        
        //Criação de botões  
        JButton botao_Adicionar = new JButton("Adicionar");
        JButton botao_Eliminar = new JButton("Eliminar");
        JButton botao_Actualizar = new JButton("Actualizar");     
        JButton botao_Pagar_Salario = new JButton("Pagar Salario");     
        JButton botao_I_Actividade = new JButton("Iniciar Actividade");
        JButton botao_F_Actividade = new JButton("Finalizar Actividade");
        
        //Define o local e o tamanho dos objectos ja criados
        //Campos de texto
        campo_texto_Id.setBounds(150, 220, 100, 25);
        campo_texto_Nome.setBounds(150, 250, 100, 25);
        campo_texto_Cargo.setBounds(150, 280, 100, 25);
        campo_texto_Salario.setBounds(150, 310, 100, 25);
        
        
        //Etiquetas
        etiqueta_Id.setBounds(20, 220, 100, 25);
        etiqueta_Nome.setBounds(20, 250, 100, 25);
        etiqueta_Cargo.setBounds(20, 280, 100, 25);
        etiqueta_Salario.setBounds(20, 310, 100, 25);        
        etiqueta_Activo.setBounds(20, 340, 100, 25);        
        etiqueta_Operacoes.setBounds(500, 220, 100, 25);        
        etiqueta_Confirmacao.setBounds(600, 240, 150, 25);        
        
        //Botões
        botao_Adicionar.setBounds(300, 220, 100, 25);
        botao_Actualizar.setBounds(300, 265, 100, 25);
        botao_Eliminar.setBounds(300, 310, 100, 25);
        botao_Pagar_Salario.setBounds(600, 240, 150, 25);
        botao_I_Actividade.setBounds(150, 340, 150, 25);
        botao_F_Actividade.setBounds(150, 340, 150, 25);
        
        // Cria um painel em que a tabela irá ficar inserida
        JScrollPane painel = new JScrollPane(tabela);
        
        //Tamanho do painel
        painel.setBounds(0, 0, 1500, 200);
        
        //É preciso meter a etiqueta de confirmação de salario pago invisivel antes de carregar no botão de pagar salario
        etiqueta_Confirmacao.setVisible(false);
        
        //É preciso meter os botoes relativamente ao inicio em fim de actividade invisiveis quando o programa inicia
        botao_I_Actividade.setVisible(false);
        botao_F_Actividade.setVisible(false);
        
        moldura.setLayout(null);
        
        
        //Adiciona todos os elementos ja criados a moldura
        //Painel
        moldura.add(painel);
        
        //Campos de texto
        moldura.add(campo_texto_Id);
        moldura.add(campo_texto_Nome);
        moldura.add(campo_texto_Cargo);
        moldura.add(campo_texto_Salario);
        
        
        //Etiquetas
        moldura.add(etiqueta_Id);
        moldura.add(etiqueta_Nome);
        moldura.add(etiqueta_Cargo);
        moldura.add(etiqueta_Salario);
        moldura.add(etiqueta_Activo);
        moldura.add(etiqueta_Operacoes);
        moldura.add(etiqueta_Confirmacao);
    
        //Botões
        moldura.add(botao_Adicionar);
        moldura.add(botao_Eliminar);
        moldura.add(botao_Actualizar);
        moldura.add(botao_Pagar_Salario);
        moldura.add(botao_I_Actividade);
        moldura.add(botao_F_Actividade);
        
        //Define o tamanho da moldura
        moldura.setSize(1500,450);
        
        moldura.setLocationRelativeTo(null);
        
        //Ao fechar o menu empregados o HIDE_ON_CLOSE ira permitir que o programa não encerre
        moldura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //Torna a moldura visivel ao utilizador
        moldura.setVisible(true);
        
        int i=0;
        
        //Vai adicionar cada elemento da respectiva coluna do ficheiro empregados.csv à correspondente coluna da tabela
        for(i=0;i<tamanho;i++){
                
                modelo.addRow(new Object [] {le_empregados.getDados_coluna_1(i),le_empregados.getDados_coluna_2(i),le_empregados.getDados_coluna_3(i),le_empregados.getDados_coluna_4(i),le_empregados.getDados_coluna_5(i),le_empregados.getDados_coluna_6(i)});
            
            }
        
        //Cria um array de objectos que ira receber os valores do campo de texto e das celulas da tabela
        Object[] linha = new Object[6];
        Object[] campo_inicial = new Object[6];
        
        //Permite que o botão adicionar depois de ser clicado, adicione os valores que estao nos campos de texto à tabela
        botao_Adicionar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
             
                //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                linha[0] = campo_texto_Id.getText();
                linha[1] = campo_texto_Nome.getText();
                linha[2] = campo_texto_Cargo.getText();
                linha[3] = campo_texto_Salario.getText();
                
                //Recebe os valores padrao ao adicionar um novo empregado relativamente as colunas Em Actividade e Ultima Actividade
                linha[4] = "Nao";
                linha[5] = "Sem Informação";
                

                
                //Adiciona os novos valores ao ficheiro empregados.csv
                String conteudo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4]+","+linha[5]+"\n";
                gestao_farmacia.Escreve_ficheiro escreve_empregados=new gestao_farmacia.Escreve_ficheiro(conteudo, "empregados.csv");       
                
                //Adiciona os novos valores retirados das caixas de texto à tabela
                modelo.addRow(linha);
            }
        });
        
        //Permite que o botão eliminar depois de ser clicado, elimine os valores do campo da tabela selecionado 
        botao_Eliminar.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
            
                
                int i = tabela.getSelectedRow();
                //A acção do botão eliminar só é valida se estiver pelo menos um campo selecionado
                if(i >= 0){
                    

                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();
                    campo_inicial[5]=modelo.getValueAt(i, 5).toString();
                    
                    //Actualiza o ficheiro empregados.csv substituindo o campo que se pretende eliminar por ""
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4]+","+campo_inicial[5];
                    String novo="";
                    gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("empregados.csv",antigo,novo);                    
                    
                    //Remove da tabela o campo que está selecionado
                    modelo.removeRow(i);
                    
                }
                else{
                    System.out.println("Erro ao eliminar");
                }
            }
        });
        
        
        //Permite que o botão actualizar depois de ser clicado, substitua os valores do campo da tabela selecionado por outros defenidos nos campos de texto 
        botao_Actualizar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                
                int i = tabela.getSelectedRow();
                
                //A acção do botão actualizar só é valida se estiver pelo menos um campo selecionado
                if(i >= 0) 
                {

                    
                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();  
                    campo_inicial[5]=modelo.getValueAt(i, 5).toString();  
                    
                    //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                    linha[0] = campo_texto_Id.getText();
                    linha[1] = campo_texto_Nome.getText();
                    linha[2] = campo_texto_Cargo.getText();
                    linha[3] = campo_texto_Salario.getText();
                    linha[4] = campo_inicial[4];                    
                    linha[5] = campo_inicial[5];                    
                    
                    //Vai subsituir o campo da tabela selecionado pelos novos valores que estão defenidos nas caixas de texto
                    modelo.setValueAt(linha[0], i, 0);
                    modelo.setValueAt(linha[1], i, 1);
                    modelo.setValueAt(linha[2], i, 2);
                    modelo.setValueAt(linha[3], i, 3);
                    
                    
                    //Actualiza o ficheiro empregados.csv substituindo o campo que se pretende actualizar pelos valores que estão defenidos nas caixas de texto
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4]+","+campo_inicial[5];
                    String novo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4]+","+linha[5]+"\n";
                    gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("empregados.csv",antigo,novo);                    
                }
                else{
                    System.out.println("Erro ao actualizar");
                }
            }
        });        
        
         //Permite que o botão salário depois de ser clicado,actualize no ficheiro contabilidade o registo de pagamento do salário correspondente ao campo que foi selecionado na tabela empregados
        botao_Pagar_Salario.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                
                int i = tabela.getSelectedRow();
                //A acção do botão pagar salario só é valida se estiver pelo menos um campo selecionado
                if(i >= 0){
                
                //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela, neste caso apenas o nome e o salário correspondente
                linha[1] = campo_texto_Nome.getText();
                linha[3] = campo_texto_Salario.getText();
                
  
                
                
                
                
                gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");
                
                //Permite gerar um id automatico através da obtenção do tamanho do ficheiro contabilidade
                int tamanho_contabilidade=le_contabilidade.getDados_tamanho();
                int linha_id=tamanho_contabilidade+1;
                
                //Adiciona ao ficheiro contabilidade o registo do pagamento de salario
                String conteudo=linha_id+",Pagamento de Salario"+","+linha[1]+",1,"+"-"+linha[3]+"\n";
                gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo, "contabilidade.csv");
                
                gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                
                //Desconta o valor que esta no balanco.csv pelo valor do salario pago
                double total_balanco =Double.parseDouble(le_balanco.getDados_coluna_1(0))- (Double.parseDouble(campo_texto_Salario.getText()));
                
                //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                String novo_balanco=total_balanco+",0,0,0,0";
                gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                 
                
                //Mete o botão pagar salário invisivel depois da operação do clique
                botao_Pagar_Salario.setVisible(false);
                
                //Mete a etiqueta com a mensagem de confirmação de pagamento do salario visível
                etiqueta_Confirmacao.setVisible(true);
                }
            }
               
                       });
               
        
        
        //Permite que o botão Inicio da Actividade depois de ser clicado,actualize a coluna Em Actividade para o valor Sim e a respectiva data e horas na coluna Ultima Actividade. Actualiza tambem o ficheiro empregados.csv com os dados novos
        botao_I_Actividade.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                
                int i = tabela.getSelectedRow();
                
                //A acção do botão actualizar só é valida se estiver pelo menos um campo selecionado
                if(i >= 0) 
                {                
                //Recebe os valores do campo da tabela selecionado
                campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                campo_inicial[4]=modelo.getValueAt(i, 4).toString();  
                campo_inicial[5]=modelo.getValueAt(i, 5).toString();  
                
                //Recebe o valor que vai actualizar na coluna Em Actividade
                linha[4] = "Sim";
                
                //Recebe a data e hora  com o formato Ano/Mes/dia horas:minutos:segundos que vai actualizar a coluna Ultima Actividade
                DateFormat Formato_Data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date data = new Date();
                linha[5]="Entrou em "+Formato_Data.format(data);
                
                //Vai subsituir o campo da tabela selecionado pelos novos valores nas colunas Em Actividade e Ultima Actividade
                modelo.setValueAt(linha[4], i, 4);
                modelo.setValueAt(linha[5], i, 5);
                
                //Actualiza o ficheiro empregados.csv substituindo os campos que se pretende actualizar pelos novos valores 
                String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4]+","+campo_inicial[5];
                String novo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+linha[4]+","+linha[5]+"\n";
                gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("empregados.csv",antigo,novo);                            
                
                //Após o clique no botão Inicio da Actividade , irá colocar este botão invisível e o botão Fim de Actividade visível
                botao_I_Actividade.setVisible(false);
                botao_F_Actividade.setVisible(true);
                
                }
                
                
            }   
            
            });
         
        //Permite que o botão Fim da Actividade depois de ser clicado,actualize a coluna Em Actividade para o valor Nao e a respectiva data e horas na coluna Ultima Actividade. Actualiza tambem o ficheiro empregados.csv com os dados novos
        botao_F_Actividade.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                
                int i = tabela.getSelectedRow();
                
                //A acção do botão actualizar só é valida se estiver pelo menos um campo selecionado
                if(i >= 0) 
                {                
                //Recebe os valores do campo da tabela selecionado
                campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                campo_inicial[4]=modelo.getValueAt(i, 4).toString();  
                campo_inicial[5]=modelo.getValueAt(i, 5).toString();  
                
                //Recebe o valor que vai actualizar na coluna Em Actividade
                linha[4] = "Nao";
                
                //Recebe a data e hora  com o formato Ano/Mes/dia horas:minutos:segundos que vai actualizar a coluna Ultima Actividade
                DateFormat Formato_Data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date data = new Date();
                linha[5]="Saiu em "+Formato_Data.format(data);
                
                //Vai subsituir o campo da tabela selecionado pelos novos valores nas colunas Em Actividade e Ultima Actividade
                modelo.setValueAt(linha[4], i, 4);
                modelo.setValueAt(linha[5], i, 5);
                
                //Actualiza o ficheiro empregados.csv substituindo os campos que se pretende actualizar pelos novos valores 
                String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4]+","+campo_inicial[5];
                String novo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+linha[4]+","+linha[5]+"\n";
                gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("empregados.csv",antigo,novo);                            
                
                //Após o clique no botão Fim da Actividade , irá colocar este botão invisível e o botão Inicio de Actividade visível
                botao_I_Actividade.setVisible(true);
                botao_F_Actividade.setVisible(false);
                }
                
                
            }   
            
            });
        
        //Permite que ao clicar em um item da tabela , que os campos de texto recebam os valores de cada coluna da tabela respectivos
        tabela.addMouseListener(new MouseAdapter(){
        
        
        public void mouseClicked(MouseEvent e){
            
            
            int i = tabela.getSelectedRow();
            
            //Campos de texto recebem os valores do campo da tabela selecionado sendo cada coluna correspondente a um campo de texto apropriado
            campo_texto_Id.setText(modelo.getValueAt(i, 0).toString());
            campo_texto_Nome.setText(modelo.getValueAt(i, 1).toString());
            campo_texto_Cargo.setText(modelo.getValueAt(i, 2).toString());
            campo_texto_Salario.setText(modelo.getValueAt(i, 3).toString());
            
            //Recebe o valor da coluna Em Actividade do campo selecionado
            campo_inicial[4]=modelo.getValueAt(i, 4).toString();  
            
            
            
            //Mete o botao pagar salario visivel após o clique em qualquer item da tabela
            botao_Pagar_Salario.setVisible(true);
            
            //Mete a etiqueta de confirmacao de salario pago invisivel 
            etiqueta_Confirmacao.setVisible(false);
            
            //Caso o valor do campo Em Actividade seja Sim, mete o botão Inicio de Actividade Visível e o Fim de Actividade visivel
            if (campo_inicial[4].equals("Sim")){
                
                 botao_I_Actividade.setVisible(false);
                 botao_F_Actividade.setVisible(true);
            
            }
            //Caso o valor do campo Em Actividade seja diferente de Sim, mete o botão Fim de Actividade Visível e o Inicio de Actividade visivel
            else{
                botao_I_Actividade.setVisible(true);
                botao_F_Actividade.setVisible(false);
            }
        }
        });
        

        
     
        
    }
            }
        
   