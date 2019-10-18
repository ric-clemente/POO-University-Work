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

/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */

public class Menu_Contabilidade {
    
     JTable tabela = new JTable();
     JFrame moldura = new JFrame();
    
     //Colunas da tabela Contabilidade
     Object[] colunas = {"Id","Operacao","Nome","Unidades","Euros"};
     
     DefaultTableModel modelo = new DefaultTableModel();
     
     gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");
     
     //Da o numero de linhas que o ficheiro tem
     int tamanho=le_contabilidade.getDados_tamanho();
     
     gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
     
     
      Menu_Contabilidade(){
        
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
        JLabel etiqueta_Operacao = new JLabel("Operacao:");
        JLabel etiqueta_Nome = new JLabel("Nome:");
        JLabel etiqueta_Unidades = new JLabel("Unidades:");
        JLabel etiqueta_Euros = new JLabel("Total Euros:");
        
        //Criacao da etiqueta que permite ver o balanco actual que se encontra no ficheiro balanco.csv
        JLabel etiqueta_Balanco = new JLabel("Balanco: "+le_balanco.getDados_coluna_1(0)+" Euros");
        
        //Criacao de campos de texto para receber os valores da tabela
        JTextField campo_texto_Id = new JTextField();
        JTextField campo_texto_Operacao = new JTextField();
        JTextField campo_texto_Nome = new JTextField();
        JTextField campo_texto_Unidades = new JTextField();
        JTextField campo_texto_Euros = new JTextField();
        
        //Criação de botões
        JButton botao_Adicionar = new JButton("Adicionar");
        JButton botao_Eliminar = new JButton("Eliminar");
        JButton botao_Actualizar = new JButton("Actualizar");     
        
        //Define o local e o tamanho dos objectos ja criados
        //Campos de texto        
        campo_texto_Id.setBounds(150, 220, 100, 25);
        campo_texto_Operacao.setBounds(150, 250, 100, 25);
        campo_texto_Nome.setBounds(150, 280, 100, 25);
        campo_texto_Unidades.setBounds(150, 310, 100, 25);
        campo_texto_Euros.setBounds(150, 340, 100, 25);
        
        //Etiquetas
        etiqueta_Id.setBounds(20, 220, 100, 25);
        etiqueta_Operacao.setBounds(20, 250, 100, 25);
        etiqueta_Nome.setBounds(20, 280, 100, 25);
        etiqueta_Unidades.setBounds(20, 310, 100, 25);        
        etiqueta_Euros.setBounds(20, 340, 100, 25);        
        etiqueta_Balanco.setBounds(500, 220, 200, 25);
        
        //Botões
        botao_Adicionar.setBounds(300, 220, 100, 25);
        botao_Actualizar.setBounds(300, 265, 100, 25);
        botao_Eliminar.setBounds(300, 310, 100, 25);
        
        // Cria um painel em que a tabela irá ficar inserida
        JScrollPane painel = new JScrollPane(tabela);
        
        //Tamanho do painel
        painel.setBounds(0, 0, 1300, 200);
        
        moldura.setLayout(null);
        
        //Adiciona todos os elementos ja criados a moldura
        //Painel        
        moldura.add(painel);
        
        //Campos de texto
        moldura.add(campo_texto_Id);
        moldura.add(campo_texto_Operacao);
        moldura.add(campo_texto_Nome);
        moldura.add(campo_texto_Unidades);
        moldura.add(campo_texto_Euros);
        
        //Etiquetas
        moldura.add(etiqueta_Id);
        moldura.add(etiqueta_Operacao);
        moldura.add(etiqueta_Nome);
        moldura.add(etiqueta_Unidades);
        moldura.add(etiqueta_Euros);
        moldura.add(etiqueta_Balanco);
    
        //Botões
        moldura.add(botao_Adicionar);
        moldura.add(botao_Eliminar);
        moldura.add(botao_Actualizar);
        
        //Define o tamanho da moldura
        moldura.setSize(1500,450);
        
        moldura.setLocationRelativeTo(null);
        
        //Ao fechar o menu contabilidade o HIDE_ON_CLOSE ira permitir que o programa não encerre
        moldura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //Torna a moldura visivel ao utilizador
        moldura.setVisible(true);
        
        int i=0;
        
        //Vai adicionar cada elemento da respectiva coluna do ficheiro contabilidade.csv à correspondente coluna da tabela
        for(i=0;i<tamanho;i++){
                
                modelo.addRow(new Object [] {le_contabilidade.getDados_coluna_1(i),le_contabilidade.getDados_coluna_2(i),le_contabilidade.getDados_coluna_3(i),le_contabilidade.getDados_coluna_4(i),le_contabilidade.getDados_coluna_5(i)});
            
            }
        
        //Cria um array de objectos que ira receber os valores do campo de texto e das celulas da tabela
        Object[] linha = new Object[5];
        Object[] campo_inicial = new Object[5];
        
        //Permite que o botão adicionar depois de ser clicado, adicione os valores que estao nos campos de texto à tabela
        botao_Adicionar.addActionListener(new ActionListener(){

            
            
            public void actionPerformed(ActionEvent e) {
             
                //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                linha[0] = campo_texto_Id.getText();
                linha[1] = campo_texto_Operacao.getText();
                linha[2] = campo_texto_Nome.getText();
                linha[3] = campo_texto_Unidades.getText();
                linha[4] = campo_texto_Euros.getText();
   
                //Adiciona os novos valores ao ficheiro contabilidade.csv
                String conteudo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4]+"\n";
                gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo, "contabilidade.csv");       
                
                //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                
                //O valor definido no campo de texto euros vai incrementar ou descontar o valor(se o valor for negativo) que esta no balanco.csv guardando na variavel total_balanco
                double total_balanco = Double.parseDouble(campo_texto_Euros.getText())+Double.parseDouble(le_balanco.getDados_coluna_1(0));    
                
                //Actualiza o ficheiro balanco.csv e a etiqueta balanco substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                String novo_balanco=total_balanco+",0,0,0,0";
                gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                                     
                etiqueta_Balanco.setText("Balanco: "+total_balanco+" Euros");
                
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
                    
                    //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                    linha[0] = campo_texto_Id.getText();
                    linha[1] = campo_texto_Operacao.getText();
                    linha[2] = campo_texto_Nome.getText();
                    linha[3] = campo_texto_Unidades.getText();
                    linha[4] = campo_texto_Euros.getText();
                    
                    //Actualiza o ficheiro contabilidade.csv substituindo o campo que se pretende eliminar por ""
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4];
                    String novo="";
                    gestao_farmacia.Modifica_ficheiro actualiza_contabilidade= new gestao_farmacia.Modifica_ficheiro("contabilidade.csv",antigo,novo);                    
                    
                    //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                    gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                    
                    //O valor definido no campo de texto euros vai descontar ou incrementar o valor(se o valor for negativo) que esta no balanco.csv guardando na variavel total_balanco
                    double total_balanco =Double.parseDouble(le_balanco.getDados_coluna_1(0))- Double.parseDouble(campo_texto_Euros.getText());
                    
                    //Actualiza o ficheiro balanco.csv e a etiqueta balanco substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                    String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                    String novo_balanco=total_balanco+",0,0,0,0";
                    gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                                     
                    etiqueta_Balanco.setText("Balanco: "+total_balanco+" Euros");
                    
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
                    //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                    linha[0] = campo_texto_Id.getText();
                    linha[1] = campo_texto_Operacao.getText();
                    linha[2] = campo_texto_Nome.getText();
                    linha[3] = campo_texto_Unidades.getText();
                    linha[4] = campo_texto_Euros.getText();
                    
                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();   
                    
                    gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                    
                    //Faz a diferença entre o valor antigo em euros  e o valor novo em euros defenido na caixa de texto
                    double diferenca= Double.parseDouble(campo_texto_Euros.getText()) - Double.parseDouble(modelo.getValueAt(i, 4).toString()) ;
                    
                    //Incrementa essa diferença ao valor que esta no ficheiro balanço.csv para o actualizar
                    double total_balanco = Double.parseDouble(le_balanco.getDados_coluna_1(0))+diferenca;
                    
                    //Actualiza o ficheiro balanco.csv e a etiqueta balanco substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                    String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                    String novo_balanco=total_balanco+",0,0,0,0";
                    gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                                     
                    etiqueta_Balanco.setText("Balanco: "+total_balanco+" Euros");                    
                    
                    //Actualiza o ficheiro contabilidade.csv substituindo o campo que se pretende actualizar pelos valores que estão defenidos nas caixas de texto
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4];
                    String novo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4];
                    gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("contabilidade.csv",antigo,novo);   
                    
                    //Vai subsituir o campo da tabela selecionado pelos novos valores que estão defenidos nas caixas de texto
                    modelo.setValueAt(linha[0], i, 0);
                    modelo.setValueAt(linha[1], i, 1);
                    modelo.setValueAt(linha[2], i, 2);
                    modelo.setValueAt(linha[3], i, 3);
                    modelo.setValueAt(linha[4], i, 4);                    
                }
                else{
                    System.out.println("Erro ao actualizar");
                }
            }
        });

        //Permite que ao clicar em um item da tabela , que os campos de texto recebam os valores de cada coluna da tabela respectivos
        tabela.addMouseListener(new MouseAdapter(){
        
        
        public void mouseClicked(MouseEvent e){
            
            
            int i = tabela.getSelectedRow();
            
            //Campos de texto recebem os valores do campo da tabela selecionado sendo cada coluna correspondente a um campo de texto apropriado
            campo_texto_Id.setText(modelo.getValueAt(i, 0).toString());
            campo_texto_Operacao.setText(modelo.getValueAt(i, 1).toString());
            campo_texto_Nome.setText(modelo.getValueAt(i, 2).toString());
            campo_texto_Unidades.setText(modelo.getValueAt(i, 3).toString());
            campo_texto_Euros.setText(modelo.getValueAt(i, 4).toString());
     
        }
        });        
     
        
    }
}
   