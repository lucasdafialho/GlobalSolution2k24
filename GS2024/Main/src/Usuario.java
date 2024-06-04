import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || !isValidPassword(senha)) {
            throw new IllegalArgumentException("Senha inválida. A senha deve ter pelo menos 8 caracteres, incluindo um número e um caractere especial.");
        }
        this.senha = senha;
    }

    public static Usuario login(String email, String senha) {
        // Aqui você pode adicionar a lógica de autenticação, como consulta ao banco de dados.
        // Por enquanto, retornando null para indicar que o login falhou.
        return null;
    }

    public static Usuario registro(String nome, String email, String senha) {
        return new Usuario(nome, email, senha);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    private boolean isValidPassword(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        String senhaRegex = "^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        Pattern pat = Pattern.compile(senhaRegex);
        return pat.matcher(senha).matches();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
