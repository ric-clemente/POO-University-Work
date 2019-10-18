package gestao_farmacia;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Ricardo Clemente Nº30000794 , Bianca Silva Nº20160090, Alexandre Martins Nº20150666
 */
public class Escreve_ficheiro {
    
    private String conteudo;
    private String nome;
    
    /**
     * 
     * @param conteudo corresponde ao conteudo que se quer introduzir no ficheiro
     * @param nome recebe o nome do ficheiro em que vai escrever o conteudo que se pretende
     */
    public Escreve_ficheiro(String conteudo,String nome){
        
        FileWriter saida = null;
        File ficheiro = null;
        
        try{
            ficheiro = new File(nome);
            saida = new FileWriter(ficheiro,true);
            
            //Se o ficheiro não existir cria um novo
            if (!ficheiro.exists())ficheiro.createNewFile();
            
            // Escreve no ficheiro            
            saida.write(conteudo);
            saida.flush();
        }
        catch(IOException ioexc){ioexc.printStackTrace();}
        try{
            saida.close();
        }
        catch(IOException ioexc){
            System.out.println("Fecho com problemas");
        }
    }
    
}
