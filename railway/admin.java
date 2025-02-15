package railway;
import java.util.*;
public class admin {
	public static int seat;
	public static int trainNo;
	public static int racCount;
	public static int waitingLimit;
	
	Scanner sc=new Scanner (System.in);
	
	public void menu() {
	System.out.print("ENTER TRAIN NO :");
	trainNo=sc.nextInt();
	System.out.print("ENTER SEAT AVAILABLITY :");
	seat=sc.nextInt();
	System.out.print("ENTER RAC LIMIT :");
	racCount=sc.nextInt();
	System.out.print("ENTER WAITING LIST LIMIT :");
	waitingLimit=sc.nextInt();
	}
	public  void display() {
		
	
		boolean check=false;
		while(!check) {
			System.out.println("\n Choose one option below :\n 1.Display confirmation list \n 2.Display RAC list \n 3.Display Waiting list \n 4.Seat available \n 5.Back");
			System.out.print("ENTER YOUR CHOICE :");
			int n=sc.nextInt();
			switch(n) {
			case 1:
			{
				TicketBooking.displayConfirmed();
				break;
			}
			case 2:
			{
				TicketBooking.displayRAC();
				break;
			}
			case 3:{
				TicketBooking.displayWaiting();
				break;
			}
			case 4:
			{
				TicketBooking.availableList();
				break;
			}
			case 5:
			{
				System.out.println("BACKING...........");
				check=true;
				break;
			}
			default:
			{
				System.out.print("OPTION IS EXISTS");
				System.exit(0);
				break;
			}
		}
	}
	}
}
