package model;

public class Produto {
    private String nome; // String-texto
    private double preco; // double-numero quebrado
    private int quantidade; //int-numero inteiro
    private int codigo; //int-numero inteiro

    public Produto() {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.codigo = 0;
    }
    public Produto(String nome, double preco, int quantidade, int codigo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setCodigo(codigo);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("Preço deve ser maior ou igual a zero.");
        }
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade deve ser maior ou igual a zero.");
        }
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        }
    }
    public double calcularValorTotal() {
        return preco * quantidade;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", codigo=" + codigo +
                '}';
    }
    public boolean temEstoque() {
    return quantidade > 0;
}
}
