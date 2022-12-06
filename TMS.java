
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.URI;

//Shahzaneer Ahmed --> SP21-BCS-087
// input fields are validated (exceptional handling)
// randomly generation Bus Registration ID
//CRUD
// file handling



public class TMS {

	private static ArrayList<String> log = new ArrayList<String>();
	private static boolean feePaid = false;
	
	public static String Choices(int choice, String regNumber) {
		String registrationNo = regNumber;
        String busID = busID();
        String busReg = "";
        
        boolean isRegistered = busFileFound(regNumber);
        
		//Enter 1.
		if(choice==1) {
			displayRoutesAndStops();
			return("Bus Routes!");
		}
		
		//Enter 2.
		else if(choice==2) {
			displayBusFees();
			return("Bus Fees!");
		}
		
		//Enter 3.
		else if(choice==3) {
			if(!isRegistered) {
				busReg = busRegistration(registrationNo);
				File busFile = new File("transport.TransportFiles/"+registrationNo+".txt");
				try {
//					busFile.createNewFile();
					isRegistered = true;
					FileWriter busFileWriter = new FileWriter("transport/TransportFiles/"+registrationNo+".txt");
					busFileWriter.write(busReg);
					System.out.print("\n******************* Registered Successfully! ****************\n\n");
					busFileWriter.close();
					return("Bus Registration Successful!");
				}
				catch (IOException e) {
					System.out.println("An Error occured during registration!");
					return("Bus Registration Failed!");
				}
			}
			else {
				System.out.println("Your Account Already exists in our database !");
				return("Bus Already Registered!");
			}
		}
		
		//Enter 4.
		else if(choice==4) {
			if(isRegistered){
				busReg = busRegistration(registrationNo);
				feePaid = false;
				try {
					FileWriter busFileWriter = new FileWriter("transport/TransportFiles/"+registrationNo+".txt");

					busFileWriter.write(busReg);
					System.out.print("\n******************* Data Updated Successfully! " +
							"****************\n\n");
					busFileWriter.close();
					return("Information Update Successful!");
				}
				catch (IOException e) {
					System.out.println("Sorry we found some issues inserting your details in the our database ");
					return("Information Update Failed!");
				}
			}
			else{
				System.out.println("Kindly Register first !");
				return("No Bus Registered.");
			}
		}
		
		//Enter 5.
		else if(choice==5) {
//			if(!feePaid){
			if(!isRegistered) {
				System.out.println("Your profile doesn't exist! Register first!");
				return("No Bus Registered!");
			}
			else if(!feePaid) {
				paymentMethod(isRegistered);
				feePaid = true;
				return("Fee Paid!");
			}
			else if(feePaid && isRegistered) {
				System.out.println("You have already paid the fee !");
				return("Fee Already Paid!");
			}

			else {
				System.out.println("Something went wrong");
				return("Error!");
			}
		}
		
		//Enter 6.
		else if(choice==6) {
			File busFilex = new File("transport/TransportFiles/"+registrationNo+".txt");

			if (!busFilex.exists()) {
				System.out.println("Your Profile doesn't exist!");
				return("No Bus Registration File Found!");
			}

			else if(feePaid && busFilex.exists()){
				try {
					File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
					Scanner sc = new Scanner(busFile);

					while (sc.hasNextLine()) {
						String profile = sc.nextLine();
						System.out.println(profile);
					}
					sc.close();
					return("Displaying Bus Profile Successful!");
				}
				catch(IOException e){
					System.out.println("We found some issues in reading your data! try again!");
					return("Displaying Bus Profile Failed!");
				}
			}
			else if(!feePaid) {
				System.out.println("Kindly pay the fee to proceed to your Profile !");
				return("Fee Not Paid!");
			}
			else {
				System.out.println("Something went wrong");
				return("Error!");
			}
		}

		//Enter 7.
		else if(choice==7) {
			File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
			if (busFile.delete()) {
				System.out.println("The bus profile has been deleted successfully!");
				isRegistered = false;
				feePaid = false;
				return("Bus Registration Deleted!");
			}
			else if (!busFile.exists()) {
				System.out.println("No record found! you haven't registered yet!");
				return("No Bus Registration File Found!");
			}
			else {
				System.out.println("Something went wrong");
				return("Error!");
			}
		}
		else if(choice==0) {
			System.out.println("Exiting...");
			return("Exiting Transport Services!");
		}
		else {
			System.out.println("Invalid Input!");
			return("Invalid Input!");
		}
	}
	
