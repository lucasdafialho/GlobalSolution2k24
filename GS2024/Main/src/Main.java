import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioRegistrado;

    public static void main(String[] args) {
        System.out.println("Sistema Iniciando!");

        menu();

        System.out.println("Sistema Finalizado!");
    }

    private static void menu() {
        int opcao;

        do {
            System.out.println("Digite o número para sua escolha:");
            System.out.println("1. Login ou Registro");
            System.out.println("2. Procurar Lixeiras");
            System.out.println("3. Visualizar Prêmios");
            System.out.println("4. Nos Contate");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    loginOuRegistro();
                    break;
                case 2:
                    procurarLixeiras();
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

    private static void loginOuRegistro() {
        System.out.println("1. Login");
        System.out.println("2. Registro");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            login();
        } else if (opcao == 2) {
            registro();
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
        }
    }

    private static void login() {
        boolean loginSucesso = false;

        while (!loginSucesso) {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            usuarioRegistrado = Usuario.login(email, senha);

            if (usuarioRegistrado != null) {
                System.out.println("Login realizado com sucesso!");
                loginSucesso = true;
            } else {
                System.out.println("Email ou senha incorretos. Tente novamente.");
            }
        }
    }

    private static void registro() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        while (true) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            try {
                usuarioRegistrado = Usuario.registro(nome, email, senha);
                System.out.println("Registro realizado com sucesso!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
    }

    private static void procurarLixeiras() {
        System.out.println("Procurando lixeiras...");
    }

    private static void visualizarPremios() {
        System.out.println("Visualizando prêmios...");
    }

    private static void nosContate() {
        System.out.println("Nos contate:");
        System.out.println("Email: contato@exemplo.com");
        System.out.println("Telefone: (00) 0000-0000");
    }
}
