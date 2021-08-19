package trello.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import trello.common.Base;
import trello.common.ExcelReader;
import trello.functions.Boards;
import trello.functions.Cards;
import trello.functions.TrelloMembers;

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
	
	@Test (dataProvider = "getTestDataFromExcel")
	public void testCreateCardInExistingBoardDataDriven(String Boardname, String ListName, String CardTitle) {
		
		//1. Get Board ID of an existing Board by name
		String boardid = TrelloMembers.getBoardIDByName(Boardname);
		System.out.println(boardid);
		//String newboardid = "611e01bb2af15f3db0ad656d";
		
		//3. For this new Board, Get the List by name "To Do"
		String todolistid = Boards.getListIDByListName(ListName, boardid);
		System.out.println(todolistid);
		
		//4. Add a new Card to the above list
		int status = Cards.addNewCardToList(todolistid, CardTitle);
		System.out.println(status);
		Assert.assertEquals(status, 200); 

	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() throws IOException {
		return ExcelReader.readExcelData("src/test/java/trello/resources/testdata.xlsx");
	}

}
