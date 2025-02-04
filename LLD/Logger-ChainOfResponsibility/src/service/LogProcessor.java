package service;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    public LogProcessor nextLoggerProcessor;

    public LogProcessor(LogProcessor nextLoggerProcessor){
        this.nextLoggerProcessor = nextLoggerProcessor;
    }

    public void log(int logLevel, String message){
        if(this.nextLoggerProcessor != null){
            this.nextLoggerProcessor.log(logLevel, message);
        }
    }

}
