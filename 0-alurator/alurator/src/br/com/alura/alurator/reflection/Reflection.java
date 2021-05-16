package br.com.alura.alurator.reflection;

public class Reflection {
    public ManipuladorClasse refleteClasse(String fqn) {

        Class<?> classe = getClass(fqn);
        return new ManipuladorClasse(classe);

    }

    public Class<?> getClass(String fqn) {
        try {
            Class<?> classe = Class.forName(fqn);
            return classe;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
