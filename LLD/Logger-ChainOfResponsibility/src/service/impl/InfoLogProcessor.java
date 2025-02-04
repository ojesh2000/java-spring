package service.impl;

import service.LogProcessor;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel == LogProcessor.INFO){
            System.out.println("INFO: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
