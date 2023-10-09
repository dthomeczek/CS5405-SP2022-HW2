package code;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Point
{
    static double MathStuff(double num1, double num2, double num3, double num4,
    double num5, double num6, double num7, double num8) {
        // Assign points to an array
        double[] nums = new double[]{num1, num2, num3, num4, num5, 
            num6, num7, num8};
        // Arrays for x values and y values
        double[] x = new double[4];
        double[] y = new double[4];
        
        // j and k are counters
        int j = 0;
        int k = 0;
        for (int i = 0; i < 8; i++) {
            if ((i % 2) == 0) {
                x[j] = nums[i];
                j+= 1;
            }
            if ((i % 2) == 1) {
                y[k] = nums[i];
                k+= 1;
            }
        }

        // Sides of the quadrilateral
        double ab = Math.sqrt((x[1]-x[0])*(x[1]-x[0]) + (y[1]-y[0])*(y[1]-y[0]));
        double bc = Math.sqrt((x[2]-x[1])*(x[2]-x[1]) + (y[2]-y[1])*(y[2]-y[1]));
        double cd = Math.sqrt((x[3]-x[2])*(x[3]-x[2]) + (y[3]-y[2])*(y[3]-y[2]));
        double da = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (y[0]-y[3])*(y[0]-y[3]));

        // Used Brahmagupta formula for calculation of variables, and cross
        // referenced my output with the same test inputs at
        // https://calculator.swiftutors.com/brahmagupta-formula-calculator.html
        double perimeter = ab + bc + cd + da;
        double semiperimeter = perimeter/2;
        double area = Math.sqrt((semiperimeter-ab)*(semiperimeter-bc)*(semiperimeter-cd)*(semiperimeter-da));

        // Print points to screen
        System.out.println("Point 1: (" + x[0] + ", " + y[0] + ")");
        System.out.println("Point 2: (" + x[1] + ", " + y[1] + ")");
        System.out.println("Point 3: (" + x[2] + ", " + y[2] + ")");
        System.out.println("Point 4: (" + x[3] + ", " + y[3] + ")");

		return area;
	}
	
	// Driver code
	public static void main (String[] args)
	{
        System.out.println("Program by: Devin Thomeczek");

        // Date and time code
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss\n");  
        Date date = new Date();  
        System.out.println(formatter.format(date));

        // Used for taking in the 8 values as doubles
        Scanner sc= new Scanner(System.in);
        double num1=sc.nextDouble();
        double num2=sc.nextDouble();
        double num3=sc.nextDouble();
        double num4=sc.nextDouble();
        double num5=sc.nextDouble();
        double num6=sc.nextDouble();
        double num7=sc.nextDouble();
        double num8=sc.nextDouble();
        System.out.println("Area of the quadrilateral with the given " + 
        "points is: " + MathStuff(num1, num2, num3, num4, num5, 
        num6, num7, num8));
	}
}