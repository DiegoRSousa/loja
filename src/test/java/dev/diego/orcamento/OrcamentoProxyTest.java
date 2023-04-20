package dev.diego.orcamento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OrcamentoProxyTest {


    private final BigDecimal valor = new BigDecimal("100.00");
    private final Orcamento orcamento = new Orcamento();
    private OrcamentoProxy orcamentoProxy;

    @BeforeEach
    void setup() {
        orcamento.adicionarItem(new ItemOrcamento(valor));
        orcamentoProxy = new OrcamentoProxy(valor, orcamento);
    }


    @DisplayName("deve retornar o valor do orcamento")
    @Test
    void test01() {
        var valorOrcamentoProxy = orcamentoProxy.getValor();
        valorOrcamentoProxy = orcamentoProxy.getValor();
        assertEquals(new BigDecimal("100.00"), valorOrcamentoProxy);
    }


}