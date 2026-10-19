-- ============================================================
-- Month 1 · Day 1 · Section 4 — SQL (Interview style)
-- Path: sql-coding/level-1-sql/day-01/
-- ============================================================
-- Schema:
--   employees(id, name, department, salary, joined_on)
--   orders(id, customer_name, amount, status, created_at)
-- ============================================================


-- ------------------------------------------------------------
-- SQL-Q1 — High Salary Employees
-- ------------------------------------------------------------
-- PROBLEM:
--   Find all employees whose salary is STRICTLY greater than 50000.
-- OUTPUT columns (order):
--   name, salary
-- ORDERING:
--   does not matter
-- EDGES to think:
--   salary = 50000  → exclude
--   salary IS NULL  → exclude (NULL > 50000 is unknown/false in WHERE)
--   no matching rows → empty result
--
-- YOUR FIRST ATTEMPT: PASS
-- FIXED / FINAL ANSWER:

SELECT name, salary
FROM employees
WHERE salary > 50000;


-- ------------------------------------------------------------
-- SQL-Q2 — Paid Orders Latest First
-- ------------------------------------------------------------
-- PROBLEM:
--   Return ALL columns for orders with status = 'PAID',
--   most recent first.
-- OUTPUT:
--   all columns from orders
-- ORDERING:
--   created_at DESC (latest first)   ← NOT id DESC
-- EDGES to think:
--   'paid' vs 'PAID' (case/collation)
--   status IS NULL → exclude
--   same created_at ties
--
-- YOUR FIRST ATTEMPT (WRONG sort column):
--   Select * from orders where status = "PAID" order by id desc;
--
-- WHY WRONG:
--   1) ORDER BY id DESC ≠ "latest by time"
--   2) Prefer single quotes: 'PAID'
--
-- FIXED / FINAL ANSWER:

SELECT *
FROM orders
WHERE status = 'PAID'
ORDER BY created_at DESC;


-- ------------------------------------------------------------
-- SQL-Q3 — Top 5 Latest Orders
-- ------------------------------------------------------------
-- PROBLEM:
--   Fetch the 5 most recent orders overall.
-- OUTPUT columns (order):
--   id, customer_name, amount, created_at
-- ORDERING:
--   created_at DESC
-- RULE:
--   if fewer than 5 rows exist, return all of them
-- EDGES to think:
--   0 / 3 / 5 / 10 rows
--   ties on created_at (optional: , id DESC)
--
-- YOUR FIRST ATTEMPT (INVALID + incomplete):
--   Select id, customer_name , amount , created_at from orders where order by created_at desc;
--
-- WHY WRONG:
--   1) "WHERE order by" is invalid syntax — WHERE needs a condition, or omit WHERE
--   2) LIMIT 5 missing (top 5)
--
-- FIXED / FINAL ANSWER:

SELECT id, customer_name, amount, created_at
FROM orders
ORDER BY created_at DESC
LIMIT 5;

-- OPTIONAL (tie-break):
-- ORDER BY created_at DESC, id DESC
