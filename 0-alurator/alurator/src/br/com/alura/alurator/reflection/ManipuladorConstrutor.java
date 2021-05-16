package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {

    private Constructor<?> constructor;

    public ManipuladorConstrutor(Constructor<?> construtorPadrao) {
        this.constructor = construtorPadrao;
    }

    public Object invoca() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new RuntimeException("Erro no construtor", e.getTargetException());
        }
    }
}
