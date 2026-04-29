package com.banco.app;


import com.banco.config.Database;
import com.banco.service.ContaService;
import com.banco.model.ContaBancaria;


import java.util.Scanner;


public class ContaStart {
    public static void main(String[] args) {

        Database.inicializar();

        ContaService service = new ContaService();
        Scanner sc = new Scanner(System.in);

        int op = 0;
        while (true) {
        System.out.println("\n");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Buscar por id");
        System.out.println("4 - Depositar");
        System.out.println("5 - Sacar");
        System.out.println("6 - Tranferencia");
        System.out.println("7 - Excluir conta");
        System.out.println("0 - Sair");
        System.out.println("-------------------------");
        System.out.print("Opção: ");

        try{
            op = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Erro: " + e.getMessage());
            continue;
        }
        
            if (op == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Saldo inicial: ");
                double saldo = sc.nextDouble();

                System.out.print("Tipo (corrente/poupanca): ");
                String tipo = sc.next();

                service.criarConta(nome, saldo, tipo);
                System.out.println("Conta criada com sucesso.");
                sc.nextLine();
            }
            else if (op == 2) {
                System.out.println("Contas cadastradas:");
                for (ContaBancaria c : service.ListarContas()) {
                    System.out.println(c.getId() + " - " + c.getNome() + " | " + c.getTipo() + " | R$ " + c.getSaldo());
                }
            }
            else if(op == 3){
                System.out.println("Digite o id referente à conta que deseja buscar");
                int id = sc.nextInt();

                ContaBancaria conta = service.BuscarPorId(id); 

                if (conta != null) {
                    System.out.println("Conta encontrada:");
                    System.out.println(conta);
                } else {
                    System.out.println("Nenhuma conta encontrada com esse ID.");
                }
            }

            else if(op == 4){
                System.out.println("Digite o id referente a conta que queres depositar");
                int id = sc.nextInt();
                sc.nextLine();

                try{
                    ContaBancaria conta = service.BuscarPorId(id);
                    if(conta == null){
                        System.out.println("Tranferencia invalidada, a conta digitada nao existe");
                        sc.nextLine();
                        return;
                    }

                    System.out.println("Verifique se seus dados estao corretos");
                    System.out.println(conta);

                    System.out.println("Confirmar transacao: (sim)S / N(nao)");
                    String confirmacao = sc.nextLine();

                    if(confirmacao.equalsIgnoreCase("S")){
                        System.out.println("Digite o valor do deposito");
                        double valor = sc.nextDouble();

                        sc.nextLine();

                        service.Depositar(id, valor);
                        System.out.println("Deposito realizado com sucesso");
                    }else{
                        System.out.println("Transacao invalidada");
                    }
                }catch(RuntimeException e){
                    System.out.println("Erro" + e.getMessage());
                }
            }

            else if(op == 5){
                System.out.println("Digite o id referente a conta que vai realizar o saque");
                int id = sc.nextInt();

                sc.nextLine();

                try{
                    ContaBancaria conta = service.BuscarPorId(id);
                    if(conta == null){
                        System.out.println("Tranferencia invalida, a conta digitada nao existe");
                        sc.nextLine();
                        return;
                    }

                    System.out.println("Verifique se seus dados estao corretos");
                    System.out.println(conta);

                    System.out.println("Confirmar saque (sim) S/N (nao)");
                    String confirmacao = sc.nextLine();

                    if(confirmacao.equalsIgnoreCase("S")){
                        System.out.println("Digite o valor do saque que deseja efetuar");
                        double valor = sc.nextDouble();

                        sc.next();

                        service.sacar(id, valor);
                        System.out.println("Saque realizado com sucesso");
                    }else{
                        System.out.println("Transacao invalidada");
                    }
                }catch(RuntimeException e){
                    System.out.println("Erro" + e.getMessage());
                }
            sc.nextLine();
            }
            

            else if(op == 6){
                System.out.println("Digite o id da conta titular que deseja tranferir");
                int idTitular = sc.nextInt();

                try{
                    ContaBancaria conta = service.BuscarPorId(idTitular);
                    if(conta == null){
                        System.out.println("A conta digitada nao existe");
                        return;
                    }

                    sc.nextLine();
                    
                    System.out.println("Digite o id da conta destino da tranferencia");
                    int idDestino = sc.nextInt();

                    ContaBancaria contaDestino = service.BuscarPorId(idDestino);

                    if(contaDestino == null){
                        System.out.println("Tranferencia invalida: A conta digitada nao existe");
                        return;
                    }
                    sc.nextLine();

                    System.out.println("Conta origem: " + conta);
                    System.out.println("Conta destino: " + contaDestino);

                    System.out.println("Confirmar transacao (sim)S / N (nao)");
                    String confirmacao = sc.nextLine();
                                        
                    if(confirmacao.equalsIgnoreCase("S")){
                        System.out.println("Digite o valor da tranferencia");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        service.tranferencia(idTitular, idDestino, valor);

                        System.out.println("Transferencia bem sucedida");
                    }else{
                        System.out.println("Falha na transacao");

                    }
                    
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            else if(op == 7){
                System.out.println("Escreva o id da conta que deseja excluir");
                int id = sc.nextInt();

                service.apagarConta(id);
            }

            else if (op == 0) {
                break;
            }
        }
        sc.close();
    }
}