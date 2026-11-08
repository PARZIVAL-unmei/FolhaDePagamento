import java.util.Scanner;
import java.util.ArrayList;

public class FolhaDePagamento {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final float SALARIO_BASE = 2000;

        ArrayList<Integer> matriculas = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<Float> beneficios = new ArrayList<>();
        ArrayList<Float> salarios = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar Colaborador Padrao");
            System.out.println("2 - Cadastrar Colaborador Comissionado");
            System.out.println("3 - Cadastrar Colaborador Producao");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("5 - Exibir Resumo da Folha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                System.out.println("\n--- COLABORADOR PADRAO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Padrao");
                beneficios.add(0f);
                salarios.add(SALARIO_BASE);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 2) {

                System.out.println("\n--- COLABORADOR COMISSIONADO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Valor de vendas: ");
                float vendas = sc.nextFloat();

                System.out.print("Percentual de comissao: ");
                float percentual = sc.nextFloat();
                sc.nextLine();

                float comissao = vendas * percentual / 100;
                float salarioComissao = SALARIO_BASE + comissao;

                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Comissionado");
                beneficios.add(comissao);
                salarios.add(salarioComissao);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 3) {

                System.out.println("\n--- COLABORADOR PRODUCAO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Quantidade de pecas: ");
                int quantidade = sc.nextInt();

                System.out.print("Valor por peca: ");
                float valorPeca = sc.nextFloat();
                sc.nextLine();

                float produtividade = quantidade * valorPeca;
                float salarioProducao = SALARIO_BASE + produtividade;

                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Producao");
                beneficios.add(produtividade);
                salarios.add(salarioProducao);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 4) {

                System.out.println("\n===== FOLHA DE PAGAMENTO =====");

                if (nomes.size() == 0) {

                    System.out.println("Nenhum colaborador cadastrado.");

                } else {

                    for (int i = 0; i < nomes.size(); i++) {

                        System.out.println("\nMatricula: " + matriculas.get(i));
                        System.out.println("Nome: " + nomes.get(i));
                        System.out.println("Tipo: " + tipos.get(i));
                        System.out.println("Salario Base: R$ " + SALARIO_BASE);

                        if (beneficios.get(i) > 0) {

                            System.out.println("Beneficio adicional: R$ " + beneficios.get(i));

                        } else {

                            System.out.println("Beneficio adicional: Nenhum");

                        }

                        System.out.println("Salario Final: R$ " + salarios.get(i));
                        System.out.println("-----------------------------");

                    }
                }

            } else if (opcao == 5) {

                System.out.println("\n===== RESUMO DA FOLHA =====");

                int totalColaboradores = nomes.size();
                float totalFolha = 0;
                float mediaSalarial = 0;

                for (int i = 0; i < salarios.size(); i++) {

                    totalFolha = totalFolha + salarios.get(i);

                }

                if (totalColaboradores > 0) {

                    mediaSalarial = totalFolha / totalColaboradores;

                }

                System.out.println("Total de colaboradores: " + totalColaboradores);
                System.out.println("Total da folha: R$ " + totalFolha);
                System.out.println("Media salarial: R$ " + mediaSalarial);

            } else if (opcao == 0) {

                System.out.println("Encerrando o programa...");

            } else {

                System.out.println("Opcao invalida!");

            }

        }

        sc.close();

    }
}
