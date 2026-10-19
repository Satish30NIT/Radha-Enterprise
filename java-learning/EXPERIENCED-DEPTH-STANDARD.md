# Experienced Depth Standard (mandatory)

Everything we add under this repo’s learning / project folders must read like a **~7 years backend engineer** explaining work — not a textbook chapter and not memorized Q&A.

## Goal
Build understanding strong enough that in interviews you can:
- explain **what** and **how**
- defend **why** you chose it
- describe **what breaks in production**
- connect it to **Radha Enterprise** decisions

Fake “I have 7 years Java” claims are not the goal. **7-year-level depth** is.

## Required style for every note / doc we add

### Must include
1. **Real framing** — when this shows up in a real service (API, OMS, deploy, incident)
2. **Mechanism** — how it works internally (enough to debug/reason)
3. **Why it exists** — problem it solves
4. **Trade-offs** — when to use / when not
5. **Common mistakes** juniors make vs how seniors avoid them
6. **Radha map** when relevant — how this affects our OMS design
7. **Spoken explanation** — short paragraph you could say aloud in an interview

### Must avoid
- Bookish definitions only (“X is a …”)
- Bullet dumps with no reasoning
- Ratta lines with no scenario
- Skipping failure modes / production reality
- Interview Q files on every topic day (those come in **Month 2 revision** after Month 1)

## Daily topic day structure (Phase 1 Month 1)
1. **Theory deep dive** (this standard) → folder under `java-learning/...`
2. **Coding** (assessment problems; attempt + correct answers)
3. **SQL** (assessment problems; attempt + correct answers)
4. **Project** (guided; decisions written at this same depth under `radha-enterprise/`)

## Interview questions
After Month 1 / phase block completes → dedicated revision days (Month 2 Days 1–7 style).  
Not stuffed into every daily theory file.

## Quality bar (self-check before saving a file)
- Could I explain this to an interviewer without looking at notes?
- Did I mention at least one **production** or **design** consequence?
- Does it sound like experience, or like a blog definition?

If it fails the bar — rewrite before commit.
