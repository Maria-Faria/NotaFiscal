package notafiscal;

public class Produto {
    String nome;
    double valor, total;
    int qtd;

    public Produto(String nome, double valor, int qtd, double total) {
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }

    public double getValor() {
        return valor;
    }

    public double getTotal() {
        return total;
    }
}