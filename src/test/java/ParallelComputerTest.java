
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelComputerTest {


    @Test
    public void test() {
        Class[] cls={ParallelTest1.class, ParallelTest2.class };

        //Parallel among classes
//        JUnitCore.runClasses(ParallelComputer.classes(), cls);

//        Parallel among methods in a class
        JUnitCore.runClasses(ParallelComputer.methods(), cls);
//
        //Parallel all methods in all classes
//        JUnitCore.runClasses(new ParallelComputer(true, true), cls);
    }

    public static class ParallelTest1 extends LoggerThread {
        @Test
        public void a() throws InterruptedException {
            try {
                Thread.sleep(1000);
                throw new Exception("ТЕСТ1.1");
            }
            catch (Exception e) {
                loggerThread();
                logger.info("ff", e);
            }
        }

        @Test
        public void b() throws InterruptedException {
            try {
                Thread.sleep(10000);
                throw new Exception("ТЕСТ1.2");
            }

            catch (Exception e) {
                loggerThread();
                logger.info("b2", e);
            }
        }
    }

    public static class ParallelTest2 extends LoggerThread {

        @Test
        public void a() throws InterruptedException {
            try {
                Thread.sleep(1000);
                throw new Exception("ТЕСТ2.1");
            }
            catch (Exception e) {
                loggerThread();
                logger.info("A1", e);
            }
        }

        @Test
        public void b() throws InterruptedException {
            try {
                Thread.sleep(1000);
                throw new Exception("ТЕСТ2.2");
            }
            catch (Exception e) {
                loggerThread();
                logger.info("B1", e);
            }
        }
    }
}