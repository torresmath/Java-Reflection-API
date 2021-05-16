package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String nomeControle;
    private String nomeMetodo;
    private Map<String, Object> queryParams;

    public Request(String url) {

        String[] partesUrl = url.replaceFirst("/", "")
                .split("[?]");

        String[] controleMetodo = partesUrl[0].split("/");

        this.nomeControle = Character.toUpperCase(controleMetodo[0].charAt(0)) +
                controleMetodo[0].substring(1) + "Controller";

        this.nomeMetodo = controleMetodo[1];
        this.queryParams = partesUrl.length > 1
                ? new QueryParamsBuilder().withParams(partesUrl[1]).build()
                : new HashMap<>();
    }

    public String getNomeControle() {
        return nomeControle;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }
}
