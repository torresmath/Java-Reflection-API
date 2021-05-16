package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjecto {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<Controle> controleClass1 = Controle.class;
//        SubControle controle = new SubControle();

//        Class<? extends Controle> controleClass2 = controle.getClass();

        Class<?> controlerClass3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        try {
            controleClass1.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        Controle objetoControle = controleClass1.newInstance();
        Object outroObjetoControle = controlerClass3.newInstance();

//        System.out.println(objetoControle instanceof Controle);
        System.out.println(outroObjetoControle instanceof Controle);

        Class<SubControle> subControleClass = SubControle.class;

        Constructor<SubControle> constructor = subControleClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        System.out.println(constructor);

//        SubControle objectSubControle = constructor.newInstance();

    }
}
