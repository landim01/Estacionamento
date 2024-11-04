package fag;

import java.util.ArrayList;
import java.util.List;

class Estacionamento {
    private List<Vaga> vagas = new ArrayList<>();
    private List<Registro> registros = new ArrayList<>();

    public void cadastrarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public void registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.ocupar();
                veiculo.registrarEntrada();
                registros.add(new Registro(veiculo, vaga));
                System.out.println("Veículo " + veiculo.getPlaca() + " alocado na vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Não há vagas disponíveis para o tamanho do veículo.");
    }

    public void registrarSaida(String placa) {
        for (Registro registro : registros) {
            if (registro.getVeiculo().getPlaca().equals(placa)) {
                registro.getVeiculo().registrarSaida();
                registro.registrarSaida();
                registro.getVaga().liberar();
                System.out.println("Veículo " + placa + " liberado. Valor a pagar: R$ " + registro.getValorPago());
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    public void gerarRelatorioVagasOcupadas() {
        for (Registro registro : registros) {
            if (registro.getVaga().isDisponivel()) {
                continue;
            }
            System.out.println("Vaga " + registro.getVaga().getNumero() +
                               ", Tamanho: " + registro.getVaga().getTamanho() +
                               ", Placa: " + registro.getVeiculo().getPlaca() +
                               ", Modelo: " + registro.getVeiculo().getModelo());
        }
    }
}