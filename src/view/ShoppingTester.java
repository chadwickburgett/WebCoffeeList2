package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.ListDetails;
import model.Shopper;
import model.beansList;

public class ShoppingTester {
	public static void main(String[] args) {
		Shopper susan = new Shopper("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		beansList Ethiopia = new beansList("Ethiopia", "Light");
		beansList Columbia = new beansList("Columbia", "Dark");
		List<beansList> susansBeans = new ArrayList<beansList>();
		susansBeans.add(Ethiopia);
		susansBeans.add(Columbia);
		ListDetails susansList = new ListDetails("Susan's beansList", LocalDate.now(), susan);
		susansList.setListOfBeans(susansBeans);
		ldh.insertNewListDetails(susansList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}
}