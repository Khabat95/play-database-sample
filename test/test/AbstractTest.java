package test;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.After;
import org.junit.Before;

import play.test.FakeApplication;
import play.test.Helpers;

public abstract class AbstractTest {

	FakeApplication app;

	@Before
	public void setUp() {
		this.app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(this.app);
		initMocks(this);
	}

	@After
	public void tearDown() {
		Helpers.stop(this.app);
	}

}
