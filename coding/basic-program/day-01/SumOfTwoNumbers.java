// CORRECT ANSWER — Day 1 Q1: Sum of Two Numbers
// Scanner/stdin deferred. Tests via method calls.
// Output: sum only (no extra text). Type: long (safe for large ints).

class SumOfTwoNumbers {
    public long sum(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) {
        SumOfTwoNumbers obj = new SumOfTwoNumbers();

        // Sample / test cases — print sum only
        System.out.println(obj.sum(2, 3));                 // 5
        System.out.println(obj.sum(-1, 5));                // 4
        System.out.println(obj.sum(0, 0));                 // 0
        System.out.println(obj.sum(10, 20));               // 30
        System.out.println(obj.sum(-5, -7));               // -12
        System.out.println(obj.sum(1000000000L, 1000000000L)); // 2000000000
    }
}
