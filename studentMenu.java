import java.io.File;
import java.util.Scanner;

public class studentMenu {
    //Joshua Tucker
//c1739307
//Adapted from PhoneBookTest.java


    public static void infoMenu(String[] schoolList, String setTopic  ) {
        StudentBank sb = new StudentBank();
        loadStudents("students.txt",sb);
        while (true){
          Scanner in = new Scanner(System.in);
        System.out.println("Hi! What school are you from?");
        for (int i=0;i<schoolList.length;i++){
            System.out.print((i+1)+"."+schoolList[i]+"\n");
        }
        int schoolSelection = in.nextInt();
        in.nextLine();
        String school =schoolList[schoolSelection-1];

        boolean running=true;
        while (running) {
            running=loadMenu(setTopic);
        }
        System.exit(0);

        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("Whats your student number");
        String number = in.nextLine();
        Student inStudent = new Student(number, school);
        sb.add(inStudent);
        loadMenu(setTopic);
        }

    }

    public static boolean loadMenu(String chosenTopic) {

        QuestionBank qb = new QuestionBank();
        adminMenu.loadQuestions("testQ.txt",qb);
        boolean running=true;
        while (true) {

            //display main menu

            System.out.println("1.Start quiz");
            System.out.println("2.Exit");

            Scanner in = new Scanner(System.in);
            int option = in.nextInt();

            switch (option) {

                case 1:
                    //1.Start quiz
                    System.out.println("-------------------------------");
                    Scanner id = new Scanner(System.in);

                    Quiz q = new Quiz();
                    q.startQuiz(qb, chosenTopic);
                    System.out.println("-------------------------------");
                    break;

                case 2:
                    //2.Exit
                    running=false;
                    break;


            }break;

        }
        return running;
    }

    public static void loadStudents(String file_name, StudentBank sb){

        try { //method adapted from lab and taught session exercises
            System.out.println("Loading Questions\n\n");
            Scanner input_file_handler = new Scanner(new File(file_name));

            while (input_file_handler.hasNextLine()) {

                String line_from_file = input_file_handler.nextLine();
                String[] split_line = line_from_file.split(",");
                addStudent(split_line, sb);
               // System.out.println("file read");

               /*System.out.println(Arrays.asList(split_line));
                StudentsList.add(new Student(Arrays.asList(split_line)));*/
            }
            input_file_handler.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem reading file: " + file_name + ". Are you sure it exists?");
        }
    }

    public static void addStudent( String[] studentInput, StudentBank sb ) {
      Student inStudent = new Student( studentInput[1], studentInput[2]);
      sb.add(inStudent);

    }
}
