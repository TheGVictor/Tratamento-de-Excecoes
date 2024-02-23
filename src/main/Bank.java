package main;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.exceptions.ValueException;

public class Bank {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Insira os dados da conta");

			System.out.print("Número: ");
			int number = sc.nextInt();

			System.out.print("Nome do titular: ");
			String holder = sc.next();

			sc.nextLine();

			System.out.print("Saldo inicial: ");
			double balance = sc.nextDouble();

			System.out.print("Limite de saque: ");
			double withdrawLimit = sc.nextDouble();

			System.out.print("\nQual o valor será sacado? ");
			double withdraw = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			account.withdraw(withdraw);
			System.out.printf("Novo saldo: %.2f%n", account.getBalance());
			
			sc.close();

		} catch (ValueException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado");
		}

	}

}
