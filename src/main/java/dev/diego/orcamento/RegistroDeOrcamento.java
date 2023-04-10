package dev.diego.orcamento;

import dev.diego.http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter adapter;

    public RegistroDeOrcamento(HttpAdapter adapter) {
        this.adapter = adapter;
    }

    public void registrar(Orcamento orcamento) {

        var url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
        );

        adapter.post(url, dados);

    }
}
