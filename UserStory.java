import java.util.Scanner;

public class UserStory {
/* 
* instance variables 
*/
  private String[] majors;
  private int[] totalStudents;
  private int[] medianSalaries;
/*
* no constructors
*/

/*
* parameterized constructors
*/
  public UserStory(String majorFile, String totalStudentsFile, String medianSalaryFile) {
    majors = FileReader.toStringArray(majorFile);
    totalStudents = FileReader. toIntArray (totalStudentsFile);
    medianSalaries = FileReader.toIntArray (medianSalaryFile);
  }

  public void run(){
    int selection = 0;

        while (selection != 2) {
            selection = promptUser();
            System.out.println(showData(selection) + "\n");
            
            String userMajor = promptUserForMajor();
            int majorIndex = findIndexByMajor(userMajor);
            
            if (majorIndex != -1) {
                System.out.println("The median salary for " + majors[majorIndex] + " is: " + medianSalaries[majorIndex] + ("\n"));
            } else {
                System.out.println("Major not found!" + ("\n"));
            }
            //selection = promptUser();

        }

        System.out.println("Goodbye!!");
    }

  

public int promptUser(){
  Scanner input = new Scanner (System.in);

  System.out.println("Would you like to see a list of majors?");
  System.out.println ("1: Yes");
  System.out.println ("2: No");
  System.out.println ("Enter Choice (1 or 2): ");

  int choice = input.nextInt();
  input.close();
  return choice;
}

  public String showData (int choice){
    String result = "/n Majors List: /n";

    if (choice == 1){
      for (int i = 0; i < majors.length; i++) {
        String majorText = "\nMajor: " + majors[i];
        String studentsText = "\nTotal Students: " + totalStudents[i];
        result += majorText + studentsText;
      }

    }
    
    return result;
  }

  
public String promptUserForMajor(){
  Scanner input = new Scanner (System.in);
  System.out.println("Type a major for the salary?:");
  String choice = input.nextLine();
  input.close();
  return choice;
}
  public int findIndexByMajor(String searchMajor) {
  for (int i = 0; i < majors.length; i++) {
    if (searchMajor.equals(majors[i])) {
      return i;
       


    }
  }
  return -1;
}


  
  
  
  
  
  /*
*return
*/
    public String toString() {
      String result = "";

      for (int i = 0; i < majors.length; i++) {
        String majorText = "\nMajor: " + majors[i];
        String studentsText = "\nTotal Students: " + totalStudents[i];
        String salaryText = "\nMedian Salary: " + medianSalaries[i];
        result += majorText + studentsText + salaryText;
      }

      return result;
    }

  
}