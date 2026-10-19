# Month 1 · Day 1 — How code works

**Folder:** `java-learning/phase-1-core-java/basic/day-01-how-code-works/`  
**Style:** Deep dive as a working backend engineer explains it — not a textbook dump.  
**Note:** Interview Q packs come **after Phase 1 / Month 1** revision block — not on this day.

---

## 1) The only fact that matters at the bottom

A CPU does not “run Java”. It does not “run C source”.

It executes **machine code**: architecture-specific instructions (x86-64, ARM, …).

Everything we do in software engineering is about bridging:

```text
Human intent  →  something the machine can execute
```

If you keep that sentence in your head, JVM, bytecode, JIT, containers — sab fit ho jate hain.

---

## 2) Two kinds of “code” we talk about every day

### Human-readable source
- What we write and review in PRs: Java, C, etc.
- Optimized for **clarity, maintenance, team velocity**
- Not what the silicon executes

### Machine code
- What the CPU fetch/decode/executes
- Tied to CPU architecture
- Not what we want to maintain as business logic

**How an experienced person says it:**

> “Source is for humans. Machine code is for the CPU. My job is to know which artifact I ship and what actually burns CPU on the server.”

---

## 3) Why we don’t ship machine code for every Java service by default

In a native C-style world, build often produces a platform binary.  
Rebuild for each OS/CPU, or ship multiple artifacts.

Java’s default product model is different on purpose:

1. Compile once to a **portable intermediate form** (bytecode)
2. Run that on a **JVM** for the target machine
3. Let the runtime optimize what’s actually hot

That’s not academic — it’s why the same jar can move across Linux servers with a compatible JVM, and why “wrong Java version on the box” is a real outage class (`UnsupportedClassVersionError`).

---

## 4) The Java path (the one you’ll live in)

```text
Write .java
    → javac
    → .class (bytecode)
    → package jar / image
    → start JVM process
    → execute bytecode (typically interpret first)
    → JIT compiles hot paths to machine code
    → CPU runs native instructions
```

```mermaid
flowchart LR
  A["Source .java"] --> B["javac"]
  B --> C["Bytecode"]
  C --> D["JVM process"]
  D --> E["Interpreter"]
  E --> F["JIT hot paths"]
  F --> G["CPU machine code"]
```

### What each step is *for* (practical)

| Step | Engineering meaning |
|---|---|
| Source | Express domain logic (orders, tax, auth…) |
| `javac` | Produce portable bytecode artifact |
| Bytecode | Ship/run unit the JVM understands |
| JVM process | Your service “is running” |
| Interpreter | Get work started without compiling everything native up front |
| JIT | Spend compile CPU on code that actually dominates runtime |
| CPU | Ultimately does the work |

---

## 5) Bytecode vs machine code (without sounding memorized)

- **Bytecode** = instructions for a **virtual machine** (JVM), not for a specific CPU
- **Machine code** = instructions for a **real CPU**

CPU does **not** execute bytecode directly.  
The JVM executes bytecode; the CPU executes the JVM’s native code (including JIT output).

This is why “Java is platform independent” is incomplete if you stop there.  
More accurate:

> “Bytecode is portable across machines that provide a compatible JVM. Native details still matter for version, arch, and native libraries.”

---

## 6) Interpreter and JIT — one runtime strategy, two gears

### Interpreter
- Executes bytecode in a more direct, stepwise way at runtime
- Helps startup / cold code
- Higher per-instruction overhead if you stayed here forever on hot loops

### JIT (Just-In-Time)
- While the app runs, the JVM notices **hot** methods/loops
- Compiles those to **native machine code** for this CPU
- Later calls use the fast path
- Can **deoptimize** if speculative assumptions break (correctness first)

**Production instinct:**

- Right after deploy, latency can look worse (warm-up: JIT, caches, pools)
- Steady-state is what capacity planning should care about
- If someone load-tests only the first 15 seconds, they’ll often draw the wrong conclusion about Java

`javac` ≠ JIT  
- `javac`: **before run**, source → bytecode  
- JIT: **during run**, hot bytecode → machine code

---

## 7) What “the service is running” means in production

When we say Radha / any Spring API is up, we don’t mean “Java text is executing.”

We mean roughly:

1. A **JVM process** is alive on the host/container  
2. Application threads are doing work (HTTP, consumers, schedulers)  
3. Underneath, the OS schedules that process onto CPU cores  
4. Those cores run **machine instructions** belonging to that process  

So scaling talk becomes concrete:

- more instances ≈ more JVM processes (usually)
- memory problems ≈ heap/process pressure
- CPU spikes after traffic ramp ≈ app work + sometimes compilation/warm-up

That’s senior vocabulary: **process, heap, threads, warm-up** — not “Java is slow.”

---

## 8) Native pipeline vs Java pipeline (so you’re not confused later)

### Native-style (simplified)
Source → compiler/assembler pieces → linker → executable → OS loader → CPU

### Java-style (simplified)
Source → `javac` → bytecode → JVM load/execute → (JIT) machine code → CPU

Same destination (CPU). Different shipping and runtime model.

You’ll go deep on compiler/assembler/linker/loader in later Month-1 days.  
Day 1 only needs: **two roads, one destination.**

---

## 9) Mental model checklist (use this when explaining)

When you explain How code works, hit these in order:

1. CPU runs machine code only  
2. We write source for humans  
3. Something must translate  
4. Java translates first to bytecode  
5. JVM runs bytecode in a process  
6. Hot code can become machine code via JIT  
7. What I ship ≠ what the silicon executes, but they’re connected  

If you can tell that story in your own words, you don’t sound like you memorized a definition — you sound like you’ve run services.

---

## 10) Map to Radha Enterprise (why this day exists)

- Local/CI build uses a **JDK** (`javac`/build tools) — detail on JDK day  
- Running OMS API = **JVM process** with our classes/jar  
- Performance conversations later (Kafka lag, slow API) still sit on this foundation: process → CPU → hot paths → I/O/DB  

Day 1 takeaway for the project:

> “Radha doesn’t run `.java` on the CPU. We build bytecode, run a JVM, and the CPU executes the native work of that process.”

---

## Revision (short — your words later)

```text
Source → humans
Bytecode → JVM
Machine code → CPU

Java: .java → javac → .class → JVM → interpret → JIT(hot) → CPU

Ship jar/bytecode
Run JVM process
Warm-up is real
javac ≠ JIT
```
