// FIRST ATTEMPT — Day 1 Q2
// Logic OK; negatives not shown in main

class Main {
    public String evenOdd(int n) {
        if (n % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.evenOdd(4));
        System.out.println(obj.evenOdd(7));
        System.out.println(obj.evenOdd(0));
    }
}
