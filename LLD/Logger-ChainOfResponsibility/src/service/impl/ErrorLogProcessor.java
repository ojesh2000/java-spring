package service.impl;

import service.LogProcessor;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    @Override
    public void log(int logLevel, String message){
        if(logLevel == LogProcessor.ERROR){
            System.out.println("ERROR: " + message);
        }else{
            super.log(logLevel, message);
        }
    }
}
