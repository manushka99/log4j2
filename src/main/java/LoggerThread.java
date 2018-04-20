import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LoggerThread {
    public static final Logger logger = LogManager.getLogger();

    public void loggerThread() {
        String fileName = Thread.currentThread().getName();
        ThreadContext.put("FILE_NAME", fileName);
    }
}

