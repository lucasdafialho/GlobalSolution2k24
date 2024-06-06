public class Premio {
    private String nomePremio;
    private String descricao;

    public Premio(String nomePremio, String descricao) {
        this.nomePremio = nomePremio;
        this.descricao = descricao;
    }

    public String getNomePremio() {
        return nomePremio;
    }

    public void setNomePremio(String nomePremio) {
        this.nomePremio = nomePremio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Premio{" +
                "nomePremio='" + nomePremio + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
