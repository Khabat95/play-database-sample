package test;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.avaje.ebean.Ebean;

import play.libs.Yaml;
import play.test.FakeApplication;
import play.test.Helpers;

public abstract class AbstractTest {

	private FakeApplication app;

	@Before
	public void setUp() {
		this.app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(this.app);
		Ebean.save((List<?>) Yaml.load("test-data.yml"));
		initMocks(this);
	}

	@After
	public void tearDown() {
		Helpers.stop(this.app);
	}

}
