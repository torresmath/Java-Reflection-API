package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflection.ManipuladorObjeto;
import br.com.alura.alurator.reflection.Reflection;

import java.util.List;
import java.util.Map;

public class Alurator {

    private final String pacoteBase;
    private ContainerIoC container;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.container = new ContainerIoC();
    }

    public Object executa(String url) throws NoSuchMethodException {
        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> params = request.getQueryParams();


        Class<?> classeControle = new Reflection().getClass(pacoteBase + nomeControle);
        Object instanciaControle = container.getInstancia(classeControle);

        Object retorno = new ManipuladorObjeto(instanciaControle)
                .getMetodo(nomeMetodo, params)
                .comTratamentoDeExcecao((metodo, exc) -> {
                    System.out.println("Erro no método " + metodo.getName() + " da classe "
                            + metodo.getDeclaringClass().getName() + ". \n\n");
                    throw new RuntimeException("Erro no método!");
                })
                .invoca();

        System.out.println(retorno);

        retorno = new ConversorXML().converte(retorno);
        return retorno;


    }

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        container.registra(tipoFonte, tipoDestino);
    }

    public static void print(List<? super Integer> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
