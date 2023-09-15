package org.example;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyBeanImplementation implements MyBean {
    private static final Logger lg = Logger.getLogger(MyBeanImplementation.class);

    @Override
    public void logLevelDebug() {
        LogManager.getRootLogger().setLevel(Level.DEBUG);
        lg.info("Change level log to Debug");
    }

    @Override
    public void logLevelInfo() {
        LogManager.getRootLogger().setLevel(Level.INFO);
        lg.info("Change level log to Info");
    }
}
