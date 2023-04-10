package dev.diego.pedido;

import dev.diego.pedido.repository.PedidoRepository;
import dev.diego.pedido.service.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GeraPedidoTest {


    @Test
    @DisplayName("deve executar geracao de pedido")
    void test() {
        var acoesApoGerarPedido
                = Arrays.asList(new PedidoRepository(), new EmailService());

        var geraPedido = new GeraPedido("Teste", "100.00", 3,
                acoesApoGerarPedido);
        var resultado = geraPedido.executa();

        assertTrue(resultado);

    }

}