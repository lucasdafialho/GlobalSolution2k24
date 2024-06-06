public class Avaliacao {
    private String usuario;
    private int nota;
    private String comentario;

    public Avaliacao(String usuario, int nota, String comentario) {
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "usuario='" + usuario + '\'' +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