	public static int Menu() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Corresponding Number to Select the option :");
			System.out.println("1. Bus Routes");
			System.out.println("2. Bus Fees");
			System.out.println("3. Bus Registration");
			System.out.println("4. Update Info");
			System.out.println("5. Fee Payment");
			System.out.println("6. Bus Profile");
			System.out.println("7. Delete Bus Registration");
			System.out.println("0. Leave Menu");
			String c = input.next();
			return(Integer.parseInt(c));
		}
		catch(InputMismatchException e) {
			System.out.println("Input Mismatch! Input can only be integer.");
			return(-1);
		}
	}

    public static void manage (String regNumber) {
    	int choose = Menu();
    	
    	while(choose!=0) {
    		
    		if(choose!=-1) {
    			String res = Choices(choose, regNumber);
    			log.add(res);
    			if(res.equalsIgnoreCase("Exiting Transport Services!")) {
    				break;
    			}
    		}
    		
    		choose = Menu();
    	}
    }


    //  Methods for TMS

    //   displaying routes, stops and fees
    static void displayBusFees(){
        System.out.println("**************** Buses Fees ***********");
        System.out.println("Route 1 : 20,000\nRoute 2 : 15,000\nRoute 3 : 14,000\nRoute 4 : 13,000\nRoute 5 : 10,000\nRoute 6 : 22,000\nRoute 7 : 24,000\nRoute 8 : 21,000\n\n");


    }
    static void displayRoutesAndStops(){
        System.out.println("--------------------------------Route # 1-----------------------------------------------");
        System.out.println("Stops -->\n F-11 Markaz\nGolra more\nMargala road\nPAF Complex Gate\nShaheen " +
                "Chowk\nMadina" +
                " Market");
        System.out.println("--------------------------------Route # 2-----------------------------------------------");
        System.out.println("Stops -->\nG-11/2 Apple School\n G-11 Markaz \n G-11/3 Alladin Appartment\n G-10 Umer " +
                "market\n G-9/1 Street no 44");
        System.out.println("--------------------------------Route # 3-----------------------------------------------");
        System.out.println("Stops --> \nAskari XI\n Qasim Market \n Roomi Market \n GPO Saddar\n Kacheri Chowk");
        System.out.println("--------------------------------Route # 4-----------------------------------------------");
        System.out.println("Stops -->\n Hajj Complex \n Old Daewoo Stop \n Pirdhadhai More \n Charing Cross \n Valley" +
                " Road");
        System.out.println("--------------------------------Route # 5-----------------------------------------------");
        System.out.println("Stops -->\nChungi no 22 \n CMH \n 502 workshop \n Jinnah Park \n Jhandha Chechi");
        System.out.println("--------------------------------Route # 6-----------------------------------------------");
        System.out.println("Stops -->\nBahria Town Ace Academy\n Street no 6 Bahria More\n Al Noor Pharmacy \nRahat " +
                "Bakery\n PWD Barrier \n London Tradex");
        System.out.println("--------------------------------Route # 7-----------------------------------------------");
        System.out.println("Stops -->\nGangal East\n karal Chowk\nGangal West\nFizaya Colony\n Chatry Chowk\n Khanna " +
                "Pull");
        System.out.println("--------------------------------Route # 8-----------------------------------------------");
        System.out.println("Stops -->\nNawal Anchorage\n Bhander \n Sowan Garden\n Al Shifa Hospital\n Toyota " +
                "Motors\n\n");

    }

    //    bus registration
    static String busID(){
        //        busID generation
        Random randCardNum = new Random();
        int number =(int) 1000 + randCardNum.nextInt(1000);
        String busID = "" + number;
        return busID;
    }
    static String registrationTiming(){
        //        Registration date and timing
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy || h:m a"));

    }
    
    static String RouteChecker(String route) {
    	if (route.equals("1") || route.equals("2")|| route.equals("3") || route.equals("4") || route.equals("5") || route.equals("6") || route.equals("7") || route.equals("8")){
            return route;
        }
        else {
        	System.out.println("Enter valid route no!");
        	return("Enter valid route no!");
        }
    }
    //    bus route validation
    static String busRoute(){
        Scanner input = new Scanner(System.in);
        String route;
        String result = "";
        do {
            System.out.println("Enter your route :");
            route = input.next();
            result = RouteChecker(route);
        } while(result=="Enter valid route no!");
        return(result);
    }
    
    static String StopChecker(String routeName, String route){
    	String arr[] = routesNameStr(route);
        for (int i = 0; i < arr.length;i++){
            if (routeName.equalsIgnoreCase(arr[i])){
                return routeName;
            }
        }
    	System.out.println("Enter valid stop name!");
        return("Enter valid stop name!");
    }
    static String [] routesNameStr(String route){
        String [] route_1 = {"F-11 Markaz","Margala road","Golra More","PAF Complex Gate","Shaheen Chowk","Madina Market"};
        String [] route_2 = {"G-11/2 Apple School","G-11 Markaz","G-11/3 Alladin Market","G-10 Umer Market","G-9/1 Street no 44"};
        String [] route_3 = {"Askari XI","Qasim Market","Roomi Market","GPO Saddar","Kacheri Chowk"};
        String [] route_4 = {"Hajj Complex","Old Daewoo Stop","Pirdhadhai More","Charing Cross","Valley Road"};
        String [] route_5 = {"Chungi no 22","CMH","502 workshop","Jinnah Park","Jhandha Chechi"};
        String [] route_6 = {"Bahria Town Ace Academy","Street no 6 Bahria More","Al Noor Pharmacy","Rahat Bakery",
                "PWD Barrier","London Tradex"};
        String [] route_7 = {"Gangal East","karal Chowk","Gangal West","Fizaya Colony","Chatry Chowk","Khanna Pull"};
        String [] route_8 = {"Nawal Anchorage","Bhander","Sowan Garden","Al Shifa Hospital","Toyota Motors"};

        switch (route){
            case "1" -> {
                return route_1;
            }
            case "2" -> {
                return route_2;
            }
            case "3" -> {
                return route_3;
            }
            case "4" -> {
                return route_4;
            }
            case "5" -> {
                return route_5;
            }
            case "6" -> {
                return route_6;
            }
            case "7" -> {
                return route_7;
            }
            case "8" -> {
                return route_8;
            }
        }
        return new String[]{};
    }
    
    static String busStop(String route){
        Scanner input = new Scanner(System.in);
        String result = "";
        do {
            System.out.println("Enter the stop name :");
            String routeName = input.next();
            result = StopChecker(routeName, route);
        } while(result=="Enter valid stop name!");
        return result;
    }

    //        bus fee
    static String busFee(String route){
        String fees = "";
        switch (route) {
            case "1" -> fees = "20000";
            case "2" -> fees = "15000";
            case "3" -> fees = "14000";
            case "4" -> fees = "13000";
            case "5" -> fees = "10000";
            case "6" -> fees = "22000";
            case "7" -> fees = "24000";
            case "8" -> fees = "21000";
        }
        return fees;
    }

    static String DropOffChecker(String choice) {
    	if(choice.equalsIgnoreCase("1")) {
    		return("1:30 PM");
    	}
    	else if(choice.equalsIgnoreCase("2")) {
    		return("2:30 PM");
    	}
    	else if(choice.equalsIgnoreCase("3")) {
    		return("5:30 PM");
    	}
    	else {
    		return("Kindly enter valid input!");
    	}
    }
    
    //    bus timing selection

    static String busDropOff(){
        Scanner input = new Scanner(System.in);
    	String dropOffTime = "";
        do {
            System.out.println("Enter your preferred timing for drop-off\n1. 1:30 PM\n2. 2:30 PM\n3. 5:30 PM");
            String selectionDropOff = input.next();
            dropOffTime = DropOffChecker(selectionDropOff);
        } while(dropOffTime == "Kindly enter valid input!");
        return(dropOffTime);
    }
    
    static String PickUpChecker(String choice) {
    	if(choice.equalsIgnoreCase("1")) {
    		return("8 AM");
    	}
    	else if(choice.equalsIgnoreCase("2")) {
    		return("10 AM");
    	}
    	else if(choice.equalsIgnoreCase("3")) {
    		return("12 AM");
    	}
    	else {
    		return("Kindly enter valid input!");
    	}
    }
    
    static String busPickUp(){
        Scanner input = new Scanner(System.in);
        String pickUpTime = "";
        do {
//            selecting the pick-up timing
            System.out.println("Enter your preferred timing for pick-up\n1.  8 AM\n2. 10 AM\n3. 12 AM");
            String selectionPickUp = input.next();
            pickUpTime = PickUpChecker(selectionPickUp);
        } while(pickUpTime == "Kindly enter valid input!");
        return(pickUpTime);
    }

