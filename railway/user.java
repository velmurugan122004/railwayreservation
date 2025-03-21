package railway;
import java.util.*;
public class user {
	Scanner s=new Scanner(System.in);
	boolean check=false;
	
	static ArrayList<train> trainList =new ArrayList<train>();
	
	public boolean check1(int trainNo)
	{
		boolean ch=false;
		/*for(Map.Entry<Integer,Integer> entry1 : entry.entrySet())
		{
			if(trainNo==entry1.getKey())
			{
				ch=true;
			}
		}*/
		for(train t :trainList)
		{
			if(trainNo==t.getTrainNumber())
			{
				ch =true;
			}
		}
		return ch;
	}
	public static void che(train t)
	{
		
		trainList.add(t);
	}
	
	public void menu() {
		
	while(!check) {
		System.out.println("\n 1.Booking Ticket \n 2.Cancel Ticket \n 3.Check seat Availability \n 4.Check available train \n 5.Ticket Status check \n 6.Back");
		System.out.print("ENTER YOUR OPTION :");
		int check1=s.nextInt();
		switch(check1)
		{ 
		case 1:
		{
			
			System.out.print("ENTER NUMBER OF TICKET TO BOOK :");
			int count=s.nextInt();
			while(count>=1)
			{
			System.out.print("ENTER TRAIN NUMBER :");
			int TrainNo=s.nextInt();
			
			if(check1(TrainNo)) 
			{
			    System.out.print("ENTER YOUR NAME :");
			    String name=s.next();
			    System.out.print("ENTER YOUR AGE :");
			    int age=s.nextInt();
			    System.out.print("YOUR PREFERENCE BERTH [U/M/L]:");
			    char prefer=s.next().charAt(0);
	            if(prefer=='U'|| prefer=='M'|| prefer=='L' || prefer=='u' || prefer=='l' || prefer=='m') {
	            	char prefer1=Character.toUpperCase(prefer);
	            	TicketBooking.train(TrainNo);
	            	TicketBooking.bookTicket(new Passenger(name,age,prefer1));
	            	count--;
	            }
	            else
	            {
	            	System.out.println("Invalid berth");
	            }
			}
			else
			{
				System.out.println("Train is not available check available train then book");
				check=false;
			}
			}
			break;
		}
		case 2:
		{
			System.out.print("Enter your Ticket id : ");
			int id = s.nextInt();
			System.out.println(CancelTicket.canceling(id));
			break;
		}
		case 3:
		{
			TicketBooking.availableList();
			break;
		}
		case 4:
		{
			System.out.println("Available Trains :-");
			for(train t:trainList)
			{
				System.out.println(t.toString());
			}
			break;
		}
		case 5:
		{
			System.out.print("Enter Your Ticket Id :");
			int id=s.nextInt();
			TicketBooking.TicketStatus(id);
			break;
		}
		case 6:
		{
			System.out.println("Switch Menu");
			check=true;
			break;
		}
		
		default:
		{
			System.out.println("YOUR OPTION IS EXITS BETTER LUCK NEXT TIME");
			System.exit(0);
			break;
		}
	}
	}
}


}
