package forumSystemCore;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import user.testUser;
import utility.testComplaint;
import utility.testRank;
import utility.testTextVerifier;


@RunWith(Suite.class)
@SuiteClasses({ 
	testComplaint.class, 
	testForum.class, 
	testRank.class,
	testTextVerifier.class, 
	testUser.class 
})
public class AllTests {

}
