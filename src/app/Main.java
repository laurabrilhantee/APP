package main.java.com.app;

import main.java.com.model.Produto;
import main.java.com.validacoes.Validacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Produto> produtos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Produtos!");
        
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = Validacoes.validarInteiro(scanner, "Escolha uma opção: ", 0, 4);
            
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n===== MENU PRODUTOS =====");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("0 - Sair");
        System.out.println("========================");
    }
    
    private static void cadastrarProduto() {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
        
        Produto produto = new Produto();
        
        String nome = Validacoes.validarString(scanner, "Nome do produto: ");
        produto.setNome(nome);
        
        double preco = Validacoes.validarDouble(scanner, "Preço: ");
        produto.setPreco(preco);
        
        int quantidade = Validacoes.validarInteiro(scanner, "Quantidade: ", 0, 1000);
        produto.setQuantidade(quantidade);
        
        int codigo = Validacoes.validarInteiro(scanner, "Código: ", 1, 9999);
        produto.setCodigo(codigo);
        
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    private static void removerProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados para remover.");
            return;
        }
        
        System.out.println("\n--- REMOÇÃO DE PRODUTO ---");
        listarProdutos();
        
        int indice = Validacoes.validarInteiro(scanner, "Digite o número do produto: ", 1, produtos.size()) - 1;
        Produto removido = produtos.remove(indice);
        
        System.out.println("Produto '" + removido.getNome() + "' removido com sucesso!");
    }
    
    private static void atualizarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
            return;
        }
        
        System.out.println("\n--- ATUALIZAÇÃO DE PRODUTO ---");
        listarProdutos();
        
        int indice = Validacoes.validarInteiro(scanner, "Escolha o produto: ", 1, produtos.size()) - 1;
        Produto produto = produtos.get(indice);
        
        String nome = Validacoes.validarString(scanner, "Novo nome: ");
        produto.setNome(nome);
        
        double preco = Validacoes.validarDouble(scanner, "Novo preço: ");
        produto.setPreco(preco);
        
        int quantidade = Validacoes.validarInteiro(scanner, "Nova quantidade: ", 0, 1000);
        produto.setQuantidade(quantidade);
        
        System.out.println("Produto atualizado com sucesso!");
    }
    
    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
            return;
        }
        
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i));
        }
    }
}