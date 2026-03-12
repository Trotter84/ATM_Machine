package edu.neumont.csc150.views;

import java.util.List;

public class EsPayUI {
	private String logoLarge = """
			                  ███████████                     \s
			                 ▒▒███▒▒▒▒▒███                    \s
			  ██████   █████  ▒███    ▒███  ██████   █████ ████
			 ███▒▒███ ███▒▒   ▒██████████  ▒▒▒▒▒███ ▒▒███ ▒███\s
			▒███████ ▒▒█████  ▒███▒▒▒▒▒▒    ███████  ▒███ ▒███\s
			▒███▒▒▒   ▒▒▒▒███ ▒███         ███▒▒███  ▒███ ▒███\s
			▒▒██████  ██████  █████       ▒▒████████ ▒▒███████\s
			 ▒▒▒▒▒▒  ▒▒▒▒▒▒  ▒▒▒▒▒         ▒▒▒▒▒▒▒▒   ▒▒▒▒▒███\s
			                                          ███ ▒███\s
			                                         ▒▒██████ \s
			                                          ▒▒▒▒▒▒  \s""";
	private String logoSmall = """
			             ____            \s
			  ___  _____/ __ \\____ ___  __
			 / _ \\/ ___/ /_/ / __ `/ / / /
			/  __(__  ) ____/ /_/ / /_/ /\s
			\\___/____/_/    \\__,_/\\__, / \s
			                     /____/  \s""";


	public int menuUI(List menuItems, boolean isExit, boolean hiddenItem, Console.TextColor color) {
		for (int i = 0; i < menuItems.size(); i++) {
			Console.write((i + 1) + ".", Console.TextColor.BLUE);
			Console.writeln(" " + menuItems.get(i), color);
		}
		return Console.getIntInput("0. " + (isExit ? "Exit" : "Return"), 0, menuItems.size() + (hiddenItem ? 1 : 0), Console.TextColor.BLACK);
	}

	public void displayString(String prompt, Console.TextColor color) {
		Console.writeln(prompt, color);
	}

	public String getStringPrompt(String prompt, boolean allowEmpty, Console.TextColor color) {
		return Console.getStringInput(prompt, allowEmpty, color);
	}


	public int getIntPrompt(String prompt, int min, int max, Console.TextColor color) {
		return Console.getIntInput(prompt, min, max, color);
	}

	public void esPaySplashScreen() {
		Console.writeln("\n".repeat(100) + logoLarge, Console.TextColor.BLUE);
	}

	public void displaySmallLogo() {
		Console.write("\n".repeat(100) + logoSmall, Console.TextColor.GREEN);
	}
}
