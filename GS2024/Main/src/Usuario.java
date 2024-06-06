import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Premio> premios;
    private Suporte suporte;
    private ArrayList<Avaliacao> avaliacoes;

    private static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.premios = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public void addPremio(Premio premio) {
        this.premios.add(premio);
    }

    public Suporte getSuporte() {
        return suporte;
    }

    public void setSuporte(Suporte suporte) {
        this.suporte = suporte;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public static Usuario login(String email, String senha) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getEmail().equals(email) && usuario.senha.equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public static Usuario registro(String nome, String email, String senha) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getEmail().equals(email)) {
                throw new IllegalArgumentException("Email já registrado.");
            }
        }
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuariosRegistrados.add(novoUsuario);
        return novoUsuario;
    }

    public Postagem escreverPostagem(String titulo, String conteudo) {
        return new Postagem(titulo, conteudo, this.nome);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", premios=" + premios +
                ", suporte=" + suporte +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
