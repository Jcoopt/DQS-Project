import java.util.Scanner; 

public class Quiz_login {
	public void run() {
		Scanner scan = new Scanner (new File());
		Scanner input = new Scanner(System.in);
		String username = scan.nextLine();
		String password = scan.nextLine();

		String inputUser = input.nextLine();
		String inputPass = input.nextLine();

		if (inputUser.equals(username) && inputPass.equals(password)) {
			System.out.println("Credentials accepted.");
		}
		else {
			System.out.println("ERROR, invalid credentials, please try again.");
		}
	}
}