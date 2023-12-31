package Week13.Lab.Task1Singleton;

class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String message){
        System.out.println(message);
    }

    public void logInfo(String message) {
        System.out.println(message);
    }

    public void logWarning(String message) {
        System.out.println(message);
    }

    public void logError(String message) {
        System.out.println(message);
    }

}

class Start {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("This is a general message.");
        logger.logInfo("This is an informational message.");
        logger.logWarning("This is a warning message.");
        logger.logError("This is an error message.");
    }
}
