package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import trello.common.Base;
import trello.functions.Boards;
import trello.functions.TrelloMembers;

public class Delete_Board_Test extends Base{
	
	@Test
	public void testDeleteWithID() {
		
		String boardid = TrelloMembers.getFirstBoardID();
		System.out.println("Deleting board with id: "+boardid);
		boolean result = Boards.deleteBoard(boardid);
		Assert.assertEquals(result, true);
	}

}
