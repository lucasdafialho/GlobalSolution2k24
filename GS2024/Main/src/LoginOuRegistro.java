import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginOuRegistro {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

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
            if (!validarEmail(email)) {
                System.out.println("Email inválido. Tente novamente.");
                continue;
            }
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
        if (!validarEmail(email)) {
            System.out.println("Email inválido. Tente novamente.");
            return null;
        }

        while (true) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            if (!validarSenha(senha)) {
                System.out.println("Senha inválida. A senha deve conter pelo menos 8 caracteres, incluindo maiúsculas, minúsculas, números e caracteres especiais.");
                continue;
            }

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

    private boolean validarEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    private boolean validarSenha(String senha) {
        Matcher matcher = PASSWORD_PATTERN.matcher(senha);
        return matcher.matches();
    }
}
