
package gestao_farmacia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */

public class Le_ficheiro {
    
    private String nome;
    private String dados="";    
    
    
    ArrayList<String> dados_coluna_1 = new ArrayList<String>();
    ArrayList<String> dados_coluna_2 = new ArrayList<String>();
    ArrayList<String> dados_coluna_3 = new ArrayList<String>();
    ArrayList<String> dados_coluna_4 = new ArrayList<String>();
    ArrayList<String> dados_coluna_5 = new ArrayList<String>();
    ArrayList<String> dados_coluna_6 = new ArrayList<String>();
   
   /**
    * 
    * @param nome recebe o nome do ficheiro que vai ler
    */
    
     
    public Le_ficheiro(String nome){
   
        String linha;
           
        try{
            
            FileReader fileReader = 
            new FileReader(nome);
            
            BufferedReader entrada = 
            new BufferedReader(fileReader);
            
            
            while ((linha=entrada.readLine())!=null)
            {
                
                // Permite extrair os valores de cada linha no ficheiro que estejam separados por uma , e coloca-los no array de Strings parte
                String[] parte = linha.split(",");
                    
                // Permite guardar cada linha do ficheiro
                dados=dados+"\n\r"+linha;
                
                // Coloca cada valor da coluna que foi extraido em cada linha, em cada uma das listas de array
                dados_coluna_1.add(parte[0]);
                dados_coluna_2.add(parte[1]);
                dados_coluna_3.add(parte[2]);
                dados_coluna_4.add(parte[3]);
                dados_coluna_5.add(parte[4]);
                
                //lista de array adicional caso o ficheiro for o empregados.csv relativamente a coluna Ultima Actividade 
                if (nome=="empregados.csv"){
                    dados_coluna_6.add(parte[5]);
                }
                
            }
            
            entrada.close();
            
        }
        catch(IOException ioexc){
            System.out.println("Ficheiro nao encontrado");
        }   
    }
    
/**
 * 
 * @return retorna tudo o que esta escrito no ficheiro
 */    
 public String getDados(){
     return dados;
 }
 
 /**
  * 
  * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 1 
  * @return retorna o valor da Coluna 1 da linha correspondende
  */
 
  public String getDados_coluna_1(int d){
    
        return dados_coluna_1.get(d);
     
 }
  
  /**
   * 
   * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 2 
   * @return retorna o valor da Coluna 2 da linha correspondende 
   */
  
   public String getDados_coluna_2(int d){
    
        return dados_coluna_2.get(d);
     
 }
   
   /**
   * 
   * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 3 
   * @return retorna o valor da Coluna 3 da linha correspondende 
   */
   
    public String getDados_coluna_3(int d){
    
        return dados_coluna_3.get(d);
     
 }
    
   /**
   * 
   * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 4 
   * @return retorna o valor da Coluna 4 da linha correspondende 
   */ 
    
 public String getDados_coluna_4(int d){
    
        return dados_coluna_4.get(d);
     
 } 
 
 
  /**
   * 
   * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 5 
   * @return retorna o valor da Coluna 5 da linha correspondende 
   */
 
public String getDados_coluna_5(int d){
    
        return dados_coluna_5.get(d);
     
 }  

 /**
   * 
   * @param d corresponde a linha que se quer aceder para obter o valor da Coluna 6 
   * @return retorna o valor da Coluna 6 da linha correspondende  
   */

public String getDados_coluna_6(int d){
    
        return dados_coluna_6.get(d);
     
 }   

/**
 * 
 * @return retorna o numero de linhas do ficheiro
 */

   public int getDados_tamanho(){
     return dados_coluna_1.size();
     
 }
 
}
