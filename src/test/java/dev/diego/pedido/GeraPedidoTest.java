package dev.diego.pedido;

import dev.diego.pedido.repository.PedidoRepository;
import dev.diego.pedido.service.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeraPedidoTest {


    @Test
    @DisplayName("deve executar geracao de pedido")
    void test() {
        var repository = new PedidoRepository();
        var service = new EmailService();
        var geraPedido = new GeraPedido("Teste", "100.00", 3,
                repository, service);
        var resultado = geraPedido.executa();

        assertTrue(resultado);

    }

}