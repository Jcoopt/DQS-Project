//Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java
import java.util.Scanner;
import java.io.*;

public class StudentTest {

  public static void main( String[] args ) {

    StudentDetails sd = readDetails();

    // sd.add(
    // "matt",
    // "c123456",
    // "Computer Science",
    // "CM2536",
    // "16",
    // "cardinal avenue",
    // "bristol",
    // "BM0PQ"
    // );
    //
    // sd.add(
    // "Micheal Bolt",
    // "c078925",
    // "maths",
    // "MM6846",
    // "123a",
    // "The Strand",
    // "Edinburgh",
    // "MC9SL"
    // );


while (true) {
  //display main menu
  System.out.println("Options:");
  System.out.println("1.Add new student");
  System.out.println("2.Display all students");
  System.out.println("3.Search students by field");
  System.out.println("4.Delete student");
  System.out.println("5.Display subset of students");
  System.out.println("6.Save Student Details to file");
  System.out.println("7.Exit");


    Scanner in = new Scanner(System.in);
    int option = in.nextInt();
    String monthString;
    switch (option) {

        case 1:
        //1.Add new Student
        StudentEntry se = new StudentEntry();
        String studentInput[] = se.newEntry();
        sd.add(
        studentInput[0],
        studentInput[1],
        studentInput[2],
        studentInput[3],
        studentInput[4],
        studentInput[5],
        studentInput[6],
        studentInput[7]
        );
        break;

        case 2:
        //2.Display all students
        System.out.println(sd);
        break;

        case 3:
        //3.Search for students by field
        System.out.println(getSearch(sd));
        break;

        case 4:
        //4.Delete student
        System.out.println("Enter number of record to Delete: ");
        sd.delete(in.nextInt());
        break;

        case 5:
        //5.Get subset of students
        System.out.println("please enter a start position: ");
        int startPos = in.nextInt();
        System.out.println("please enter a end position: ");
        int endPos = in.nextInt();
        System.out.println(sd.subset(startPos, endPos));
        break;

        case 6:
        //6.Save student details
        writeDetails(sd);
        break;

        case 7:
        //7.save and exit
        writeDetails(sd);
        System.exit(0);

      }

    }

  }

  public static String getSearch(StudentDetails sd) {
    System.out.println("please select field:");
    System.out.println("1.Name");
    System.out.println("2.House number");
    System.out.println("3.Street name");
    System.out.println("4.Town");
    System.out.println("5.Postcode");

    //get field to search
    Scanner in = new Scanner(System.in);
    int option = in.nextInt();
    int field = 0;
    switch (option) {
        case 1: field = 0;
        break;
        case 2: field = 4;
        break;
        case 3: field = 5;
        break;
        case 4: field = 6;
        break;
        case 5: field = 7;
        break;
      }

    //get substring to search for
    System.out.println("Search for: ");
    Scanner ib = new Scanner(System.in);
    String pattern = ib.nextLine();

    //return results
    return (sd.searchStudents( field, pattern ));
  }

  public static void writeDetails( StudentDetails sd ) {
    //taken from WriteTest.java from week3
    //saves state of given object as .dat file
    //the object and all subclasses must implement Serializable
    try {
        ObjectOutputStream out = new ObjectOutputStream
            ( new FileOutputStream( "students.dat" ) );
        out.writeObject(sd);
        System.out.println("saved successfully");
        out.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
  }
public static StudentDetails readDetails( ) {
  //taken from ReadTest.java from week3
  try {
      ObjectInputStream in = new ObjectInputStream
          ( new FileInputStream( "students.dat" ) );
      StudentDetails sd = (StudentDetails)in.readObject();

      in.close();
      return sd;
  }
  catch (Exception e) {
      e.printStackTrace();
  }
  StudentDetails sd2 = new StudentDetails();
  return sd2;

}


}
