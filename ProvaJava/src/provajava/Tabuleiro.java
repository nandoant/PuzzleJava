package provajava;

import java.util.List;


import java.util.Scanner;

public class Tabuleiro {
    private PecaPrincipal[][] tabuleiro;
    private final int tamanho;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new PecaPrincipal[tamanho][tamanho];
    }

    public boolean adicionarPeca(PecaPrincipal peca, int linha, int coluna) {
        if (linha < 0 || linha >= tamanho || coluna < 0 || coluna >= tamanho) {
            System.out.println("Posicao invalida! Escolha uma posicao dentro do tabuleiro.");
            return false;
        }

        if (tabuleiro[linha][coluna] != null) {
            System.out.println("Ja existe uma peca nessa posicao!");
            return false;
        }

        // Verifica os encaixes com peças vizinhas
        if ((linha > 0 && !peca.encaixaCom(tabuleiro[linha - 1][coluna], "cima")) ||
            (linha < tamanho - 1 && !peca.encaixaCom(tabuleiro[linha + 1][coluna], "baixo")) ||
            (coluna > 0 && !peca.encaixaCom(tabuleiro[linha][coluna - 1], "esquerda")) ||
            (coluna < tamanho - 1 && !peca.encaixaCom(tabuleiro[linha][coluna + 1], "direita"))) {
            System.out.println("A peca no encaixa corretamente nessa posicao.");
            return false;
        }

        // Adiciona a peça ao tabuleiro
        tabuleiro[linha][coluna] = peca;
        return true;
    }

    public void exibirTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] != null) {
                    System.out.print(tabuleiro[i][j].id + " ");
                } else {
                    System.out.print("X "); // Indica espaços vazios
                }
            }
            System.out.println();
        }
    }
}

