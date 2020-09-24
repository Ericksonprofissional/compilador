
package cport;

import java.io.IOException;
import java.util.Scanner;


public class CPort {
    
    public static void main(String[] args) throws IOException {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do Arquivo fonte");
        String nomeFonte = teclado.nextLine();
       
    Lexico scanner = new Lexico();
    scanner.AnalisarLexito(nomeFonte);
        
    }

 
    
}
