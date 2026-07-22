import java.util.Scanner;

class Student {
    private String name;
    private String regNo;
    private int workingDays;
    private int presentDays;
    private double attendance;
    private double averageMarks;

    // Constructor
    Student(String name, String regNo, int workingDays,
            int presentDays, double averageMarks) {

        this.name = name;
        this.regNo = regNo;
        this.workingDays = workingDays;
        this.presentDays = presentDays;
        this.averageMarks = averageMarks;

        attendance = ((double) presentDays / workingDays) * 100;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    // Attendance Status
    public void attendanceStatus() {

        System.out.printf("Attendance Percentage : %.2f%%\n", attendance);

        if (attendance >= 75)
            System.out.println("Attendance Status : Eligible");
        else
            System.out.println("Attendance Status : Shortage of Attendance");
    }

    // Performance
    public void performance() {

        System.out.println("Average Marks : " + averageMarks);

        if (averageMarks >= 90)
            System.out.println("Performance : Outstanding");
        else if (averageMarks >= 80)
            System.out.println("Performance : Excellent");
        else if (averageMarks >= 70)
            System.out.println("Performance : Very Good");
        else if (averageMarks >= 60)
            System.out.println("Performance : Good");
        else if (averageMarks >= 50)
            System.out.println("Performance : Average");
        else
            System.out.println("Performance : Poor");
    }

    // Category
    public void category() {

        if (averageMarks >= 90)
            System.out.println("Category : TOPPER");
        else if (averageMarks < 50)
            System.out.println("Category : SLOW LEARNER");
        else
            System.out.println("Category : AVERAGE LEARNER");
    }

    // Display Details
    public void display() {

        System.out.println("\n--------------------------------------");
        System.out.println("Student Name      : " + name);
        System.out.println("Register Number   : " + regNo);
        attendanceStatus();
        performance();
        category();
    }
}

public class Main{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Student student[] = new Student[50];

        int count = 0;
        do {

            System.out.println("\n==================================");
            System.out.println(" STUDENT ATTENDANCE MANAGEMENT ");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. Check Attendance");
            System.out.println("3. Attendance Percentage");
            System.out.println("4. Student Performance");
            System.out.println("5. Display All Students");
            System.out.println("6. Display Topper");
            System.out.println("7. Display Slow Learners");
            System.out.println("8. Exit");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Register Number : ");
                    String regNo = sc.nextLine();

                    System.out.print("Enter Total Working Days : ");
                    int workingDays = sc.nextInt();

                    System.out.print("Enter Present Days : ");
                    int presentDays = sc.nextInt();

                    System.out.print("Enter Average Marks : ");
                    double averageMarks = sc.nextDouble();

                    student[count] = new Student(name, regNo, workingDays,
                            presentDays, averageMarks);

                    count++;

                    System.out.println("Student Record Added Successfully.");

                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Enter Register Number : ");
                    String reg = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {

                        if (student[i].getRegNo().equals(reg)) {

                            student[i].attendanceStatus();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found.");

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Register Number : ");
                    reg = sc.nextLine();

                    found = false;

                    for (int i = 0; i < count; i++) {

                        if (student[i].getRegNo().equals(reg)) {

                            System.out.printf("Attendance Percentage : %.2f%%\n",
                                    student[i].getAttendance());

                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found.");

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter Register Number : ");
                    reg = sc.nextLine();

                    found = false;

                    for (int i = 0; i < count; i++) {

                        if (student[i].getRegNo().equals(reg)) {

                            student[i].performance();
                            student[i].category();

                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found.");

                    break;

                case 5:

                    if (count == 0) {

                        System.out.println("No Student Records Available.");

                    } else {

                        for (int i = 0; i < count; i++) {

                            student[i].display();

                        }
                    }

                    break;

                case 6:

                    if (count == 0) {

                        System.out.println("No Student Records.");

                    } else {

                        int top = 0;

                        for (int i = 1; i < count; i++) {

                            if (student[i].getAverageMarks() >
                                    student[top].getAverageMarks()) {

                                top = i;

                            }
                        }

                        System.out.println("\n******** TOPPER ********");

                        student[top].display();
                    }

                    break;

                case 7:

                    boolean slow = false;

                    System.out.println("\n****** SLOW LEARNERS ******");

                    for (int i = 0; i < count; i++) {

                        if (student[i].getAverageMarks() < 50) {

                            student[i].display();

                            slow = true;
                        }
                    }

                    if (!slow)
                        System.out.println("No Slow Learners.");

                    break;

                case 8:

                    System.out.println("Thank You...!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 8);

        sc.close();
    }
}