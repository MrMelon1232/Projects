import java.util.Scanner;
//------------------------------------------------
//Assignment 1
//Question: Part 1
//Written by: Julien Phan id:40133814
//------------------------------------------------

//Description comment

public class Assignment1_main {

	static long serialnum = 999;

	public static void main(String[] args)

	{

		// Welcome Message
		System.out.println("Welcome to Julien Phan's program for Assignment 1!");

		// Max Number of Appliances
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many appliances can your store contain or wish to aquire?");
		int maxNumAppliances = keyboard.nextInt();

		// Tracking Appliance Objects
		Appliance[] inventory = new Appliance[maxNumAppliances];

		// Variables
		int choice;
		int failedattempt = 0;
		int sum = 0;
		final String password = "c249";
		int verifyC1 = 0;
		int verifyC2 = 0;
		long serialNum2;
		long serialNum1;
		int answer1 = 0;
		String answer;
		int remaining = maxNumAppliances;
		String menu;

		// Main Menu
		do {
			do {
				System.out.print("|");
				for (int j = 0; j < 65; j++)
					System.out.print("-");
				System.out.print("|");
				System.out.println("\n| What do you want to do?\t\t\t\t\t  |");
				System.out.println("|    1.  Enter new appliances (password required)\t\t  |");
				System.out.println("|    2.  Change information of an appliance (password required)\t  |");
				System.out.println("|    3.  Display all appliances by a specific brand\t\t  |");
				System.out.println("|    4.  Display all appliances under a certain a price.\t  |");
				System.out.println("|    5.  Quit\t\t\t\t\t\t\t  |");
				System.out.print("| Please enter your choice >\t\t\t\t\t  |");
				System.out.print("\n|");
				for (int j = 0; j < 65; j++)
					System.out.print("-");
				System.out.println("|");

				// Prompt User choice
				choice = keyboard.nextInt();

			} while (!(choice >= 1 && choice <= 5));

			// Option1
			if (choice == 1) {
				failedattempt = 0;
				verifyC1 = 0;
				String password1;
				do {
					System.out.print("Please enter your password: ");
					password1 = keyboard.next();
					if (password1.equals(password)) {
						verifyC1 += 1;
					}

					failedattempt += 1;
					sum += 1;

				} while (!password1.equals(password) && failedattempt != 3);

				// Inventory check
				if (verifyC1 == 1) {
					int applianceRequest;
					String type;
					String brand;
					double price;
					int r = Appliance.findNumberOfCreatedAppliances();

					do {
						failedattempt = 0;
						System.out.print("How many appliances would you like to enter? ");
						applianceRequest = keyboard.nextInt();

						if (applianceRequest <= remaining && applianceRequest != 0) {
							if ((r <= applianceRequest && remaining == 1) || applianceRequest == 1) {
								System.out.println("Please enter appliance info:");
								do {
									System.out.print("Please set the type: ");
									type = keyboard.next();
								} while (!Appliance.isValidType(type));
								System.out.print("Please set the brand: ");
								brand = keyboard.next();
								System.out.print("Please set the price: ");
								price = keyboard.nextDouble();
								++serialnum;
								long serialnumStore = serialnum;
								Appliance A1 = new Appliance(type, brand, serialnumStore, price);
								inventory[r] = A1;
								remaining = maxNumAppliances - Appliance.findNumberOfCreatedAppliances();
								r = Appliance.findNumberOfCreatedAppliances();
							}
							if ((r < applianceRequest && remaining != 1)
									|| (applianceRequest == remaining && remaining != 1)) {
								for (int i = 0; i < applianceRequest; i++) {
									System.out.println("Please enter appliance info:");
									do {
										System.out.print("Please set the type: ");
										type = keyboard.next();
									} while (!Appliance.isValidType(type));
									System.out.print("Please set the brand: ");
									brand = keyboard.next();
									System.out.print("Please set the price: ");
									price = keyboard.nextDouble();
									++serialnum;
									long serialnumStore = serialnum;
									Appliance A1 = new Appliance(type, brand, serialnumStore, price);
									inventory[r] = A1;
									remaining = maxNumAppliances - Appliance.findNumberOfCreatedAppliances();
									r = Appliance.findNumberOfCreatedAppliances();
								}
							}

						}

						else if (applianceRequest > remaining) {
							System.out.println("There isn't enough space in the inventory to add " + applianceRequest
									+ ". There is a maximum of " + remaining + " remaining places in the inventory.");
							answer1 = 1;
							break;
						} else if (applianceRequest == 0) {
							answer1 = 1;
							break;
						}
					} while (remaining >= 0);

				}
			}

			// Option2
			if (choice == 2) {
				failedattempt = 0;
				verifyC2 = 0;
				String password1;
				do {
					System.out.print("Please enter your password: ");
					password1 = keyboard.next();
					if (password1.equals(password)) {
						verifyC2 += 1;
					}
					failedattempt += 1;
				} while (!password1.equals(password) && failedattempt != 3);

				// Serial Number update
				if (verifyC2 == 1) {
					boolean validserialNum = false;

					do {
						System.out.println("Which appliance's serial number do you wish to update?");
						serialNum1 = keyboard.nextLong();
						answer1 = 0;
						serialNum2 = 0;
						int index = 0;
						boolean found = false;
						for (int i = 0; i < inventory.length; i++) {
							serialNum2 = inventory[i].getSerialnum();
							if (String.valueOf(serialNum2).equals(String.valueOf(serialNum1))) {
								found = true;
								index = i;
								break;
							}
						}
						if (found) {
							System.out.println(inventory[index].toString());

							validserialNum = true;
							answer1 = 1;
							break;
						}

						if (!found) {
							System.out.println(
									"There exists no appliance with that serial number. Do you wish to enter a new serial number or quit this operation?");
							answer = keyboard.next();

							if (answer.equals("quit")) {
								answer1 = 1;
								break;
							}
						}

					} while (answer1 != 1);

					if (validserialNum == true) {
						int choice1;
						do {
							choice1 = 0;
							answer1 = 0;
							System.out.print("|");
							for (int j = 0; j < 40; j++)
								System.out.print("-");
							System.out.print("|");
							System.out.println("\n| What information would you like to\t |\n| change?\t\t\t\t |");
							System.out.println("|    1.  brand\t\t\t\t |");
							System.out.println("|    2.  type\t\t\t\t |");
							System.out.println("|    3.  price\t\t\t\t |");
							System.out.println("|    4.  Quit\t\t\t\t |");
							System.out.print("| Enter your choice >\t\t\t |");
							System.out.print("\n|");
							for (int j = 0; j < 40; j++)
								System.out.print("-");
							System.out.println("|");
							choice1 = keyboard.nextInt();

							if (choice1 == 1) {
								boolean found = false;
								System.out.println("What is the name of the new brand?");
								String brand1 = keyboard.next();
								int index = 0;
								for (int i = 0; i < maxNumAppliances; i++) {
									serialNum2 = inventory[i].getSerialnum();

									if (String.valueOf(serialNum2).equals(String.valueOf(serialNum1))) {
										found = true;
										index = i;
										break;
									}
								}
								if (found) {
									inventory[index].setBrand(brand1);
									System.out.println(inventory[index].toString());
								}

							}

							if (choice1 == 2) {
								String type1;
								boolean found = false;
								int index = 0;
								do {
									System.out.println("What is the new type?");
									type1 = keyboard.next();
								} while (!Appliance.isValidType(type1));
								for (int i = 0; i < maxNumAppliances; i++) {
									serialNum2 = inventory[i].getSerialnum();

									if (String.valueOf(serialNum2).equals(String.valueOf(serialNum1))) {
										found = true;
										index = i;
										break;
									}
								}
								if (found) {
									inventory[index].setType(type1);
									System.out.println(inventory[index].toString());
								}

							}
							if (choice1 == 3) {
								boolean found = false;
								System.out.println("What is the new price value?");
								double price1 = keyboard.nextDouble();
								int index = 0;
								for (int i = 0; i < maxNumAppliances; i++) {
									serialNum2 = inventory[i].getSerialnum();

									if (String.valueOf(serialNum2).equals(String.valueOf(serialNum1))) {
										found = true;
										index = i;
										break;
									}
								}
								if (found) {
									inventory[index].setPrice(price1);
									System.out.println(inventory[index].toString());
								}

							}
							if (choice1 == 4)
								answer1 = 1;

						} while ((choice1 > 4 && choice1 < 1) || choice1 != 4);
					}

				}
			}

			// Option3
			if (choice == 3) {
				String brandsearch;
				do {
					System.out.println("Please enter a brand name: ");
					brandsearch = keyboard.next();
					System.out.println(Appliance.findAppliancesBy(brandsearch, inventory));
					menu = keyboard.next();
				} while (!menu.equals("quit"));
				answer1 = 1;
			}

			// Option4
			if (choice == 4) {
				double pricesearch;
				do {
					System.out.println("Please enter a price: ");
					pricesearch = keyboard.nextDouble();
					System.out.println(Appliance.findCheaperThan(pricesearch, inventory));
					menu = keyboard.next();
				} while (!menu.equals("quit"));
				answer1 = 1;
			}

			// Option5
			if (choice == 5) {
				System.out.print("The program has ended. Have a good day!");
				answer1 = 0;
			}

		} while ((failedattempt == 3 && sum < 12) || answer1 == 1);

		keyboard.close();
		// More than 12 tries
		if (sum == 12)
			System.out.println("Program detected suspicious activities and will terminate immediately!");

	}

}
