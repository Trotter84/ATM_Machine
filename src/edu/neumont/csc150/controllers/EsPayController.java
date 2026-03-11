package edu.neumont.csc150.controllers;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.models.data.*;
import edu.neumont.csc150.server.Server;
import edu.neumont.csc150.views.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class EsPayController {
	private int clearScreen = 100;
	private EsPayUI esPayUI;
	private Bank bank;
	private Person person;
	private List<Person> persons;

	private String currentCardNum = "";

	public EsPayController() {
		esPayUI = new EsPayUI();
		bank = new Bank();
		persons = new ArrayList<>();
	}

	public void run() throws IOException {
		esPayUI.esPaySplashScreen();
		esPayUI.getStringPrompt("continue..", true, Console.TextColor.PURPLE);
		mainMenuController();
	}

	private void mainMenuController() throws IOException {
		String[] options = {"Read Card", "Create Person", "View Persons", "Create Account", "View Accounts"};

		do {
			esPayUI.displayString("\n".repeat(clearScreen) + """
					=================
					--- Main Menu ---
					=================""", Console.TextColor.CYAN
			);
			int choice = esPayUI.menuUI(Arrays.asList(options), true, true, Console.TextColor.BLUE);
			switch (choice) {
				case 1 -> startServer();
				case 2 -> createPerson();
				case 3 -> viewPersons();
				case 4 -> assignAccount();
				case 5 -> viewAccounts();
				case 6 -> devMode(); // hidden option
				case 0 -> {
					quit();
					return;
				}
			}
		} while (true);
	}


	public void startServer() throws IOException {
		try {
			Server.run();
		} catch (IOException ioe) {
			throw new IOException(ioe);
		}
	}

	public static void readCard(String cardNum) {
		System.out.println("I made it: " + cardNum);
	}

	private void createPerson() {
		boolean isCorrect = false;
		esPayUI.displayString("\n".repeat(clearScreen) + """
				=====================
				--- Create Person ---
				=====================""", Console.TextColor.CYAN
		);
		do {
			person = new Person(
					esPayUI.getStringPrompt("Enter first name.", false, Console.TextColor.BLUE),
					esPayUI.getStringPrompt("Enter last name.", false, Console.TextColor.BLUE),
					esPayUI.getIntPrompt("Enter age.", 1, 10000, Console.TextColor.BLUE)
			);
			esPayUI.displayString("Is " + person + " (" + person.getAge() + ")" + " correct?", Console.TextColor.BLUE);
			int choice = esPayUI.getIntPrompt("""
							1. yes
							2. no""",
					1, 2,
					Console.TextColor.BLUE
			);
			if (choice == 1) isCorrect = true;
		} while (!isCorrect);
		esPayUI.displayString('\n' + person.toString() + ", age " + person.getAge() + '\n', Console.TextColor.GREEN);

		persons.add(person);
	}

	private void viewPersons() {
		esPayUI.displayString("\n".repeat(clearScreen) + """
				===================
				--- All Persons ---
				===================""", Console.TextColor.CYAN
		);
		for (Person person : persons) {
			esPayUI.displayString(("\t" + person.toString()), Console.TextColor.YELLOW);
		}
		esPayUI.getStringPrompt("\ncontinue..", true, Console.TextColor.PURPLE);
	}

	private void viewAccounts() {
		esPayUI.displayString("\n".repeat(clearScreen) + """
				====================
				--- All Accounts ---
				====================""", Console.TextColor.CYAN
		);
		for (Account account : bank.getAccounts()) {
			esPayUI.displayString(("\t" + account.toString()), Console.TextColor.YELLOW);
		}
		esPayUI.getStringPrompt("\ncontinue..", true, Console.TextColor.PURPLE);

	}

	private void assignAccount() {
		boolean unConfirmed = true;
		esPayUI.displayString("\n".repeat(clearScreen) + """
				==========================
				--- Assign New Account ---
				==========================""", Console.TextColor.CYAN
		);
		do {
			List<Person> personsWithoutAccount = new ArrayList<>();
			for (Person person : persons) {
				if (person.getAccount() == null) {
					personsWithoutAccount.add(person);
				}
			}
			esPayUI.displayString("\nWho would you like to create an account for?", Console.TextColor.BLUE);
			int choice = esPayUI.menuUI(personsWithoutAccount, false, false, Console.TextColor.YELLOW);
			switch (choice) {
				case 0:
					return;
				default:
					int deposit = esPayUI.getIntPrompt("Enter an initial deposit amount.", 5, 1000000, Console.TextColor.BLUE);
					Person currentPerson = persons.get(choice - 1);
					esPayUI.displayString(bank.createAccount(currentPerson
							, deposit).toString(), Console.TextColor.PURPLE);
					break;
			}
			esPayUI.displayString("Would you like to create another account?", Console.TextColor.BLUE);
			int secondChoice = esPayUI.getIntPrompt("""
							1. yes
							2. no""",
					1, 2,
					Console.TextColor.BLUE
			);
			if (secondChoice == 2) unConfirmed = false;
		} while (unConfirmed);
	}

	private void quit() {
		esPayUI.quitUI();
		esPayUI.displayString("Have a great day!", Console.TextColor.PURPLE);
	}


	private void devMode() {
		esPayUI.displayString("\n".repeat(clearScreen) + """
				=================
				--- Dev Menu ---
				=================""", Console.TextColor.RED
		);

		esPayUI.displayString("Create random persons?", Console.TextColor.BLUE);
		int choice = esPayUI.getIntPrompt("""
						1. yes
						2. no""",
				1, 2,
				Console.TextColor.BLUE
		);
		if (choice == 1) {
			Random random = new Random();
			int count = esPayUI.getIntPrompt("How many persons would you like to create?", 1, 51, Console.TextColor.BLUE);
			int testAges = random.nextInt(1, 10000);
			for (int i = 0; i < count; i++) {
				person = new Person(Arrays.asList(FirstName.values()).get(ThreadLocalRandom.current().nextInt(51)).fName, Arrays.asList(LastName.values()).get(ThreadLocalRandom.current().nextInt(51)).lName, testAges);
				persons.add(person);
			}
			viewPersons();
		}
	}

	//	TODO: Delete later.
	public void shoppingSpree() {
		Random random = new Random();
		int testLength = 6;
		for (int i = 0; i < testLength; i++) {
			bank.getAccounts().get(0).swipeCard(random.nextInt(10000));
		}
	}
}
