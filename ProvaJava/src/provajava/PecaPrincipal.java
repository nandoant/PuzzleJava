
package provajava;

public class PecaPrincipal {
    public int id; 
    public PecaHorizontal esquerda; 
    public PecaHorizontal direita; 
    public PecaVertical superior; 
    public PecaVertical inferior; 


    public PecaPrincipal(int id, PecaHorizontal esquerda, PecaHorizontal direita, PecaVertical superior, PecaVertical inferior ) {
        this.id = id;
        this.direita = direita;
        this.esquerda = esquerda;
        this.superior = superior;
        this.inferior = inferior;
    }
    
    public boolean encaixaCom(PecaPrincipal outraPeca, String direcao){
        if(outraPeca == null) return true;
        
        switch (direcao){
            case "esquerda":
                return this.esquerda.inferior == !outraPeca.direita.inferior &&
                        this.esquerda.superior == !outraPeca.direita.superior;
            //outraPeca PecaSelecioa
                // ? O |     O ?
                // ? O |     O ?
            case "direita":
                return this.direita.inferior == !outraPeca.esquerda.inferior &&
                        this.direita.superior == !outraPeca.esquerda.superior;
            case "cima":
                return this.superior.direita == !outraPeca.inferior.direita &&
                        this.superior.esquerda == !outraPeca.inferior.esquerda;
            case "baixo":
                return this.inferior.direita == !outraPeca.superior.direita &&
                        this.inferior.esquerda == !outraPeca.superior.esquerda;
            default:
                return false;
        }
    }
    
    public void exibirPeca() {
        StringBuilder exibir = new StringBuilder();
        exibir.append(gerarLinhaSuperior())
              .append("\n")
              .append(gerarLinhaCorpo1())
              .append("\n")
              .append(gerarLinhaCorpo2())
              .append("\n")
              .append(gerarLinhaInferior());

        System.out.println(exibir);
    }

    private String gerarLinhaSuperior() {
        return (superior.direita ? " X " : "   ") + 
               (superior.esquerda ? "X" : "  ");
    }

    private String gerarLinhaCorpo1() {
        return (esquerda.superior ? "X" : " ") + 
               "###" + 
               (direita.superior ? "X" : " ");
    }
    
    private String gerarLinhaCorpo2() {
        return (esquerda.superior ? "X" : " ") + 
               "###" + 
               (direita.superior ? "X" : " ");
    }

    private String gerarLinhaInferior() {
        return (inferior.direita ? " X " : "   ") + 
               (inferior.esquerda ? "X" : "  ");
    }
 

}
