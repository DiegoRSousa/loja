package dev.diego.imposto;

import dev.diego.orcamento.Orcamento;

import java.math.BigDecimal;


public abstract class Imposto {

    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal valorImposto = efetuarCalculo(orcamento);
        BigDecimal valorOutroImposto = BigDecimal.ZERO;

        if(null != outro)
            valorOutroImposto = outro.efetuarCalculo(orcamento);
        return valorImposto.add(valorOutroImposto);

    }
}
