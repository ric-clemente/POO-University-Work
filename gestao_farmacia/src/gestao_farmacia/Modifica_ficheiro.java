package gestao_farmacia;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */
public class Modifica_ficheiro {
    
    /**
     * 
     * @param nome_ficheiro recebe o nome do ficheiro em que se vai modificar o conteudo que se pretende
     * @param campo recebe o conteudo que se pretende modificar (conteudo antigo)
     * @param campo_modificado recebe o conteudo que se pretende substituir pelo antigo (conteudo novo)
     */
    public Modifica_ficheiro(String nome_ficheiro,String campo,String campo_modificado ){
        String linha;
        String nome=nome_ficheiro;
        String nome_alternativo="ficheiro.tmp";
        
        
        String conteudo="";
        String conteudo_2="";
        try{
            
            FileReader fileReader = new FileReader(nome);  
            BufferedReader entrada = 
            new BufferedReader(fileReader);
            FileWriter saida = null;
            File ficheiro = null;
            ficheiro = new File(nome);
            File ficheiro_temp = new File(nome_alternativo);
            saida = new FileWriter(ficheiro_temp,true);     
            
            while ((linha=entrada.readLine())!=null)
            { 
                //Se encontrar o conteudo que se pretende substituir, o programa ira subistituir o conteudo antigo pelo conteudo novo escrevendo-o no ficheiro.tmp
                if (linha.contains(campo)){
                    
                    conteudo = linha.replace(campo,campo_modificado);
                    
                    saida.write(conteudo);
                    
                    
                    
                }
                //Apanha todo o conteudo restante que não seja igual ao que se pretende substituir e escreve-o no ficheiro.tmp 
                if (!linha.contains(campo)){
                    
                    conteudo_2=linha;
                    
                    saida.write(conteudo_2+"\n");
                    
                    
                    
                }                
                
                
                saida.flush();
           
            
            
            }

            
            
            fileReader.close();
            entrada.close();
            saida.close();
            
            //Apaga o ficheiro antigo (nome_ficheiro)
            ficheiro.delete();
            
            //Renomeia o ficheiro.tmp para o nome do ficheiro antigo(nome_ficheiro) com o conteudo ja modificado 
            ficheiro_temp.renameTo(ficheiro);
            
            

          
            
            
            
        }
        catch(IOException ioexc){
            System.out.println("Ficheiro nao encontrado");
        }   
}
}
