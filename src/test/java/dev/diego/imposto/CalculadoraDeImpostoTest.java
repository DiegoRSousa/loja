package dev.diego.imposto;

import dev.diego.orcamento.Orcamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDeImpostoTest {

    @ParameterizedTest()
    @MethodSource("criaImpostoComValor")
    @DisplayName("deve calcular imposto quando tipo igual a ICMS")
    void test(Imposto input, BigDecimal expected) {
        var calculadoraDeImposto  = new CalculadoraDeImposto();
        var orcamento = new Orcamento(new BigDecimal("100.00"), 1);
        var imposto = calculadoraDeImposto.calcular(orcamento, input);

        assertEquals(expected, imposto);
    }

    private static Stream<Arguments> criaImpostoComValor() {
        return Stream.of(
                Arguments.of(new ICMS(), new BigDecimal("10.0000")),
                Arguments.of(new ISS(), new BigDecimal("6.0000")));
    }
}