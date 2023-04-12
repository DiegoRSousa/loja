package dev.diego.orcamento;

import dev.diego.orcamento.situacao.Aprovado;
import dev.diego.orcamento.situacao.EmAnalise;
import dev.diego.orcamento.situacao.Finalizado;
import dev.diego.orcamento.situacao.Reprovado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrcamentoTest {

    private final BigDecimal valor = new BigDecimal("100.00");
    private final Orcamento orcamento = new Orcamento();

    @BeforeEach
    void setup() {
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100.00")));
    }

    @DisplayName("Deve aplicar desconto extra quando orcamento em_analize")
    @Test
    void test01(){

        orcamento.aplicarDescontoExtra();

        assertEquals(new BigDecimal("95.0000"), orcamento.getValor());
        assertInstanceOf(EmAnalise.class, orcamento.getSituacao());
    }

    @DisplayName("Deve aplicar desconto extra quando orcamento aprovado")
    @Test
    void test02(){
        orcamento.aprovar();
        orcamento.aplicarDescontoExtra();

        assertEquals(new BigDecimal("98.0000"), orcamento.getValor());
        assertInstanceOf(Aprovado.class, orcamento.getSituacao());
    }

    @DisplayName("Deve aplicar desconto extra quando orcamento reprovado")
    @Test
    void test03(){
        orcamento.reprovar();
        orcamento.aplicarDescontoExtra();

        assertEquals(valor, orcamento.getValor());
        assertInstanceOf(Reprovado.class, orcamento.getSituacao());
    }



    @DisplayName("Deve aplicar desconto extra quando orcamento finalizado")
    @Test
    void test04(){
        orcamento.aprovar();
        orcamento.finalizar();
        orcamento.aplicarDescontoExtra();

        assertEquals(valor, orcamento.getValor());
        assertInstanceOf(Finalizado.class, orcamento.getSituacao());
    }

    @DisplayName("deve finalizar orcamento reprovado")
    @Test
    void test05() {
        orcamento.reprovar();
        orcamento.finalizar();

        assertInstanceOf(Finalizado.class, orcamento.getSituacao());
    }

    @DisplayName("deve compor orcamento")
    @Test
    void test06() {
        var novoOrcamento = new Orcamento();
        novoOrcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200.00")));
        novoOrcamento.adicionarItem(orcamento);
        assertEquals(new BigDecimal("300.00"), novoOrcamento.getValor());
    }

    @DisplayName("deve lançar exception quando finalizar orcamento em_analise")
    @Test
    void test07() {
        assertThrows(IllegalStateException.class,
                orcamento::finalizar,
                "Orçamento não pode ser finalizado!");
    }

    @DisplayName("deve lançar exception quando aprovar orcamento finalizado")
    @Test
    void test08() {
        orcamento.aprovar();
        orcamento.finalizar();
        assertThrows(IllegalStateException.class,
                orcamento::aprovar,
                "Orçamento não pode ser aprovado!");
    }

    @DisplayName("deve lançar exception quando reprovar orcamento finalizado")
    @Test
    void test09() {
        orcamento.aprovar();
        orcamento.finalizar();
        assertThrows(IllegalStateException.class,
                orcamento::reprovar,
                "Orçamento não pode ser reprovado!");
    }

}