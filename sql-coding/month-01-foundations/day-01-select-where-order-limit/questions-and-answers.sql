-- ============================================================
-- Month 1 · Day 1 · Section 3 — SQL (correct final answers)
-- Lessons locked today:
--   1) Text values use single quotes: status = 'PAID'  (double quotes = identifier)
--   2) "Latest" means created_at, not id (ORDER BY created_at DESC)
-- Path: sql-coding/month-01-foundations/day-01-select-where-order-limit/
-- ============================================================
-- Schema:
--   employees(id, name, department, salary, joined_on)
--   orders(id, customer_name, amount, status, created_at)
-- ============================================================


-- ------------------------------------------------------------
-- SQL-Q1 — High Salary Employees
-- ------------------------------------------------------------
-- Find employees with salary STRICTLY greater than 50000.
-- Output: name, salary

SELECT name, salary
FROM employees
WHERE salary > 50000;


-- ------------------------------------------------------------
-- SQL-Q2 — Paid Orders Latest First
-- ------------------------------------------------------------
-- All columns where status = 'PAID', most recent first.

SELECT *
FROM orders
WHERE status = 'PAID'
ORDER BY created_at DESC;


-- ------------------------------------------------------------
-- SQL-Q3 — Top 5 Latest Orders
-- ------------------------------------------------------------
-- Output: id, customer_name, amount, created_at
-- If fewer than 5 rows exist, return all of them.

SELECT id, customer_name, amount, created_at
FROM orders
ORDER BY created_at DESC
LIMIT 5;
