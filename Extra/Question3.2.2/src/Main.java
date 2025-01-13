public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.writeLog("This is a log message...");
    }
}

class Logger {
    private static final Logger log = new Logger();
    private Logger() {}
    public static Logger getInstance() {
        return log;
    }

    public void writeLog(String message) {
        System.out.println("Log: " + message);
    }
}