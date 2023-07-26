package paone.cs655.p2;

//Main method to test the composite pattern
public class CompositeTestDrive {

    public static void main (String args[]){

        //Creates all the monthly statements in 2022
        Statement janStatement = new MonthlyStatement("Jan",
                "Monthly Statement for January 2022");
        Statement febStatement = new MonthlyStatement("Feb",
                "Monthly Statement for February 2022");
        Statement marStatement = new MonthlyStatement("Mar",
                "Monthly Statement for March 2022");
        Statement aprStatement = new MonthlyStatement("Apr",
                "Monthly Statement for April 2022");
        Statement mayStatement = new MonthlyStatement("May",
                "Monthly Statement for May 2022");
        Statement junStatement = new MonthlyStatement("Jun",
                "Monthly Statement for June 2022");
        Statement julStatement = new MonthlyStatement("Jul",
                "Monthly Statement for July 2022");
        Statement augStatement = new MonthlyStatement("Aug",
                "Monthly Statement for August 2022");
        Statement sepStatement = new MonthlyStatement("Sep",
                "Monthly Statement for September 2022");
        Statement octStatement = new MonthlyStatement("Oct",
                "Monthly Statement for October 2022");
        Statement novStatement = new MonthlyStatement("Nov",
                "Monthly Statement for November 2022");
        Statement decStatement = new MonthlyStatement("Dec",
                "Monthly Statement for December 2022");

        System.out.println("\n-- Testing Monthly Statement by itself --");
        janStatement.print();
        System.out.println();


        Statement q1 = new ComboStatement("Q1",
                "Combo Statement of Quarterly Statements for Q1 2022");
        q1.add(janStatement);
        q1.add(febStatement);
        q1.add(marStatement);

        System.out.println("-- Testing Quarterly Statement --");
        q1.print();
        System.out.println();

        Statement q2 = new ComboStatement("Q2",
                "Combo Statement of Quarterly Statements for Q2 2022");

        q2.add(aprStatement);
        q2.add(mayStatement);
        q2.add(junStatement);

        System.out.println("-- Testing Quarterly Statement --");
        q2.print();
        System.out.println();

        Statement q3 = new ComboStatement("Q3",
                "Combo Statement of Quarterly Statements for Q3 2022");

        q3.add(julStatement);
        q3.add(augStatement);
        q3.add(sepStatement);


        Statement q4 = new ComboStatement("Q4",
                "Combo Statement of Quarterly Statements for Q4 2022");

        q4.add(octStatement);
        q4.add(novStatement);
        q4.add(decStatement);


        Statement half1 = new ComboStatement("First Half-Year",
                "Combo Statement of First Half Yearly Statements for 2022");
        half1.add(q1);
        half1.add(q2);

        System.out.println("-- Testing Half-Yearly Statement --");
        half1.print();
        System.out.println();

        Statement half2 = new ComboStatement("Second Half-Year",
                "Combo Statement of Second Half Yearly Statements for 2022");
        half2.add(q3);
        half2.add(q4);

        Statement full = new ComboStatement("Full-Year",
                "Combo Statement of Full Yearly Statements for 2022");
        full.add(half1);
        full.add(half2);

        System.out.println("-- Testing Full Yearly Statement --");
        full.print();






    }
}
