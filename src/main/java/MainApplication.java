import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class MainApplication extends Application {

    public MainApplication() {
        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("DBConnection API");
        beanConfig.setBasePath("/DBConnectionAPI/api");
        beanConfig.setResourcePackage("dbconnection");
        beanConfig.setScan(true);
    }
}
