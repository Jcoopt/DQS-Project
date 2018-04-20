//Joshua Tucker
//c1739307
//Used to help instantiate student objects
//by checking inputs against corresponding regular expressions
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class StudentEntry {



  public static String[] newEntry ( ) {


    String[] patterns = {"([a-zA-Z]+\\s*)+",
                        "C\\d{6}",
                        "([a-zA-Z]+\\s*)+",
                        "[A-Z]{2}\\d{4}",
                        "\\d+[a-z]?",
                        "([a-zA-Z]+\\s*)+",
                        "([a-zA-Z]+\\s*)+",
                        "[A-Z]{2}\\d[A-Z]{2}"};
    String[] inputLabels = {"name",
                            "student number",
                            "course name",
                            "course ID",
                            "house number",
                            "street name",
                            "town",
                            "postcode"};

    String[] studentInput = new String[patterns.length];

    for (int i = 0; i < patterns.length; ++i ) {
      studentInput[i] = getInput(inputLabels[i], patterns[i]);

    }

    //returns a String array of vald entries in the correct order
    return studentInput;

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
