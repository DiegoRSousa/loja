package dev.diego.imposto;

import dev.diego.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImposto {
    public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {
        return switch (tipoImposto) {
            case ICMS -> orcamento.getValor().multiply(new BigDecimal("0.10"));
            case ISS -> orcamento.getValor().multiply(new BigDecimal("0.06"));
        };

    }
}
