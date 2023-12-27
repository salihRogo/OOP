package Week7.Lab.LoggingSystem;

interface LogMessageProvider {
    String provideMessage();
}

interface Logger {
    void logMessage(LogMessageProvider messageProvider);
}

record RecordLogger(String loggerName) implements Logger {
    @Override
    public void logMessage(LogMessageProvider messageProvider) {
        System.out.println("Record Logger [" + this.loggerName + "]: " + messageProvider.provideMessage());
    }
}

class ClassLogger implements Logger {

    private String loggerName;

    public ClassLogger(String loggerName) {
        this.loggerName = loggerName;
    }

    @Override
    public void logMessage(LogMessageProvider messageProvider) {
        System.out.println("Class Logger [" + this.loggerName + "]: " + messageProvider.provideMessage());
    }
}

class Start {
    public static void main(String[] args) {

        Logger recordLogger = new RecordLogger("RecordLogger");
        recordLogger.logMessage(() -> "Logging with lambda function in a record");

        Logger classLogger = new ClassLogger("ClassLogger");
        classLogger.logMessage(() -> "Logging with lambda function in a class");

    }
}