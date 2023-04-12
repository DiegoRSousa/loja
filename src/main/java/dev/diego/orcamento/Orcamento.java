package dev.diego.orcamento;

import dev.diego.orcamento.situacao.EmAnalise;
import dev.diego.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento {
    private BigDecimal valor;
    private SituacaoOrcamento situacao;
    private List<ItemOrcamento> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.situacao = new EmAnalise();
        this.itens = new ArrayList<>();
    }

    public void aplicarDescontoExtra() {
        var valorDoDescontoExtra = this.situacao.calcularDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar() {
        situacao.aprovar(this);
    }

    public void reprovar() {
        situacao.reprovar(this);
    }

    public void finalizar() {
        situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public void adicionarItem(ItemOrcamento item) {
        this.valor = valor.add(item.valor());
        this.itens.add(item);
    }
}