//bus registration main
    

    static String busRegistration(String registrationNo){
        String busID = busID();
        String dateAndTime = registrationTiming();
        String route = busRoute();
        String busStop = busStop(route);
        String busFee = busFee(route);
        String pickUp = busPickUp();
        String dropOff = busDropOff();

//        All details
        String details_x = String.format("""
                Registration No                  : %s
                Bus ID                           : %s
                Route                            : %s
                Stop Name                        : %s
                Fee                              : %s
                PickUp Timing                    : %s
                DropOff Timing                   : %s
                Registered at                    : %s
                 
                """,registrationNo,busID,route,busStop,busFee,pickUp,dropOff,dateAndTime);

        return details_x;

    }

    //  payment Method

    static String paymentMethod(boolean isRegistered) {
        if (isRegistered) {
            Desktop desk = Desktop.getDesktop();
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println("Select your payment method :\n1. JazzCash\n2. HBL\n3. Bank Alfalah");
                    int option = input.nextInt();
                    if (option >= 1 && option <= 3) {
                        switch (option) {

                            case 1 -> {
                                try {
                                    desk.browse(new URI("https://www.jazzcash.com.pk"));
                                    System.out.println("Thank you for using JazzCash for paying fee");
                                    return("Jazzcash Payment Successful!");

                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");
                                    return("Jazzcash Payment Failed!");
                                }
                            }
                            case 2 -> {
                                try {
                                    desk.browse(new URI("https://www.hblibank.com.pk"));
                                    System.out.println("Thank you for using HBL for paying fee");
                                    return("HBL Payment Successful!");
                                    
                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");
                                    return("HBL Payment Failed!");
                                }
                            }
                            case 3 -> {
                                try {
                                    desk.browse(new URI("https://netbanking.bankalfalah.com/"));
                                    System.out.println("Thank you for using Bank Alfalah for paying fee");
                                    return("Bank Alfalah Payment Successful!");

                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");
                                    return("Bank Alfalah Payment Failed!");
                                }
                            }
                        }

                        break;
                    } 
                    else {
                    	System.out.println("Enter appropriate option !");
                    	return("Invalid Input!");
                    }
            }
            return("Registration Found!");
        } 
        else {
        	System.out.println("you have to register first to proceed Payment!");
        	return("No Registration Found!");
        }

    }

//    if bus file found!
    static boolean busFileFound(String registrationNo){
        File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
        if (busFile.exists()) return true;
        else return false;
    }

}