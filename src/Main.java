import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<ItemDoCardapio> cardapio = new ArrayList<>();
        cardapio.add(new ItemDoCardapio(1, "Cafe 1 kg", 53.00));
        cardapio.add(new ItemDoCardapio(2, "Sabao em po", 36.00));
        cardapio.add(new ItemDoCardapio(3, "Caixa de Leite", 82.00));
        cardapio.add(new ItemDoCardapio(4, "Refrigerante", 8.50));

        CaixaDoAtacado caixa = new CaixaDoAtacado((ArrayList<ItemDoCardapio>) cardapio);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cardapio:");
            for (ItemDoCardapio item : cardapio) {
                System.out.println(item.getId() + " - " + item.getNome() + " | R$" + item.getPreco());
            }
            System.out.print("Escolha o ID do item (0 para finalizar): ");
            int id = scanner.nextInt();

            if (id == 0) {
                break;
            }

            System.out.print("Quantidade desejada: ");
            int quantidade = scanner.nextInt();

            ItemDoCardapio item = cardapio.stream()
                    .filter(i -> i.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (item != null) {
                CompraItem compraItem = new CompraItem(item, quantidade);
                caixa.adicionarCompraItem(compraItem);
            } else {
                System.out.println("Item com ID " + id + " nao encontrado no cardapio.");
            }
        }

        System.out.print("Escolha o metodo de pagamento (debito, dinheiro, credito): ");
        String metodoPagamento = scanner.next();

        double total = caixa.calcularTotal(metodoPagamento);
        System.out.println("Total: R$" + total);
    }
}



