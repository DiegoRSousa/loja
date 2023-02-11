package dev.diego.imposto;

import dev.diego.orcamento.Orcamento;

import java.math.BigDecimal;


public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
