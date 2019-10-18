/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_farmacia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */

 public class Menu extends JFrame{
   
     Menu(){
         
        //Cria os vários Botões 
        JButton botao_Empregados = new JButton("Empregados");
        JButton botao_Produtos = new JButton("Produtos");
        JButton botao_Contabilidade = new JButton("Contabilidade");    
        
        //Cria Etiqueta
        JLabel etiqueta_Titulo = new JLabel("Farmacia XPTO");
        
        // Define o tamanho da moldura criada
        this.setSize(400,300);
        
        //Define a localizacao da moldura no monitor
        this.setLocation(500,200);
        
        //Define a moldura visivel ao utilizador
        this.setVisible(true);
       
        //Encerra o programa quando se fechar a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Define que accao vai acontecer ao clicar no botao Empregados
        botao_Empregados.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               
                //Ao clicar vai chamar o conteudo que esta no Menu_empregados.java
                Menu_Empregados m1= new Menu_Empregados();
            
     }
        });
        
        //Define que accao vai acontecer ao clicar no botao Produtos
        botao_Produtos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Ao clicar vai chamar o conteudo que esta no Menu_empregados.java
                Menu_Produtos m2= new Menu_Produtos();
            
     }
        });
               
        //Define que accao vai acontecer ao clicar no botao Contabilidade
        botao_Contabilidade.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Ao clicar vai chamar o conteudo que esta no Menu_empregados.java
                Menu_Contabilidade m3= new Menu_Contabilidade();
            
     }
        });               
        
        
       //Formatação dos componentes 
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       
        //Formatação a nivel horizontal
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(etiqueta_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Empregados, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Contabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        
        //Formatação a nivel vertical
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
               
                .addComponent(etiqueta_Titulo)
                .addGap(30, 30, 30)
                .addComponent(botao_Empregados)
                .addGap(18, 18, 18)
                .addComponent(botao_Produtos)
                .addGap(18, 18, 18)
                .addComponent(botao_Contabilidade)
                .addGap(18, 18, 18))
        );
        
        pack();        
        
               }
     public static void main(String[] args){
         //Inicia o Menu principal
         Menu iniciar_menu = new Menu();
     }
 }
        
     
 
        
 
   