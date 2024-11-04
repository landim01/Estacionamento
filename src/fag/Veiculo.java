package fag;

import java.time.LocalDateTime;

class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho; 
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getModelo() {
    	return modelo;
    }
    
    public String getPlaca() {
        return placa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void registrarEntrada() {
        horaEntrada = LocalDateTime.now();
    }

    public void registrarSaida() {
        horaSaida = LocalDateTime.now();
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }
}