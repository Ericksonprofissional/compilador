package cport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Lexico {

    public List<String> dicionario;
    public List<String> codigoFonte;
    public List<String> tokens;

    public void AnalisarLexito(String nome) throws IOException {
        // ler arquivos
        //ler exempllo
        //separa exemplo por token
        // procurar expressão dicionario que valide o token
        // se houver erro enviar mensagem

        Arquivo arq_dic = new Arquivo("expressoes.txt");
        this.dicionario = arq_dic.LerConteudo();

        Arquivo arq_fonte = new Arquivo(nome);
        this.codigoFonte = arq_fonte.LerConteudo();

        this.tokens = separarTokens();

        Integer quantidadesErros = validarTokens();
        System.out.println("Total de erros: " + quantidadesErros);

        /*  
        System.out.println("____________________________Dicionario");
            
        for(int i =0; i < dicionario.size();i++){
            System.out.println(dicionario.get(i));
        }
        System.out.println("____________________________codigo Fonte");
            
        for(int i =0; i < codigoFonte.size();i++){
            System.out.println(codigoFonte.get(i));
        }
         
        System.out.println("____________________________Tokens");

        for (int i = 0; i < this.tokens.size(); i++) {
            System.out.println(this.tokens.get(i));
        }
         */
    }

    public List<String> separarTokens() {
        // preparar a lista de tokens
        List<String> tks = new ArrayList();
        int x = 0;
        // percorrer o codigo fonte e separar os tokens de cada linha
        for (int i = 0; i < codigoFonte.size(); i++) {
            String linha = codigoFonte.get(i);

            if (linha.contains("\"")) {

                linha = trocarEspacoPorPonto(linha);
            }
            String[] palavras = linha.split(" ");
            for (int j = 0; j < palavras.length; j++) {
                tks.add(palavras[j]);
            }
        }
        return tks;
    }

    public String trocarEspacoPorPonto(String linha) {

        //se estiver entre spasdeve mudara para ponto
        int posicaoInicial = linha.indexOf("\"");
        Integer posicaoFinal = linha.lastIndexOf("\"") + 1;
        String texto = linha.substring(posicaoInicial, posicaoFinal);
        texto = texto.replace(" ", ".");
        linha = linha.substring(0, posicaoInicial - 1) +" " + texto;

        return linha;

    }

    public Integer validarTokens() {
        int i;
        int quantidadeErros = 0;
        for (i = 0; i < this.tokens.size(); i++) {
            //procurar uma expressão regular que a valide
            String palavra = this.tokens.get(i);
            boolean valido = false;

            for (int j = 0; j < this.dicionario.size(); j++) {
                String expressao = this.dicionario.get(j);
                if (palavra.matches(expressao)) {
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                System.out.println("Token " + palavra + " invalido no termo: " + i);
                quantidadeErros++;
            } else {
                System.out.println("Token CORRETO: " + palavra);
            }
        }

        return quantidadeErros;
    }
}
