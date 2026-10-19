# Radha-Enterprise — Folder Structure (correct)

```text
Radha-Enterprise/
├── java-learning/                     # Java theory (7+ depth)
│   ├── EXPERIENCED-DEPTH-STANDARD.md
│   ├── month-01-basic/
│   │   └── day-01-how-code-works/
│   ├── month-02-...                   # later
│   └── phase-*/                       # long-term phase roadmap placeholders
│
├── coding/                            # DSA coding
│   ├── month-01-basics/
│   │   └── day-01-basic-program/
│   ├── level-1-array/ ...             # later DSA levels
│   └── level-*-string/
│
├── sql-coding/                        # SQL skill track (NOT Radha project)
│   ├── SCHEDULE.md
│   ├── month-01-foundations/          # mastery 1–6
│   ├── month-02-joins-subqueries/
│   ├── month-03-indexes-transactions/
│   ├── month-04-windows-cte-analytics/
│   ├── month-05-postgresql-advanced/
│   ├── month-06-advanced-production-sql/
│   ├── month-07-sql-competition-online/
│   ├── month-08-sql-competition-online/
│   ├── month-09-interview-oms-drills/
│   └── month-10-interview-oms-drills/
│
└── radha-enterprise/                  # OMS product / project track
    ├── month-01-foundation/
    │   └── day-01-domain-and-runtime/
    ├── auth-enterprise/
    ├── dashboard-rbac/
    ├── channel-integration/
    ├── catalog-inventory/
    ├── order-management/
    └── ...
```

## Rules
- Pattern: `month-NN-<topic>/day-XX-<concept>/`
- Only correct final code/SQL; questions in comments
- Interview Q packs after Month 1 block (Java) / Months 9–10 (SQL)
- Radha schema & product SQL → `radha-enterprise/` only
