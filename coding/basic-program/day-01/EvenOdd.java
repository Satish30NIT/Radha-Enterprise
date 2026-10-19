/*
 * Day 1 · Coding Q2 — Odd or Even
 *
 * Problem:
 *   Given one integer N, print "Even" if N is divisible by 2, otherwise "Odd".
 *
 * Output:
 *   Exactly: Even  OR  Odd
 *
 * Constraints:
 *   -1e9 <= N <= 1e9
 *
 * Samples / tests:
 *   4  -> Even
 *   7  -> Odd
 *   0  -> Even
 *   2  -> Even
 *   9  -> Odd
 *  -4  -> Even
 *  -1  -> Odd
 *
 * Edges: 0, negatives
 *
 * Note: Scanner/stdin deferred to a later topic.
 * Correct final answer only.
 */

class EvenOdd {
    public String evenOdd(int n) {
        if (n % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    public static void main(String[] args) {
        EvenOdd obj = new EvenOdd();

        System.out.println(obj.evenOdd(4));
        System.out.println(obj.evenOdd(7));
        System.out.println(obj.evenOdd(0));
        System.out.println(obj.evenOdd(2));
        System.out.println(obj.evenOdd(9));
        System.out.println(obj.evenOdd(-4));
        System.out.println(obj.evenOdd(-1));
    }
}
