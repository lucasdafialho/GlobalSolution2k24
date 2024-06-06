import java.util.Scanner;

public class BlogGUI {
    private static final Scanner scanner = new Scanner(System.in);
    private Usuario usuarioRegistrado;
    private Blog blog;

    public BlogGUI(Usuario usuarioRegistrado, Blog blog) {
        this.usuarioRegistrado = usuarioRegistrado;
        this.blog = blog;
    }

    public void menuBlog() {
        System.out.println("Bem-vindo ao Blog!");
        System.out.println("1. Ver postagens");
        System.out.println("2. Escrever nova postagem");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            verPostagens();
        } else if (opcao == 2) {
            escreverPostagem();
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
        }
    }

    private void verPostagens() {
        System.out.println("Exibindo postagens do blog...");
        blog.exibirPostagens();
    }

    private void escreverPostagem() {
        if (usuarioRegistrado != null) {
            System.out.print("Digite o título da sua postagem: ");
            String titulo = scanner.nextLine();
            System.out.print("Digite o conteúdo da sua postagem: ");
            String conteudo = scanner.nextLine();
            Postagem postagem = usuarioRegistrado.escreverPostagem(titulo, conteudo);
            blog.adicionarPostagem(postagem);
            System.out.println("Postagem salva com sucesso!");
        } else {
            System.out.println("Você precisa estar logado para escrever uma postagem.");
        }
    }
}
