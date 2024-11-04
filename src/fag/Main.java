package fag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();

        
        estacionamento.cadastrarVaga(new Vaga(1, "pequeno"));
        estacionamento.cadastrarVaga(new Vaga(2, "pequeno"));
        estacionamento.cadastrarVaga(new Vaga(3, "médio"));
        estacionamento.cadastrarVaga(new Vaga(4, "médio"));
        estacionamento.cadastrarVaga(new Vaga(5, "grande"));
        estacionamento.cadastrarVaga(new Vaga(6, "grande"));

        int opcao;
        
        do {
            System.out.println("\nSistema de Gerenciamento de Estacionamento");
            System.out.println("1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Gerar relatório de vagas ocupadas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho do veículo (pequeno, médio, grande): ");
                    String tamanho = scanner.nextLine();

                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                    estacionamento.registrarEntrada(veiculo);
                    break;

                case 2:
                    System.out.print("Placa do veículo para saída: ");
                    String placaSaida = scanner.nextLine();
                    estacionamento.registrarSaida(placaSaida);
                    break;

                case 3:
                    estacionamento.gerarRelatorioVagasOcupadas();
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}