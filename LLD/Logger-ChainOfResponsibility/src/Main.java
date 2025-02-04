import service.LogProcessor;
import service.impl.DebugLogProcessor;
import service.impl.ErrorLogProcessor;
import service.impl.InfoLogProcessor;

public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.log(3, "this is error message");
        logger.log(2, "this is debug message");
        logger.log(1, "this is info message");
    }
}