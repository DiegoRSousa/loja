package dev.diego.desconto;

import dev.diego.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {
    protected Desconto proximo;

    protected Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if(deveAplicar(orcamento)){
            return efetuarCalculo(orcamento);
        }
        return proximo.calcular(orcamento);
    }

    protected abstract boolean deveAplicar(Orcamento orcamento);
    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

}
