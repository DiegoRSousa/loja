package dev.diego.pedido;

import dev.diego.orcamento.ItemOrcamento;
import dev.diego.pedido.repository.PedidoRepository;
import dev.diego.pedido.service.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeraPedidoTest {


    @Test
    @DisplayName("deve executar geracao de pedido")
    void test() {
        var acoesApoGerarPedido
                = Arrays.asList(new PedidoRepository(), new EmailService());

        var geraPedido = new GeraPedido("Teste", acoesApoGerarPedido,
                List.of(new ItemOrcamento(BigDecimal.TEN), new ItemOrcamento(BigDecimal.TEN)));
        var resultado = geraPedido.executa();

        assertTrue(resultado);

    }

}