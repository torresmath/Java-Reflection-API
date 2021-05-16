package br.com.alura.alurator.conversor;

import br.com.alura.alurator.conversor.anotacao.NomeTagXml;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {
    public String converte(Object objeto) {

        try {
            Class<?> classeObjeto = objeto.getClass();

            StringBuilder xmlBuilder = new StringBuilder();

            if (objeto instanceof Collection) {
                Collection<?> colecao = (Collection<?>) objeto;

                xmlBuilder.append("<lista>");

                for (Object o : colecao) {
                    String xml = converte(o);
                    xmlBuilder.append(xml);
                }

                xmlBuilder.append("</lista>");
            } else {

                NomeTagXml anotacaoClasse = classeObjeto.getDeclaredAnnotation(NomeTagXml.class);

                String nomeClasse = anotacaoClasse == null
                        ? classeObjeto.getName()
                        : anotacaoClasse.value();

                xmlBuilder.append("<" + nomeClasse + ">");

                for (Field field : classeObjeto.getDeclaredFields()) {
                    field.setAccessible(true);

                    NomeTagXml anotacaoField = field.getDeclaredAnnotation(NomeTagXml.class);

                    String nomeAtr = anotacaoField == null
                            ? field.getName()
                            : anotacaoField.value();

                    Object valorAtr = field.get(objeto);

                    xmlBuilder.append("<" + nomeAtr + ">");
                    xmlBuilder.append(valorAtr);
                    xmlBuilder.append("</" + nomeAtr + ">");
                }

                xmlBuilder.append("</" + nomeClasse + ">");

            }

            return xmlBuilder.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na geração do XML");
        }
    }
}
