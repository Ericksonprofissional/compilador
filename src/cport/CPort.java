
package cport;

import java.io.IOException;
import java.util.Scanner;


public class CPort {
    
    public static void main(String[] args) throws IOException {
                
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o caminho da pasta onde esta o arquivo:\n exemplo: \"C:\\\\Linguagens\\\\trabalho\\\\\"");
        String pasta = teclado.nextLine();       
        
        System.out.println("Digite apenas nome do Arquivo fonte, sem extensão do arquivo");
        String nomeFonte = teclado.nextLine();
       
        Lexico scanner = new Lexico();
        scanner.AnalisarLexito(pasta ,nomeFonte);
        
        Sintatico sintatico = new Sintatico();
        System.out.println("Analisando sintaticamente");
        sintatico.analisadorSintatico(pasta, nomeFonte);
        System.out.println("/fim da Analise sintatica");

    }

 
    
}
