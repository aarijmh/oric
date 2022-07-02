package pk.edu.iqra.oric.factory;

import org.springframework.stereotype.Component;
import pk.edu.iqra.oric.service.GenericResourceService;

@Component
public interface ServiceFactory {

    GenericResourceService getService(String serviceType);
}
