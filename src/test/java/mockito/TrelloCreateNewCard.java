package mockito;

import org.mockito.Mockito;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import trello.functions.Boards;
import trello.functions.Cards;

public class TrelloCreateNewCard {
	
	Boards board;
	
	@BeforeTest
	public void setUpMocks() {
		//1. You need a BOARD id - Team B
		//2. You need a LIST id - Team C
		board = Mockito.mock(Boards.class);
		Mockito.when(board.getListIDByListName("To Do", "3r2873r92781387235137t5")).thenReturn("26734129763rt91tr17rt734t");
	}
	
	@Test
	public void testCreationOfNewCard() {
		
		//3. Only then we can create a Card - Team A
		String listid = board.getListIDByListName("To Do", "3r2873r92781387235137t5");
		Cards.addNewCardToList(listid, "Learning Mockito");
		
	}

}
