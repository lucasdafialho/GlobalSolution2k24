public class Suporte {
    private String tipoSuporte;
    private String contato;

    public Suporte(String tipoSuporte, String contato) {
        this.tipoSuporte = tipoSuporte;
        this.contato = contato;
    }

    public String getTipoSuporte() {
        return tipoSuporte;
    }

    public void setTipoSuporte(String tipoSuporte) {
        this.tipoSuporte = tipoSuporte;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Suporte{" +
                "tipoSuporte='" + tipoSuporte + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
