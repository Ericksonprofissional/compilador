/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cport;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author before
 */
public class Sintatico {

    public List<String> codigoFonte;
    public List<String> gramatica;

    public void analisadorSintatico(String nome) throws IOException {
        Arquivo arq_gramatica = new Arquivo("gramatica_exp");
        this.gramatica = arq_gramatica.LerConteudo();

        Arquivo arq_fonte = new Arquivo(nome);
        this.codigoFonte = arq_fonte.LerConteudo();

        Boolean correto = false;

        for (String linha : codigoFonte) {
            for (String grama : gramatica) {
                correto = false;
                if (linha.matches(grama)) {
                        correto = true;
                        System.out.println("Linha: " + linha + " -> OK");
                        break;
                }
            }
            if (!correto) {
                System.out.println("Erro de sintaxe na linha: " + linha);
            }

        }
    }

}
