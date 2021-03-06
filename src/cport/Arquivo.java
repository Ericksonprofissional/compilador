
package cport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {
    
    
    public String nomeArquivo;
    public String diretorio;
    
    public Arquivo(String caminho, String nome) {
        this.diretorio = caminho;
        ///home/before/EricksonSouzaMartinez
        this.nomeArquivo = nome;
    }
    
    public List<String>LerConteudo() throws FileNotFoundException, IOException {
        List<String> conteudo = new ArrayList();
        String nomeCompleto = this.diretorio + this.nomeArquivo + ".txt";
        //System.out.println(nomeCompleto);
        FileReader arq = new FileReader(nomeCompleto);
        BufferedReader buffer = new BufferedReader(arq);

        String linha = "..";
        while (linha != null) { 
            // vai ler a linha e acabar o arquivo        
            linha = buffer.readLine();            
            if(linha != null){
                linha = linha.trim(); // remove os espaços
                conteudo.add(linha); // adiciona na lista de conteudo
            }
        }
                
        return conteudo;
        
    }
}
