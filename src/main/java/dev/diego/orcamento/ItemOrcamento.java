package dev.diego.orcamento;

import java.math.BigDecimal;

public record ItemOrcamento(BigDecimal getValor) implements Orcavel {

}
