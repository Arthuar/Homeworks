package org.example;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class App {
    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer mb = ManagementFactory.getPlatformMBeanServer();
        StandardMBean mbean = new StandardMBean(new MyBeanImplementation(), MyBean.class);

        ObjectName mbName = new ObjectName("org.example:type=MyBean");
        mb.registerMBean(mbean, mbName);
        System.in.read();
        ConsoleTaker ck = new ConsoleTaker();
        ck.transform();

    }
}
