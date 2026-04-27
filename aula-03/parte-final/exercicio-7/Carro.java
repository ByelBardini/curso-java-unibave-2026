public class Carro {
    private String modelo;
    private int ano;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 1886 || ano > 2026) {
            IO.println("Erro: ano inválido (" + ano + "). Deve estar entre 1886 e 2026.");
            return;
        }
        this.ano = ano;
    }
}
