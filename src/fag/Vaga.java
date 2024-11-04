package fag;

class Vaga {
    private int numero;
    private String tamanho; // pequeno, médio, grande
    private boolean disponivel;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = true; // A vaga inicia como disponível
    }

    public int getNumero() {
        return numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocupar() {
        disponivel = false;
    }

    public void liberar() {
        disponivel = true;
    }
}