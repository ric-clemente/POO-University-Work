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

 public class Menu_Produtos {
     
     JTable tabela = new JTable();
     JFrame moldura = new JFrame();
     
     //Colunas da tabela Produtos
     Object[] colunas = {"Id","Nome","Custo por Unidade","Preco de Venda","Total Unidades"};
     
     DefaultTableModel modelo = new DefaultTableModel();
     
     //Acede ao conteudo do ficheiro produtos.csv
     gestao_farmacia.Le_ficheiro le_produtos = new  gestao_farmacia.Le_ficheiro("produtos.csv");
     
     //Da o numero de linhas que o ficheiro tem
     int tamanho=le_produtos.getDados_tamanho();
     
      Menu_Produtos(){
        
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
        JLabel etiqueta_Custo = new JLabel("Custo por Unidade:");
        JLabel etiqueta_Venda = new JLabel("Preco de Venda:");
        JLabel etiqueta_Unidades = new JLabel("Total Unidades:");
        
        //Etiquetas adicionais
        JLabel etiqueta_Operacoes = new JLabel("Operacoes:");
        JLabel etiqueta_Unidades_Venda = new JLabel("Nº Unidades:");

        //Etiqueta criada para dar a confirmacao que a venda foi registada apos carregar no botão Vender
        JLabel etiqueta_Confirmacao = new JLabel("Venda Registada!");
        
        
        //Criacao de campos de texto para receber os valores da tabela
        JTextField campo_texto_Id = new JTextField();
        JTextField campo_texto_Nome = new JTextField();
        JTextField campo_texto_Custo = new JTextField();
        JTextField campo_texto_Venda = new JTextField();
        JTextField campo_texto_Unidades = new JTextField();
        
        //campos de texto para receber os valor de nr de unidades para venda
        JTextField campo_texto_Unidades_Venda = new JTextField();
        
        
        //Criação de botões 
        JButton botao_Adicionar = new JButton("Adicionar");
        JButton botao_Eliminar = new JButton("Eliminar");
        JButton botao_Actualizar = new JButton("Actualizar");     
        JButton botao_Vender = new JButton("Vender");     
        
        //Define o local e o tamanho dos objectos já criados
        //Campos de texto
        campo_texto_Id.setBounds(150, 220, 100, 25);
        campo_texto_Nome.setBounds(150, 250, 100, 25);
        campo_texto_Custo.setBounds(150, 280, 100, 25);
        campo_texto_Venda.setBounds(150, 310, 100, 25);
        campo_texto_Unidades.setBounds(150, 340, 100, 25);
        campo_texto_Unidades_Venda.setBounds(540, 270, 50, 25);
        
        //Etiquetas
        etiqueta_Id.setBounds(20, 220, 100, 25);
        etiqueta_Nome.setBounds(20, 250, 100, 25);
        etiqueta_Custo.setBounds(20, 280, 150, 25);
        etiqueta_Venda.setBounds(20, 310, 150, 25);        
        etiqueta_Unidades.setBounds(20, 340, 150, 25);        
        etiqueta_Confirmacao.setBounds(600, 240, 150, 25);
        etiqueta_Operacoes.setBounds(500, 220, 100, 25);
        etiqueta_Unidades_Venda.setBounds(460, 270, 100, 25);
        
        //Botões
        botao_Adicionar.setBounds(300, 220, 100, 25);
        botao_Actualizar.setBounds(300, 265, 100, 25);
        botao_Eliminar.setBounds(300, 310, 100, 25);
        botao_Vender.setBounds(600, 270, 100, 25);
        
        // Cria um painel em que a tabela irá ficar inserida
        JScrollPane painel = new JScrollPane(tabela);
        
        //Tamanho do painel
        painel.setBounds(0, 0, 880, 200);
        
        //É preciso meter a etiqueta de confirmação de venda invisivel antes de carregar no botão de venda
        etiqueta_Confirmacao.setVisible(false);
        
        
        
        moldura.setLayout(null);
        
        //Adiciona todos os elementos ja criados a moldura
        //Painel
        moldura.add(painel);
     
        //Campos de texto
        moldura.add(campo_texto_Id);
        moldura.add(campo_texto_Nome);
        moldura.add(campo_texto_Custo);
        moldura.add(campo_texto_Venda);
        moldura.add(campo_texto_Unidades);
        moldura.add(campo_texto_Unidades_Venda);
        
        //Etiquetas
        moldura.add(etiqueta_Id);
        moldura.add(etiqueta_Nome);
        moldura.add(etiqueta_Custo);
        moldura.add(etiqueta_Venda);
        moldura.add(etiqueta_Unidades);
        moldura.add(etiqueta_Operacoes);
        moldura.add(etiqueta_Confirmacao);
        moldura.add(etiqueta_Unidades_Venda);
    
        //Botões
        moldura.add(botao_Adicionar);
        moldura.add(botao_Eliminar);
        moldura.add(botao_Actualizar);
        moldura.add(botao_Vender);
        
        //Define o tamanho da moldura
        moldura.setSize(900,450);
        
        moldura.setLocationRelativeTo(null);
        
        //Ao fechar o menu produtos o HIDE_ON_CLOSE ira permitir que o programa não encerre
        moldura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //Torna a moldura visivel ao utilizador
        moldura.setVisible(true);
        
        int i=0;
        
        //Vai adicionar cada elemento da respectiva coluna do ficheiro produtos.csv à correspondente coluna da tabela
        for(i=0;i<tamanho;i++){
                
                modelo.addRow(new Object [] {le_produtos.getDados_coluna_1(i),le_produtos.getDados_coluna_2(i),le_produtos.getDados_coluna_3(i),le_produtos.getDados_coluna_4(i),le_produtos.getDados_coluna_5(i)});
            
            }
        
        //Cria um array de objectos que ira receber os valores do campo de texto e das celulas da tabela
        Object[] linha = new Object[5];
        Object[] campo_inicial = new Object[5];
        
         //Permite que o botão adicionar depois de ser clicado, adicione os valores que estao nos campos de texto à tabela
        botao_Adicionar.addActionListener(new ActionListener(){

            
            
            public void actionPerformed(ActionEvent e) {
             
                //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                linha[0] = campo_texto_Id.getText();
                linha[1] = campo_texto_Nome.getText();
                linha[2] = campo_texto_Custo.getText();
                linha[3] = campo_texto_Venda.getText();
                linha[4] = campo_texto_Unidades.getText();
                
                
                //Adiciona os novos valores ao ficheiro produtos.csv
                String conteudo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4]+"\n";
                gestao_farmacia.Escreve_ficheiro escreve_produtos=new gestao_farmacia.Escreve_ficheiro(conteudo, "produtos.csv");

                
                gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                
                //Desconta o valor que esta no balanco.csv pela multiplicação do nr de unidades pelo custo por unidade do novo produto e guarda na variável total_balanco
                double total_balanco =Double.parseDouble(le_balanco.getDados_coluna_1(0))- (Double.parseDouble(campo_texto_Unidades.getText())*Double.parseDouble(campo_texto_Custo.getText()));
                
                //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                String novo_balanco=total_balanco+",0,0,0,0";
                gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                                     
                
                
                gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");
                
                //Permite gerar um id automatico através da obtenção do tamanho do ficheiro contabilidade
                int tamanho_contabilidade=le_contabilidade.getDados_tamanho();
                int linha_id=tamanho_contabilidade+1;    
                
                //Calcula o valor resultante da multiplicacao do total de unidades pelo custo guardando na variável euros 
                double euros = Double.parseDouble(campo_texto_Unidades.getText())*Double.parseDouble(campo_texto_Custo.getText());
                
                //Adiciona ao ficheiro contabilidade o registo do custo do novo produto
                String conteudo_contabilidade=linha_id+",Compra de Produto"+","+linha[1]+","+linha[4]+",-"+euros+"\n";
                gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo_contabilidade, "contabilidade.csv");
                
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
                    
                    //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                    linha[0] = campo_texto_Id.getText();
                    linha[1] = campo_texto_Nome.getText();
                    linha[2] = campo_texto_Custo.getText();
                    linha[3] = campo_texto_Venda.getText();
                    linha[4] = campo_texto_Unidades.getText();                    
                    
                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();
                    
                    //Actualiza o ficheiro produtos.csv substituindo o campo que se pretende eliminar por ""
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4];
                    String novo="";
                    gestao_farmacia.Modifica_ficheiro escreve_produtos= new gestao_farmacia.Modifica_ficheiro("produtos.csv",antigo,novo); 
                    
                    
                    gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                    
                    //Incrementa o valor que esta no balanco.csv pela multiplicação do nr de unidades pelo custo por unidade do produto que foi eliminado e guarda na variável total_balanco
                    double total_balanco = Double.parseDouble(le_balanco.getDados_coluna_1(0))+ (Double.parseDouble(campo_texto_Unidades.getText())*Double.parseDouble(campo_texto_Custo.getText()));
                    
                    //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                    String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                    String novo_balanco=total_balanco+",0,0,0,0";
                    gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);    
                    
                    gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");

                    //Permite gerar um id automatico através da obtenção do tamanho do ficheiro contabilidade
                    int tamanho_contabilidade=le_contabilidade.getDados_tamanho();
                    int linha_id=tamanho_contabilidade+1;    

                    //Calcula o valor resultante da multiplicacao do total de unidades pelo custo guardando na variável euros 
                    double euros = Double.parseDouble(campo_texto_Unidades.getText())*Double.parseDouble(campo_texto_Custo.getText());

                    //Adiciona ao ficheiro contabilidade o registo da anulação de compra do produto
                    String conteudo_contabilidade=linha_id+",Anulação na Compra de Produto"+","+linha[1]+","+linha[4]+",+"+euros+"\n";
                    gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo_contabilidade, "contabilidade.csv");                    

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
                    linha[1] = campo_texto_Nome.getText();
                    linha[2] = campo_texto_Custo.getText();
                    linha[3] = campo_texto_Venda.getText();
                    linha[4] = campo_texto_Unidades.getText();
                    
                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();                    
                    
                    //Actualiza o ficheiro produtos.csv substituindo o campo que se pretende actualizar pelos valores que estão defenidos nas caixas de texto    
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4];
                    String novo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+linha[4];
                    gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("produtos.csv",antigo,novo); 
                    
                    gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                    
                    //Faz a diferença entre o valor antigo do nr de unidades do produto e o valor novo do nr de unidades do produto que se pretende actualizar multiplicando-o pelo custo por unidade e guarda na variável diferença
                    double diferenca= (Double.parseDouble(modelo.getValueAt(i, 4).toString()) - Double.parseDouble(campo_texto_Unidades.getText()))*Double.parseDouble(campo_texto_Custo.getText());
                    
                    //Incrementa essa diferença ao valor que esta no ficheiro balanço.csv para o actualizar
                    double total_balanco = Double.parseDouble(le_balanco.getDados_coluna_1(0))+diferenca;
                    
                    //Actualiza o ficheiro balanco.csv substituindo o antigo balanco pelo novo balanco que esta guardado na variável total_balanco
                    String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                    String novo_balanco=total_balanco+",0,0,0,0";
                    gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco); 
                    
                    gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");

                    //Permite gerar um id automatico através da obtenção do tamanho do ficheiro contabilidade
                    int tamanho_contabilidade=le_contabilidade.getDados_tamanho();
                    int linha_id=tamanho_contabilidade+1;    

                    //Calcula o valor resultante da multiplicacao do total de unidades pelo custo guardando na variável euros 
                    double euros = Double.parseDouble(campo_texto_Unidades.getText())*Double.parseDouble(campo_texto_Custo.getText());

                    //Adiciona ao ficheiro contabilidade o registo da anulação de compra do produto
                    String conteudo_contabilidade=linha_id+",Anulação na Compra de Produto"+","+linha[1]+","+linha[4]+",+"+euros+"\n";
                    gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo_contabilidade, "contabilidade.csv");                                    
                    
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
        
        //Permite que o botão vender depois de ser clicado,actualize no ficheiro contabilidade o registo da venda com base no numero de unidades inseridas no campo de texto , adicionando o registo no ficheiro contabilidade.csv
        botao_Vender.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                int i = tabela.getSelectedRow();
                //A acção do botão vender só é valida se estiver pelo menos um campo selecionado
                if(i >= 0){
                    
                    //Recebe os valores que estão nas caixas de texto do campo correspondentes ao campo seleccionado na tabela
                    linha[0] = campo_texto_Id.getText();
                    linha[1] = campo_texto_Nome.getText();
                    linha[2] = campo_texto_Custo.getText();
                    linha[3] = campo_texto_Venda.getText();
                    linha[4] = campo_texto_Unidades.getText();
                    
                    //Recebe os valores do campo da tabela selecionado
                    campo_inicial[0]=modelo.getValueAt(i, 0).toString();
                    campo_inicial[1]=modelo.getValueAt(i, 1).toString();
                    campo_inicial[2]=modelo.getValueAt(i, 2).toString();
                    campo_inicial[3]=modelo.getValueAt(i, 3).toString();                    
                    campo_inicial[4]=modelo.getValueAt(i, 4).toString();                    
                    
                    //Converte string para int ou double os valores dos respectivos campos de texto
                    int unidades_restantes=Integer.parseInt(campo_texto_Unidades.getText());
                    int unidades_a_vender=Integer.parseInt(campo_texto_Unidades_Venda.getText());
                    double preco_de_venda=Double.parseDouble(campo_texto_Venda.getText());
                    
                    //Multiplica o preco de venda por unidades pelas as unidades que foram vendidas para obter o valor total e guardar na variável euros
                    double euros=preco_de_venda*unidades_a_vender;

                    

                    //Vai subsituir o campo da tabela selecionado pelos novos valores que estão definidos nas caixas de texto
                    modelo.setValueAt(linha[0], i, 0);
                    modelo.setValueAt(linha[1], i, 1);
                    modelo.setValueAt(linha[2], i, 2);
                    modelo.setValueAt(linha[3], i, 3);
                    
                    //Desconta as unidades que foram vendidas pelo total de unidades existentes na tabela
                    modelo.setValueAt(unidades_restantes-unidades_a_vender, i, 4);
                    
                    
                    gestao_farmacia.Le_ficheiro le_contabilidade = new  gestao_farmacia.Le_ficheiro("contabilidade.csv");
                    
                    //Permite gerar um id automatico através da obtenção do tamanho do ficheiro contabilidade
                    int tamanho_contabilidade=le_contabilidade.getDados_tamanho();
                    int linha_id=tamanho_contabilidade+1;

                    //Adiciona ao ficheiro contabilidade o registo da venda
                    String conteudo_contabilidade=linha_id+",Venda de Produto"+","+linha[1]+","+unidades_a_vender+",+"+euros+"\n";
                    gestao_farmacia.Escreve_ficheiro escreve_contabilidade=new gestao_farmacia.Escreve_ficheiro(conteudo_contabilidade, "contabilidade.csv");

                    //Actualiza o nr de unidades descontadas do nr de unidades vendidas no ficheiro produtos.csv
                    String antigo=campo_inicial[0]+","+campo_inicial[1]+","+campo_inicial[2]+","+campo_inicial[3]+","+campo_inicial[4];
                    String novo=linha[0]+","+linha[1]+","+linha[2]+","+linha[3]+","+(unidades_restantes-unidades_a_vender);
                    gestao_farmacia.Modifica_ficheiro registo_de_actividade= new gestao_farmacia.Modifica_ficheiro("produtos.csv",antigo,novo); 
                    
                    //Actualiza o balanco substituindo o valor antigo pelo novo inscrementado pela venda
                    gestao_farmacia.Le_ficheiro le_balanco = new  gestao_farmacia.Le_ficheiro("balanco.csv");
                    double total_balanco=euros+Double.parseDouble(le_balanco.getDados_coluna_1(0));
                    String antigo_balanco=le_balanco.getDados_coluna_1(0)+",0,0,0,0";
                    String novo_balanco=total_balanco+",0,0,0,0";
                    gestao_farmacia.Modifica_ficheiro actualiza_balanco= new gestao_farmacia.Modifica_ficheiro("balanco.csv",antigo_balanco,novo_balanco);                     

                    //Mete o botao vender, campo de texto e etiqueta do nr de unidades a vender invisivel após do botão vender ser clicado
                    botao_Vender.setVisible(false);
                    etiqueta_Unidades_Venda.setVisible(false);
                    campo_texto_Unidades_Venda.setVisible(false);
                    
                    //Mete a etiqueta com a mensagem de confirmação do registo de venda visivel
                    etiqueta_Confirmacao.setVisible(true);
                    
                    
                    
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
            campo_texto_Custo.setText(modelo.getValueAt(i, 2).toString());
            campo_texto_Venda.setText(modelo.getValueAt(i, 3).toString());
            campo_texto_Unidades.setText(modelo.getValueAt(i, 4).toString());
            
            //Mete o botao vender, campo de texto e etiqueta do nr de unidades a vender visivel após o clique em qualquer item da tabela
            botao_Vender.setVisible(true);
            campo_texto_Unidades_Venda.setVisible(true);
            etiqueta_Unidades_Venda.setVisible(true);
            
            //Mete a etiqueta com a mensagem de confirmção do registo de venda visivel após o clique em qualquer item da tabela
            etiqueta_Confirmacao.setVisible(false);
            
        }
        });
        
    }
}
   