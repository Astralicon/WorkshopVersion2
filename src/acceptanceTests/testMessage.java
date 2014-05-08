package unitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import forumsys.Forum;
import forumsys.ForumSystem;
import forumsys.Message;
import forumsys.Rank;
import forumsys.User;

public class testMessage {
	public static ForumSystem sys;
	public static User admin;
	public static User u;
	public static Forum forum;
	public static Message m;
	
	@Before 
	public static void initialize() {
		sys = new ForumSystem();
		admin = sys.startSystem("yy2006@gmail.com", "Yakir yehuda",
										"fashizel", "123");
		m = new Message(admin, "dd", "ff");
		forum = new Forum("lolz",admin);
		u = forum.signup("motek@walla.co.il", "Matan Carmis", "mamush", "12345");
		
	}

	@Test
	public void testRemoveReply() {
		Message r = m.addReply(admin, "dd", "ff");
		assertTrue(m.removeReply(admin, r));

	}
	
	@Test
	public void testIsWriter() {
		assertTrue(m.isWriter(admin));

	}

	@Test
	//add gotNotified method in user , that gets the msg id to notify
	public void testNotifications(){
		assretTrue(u.gotNotified(m.getId()));
		assertFalse(admin.gotNotified(m.getId()));
	}
	
	@Test
	//need to add user in edit message method signature
	public void testEditMsg(){
		assertTrue(m.editMessage(admin, "dd", "gg!!!"));
		assertFalse(m.editMessage(u, "dd", "gg!!!"));
		assertFalse(m.editMessage(admin, "", ""));
		assertFalse(m.editMessage(admin, null, null));
	}
}
