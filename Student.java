import java.io.FileNotFoundException;

import java.util.Scanner;


public class Student
{
	static Scanner mc=new Scanner(System.in);//new Scanner(System.in);
    // Declare the important attributes of a student. For example:
    //1.Id
    //2. Name
    //3. Department
    //4. University
    //5. GPAs in various terms (Multidimensional arrays)
    //6. subjects for Current terms
    //7. Credits and grades of Current Terms (Multidimmentional Array)
   private int id;
   private String name;
   private String dept;
   private String university;
   private double[][] gpa;
   private String[] sub;
   private double[] credit;
   private double[] grade;
   private int id_;





    /**
     * Define a constructor that initilize the default properties of the Student
     */
    public Student()
    {
        // initialise   variables with defult values
    	id=0;
    	name=new String();
    	dept=new String();
    	university=new String();
    	gpa=new double[100][100];
        sub=new String[100];
        credit=new double[100];
        grade=new double[100];
    }
    /**
     * Define a method to print the students details.
     */

    public void studentDetailsById(int Id,String a,String b,String c)
    {
        //write your code here

    	id=Id;
    	name=a;
    	dept=b;
    	university=c;
    }

    public void setsub(int n){
    	System.out.println("Enter courses: ");
    	//Scanner mn=new Scanner(mc.nextLine());
    	for(int i=0;i<=n;i++){
    		sub[i]=mc.nextLine();
    	}
    }
    public void setcredit(int n){
    	System.out.println("Enter credit: ");
    	//Scanner mn=new Scanner(mc.nextLine());
    	for(int i=0;i<n;i++){
    		credit[i]=mc.nextDouble();
    	}
    }
    public void setgrade(int n){
    	System.out.println("Enter grades: ");
    	//Scanner mn=new Scanner(mc.nextLine());
    	for(int i=0;i<n;i++){
    		grade[i]=mc.nextDouble();
    	}
    }
    public void computeGpa(int n, int x, int y) {
		double totalcredits = 0;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			totalcredits += credit[i];
		}
		for (int i = 0; i < n; i++) {
			sum += (credit[i] * grade[i]);
		}
		gpa[x][y] = (sum / totalcredits);
	}
    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    public void updateStudentById(Student st,int s,int t)
    {
        //Write your code here
    	System.out.println(st.id);
    	System.out.println(st.name);
    	System.out.println(st.dept);
    	System.out.println(st.university);
    	System.out.println("Enter number of courses: ");
    	int n=mc.nextInt();
    	setsub(n);
    	setcredit(n);
    	setgrade(n);
    	computeGpa(n,s,t);
    	System.out.println("GPA: ");
    	System.out.println(computeGPAById(st.id,st,s,t));


    }

    /**
     * Define a method to compute the CGPA from the Given term GPA for a particular student.
     * se as many arguments as required.
     */
    public double computeCGPAByID(int x, int y, Student s) {
		double sum = 0;
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				sum += s.computeGPAById(s.id_, s, i, j);
			}
		}
		return sum / y;
	}

    /**
     * Define a method to compute the GPA from the given Credits and Grades of all the subjects
     */
    public double computeGPAById(int id, Student s, int i, int j) {
		//if (id == s.id_) {
			return s.gpa[i][j];
		//} else {
		//	return 0.0;
		//}
		// write yor code here

	}

    /**
     * After performing required operations on each student, save the information to a file. Use File and PrintWriter Class.
     * use as many arguments as required.
     *
     */
    public void saveStudents()
    {
        //Write your code here
    }

    /**
     * Create a dummy files with infromations to describe the properties of a Student object and load the data files using Java File and Scanner class.
     * use as many arguments as required.
     */
    public void loadStudents()
    {
        //Write your code here

    }

    /**
     * The tasks to be carried out here:
     * 1. Create an Arrays of students using Student Class. Initlize them and perfom all the above defined operation to evualuate your code.
     * use as many arguments as required.
     */
    public static void main(String[] args)
    {
        //Write your main function to execute call defined methods
    	Student a=new Student();
    	a.studentDetailsById(1407036, "Fuad", "cse", "Kuet");
    	System.out.println("Enter year and term: ");
    	int s=mc.nextInt();
    	int t=mc.nextInt();
    	a.updateStudentById(a,s,t);

    	System.out.println(a.computeCGPAByID(s,t,a));
    }

}
