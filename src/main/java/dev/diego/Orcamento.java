package dev.diego;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private final int quantidadeItens;
    private String situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
    }

    public void aplicarDescontoExtra() {
        var valorDoDescontoExtra = BigDecimal.ZERO;
        if("EM_ANALISE".equals(situacao))
            valorDoDescontoExtra = new BigDecimal("0.05");
        else if("FINALIZADO".equals(situacao))
            valorDoDescontoExtra = new BigDecimal("0.02");

        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar() {
        this.situacao = "APROVADO";
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}
