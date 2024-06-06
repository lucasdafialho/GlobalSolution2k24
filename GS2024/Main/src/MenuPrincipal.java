import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioRegistrado;
    private Blog blog;

    public MenuPrincipal() {
        this.blog = new Blog();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("Digite o número para sua escolha:");
            System.out.println("1. Login ou Registro");
            System.out.println("2. Blog");
            System.out.println("3. Visualizar Prêmios");
            System.out.println("4. Nos Contate");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarLoginOuRegistro();
                    break;
                case 2:
                    if (usuarioRegistrado != null) {
                        BlogGUI blogUI = new BlogGUI(usuarioRegistrado, blog);
                        blogUI.menuBlog();
                    } else {
                        System.out.println("Você precisa estar logado para acessar o blog.");
                    }
                    break;
                case 3:
                    visualizarPremios();
                    break;
                case 4:
                    nosContate();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();

        } while (opcao != 5);
    }

    private void realizarLoginOuRegistro() {
        LoginOuRegistro loginRegistro = new LoginOuRegistro();
        usuarioRegistrado = loginRegistro.loginOuRegistro();
    }

    private void visualizarPremios() {
        if (usuarioRegistrado != null) {
            System.out.println("Visualizando prêmios de " + usuarioRegistrado.getNome() + ":");
            for (Premio premio : usuarioRegistrado.getPremios()) {
                System.out.println(premio);
            }
        } else {
            System.out.println("Você precisa estar logado para visualizar os prêmios.");
        }
    }

    private void nosContate() {
        System.out.println("Nos contate:");
        System.out.println("Email: contato@exemplo.com");
        System.out.println("Telefone: (00) 0000-0000");
    }
}
