# Radha Enterprise

Multi-tenant **Order Management System (OMS)** SaaS — built from scratch as a learning + portfolio product (not a clone of any existing OMS).

## Vision
Help enterprises manage orders across marketplaces and warehouses from one platform:
- Onboard an enterprise (tenant)
- Connect sales channels
- Manage products & inventory
- Process orders → payments → fulfillment → returns
- Tax, reports, notifications, and auditability

## Who uses it
| Role | Meaning |
|---|---|
| **Platform** | Radha Enterprise SaaS operator (you) |
| **Enterprise** | A tenant company using the product |
| **User** | People inside an enterprise (Admin, Ops, Finance, etc.) |

## Core modules (roadmap)
1. Auth / Enterprise (multi-tenant foundation)
2. Dashboard + Users & RBAC
3. Marketplace / Channel Integration
4. Products / SKUs + Inventory
5. Order Management
6. Payments + Fulfillment / Shipping
7. Returns & Refunds
8. Tax
9. Reports & Analytics
10. Notifications + Settings
11. Logging / Monitoring / Auditing
12. Demo polish

## Tech stack (target)
- **Language:** Java 17+
- **Framework:** Spring Boot
- **DB:** PostgreSQL + Flyway
- **ORM:** Spring Data JPA
- **Cache / messaging:** Redis, Kafka (later)
- **Auth:** JWT
- **Ops:** Docker

## Principle
Inventory and channels come **before** orders. Build lifecycle in the correct business order.

## Status
Day 1 — repo + product vision README created.
