package railway;
import java.util.*;
public class Mainclass
{
	public static boolean isValidEmail(String email) {
		boolean flag = false;
		String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.(com|in)";

		if (email.matches(regex)) {
			flag = true;
		}
		return flag;
	}
    public static boolean isPassword(String pass) {
    	boolean flag=false;
    	String regex="[A-Za-z0-9]{8,12}";

		if (pass.matches(regex)) {
			flag = true;
		}
		return flag;
    }
    
    public static void admin1()
    {
    	Scanner s=new Scanner(System.in);
    	System.out.print("ENTER YOUR ADMIN ID:");
		String s1=s.next();
		System.out.print("ENTER PASSWORD :");
		String s2=s.next();
		if(s1.matches("admin123")) {
			if(s2.matches("vel12345")) {
				System.out.println("VERIFIED");
				admin ob=new admin();
				ob.menu();
			}
			else {
				System.out.println("Incorrect password");
			}
		}
		else {
			System.out.println("Incorrect admin id ");
		}
    }
    public static void user1()
    {
    	Scanner s=new Scanner(System.in);
    	boolean check=false;
		while(!check) {
			System.out.print("ENTER YOUR EMAIL ID :");
		    String s3=s.next();
		    System.out.print("ENTER PASSWORD :");
		    String s4=s.next();
		    if(isValidEmail(s3)) {
		    	if(isPassword(s4)) {
		    		System.out.print("VERIFIED");
				    check=true;
				    user ob=new user();
				    ob.menu();
				}
		    	else {
				System.out.println("Incorrect password format pls reenter correct gmail");
				}
		    }
		    else {
			System.out.println("Incorrect email format");
			}
		}
    }
	public static void main(String[] args) {
		admin1();
		Scanner s=new Scanner(System.in);
		boolean check=false;
		while(!check) {
			System.out.println("Choose Any One :- \n 1.admin \n 2.user \n 3.admin view \n 4.Exit \n");
			System.out.print("ENTER YOUR OPTION :");
			int n=s.nextInt();
			switch(n) {
			
			case 1:
			{
				admin1();
				break;
			}
			case 2:
			{
				user1();
				break;
			}
			case 3:
			{
				admin ob=new admin();
			    ob.display();
			    break;
		    }
			case 4:
			{
				System.out.println("Thank you for using ");
			    System.exit(0);
			    break;
			}
			default:
			{
				System.out.print("OPTION IS EXITS.....");
				System.exit(0);
				break;
			}
			}
		}
	}
}
