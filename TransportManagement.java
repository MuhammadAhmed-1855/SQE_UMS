
import java.util.*;
public class TransportManagement{
	
	static TMS transportObj = new TMS();
	private static ArrayList<String> log = new ArrayList<String>();
	
	static String Choices(int c, String regNumber) {
		if(c==1) {
			transportObj.manage(regNumber);
			return("Transport Services.");
		}
		else if(c==0) {
			System.out.println("Exiting...");
			return("Exiting Transport System.");
		}
		else {
			System.out.println("Invalid Input!");
			return("Invalid Input!");
		}
	}
	
	static int Menu() {
		Scanner input = new Scanner(System.in); 
		
		System.out.println("\n*******************************************************\n");
        System.out.println("\tTransport Management System\n");
        System.out.println("*******************************************************\n");

        System.out.println("1. Visit Transport Menu.");
		System.out.println("0. Leave Menu.");
		System.out.println("Enter your choice : ");
		int opt = input.nextInt();
		return(opt);
	}
	
	static void manage(String regNumber){
		int value = Menu();
		
		while(value!=0) {
			String res = Choices(value, regNumber);
    		log.add(res);
			value = Menu();
		}

	}//42
}