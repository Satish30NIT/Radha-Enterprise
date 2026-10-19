/*
 * Day 1 · Coding Q1 — Sum of Two Numbers
 *
 * Problem:
 *   Given two integers, return/print their sum.
 *
 * Output:
 *   Single integer — the sum only (no extra text).
 *
 * Constraints:
 *   -1e9 <= A, B <= 1e9  (use long for safe sum)
 *
 * Samples:
 *   2, 3              -> 5
 *   -1, 5             -> 4
 *   0, 0              -> 0
 *   10, 20            -> 30
 *   -5, -7            -> -12
 *   1000000000, 1000000000 -> 2000000000
 *
 * Edges: zeros, mixed signs, large values
 *
 * Note: Scanner/stdin deferred to a later topic.
 * Correct final answer only.
 */

class SumOfTwoNumbers {
    public long sum(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) {
        SumOfTwoNumbers obj = new SumOfTwoNumbers();

        System.out.println(obj.sum(2, 3));
        System.out.println(obj.sum(-1, 5));
        System.out.println(obj.sum(0, 0));
        System.out.println(obj.sum(10, 20));
        System.out.println(obj.sum(-5, -7));
        System.out.println(obj.sum(1000000000L, 1000000000L));
    }
}
