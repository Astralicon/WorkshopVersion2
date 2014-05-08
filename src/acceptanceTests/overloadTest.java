package acceptanceTests;

import org.junit.Before;
import org.junit.Test;

import user.User;
import forumSystemCore.ForumSystem;
import junit.framework.TestCase;

public class overloadTest extends TestCase {
	private static ForumSystem sys = new ForumSystem();
	private static User admin;
	
	public overloadTest(){
		super();
	}
	
	@Before
	public void init(){
		admin = sys.startSystem("halevm@post.aliza.com","halevm","katriel","halev em");
		String forumID = sys.createForum("fools",admin);
		
	}
	
	@Test
	public void testOverload(){
		//TODO
	}

}
