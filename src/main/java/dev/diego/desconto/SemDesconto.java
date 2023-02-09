package dev.diego.desconto;

import dev.diego.Orcamento;

import java.math.BigDecimal;

public class SemDesconto extends Desconto{

    public SemDesconto() {
        super(null);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }

    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
}
