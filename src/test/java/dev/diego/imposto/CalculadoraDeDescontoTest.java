package dev.diego.imposto;

import dev.diego.Orcamento;
import dev.diego.desconto.CalculadoraDeDesconto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDeDescontoTest {

    @ParameterizedTest()
    @MethodSource("cenarios")
    @DisplayName("deve calcular desconto")
    void test(BigDecimal valor, int quantidade, BigDecimal expected) {
        var calculadoraDeDesconto  = new CalculadoraDeDesconto();
        var orcamento = new Orcamento(valor, quantidade);

        var desconto = calculadoraDeDesconto.calcular(orcamento);

        assertEquals(expected, desconto);
    }

    private static Stream<Arguments> cenarios() {
        return Stream.of(
                Arguments.of(new BigDecimal("100.00"), 6, new BigDecimal("6.0000")),
                Arguments.of(new BigDecimal("1100.00"), 1, new BigDecimal("110.0000")),
                Arguments.of(new BigDecimal("100.00"), 5, BigDecimal.ZERO));
    }
}