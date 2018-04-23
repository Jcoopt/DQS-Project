
//Nikeen Patel
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Quiz_login {


	public static void main(String[] args) {
		String username;
		String password;
		try {
			String file_name = "userData.txt";
			Scanner scan = new Scanner(new File(file_name));

			username = scan.nextLine();
			password = scan.nextLine();

			scan.close();

			Scanner input = new Scanner(System.in);
			System.out.println("username: ");
			String inputUser = input.nextLine();
			System.out.println("password: ");
			String inputPass = input.nextLine();

			Pattern up = Pattern.compile(inputUser);
			Pattern pp = Pattern.compile(inputPass);
			Matcher um = up.matcher(username);
			Matcher pm = pp.matcher(password);
			if (um.matches() && pm.matches()) {
				System.out.println("Credentials accepted.");
				Menu m = new Menu();
				Menu.loadMenu();
			}
			else {
				System.out.println("ERROR, invalid credentials, please try again.");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}



	}


}
