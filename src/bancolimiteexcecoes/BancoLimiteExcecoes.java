package bancolimiteexcecoes;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exception.DomainException;

public class BancoLimiteExcecoes {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter account data"); //Inserir dados da conta
        System.out.print("Number account: "); //Numero da conta
        int number = sc.nextInt();
        System.out.print("Holder: "); //Titular
        String holder = sc.next();
        System.out.print("Inicital balance: "); //Saldo inicial
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: "); //Limite de retirada
        double withdrawLimit = sc.nextDouble();
        
        Account acc = new Account(number, holder, balance, withdrawLimit);
        
        System.out.println();
        System.out.print("Enter amount for withdraw: "); //Insira o valor para retirada
        double amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance())); //Novo saldo
        }
        catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage()); //Erro ao retirar
        }
        
        sc.close();
    }
    
}
