import java.util.Scanner;
public class areaOfTriangle{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);

      float base = input.nextFloat();  
      float height = input.nextFloat();
      float cmarea = base*height/2; //area of triangle is half time product of base and height
      double inchesarea = cmarea/ Math.pow(2.54,20);
      double feetarea = inchesarea/ Math.pow(12,2);
    System.out.println("Area of triangle in cm is  " + cmarea + " while in feet is " + feetarea + " and inches is " + inchesarea );
   }
}
