package fag;

import java.time.Duration;
import java.time.LocalDateTime;

class Registro {
    private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public Registro(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = veiculo.getHoraEntrada();
    }

    public void registrarSaida() {
        this.horaSaida = veiculo.getHoraSaida();
        calcularValorPago();
    }

    private void calcularValorPago() {
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long horas = duracao.toHours();

        if (horas <= 1) {
            valorPago = 5.0;
        } else if (horas <= 3) {
            valorPago = 10.0;
        } else {
            valorPago = 15.0;
        }
    }

    public double getValorPago() {
        return valorPago;
    }

    public String gerarRelatorio() {
        return "Placa: " + veiculo.getPlaca() + 
               ", Entrada: " + horaEntrada + 
               ", Saída: " + horaSaida + 
               ", Valor pago: R$ " + valorPago;
    }
    
    
}
