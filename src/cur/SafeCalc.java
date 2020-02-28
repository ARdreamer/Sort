package cur;

class SafeCalc {
    long value = 0L;

    long get() {
        synchronized (new Object()) {
            return value;
        }
    }

    void addOne() {
        synchronized (new Object()) {
            value += 1;
        }
    }

    public static void main(String[] args) {
        SafeCalc safeCalc = new SafeCalc();
        safeCalc.addOne();
        safeCalc.get();
    }
}
