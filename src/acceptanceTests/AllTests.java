package acceptanceTests;
/** AllTests! **/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	initSystemTests.class, 
	RegLoginLogoutTest.class,
	SubForumTest.class, 
	writeMessageTest.class 
})
public class AllTests {

}
