package railway;
import java.util.*;
import java.util.Map.Entry;
public class TicketBooking {
	static int limit=admin.seat;
	static int rl=admin.racCount;
	static int wl=admin.waitingLimit;
	
	private static int seatLimit=limit/3;
	private static int racLimit=rl;
	private static int waitingListLimit=wl;
	
	private static int upperSeatNumber=1;
	private static int middleSeatNumber=2;
	private static int lowerSeatNumber=3;
	
	static ArrayList<Passenger> confirmedList =new ArrayList<Passenger>();
	
	static ArrayList<Passenger> upperList=new ArrayList<Passenger>();
	static ArrayList<Passenger> lowerList=new ArrayList<Passenger>();
	static ArrayList<Passenger> middleList=new ArrayList<Passenger>();
	
	static ArrayList<Passenger> statusList=new ArrayList<Passenger>();
	 
	static Queue<Passenger> racQueue=new LinkedList<Passenger>();
	static Queue<Passenger> waitingQueue=new LinkedList<Passenger>();
	
	public static void bookTicket(Passenger p) {
		if(upperList.size()==seatLimit && lowerList.size()==seatLimit && middleList.size()==seatLimit)
		{
			if(updateRacQueue(p))
			{
				System.out.println("Added to RAC "+"\n Your ticked id is :"+p.getId());
			}
			else if(updateWaitingQueue(p)) {
				System.out.println("Added to Waiting list \n Your ticket id is :"+p.getId());
			}
			else {
				p.setId(p.getId()-1);
				System.out.println("!!!!!! Ticket is not Available !!!!!!");
			}
			
		}
		else if(checkAvailability(p)) {
			System.out.println("Booking confirmed \n Your ticked id is :"+p.getId());
			p.setTicketType("berth confirmed");
			confirmedList.add(p);
			statusList.add(p);		}
		else {
			System.out.println(p.getPreference()+"is not available");
			p.setId(p.getId()-1);
			System.out.println("PLEASE CHECK AVAILABLE LIST AFTER BOOKING");
			user ob1=new user();
			ob1.menu();
		}
	}
	
	private static boolean updateRacQueue(Passenger p) {
		if(racQueue.size()<racLimit) {
			p.setTicketType("rac");
			racQueue.add(p);
			statusList.add(p);
			return true;
		}
		return false;
	}
	private static boolean updateWaitingQueue(Passenger p) {
		if(waitingQueue.size()<waitingListLimit)
		{
			p.setTicketType("waiting");
			waitingQueue.add(p);
			statusList.add(p);
			return true;
		}
		return false;
	}
	
	private static boolean checkAvailability(Passenger p) {
		Map<Integer,Character> map=CancelTicket.getSeatNumberWithBerth();
		
		if(p.getPreference()=='U') {
			if(upperList.size()<seatLimit) 
			{
				if(!map.isEmpty())
				{
					getSeatDetails(map,p);
				}
				else
				{
					p.setSeatNumber(upperSeatNumber);
					upperSeatNumber+=3;
				}
				upperList.add(p);
				return true;
			}
		}
		else if(p.getPreference()=='M') {
			if(middleList.size()<seatLimit)
			{
				if(!map.isEmpty())
				{
					getSeatDetails(map,p);
				}
				else
				{
					p.setSeatNumber(middleSeatNumber);
					middleSeatNumber+=3;
				}
				middleList.add(p);
				return true;
			}
		}
		else {
			if(lowerList.size()<seatLimit) {
				if(!map.isEmpty())
				{
					getSeatDetails(map,p);
				}
				else
				{
					p.setSeatNumber(lowerSeatNumber);
					lowerSeatNumber+=3;
				}
				lowerList.add(p);
				return true;
			}
		}
		return false;
	}
	public static void getSeatDetails(Map<Integer,Character> map,Passenger p)
	{
		int seatNumber=checkForPreferenceAvailability(map,p.getPreference());
		p.setSeatNumber(seatNumber);
		map.remove(seatNumber);
	}
	public static int checkForPreferenceAvailability(Map<Integer,Character> map,char preference)
	{
		int seatNumber=0;
		for(Entry<Integer,Character> entry : map.entrySet())
		{
			if(preference== (char) entry.getValue())
			{
				seatNumber=(int)entry.getKey();
				break;
			}
		}
		return seatNumber;
	}
	
	public static void availableList() {
		System.out.println("CHECK OUT THE NO OF SEAT AVAILABALE");
		System.out.println("UPPER BERTH :"+(seatLimit-upperList.size()));
		System.out.println("MIDDLE BERTH :"+(seatLimit-middleList.size()));
		System.out.println("LOWER BERTH :"+(seatLimit-lowerList.size()));
	}
	
	public static void displayConfirmed() {
		System.out.println("------------------------------");
		if(!confirmedList.isEmpty())
		{
			for(Passenger p: confirmedList)
			{
				System.out.println(p.toString());
				System.out.println("----------------------------------");
			}
		}
		else {
			System.out.println("CONFIRMED LIST IS EMPTY");
		}
	}
	
	public static void displayRAC() {
		System.out.println("-------------------------------");
		if(!racQueue.isEmpty())
		{
			for(Passenger p: racQueue) {
				System.out.println(p.toString());
				System.out.println("-----------------------------------");
			}
		}
		else
		{
			System.out.println("RAC LIST IS EMPTY");
		}
	}
	
	public static void displayWaiting() {
		System.out.println("-------------------------------");
		if(!waitingQueue.isEmpty())
		{
			for(Passenger p: waitingQueue) {
				System.out.println(p.toString());
				System.out.println("-----------------------------------");
			}
		}
		else {
			System.out.println("WAITING LIST IS EMPTY");
		}
	}
	public static void TicketStatus(int id)
	{
		System.out.println("----------------------------------");
		System.out.println();
		if(!statusList.isEmpty())
		{
			int count=0;
			for(Passenger p :statusList)
			{
				if(p.getId()==id)
				{
					System.out.println("Your Ticket Id id :"+id);
					System.out.println("Your Name is :"+p.getName());
					System.out.println("Your Ticket Status is :"+p.getTicketType());
					count=1;
					break;
				}
				
			}
			if(count==0)
			{
				System.out.println("Invalid Ticket Id");
				
			}
		}
		else {
			System.out.println("Status List is Empty");
		}
		
		System.out.println();
		System.out.println("----------------------------------");
		
	}
	
}
