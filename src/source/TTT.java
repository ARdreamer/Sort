package source;

public class  TTT {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        System.out.printf("%.5f", sqrt(2));
//        RRR rrr = new RRR();
//        Field name = rrr.getClass().getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(rrr,"asasas");
//        Field qwe = rrr.getClass().getDeclaredField("qwe");
//        qwe.set(rrr,123);
//        System.out.println(rrr.qwe);
//        String a = "abc";
//        String b = "abc";
//        System.out.println(a == b);
        System.out.println(bsqrt(12));
        System.out.println(sqrt(12));
    }

    public static double sqrt(double m) {
        if (m < 0) {
            return Double.NaN;
        }
        double e = 1e-5;
        double x = m;
        double y = (x + m / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + m / x) / 2;
        }
        return x;
    }

    public static double bsqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double e = 1e-5;
        double low = 0;
        double high = c;
        double m = low + (high - low) / 2;
        while (high - low > e) {
            if (m * m > c)
                high = m;
            else if (m * m < c)
                low = m;
            else if (Math.abs(m * m - c) < e) {
                return m;
            }
            m = low + (high - low) / 2;
        }
        return m;
    }
}
