package ua.com.alevel;

public class NullProblem {

    private int i1;
    private Integer i2;

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    @Override
    public String toString() {
        return "NullProblem{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                '}';
    }
}
