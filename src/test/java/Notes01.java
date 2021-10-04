public class Notes01 {
  /*
  What do you remember from the last class:
	WebDriver driver = new ChromeDriver(); -> create ChromeDriver
*Navigations
	get(), navigate(), to(), back(), forward (), refresh()
*Common Driver methods
	getTitle(), getCurrentURL(), getPageSoure();
*Closing driver
	close(),quit()
*to maximize a windows
	driver.manage().window(),maximize()
*wait
	Thread.sleep(5000); --> comes from Java wait 4 second hard wait() 5 second for all conditions even if no need for wait
	NOTE: testers should now use this wait, cause it causes additional unnecessary wait
	Instead we will use IMPLICIT AND EXPLICIT WAIT we will learn later
MAVEN :
	Java project build tool. It makes project development and deployment easy
POM.XML
	It is a file we put external dependencies, plug ins, profiles, configurations...
	-POM is the fundamental unit of work in Maven. It is an XML file that contains information about the project and
	 configuration details used by Maven to build the project
   */
/*
***myjunitproject35_36  is the framework
***.idea --->>> Belong to intellij. It has project specific information. DO NOT TOUCH
***src --->>> source folder. It is used to create the classes and methods.
It is used to either create a development or testing framework
main --->>> usually used by developers for development
test --->>> usually used by testers for testing
***pom.xml --->>> this is the most important file in a maven project
-used to add dependencies, plugins, and similar configurations
***external libraries
this has imported libraries/jar files/plugins/dependencies
*
@Test : create a test case. This let us create and run test cases
@Before : Runs before each @Test annotation . Used for repeated precondition
@After : Runs after each @Test annotation. Used for repeated post condition
@Test, @Before, @BeforeClass, @After, @AfterClass, @Ignore
*
 */
}
