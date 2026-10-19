// FIRST ATTEMPT — Day 1 Q1
// Issues: double type; prints "sum = " prefix (assessment wants sum only)

class Main {
    public double sum(double a, double b) {
        double sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("sum = " + obj.sum(2, 3));
        System.out.println("sum = " + obj.sum(-1, 4));
        System.out.println("sum = " + obj.sum(0, 0));
    }
}
