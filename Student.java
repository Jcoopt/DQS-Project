public class Student
{
  String school;
  String studentNumber;
  int questionsAnswered;
  int correctAnswers;
  int incorrectAnswers;

  public Student( String studentNumber, String school)
    {
      this.school = school;
      this.studentNumber = studentNumber;
      this.questionsAnswered = 0;
      this.incorrectAnswers = 0;
    }


    public String getSchool()
  {
    return this.school ;
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
    public void correct(int num)
      {
        this.questionsAnswered += num ;
        this.correctAnswers += num ;
      }
    public String infoString()
      {
        String info = "School : " + this.school +
        "\nQuestions answered : " + this.questionsAnswered +
        "\n Correct answers : " + this.correctAnswers +
        "\n Incorrect answers : " + this.incorrectAnswers  ;

        return info ;

      }


}
