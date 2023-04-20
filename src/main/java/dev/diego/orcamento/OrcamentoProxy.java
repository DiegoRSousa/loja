package dev.diego.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy implements Orcavel{
    private BigDecimal valor;
    private Orcamento orcamento;

    public OrcamentoProxy(BigDecimal valor, Orcamento orcamento) {
        this.valor = valor;
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        if(null == this.valor)
            this.valor = orcamento.getValor();
        return this.valor;

    }
}
