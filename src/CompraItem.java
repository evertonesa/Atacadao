public class CompraItem {

    private ItemDoCardapio item;
    private int quantidade;

    public CompraItem(ItemDoCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return item.getPreco() * quantidade;
    }
}
