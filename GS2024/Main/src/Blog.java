import java.util.ArrayList;

public class Blog {
    private ArrayList<Postagem> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }

    public void exibirPostagens() {
        if (postagens.isEmpty()) {
            System.out.println("Nenhuma postagem disponível.");
        } else {
            for (Postagem postagem : postagens) {
                System.out.println(postagem);
            }
        }
    }
}
