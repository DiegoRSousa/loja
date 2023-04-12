package dev.diego.imposto;

import dev.diego.orcamento.ItemOrcamento;
import dev.diego.orcamento.Orcamento;
import dev.diego.desconto.CalculadoraDeDesconto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDeDescontoTest {

    @ParameterizedTest()
    @MethodSource("cenarios")
    @DisplayName("deve calcular desconto")
    void test(List<ItemOrcamento> itens, BigDecimal expected) {
        var calculadoraDeDesconto  = new CalculadoraDeDesconto();
        var orcamento = new Orcamento();
        itens.forEach(orcamento::adicionarItem);

        var desconto = calculadoraDeDesconto.calcular(orcamento);

        assertEquals(expected, desconto);
    }

    private static Stream<Arguments> cenarios() {
        return Stream.of(
                Arguments.of(List.of(
                        new ItemOrcamento(new BigDecimal("10.00")),
                        new ItemOrcamento(new BigDecimal("10.00")),
                        new ItemOrcamento(new BigDecimal("10.00")),
                        new ItemOrcamento(new BigDecimal("10.00")),
                        new ItemOrcamento(new BigDecimal("10.00")),
                        new ItemOrcamento(new BigDecimal("50.00"))),
                        new BigDecimal("6.0000")),
                Arguments.of(List.of(
                        new ItemOrcamento(new BigDecimal("1100.00"))),
                        new BigDecimal("110.0000")),
                Arguments.of(List.of(
                        new ItemOrcamento(new BigDecimal("20.00")),
                        new ItemOrcamento(new BigDecimal("20.00")),
                        new ItemOrcamento(new BigDecimal("20.00")),
                        new ItemOrcamento(new BigDecimal("20.00")),
                        new ItemOrcamento(new BigDecimal("20.00"))),
                        BigDecimal.ZERO));
    }
}