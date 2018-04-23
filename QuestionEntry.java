//Joshua Tucker
//c1739307
//Used to help instantiate student objects
//by checking inputs against corresponding regular expressions
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class QuestionEntry {

  public static String[] newEntry ( ) {

    String quesitonpattern = "([a-zA-Z0-9]+\\s*)+";

    String[] patterns = {"([a-zA-Z]+\\s*)+",
                        "([a-zA-Z0-9]+\\s*)+",
                        "([a-zA-Z0-9]+\\s*)+",
                        "([a-zA-Z0-9]+\\s*)+",
                        "([a-zA-Z0-9]+\\s*)+",
                        "[1-4]",
                        "([a-zA-Z0-9]+\\s*)+"};

    String[] inputLabels = {"Question text",
                            "Answer 1",
                            "Answer 2",
                            "Answer 3",
                            "Answer 4",
                            "number of the correct answer (1-4)",
                            "Topic"};

    String[] quesitonInput = new String[inputLabels.length];

    for (int i = 0; i < inputLabels.length; ++i ) {
      quesitonInput[i] = getInput(inputLabels[i], patterns[i]);

    }

    //returns a String array of valid entries in the correct order
    return quesitonInput;

  }

  public static String getInput( String label, String regex ) {
    Scanner in = new Scanner(System.in);
    Pattern p = Pattern.compile(regex);

   System.out.print( "Please enter " + label + ": " );
   String result = in.nextLine();
   Matcher m = p.matcher(result);


   if ( m.matches() ) {
     return result;

   } else {
     System.out.println( "Invalid entry.\nPlease Enter a valid " + label );
     return getInput(label, regex);

   }

  }

}
