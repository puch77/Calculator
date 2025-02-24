package rechner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class RechnerTest {

	static Rechner rechner;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		rechner = new Rechner(0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		rechner.clear();
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		rechner.setA(0);
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		rechner.clear();
		System.out.println("tearDown");
	}

	@Test
	@Order(1)
	@DisplayName("Addiere 10")
	void testAdd() {
		rechner.add(10);
		assertEquals(10, rechner.getA(), "Addition falsch");
	}

	@Test
	@Order(2)
	@DisplayName("Subtrahiere 2")
	void testSub() {
		rechner.subtract(2);
		assertEquals(-2, rechner.getA(), "Subtraktion falsch");
	}

	@Test
	@Order(3)
	@DisplayName("Division durch 0")
	void testDivideByZero() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> rechner.divide(0));
		assertEquals("Division durch 0", exception.getMessage());
	}

	@Test
	@Order(4)
	@DisplayName("Rechnerspeicher gelöscht und dann addieren")
	void testClearAndAdd() {
		rechner.clear();
		assertThrows(IllegalStateException.class, () -> rechner.add(0));
	}
}
