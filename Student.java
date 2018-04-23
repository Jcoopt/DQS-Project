public class Student
{
  String name;
  String studentNumber;
  int questionsAnswered;
  int correctAnswers;
  int incorrectAnswers;

  public Student(String name, String studentNumber)
    {
      this.studentNumber = studentNumber ;
      this.name = name;
      this.questionsAnswered = 0 ;
      this.incorrectAnswers = 0 ;
    }

    public String getName()
    {
      return this.name ;
    }

    public String getStudentNumber()
    {
      return this.studentNumber ;
    }

    public void inCorrect(int num)
      {
        this.questionsAnswered += num ;
        this.incorrectAnswers += num ;
      }
    public void correct(nt num)
      {
        this.questionsAnswered += num ;
        this.correctAnswers += num ;
      }
    public String infoString()
      {
        String info = "Name : " + this.name +
        "\nQuestions answered : " + this.questionsAnswered +
        "\n Correct answers : " + this.correctAnswers +
        "\n Incorrect answers : " + this.incorrectAnswers  ;

        return info ;

      }


}
