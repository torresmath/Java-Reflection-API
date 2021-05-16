package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.conversor.anotacao.NomeTagXml;
import br.com.alura.alurator.playground.modelo.Produto;

public class TesteManipulaAnotacao {
    public static void main(String[] args) {
        Produto produto = new Produto("Produto 1", 444.0, "Marca1");
        Class<?> classe = produto.getClass();

        String value = classe.getDeclaredAnnotation(NomeTagXml.class).value();
        System.out.println("value = " + value);
    }
}
