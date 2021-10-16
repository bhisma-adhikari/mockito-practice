package mypkg;

public class Calculator {
    private Adder adder;
    private Logger logger;

    public Calculator(Adder adder, Logger logger) {
        this.adder = adder;
        this.logger = logger;
    }

    public int add(int x, int y) {
        return adder.add(x, y);
    }

    public void log(String logStr) {
        logger.log(logStr);
    }
}
