package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle{

    private SubControle() {}
    private SubControle(String str) {}

    public void metodoSubControle1() {
        System.out.println("Executando metodo SubControle.metodoSubControle1()");
    }

    private String metodoSubControle2() {
        System.out.println("Executando metodo SubControle.metodoSubControle2()");
        return "Retornando SubControle.metodoSubControle2()";
    }
}
