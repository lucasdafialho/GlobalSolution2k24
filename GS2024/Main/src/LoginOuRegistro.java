import java.util.Scanner;

public class LoginOuRegistro {
    private static final Scanner scanner = new Scanner(System.in);

    public Usuario loginOuRegistro() {
        System.out.println("1. Login");
        System.out.println("2. Registro");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            return login();
        } else if (opcao == 2) {
            return registro();
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
            return null;
        }
    }

    private Usuario login() {
        boolean loginSucesso = false;
        Usuario usuario = null;

        while (!loginSucesso) {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            usuario = Usuario.login(email, senha);

            if (usuario != null) {
                System.out.println("Login realizado com sucesso!");
                loginSucesso = true;
            } else {
                System.out.println("Email ou senha incorretos. Tente novamente.");
            }
        }
        return usuario;
    }

    private Usuario registro() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        while (true) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            try {
                Usuario usuario = Usuario.registro(nome, email, senha);
                System.out.println("Registro realizado com sucesso!");
                return usuario;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
    }
}
