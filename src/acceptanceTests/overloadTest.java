package acceptanceTests;

import org.junit.Before;
import org.junit.Test;

import user.User;
import forumSystemCore.Forum;
import forumSystemCore.ForumSystem;
import junit.framework.TestCase;

public class overloadTest extends TestCase {
	private static ForumSystem sys = new ForumSystem();
	private static User admin;
	private static User u1;
	private static String fId, fId2;
	private static String sfId;
	private static String sfId2;
	private static Forum forum;
	
	private static int X = 20;
	
	public overloadTest(){
		super();
	}
	
	@Before
	public void init(){
		admin = sys.startSystem("katrina@walla.com", "Katrina Tros", "Katkat", "ass1234");
		fId = sys.createForum("testers4life", admin);
		fId2 = sys.createForum("testresRloozers", admin);
		u1 = sys.signup("halevav@post.aliza.com","halevav","katriel","halev av", fId);
		sfId = sys.createSubForum(admin, u1, "loozers", fId);
		sfId2 = sys.createSubForum(admin, admin, "eggs", fId);
		
	}
	
	@Test
	public void testMessages(){
		User u, u2;
		for(int i=0;i<=X;i++){
			assertNotNull(u = sys.signup("Kak"+i+"@post.aliza.com","Kat","katriel"+i+"","12345", fId));
			assertNotNull(u2 = sys.signup("Kak"+i+"@post.aliza.com","Kat","katriel"+i+"","12345", fId2));
			assertNotNull(sys.createMessage(fId, sfId, u, "hi"+i+"", "wasup?"));
			assertNotNull(sys.createMessage(fId, sfId2, u2, "hi"+i+"", "wasup?"));
		}
	}


}
