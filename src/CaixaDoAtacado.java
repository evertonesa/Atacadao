import java.util.ArrayList;

public class CaixaDoAtacado {

    private java.util.List<ItemDoCardapio> cardapio;
    private java.util.List<CompraItem> compraItens;
    private double descontoPorMetodoPagamento;

    public CaixaDoAtacado(ArrayList<ItemDoCardapio> cardapio) {
        this.cardapio = (java.util.List<ItemDoCardapio>) cardapio;
        compraItens = new ArrayList<>();
        descontoPorMetodoPagamento = 0.0; // Inicialmente nenhum desconto
    }

    public void adicionarCompraItem(CompraItem compraItem) {
        compraItens.add((compraItem));
    }

    public double calcularTotal(String metodoPagamento) {
        double total = 0.0;

        for (CompraItem compraItem : compraItens) {
            total += compraItem.calcularSubtotal();
        }

        if (compraItens.size() >= 5 && compraItens.size() <= 15) {
            total *= 0.9; // Aplica desconto de 10% se houver de 5 a 15 itens
        } else if (compraItens.size() > 15 && compraItens.size() <= 25) {
            total *= 0.8; // Aplica desconto de 20% se houver de 15 a 25 itens
        } else if (compraItens.size() > 25) {
            total *= 0.75; // Aplica desconto de 25% se houver mais de 25 itens
        }

        if (metodoPagamento.equals("dinheiro")) {
            total *= 0.95; // Aplica desconto de 5% para pagamento em dinheiro
        } else if (metodoPagamento.equals("credito")) {
            total *= 1.03; // Aplica acréscimo de 3% para pagamento com cartão de crédito
        }

        return total;
    }
}

