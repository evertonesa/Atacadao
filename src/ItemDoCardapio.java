public class ItemDoCardapio {

    private int id;
    private String nome;
    private double preco;

    public ItemDoCardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
