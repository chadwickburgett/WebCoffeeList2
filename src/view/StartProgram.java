package view;

import java.util.List;
import java.util.Scanner;

import controller.ListBeanHelper;
import model.beansList;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListBeanHelper lch = new ListBeanHelper();

	private static void addBean() {
		// TODO Auto-generated method stub
		System.out.print("Enter a coffee origin: ");
		String origin = in.nextLine();
		System.out.print("Enter a roast level: ");
		String roast = in.nextLine();
		beansList toAdd = new beansList(origin, roast);
		lch.insertBean(toAdd);

	}

	private static void deleteBean() {
		// TODO Auto-generated method stub
		System.out.print("Enter the origin to delete: ");
		String origin = in.nextLine();
		System.out.print("Enter the roast to delete: ");
		String roast = in.nextLine();
		beansList toDelete = new beansList (origin, roast);
		lch.deleteBean(toDelete);

	}

	private static void editBean() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Origin");
		System.out.println("2 : Search by Roast");
		int searchBy = in.nextInt();
		in.nextLine();
		List<beansList> foundBeans;
		if (searchBy == 1) {
			System.out.print("Enter the origin name: ");
			String originName = in.nextLine();
			foundBeans = lch.searchForBeansByOrigin(originName);
			
		} else {
			System.out.print("Enter the roast: ");
			String roastName = in.nextLine();
			foundBeans = lch.searchForBeansByRoast(roastName);
			

		}

		if (!foundBeans.isEmpty()) {
			System.out.println("Found Results.");
			for (beansList l : foundBeans) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			beansList toEdit = lch.searchForBeanById(idToEdit);
			System.out.println("Retrieved " + toEdit.getRoast() + " from " + toEdit.getOrigin());
			System.out.println("1 : Update Origin");
			System.out.println("2 : Update Roast");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Origin: ");
				String newOrigin = in.nextLine();
				toEdit.setOrigin(newOrigin);
			} else if (update == 2) {
				System.out.print("New Roast: ");
				String newRoast = in.nextLine();
				toEdit.setRoast(newRoast);
			}

			lch.updateBean(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome coffee beans list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a bean");
			System.out.println("*  2 -- Edit a bean");
			System.out.println("*  3 -- Delete a bean");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addBean();
			} else if (selection == 2) {
				editBean();
			} else if (selection == 3) {
				deleteBean();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<beansList> allBeans = lch.showAllBeans();
		for(beansList singleBean : allBeans){
			System.out.println(singleBean.returnBeansDetails());
		}

	}

}
 

