import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;
import services.DefaultCreateAccountService;
import services.DefaultLoginService;
import services.DefaultTableService;
import services.DefaultTablesService;
import services.ICreateAccountService;
import services.ILoginService;
import services.ITableService;
import services.ITablesService;

public class Global extends GlobalSettings {

	private Injector injector;

	@Override
	public void onStart(Application application) {
		injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				bind(ILoginService.class).to(DefaultLoginService.class);
				bind(ICreateAccountService.class).to(
						DefaultCreateAccountService.class);
				bind(ITablesService.class).to(DefaultTablesService.class);
				bind(ITableService.class).to(DefaultTableService.class);
			}
		});
	}

	@Override
	public <T> T getControllerInstance(Class<T> aClass) throws Exception {
		return injector.getInstance(aClass);
	}
}