import java.util.Scanner ;
import java.util.Vector ;
import java.io.*;


public class StudentBank implements Serializable
{
  	private Vector<Student> studentBank;

    public StudentBank()
      {
        this.studentBank = new  Vector<Student>();
      }

    public void add(Student student)
      {
        studentBank.addElement(student) ;
      }

    public Student get(int index)
      {
        return studentBank.elementAt(index) ;
      }

    public int length()
      {
        return studentBank.size();
      }






}
