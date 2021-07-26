package ua.com.alevel;

public class PrimitiveType {

    public void run() {
        byte bMax = Byte.MAX_VALUE;
        byte bMin = Byte.MIN_VALUE;

        System.out.println("bMax = " + bMax);
        System.out.println("bMin = " + bMin);

        System.out.println((byte) (bMax + (byte) 1));

        short sMax = Short.MAX_VALUE;
        short sMin = Short.MIN_VALUE;

        System.out.println("sMax = " + sMax);
        System.out.println("sMin = " + sMin);

        int iMax = Integer.MAX_VALUE;
        int iMin = Integer.MIN_VALUE;

        System.out.println("iMin = " + iMin);
        System.out.println("iMax = " + iMax);

        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;

        System.out.println("lMin = " + lMin);
        System.out.println("lMax = " + lMax);

        float fMin = Float.MIN_VALUE;
        float fMax = Float.MAX_VALUE;

        System.out.println("fMin = " + fMin);
        System.out.println("fMax = " + fMax);

        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;

        System.out.println("dMin = " + dMin);
        System.out.println("dMax = " + dMax);

        System.out.println(2.0 - 0.1);

        char c = 'W';
        System.out.println("c = " + c);
        System.out.println("c = " + (int) c);

        boolean b = false;

        System.out.println("b = " + b);
    }
}
