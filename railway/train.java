package railway;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class train {
	private int trainNo;
	private  String trainName;
	private int availableSeat;
	private int rac;
	private int waiting;
	
	//private static int seatLimit=limit/3;
	//private static int racLimit=rl;
	//private static int waitingListLimit=wl;
	
	
	
	private int upperSeatNumber=1;
	private int middleSeatNumber=2;
	private int lowerSeatNumber=3;
	
	public int getUpperSeatNumber()
	{
		return upperSeatNumber;
	}
	public void setUpperSeatNumber(int upperSeatNumber)
	{
		this.upperSeatNumber=upperSeatNumber;
	}
	public int getLowerSeatNumber()
	{
		return lowerSeatNumber;
	}
	public void setLowerSeatNumber(int lowerSeatNumber)
	{
		this.lowerSeatNumber=lowerSeatNumber;
	}
	public int getMiddleSeatNumber()
	{
		return middleSeatNumber;
	}
	public void setMiddleSeatNumber(int middleSeatNumber)
	{
		this.middleSeatNumber=middleSeatNumber;
	}
	
	
    static ArrayList<Passenger> confirmedList =new ArrayList<Passenger>();
	
	static ArrayList<Passenger> upperList=new ArrayList<Passenger>();
	static ArrayList<Passenger> lowerList=new ArrayList<Passenger>();
	static ArrayList<Passenger> middleList=new ArrayList<Passenger>();
	
	static ArrayList<Passenger> statusList=new ArrayList<Passenger>();
	 
	static Queue<Passenger> racQueue=new LinkedList<Passenger>();
	static Queue<Passenger> waitingQueue=new LinkedList<Passenger>();
	
	public train(int trainNo,String trainName,int availableSeat,int rac,int waiting)
	{
		this.trainNo=trainNo;
		this.trainName=trainName;
		this.availableSeat=availableSeat;
		this.rac=rac;
		this.waiting=waiting;
	}
	public int getTrainNumber()
	{
		return trainNo;
	}
	public void setTrainNumber(int trainNo)
	{
		this.trainNo=trainNo;
	}
	public String getTrainName()
	{
		return trainName;
	}
	public void setTrainName(String trainName)
	{
		this.trainName=trainName;
	}
	public static int getAvailableSeat()
	{
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat)
	{
		this.availableSeat=availableSeat;
	}
	public static int getRac()
	{
		return rac;
	}
	public void setRac(int rac)
	{
		this.rac=rac;
	}
	public static int getWaiting()
	{
		return waiting;
	}
	public void setwaiting(int waiting)
	{
		this.waiting=waiting;
	}
	public String toString()
	{
		return "\nTrain Name :"+trainName+"\n Train No:"+trainNo+"\n Train Available Seat :"+availableSeat;
	}

}
