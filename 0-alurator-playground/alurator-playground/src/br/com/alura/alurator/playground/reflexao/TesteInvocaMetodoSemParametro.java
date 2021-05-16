package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> subControleClass = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        for (Method method : subControleClass.getMethods()) {
            System.out.println(method);
        }

        System.out.println();

        for (Method method : subControleClass.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println();

        Method m = subControleClass.getDeclaredMethod("metodoSubControle2");
        m.setAccessible(true);

        Constructor<?> constructor = subControleClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object objSubControle = constructor.newInstance();
        Object retorno = m.invoke(objSubControle);

        System.out.println(retorno);
    }
}
