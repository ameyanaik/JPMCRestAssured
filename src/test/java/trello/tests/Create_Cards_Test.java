package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import trello.common.Base;
import trello.functions.Boards;
import trello.functions.Cards;

public class Create_Cards_Test extends Base{
	
	@Test
	public void testCreateCardInANewBoard() {
		
		//1. Create a New Board
		//2. Get the ID of the New Board
		String newboardid = Boards.createBoardAndReturnID("RABoard_2");
		System.out.println(newboardid);
		//String newboardid = "611e01bb2af15f3db0ad656d";
		
		//3. For this new Board, Get the List by name "To Do"
		String todolistid = Boards.getListIDByListName("To Do", newboardid);
		System.out.println(todolistid);
		
		//4. Add a new Card to the above list
		int status = Cards.addNewCardToList(todolistid, "Learning RestAssured");
		System.out.println(status);
		Assert.assertEquals(status, 200); 
		
	}

}
