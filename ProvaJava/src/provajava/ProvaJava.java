
package provajava;


import java.util.Scanner;


public class ProvaJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configurações iniciais do tabuleiro
        System.out.println("Digite o tamanho do tabuleiro (Exemplo: 3 para um tabuleiro 3x3): ");
        int tamanho = scanner.nextInt();
        Tabuleiro tabuleiro = new Tabuleiro(tamanho);

        // Definição de peças (exemplo simples com IDs e bordas configuradas manualmente)
        PecaPrincipal[] pecas = {
            new PecaPrincipal(1, new PecaHorizontal(false, true), new PecaHorizontal(true, false),
                              new PecaVertical(false, true), new PecaVertical(true, false)),
            new PecaPrincipal(2, new PecaHorizontal(true, false), new PecaHorizontal(false, true),
                              new PecaVertical(false, false), new PecaVertical(true, true)),
            new PecaPrincipal(3, new PecaHorizontal(false, false), new PecaHorizontal(false, true),
                              new PecaVertical(true, false), new PecaVertical(true, true))
        };

        //  X X
        // X▇▇X  
        // X▇▇X
        //  X X
        
        // Exibe peças disponíveis
        System.out.println("\nPecas disponiveis:");
        for (PecaPrincipal peca : pecas) {
            System.out.println("Peca ID: " + peca.id);
            peca.exibirPeca();
        }

        // Interação para adicionar peças no tabuleiro
        while (true) {
            System.out.println("\nEstado atual do tabuleiro:");
            tabuleiro.exibirTabuleiro();

            System.out.println("Escolha a ID da peca para adicionar ou digite -1 para sair:");
            int id = scanner.nextInt();
            if (id == -1) break;

            // Busca a peça pelo ID
            PecaPrincipal pecaSelecionada = null;
            for (PecaPrincipal p : pecas) {
                if (p.id == id) {
                    pecaSelecionada = p;
                    break;
                }
            }

            if (pecaSelecionada == null) {
                System.out.println("Peca invalida! Escolha um ID valido.");
                continue;
            }

            // Escolha de posição
            System.out.println("Digite a posicao para colocar a peca (linha e coluna, comecando de 0): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            // Tenta adicionar a peça
            if (!tabuleiro.adicionarPeca(pecaSelecionada, linha, coluna)) {
                System.out.println("Nao foi possivel adicionar a peca na posicao escolhida.");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
    

