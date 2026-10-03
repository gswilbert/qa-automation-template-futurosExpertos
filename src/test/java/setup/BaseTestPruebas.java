package setup;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestPruebas {
	
	@BeforeAll
	public static void beforeAll() throws Exception {
		System.out.println("BEFORE ALL");
	}
	
	@BeforeEach
	public void beforeTest() throws Exception {
		System.out.println("BEFORE TEST");
	}

	@AfterEach
	public void afterTest() throws Exception {
		System.out.println("AFTER TEST");
	}

	@AfterAll
	public static void endTestSuite() {
		System.out.println("AFTER ALL");
	}
	

}
