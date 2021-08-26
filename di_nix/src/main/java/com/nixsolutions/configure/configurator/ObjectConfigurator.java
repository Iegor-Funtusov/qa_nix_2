package com.nixsolutions.configure.configurator;

import com.nixsolutions.ApplicationContext;

public interface ObjectConfigurator {

    void configure(Object o, ApplicationContext context);
}
