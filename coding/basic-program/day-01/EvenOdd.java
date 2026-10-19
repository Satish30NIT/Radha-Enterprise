// CORRECT ANSWER — Day 1 Q2: Odd or Even
// Scanner/stdin deferred. Tests via method calls.
// Output: exactly "Even" or "Odd"

class EvenOdd {
    public String evenOdd(int n) {
        if (n % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    public static void main(String[] args) {
        EvenOdd obj = new EvenOdd();

        System.out.println(obj.evenOdd(4));   // Even
        System.out.println(obj.evenOdd(7));   // Odd
        System.out.println(obj.evenOdd(0));   // Even
        System.out.println(obj.evenOdd(2));   // Even
        System.out.println(obj.evenOdd(9));   // Odd
        System.out.println(obj.evenOdd(-4));  // Even
        System.out.println(obj.evenOdd(-1));  // Odd
    }
}
