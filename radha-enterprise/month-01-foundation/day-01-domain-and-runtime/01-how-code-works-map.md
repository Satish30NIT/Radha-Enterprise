# Day 1 Project — How code works → Radha OMS

**Goal today:** Map platform fundamentals onto Radha’s first domain sketch — the way an experienced backend engineer would explain decisions, not a checklist of field names.

---

## 1) Runtime reality for Radha (correct mental model)

When Radha’s API is “up”, we are not executing `.java` files on the server.

**What is actually true:**

1. **We ship** compiled artifacts — typically a **jar** containing **bytecode** (plus config/deps as designed later).
2. **We run** a **JVM process**. That process is the service from an ops point of view.
3. **The CPU** executes **machine code** belonging to that process (interpreter/JIT/runtime native paths). It never “runs source.”

**How I’d say this in a design / interview discussion:**

> “For Radha I’ll build and ship bytecode in a jar. At runtime we run a JVM process. The CPU executes machine instructions for that process. So when we talk scale, memory, or CPU, we’re talking about JVM processes — not source files.”

**Why this matters for an OMS product:**
- Deploy/rollback = ship a build artifact, not copy `.java`
- Horizontal scale = more service instances (JVM processes), later behind a load balancer
- Perf incidents start with process health (CPU, heap, threads), not “Java language is slow”

---

## 2) Tenant (Company) — v1 sketch (correct intent)

Radha is multi-tenant SaaS. A **Tenant** is an enterprise/company using the platform.

### Fields (v1)

| Field | Why it’s there |
|---|---|
| `id` | Stable identity for the enterprise |
| `title` | Human-readable company name |
| `email` | Primary company contact (v1; may move later) |
| `phone` | Primary company phone (v1; may move later) |
| `is_active` | Enable/disable tenant access without destroying data |
| `is_deleted` | Soft delete — hard delete is rarely the first choice in business systems |

**Experienced note:**  
`is_active` vs `is_deleted` are different concerns — suspended vs logically removed. Keeping both early avoids painting ourselves into a corner.

---

## 3) User — v1 sketch (correct intent)

A **User** is a person who can sign in. In Radha, that person may work across **more than one company**.

### Fields on User (v1) — identity only

| Field | Why it’s there |
|---|---|
| `id` | Primary key |
| `first_name`, `middle_name`, `last_name` | Display / legal-ish name parts |
| `user_id` | Login handle / username — **not** the same as PK `id` |
| `email` | Login + communication |
| `password` | Auth secret — **store hashed later; never plain text in real systems** |
| `phone` | Contact |
| `is_active`, `is_deleted` | Soft lifecycle flags for the person account |

### What we deliberately do **not** put on User
A single `company_id` on User.

**Why (this was the important correction today):**  
If one user can work for multiple companies, a single FK on User is the wrong model. It forces “one company per user” and breaks real OMS/consulting/multi-brand operations.

---

## 4) Tenancy relationship — correct model (many-to-many)

### Business rule (final)
- One **User** can belong to **many** Companies/Tenants  
- One **Company** has **many** Users  
- Role/permissions can differ **per company**

### Correct structure

```text
User (*) ────────< Membership / UserCompany >──────── (*) Tenant (Company)
   id                   user_id                              id
                        company_id
                        role (per company)
                        is_active
```

### Membership / UserCompany fields (v1)

| Field | Why it’s there |
|---|---|
| `id` | Membership row identity |
| `user_id` | Which person |
| `company_id` | Which enterprise |
| `role` | What they can do **in that company** (Admin/Ops/Finance…) |
| `is_active` | Whether this membership is currently usable |

**How I’d defend this choice:**

> “I modeled User and Company as many-to-many through a membership table because the same operator can work across multiple enterprises. Role lives on the membership, not on the user globally — otherwise permissions leak across tenants.”

That last sentence is the 7-year part: **tenant isolation of authorization**.

---

## 5) Day 1 project outcome (what we actually decided)

1. Radha runs as a **JVM process**, ships **jar/bytecode**, CPU runs **machine code**.  
2. First domain nouns: **Tenant**, **User**, **Membership**.  
3. Soft flags early (`is_active`, `is_deleted`).  
4. Multi-company users → **join table**, not `User.company_id`.  
5. No Spring/DB code yet — correct **shape** before implementation.

---

## 6) Explicitly out of scope today (on purpose)

- Password hashing / Spring Security  
- Flyway tables / JPA entities  
- APIs for login or company switch  
- Exact role enum values  

Those come when Phase/stack days unlock them — on top of this model.
