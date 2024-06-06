import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.print("Digite seu email (formato: exemplo@dominio.com): ");
            String email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Email inválido. O email deve estar no formato 'exemplo@dominio.com'. Tente novamente.");
                continue;
            }

            System.out.print("Digite sua senha (mínimo 8 caracteres, incluindo pelo menos um dígito, uma letra minúscula, uma letra maiúscula e um caractere especial): ");
            String senha = scanner.nextLine();
            if (!isValidSenha(senha)) {
                System.out.println("Senha inválida. A senha deve conter pelo menos um dígito, uma letra minúscula, uma letra maiúscula, um caractere especial e ter pelo menos 8 caracteres. Tente novamente.");
                continue;
            }

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
        System.out.print("Digite seu email (formato: exemplo@dominio.com): ");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Email inválido. O email deve estar no formato 'exemplo@dominio.com'. Por favor, tente novamente.");
            return null;
        }

        while (true) {
            System.out.print("Digite sua senha (mínimo 8 caracteres, incluindo pelo menos um dígito, uma letra minúscula, uma letra maiúscula e um caractere especial): ");
            String senha = scanner.nextLine();
            if (!isValidSenha(senha)) {
                System.out.println("Senha inválida. A senha deve conter pelo menos um dígito, uma letra minúscula, uma letra maiúscula, um caractere especial e ter pelo menos 8 caracteres. Por favor, tente novamente.");
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

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidSenha(String senha) {
        String senhaRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$";
        Pattern pattern = Pattern.compile(senhaRegex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }
}'
