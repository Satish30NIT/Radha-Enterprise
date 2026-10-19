# Day 1 — Coding Questions + Correct Answers

**Path:** `coding/basic-program/day-01/`  
**Deferred:** `Scanner` (later topic). Correct solutions use methods + exact output.

---

## Q1 — Sum of Two Numbers

### Problem
Read two integers and print their sum.

**Input (later with Scanner):** `A B`  
**Output:** single integer — sum only (no extra text)  
**Constraints:** `-1e9 ≤ A, B ≤ 1e9` (prefer `long` for safe sum discussion)

**Samples**
| Input | Output |
|---|---|
| `2 3` | `5` |
| `-1 5` | `4` |
| `0 0` | `0` |

**Edges:** zeros, mixed signs, large values

### First attempt (issues)
- Used `double`
- Printed `"sum = "` prefix (format mismatch)
- File: `attempts/SumOfTwoNumbers_attempt.java`

### Correct answer
File: `SumOfTwoNumbers.java`  
- Type: `long`  
- Print **only** the sum  
- Logic via `sum(a, b)` + test calls in `main`

---

## Q2 — Odd or Even

### Problem
Read one integer `N`. Print `Even` or `Odd`.

**Output:** exactly `Even` or `Odd`  
**Constraints:** `-1e9 ≤ N ≤ 1e9`

**Samples**
| Input | Output |
|---|---|
| `4` | `Even` |
| `7` | `Odd` |
| `0` | `Even` |

**Tests also:** `-4` → Even · `-1` → Odd

### First attempt
- Logic mostly OK; negatives not demonstrated in `main`
- File: `attempts/EvenOdd_attempt.java`

### Correct answer
File: `EvenOdd.java`  
- `n % 2 == 0` → Even else Odd  
- Includes negative test prints  
- Exact `Even` / `Odd` output
