# System-Design-Interview-Questions

### Project: Design & Implement a Parking Lot System (classic but practical — models allocation, multiple floors/types, ticketing).

- Why practical? Teaches resource management, state tracking, pricing strategies — similar to booking/inventory systems in industry.
- Steps:
    - Start with basic: Single floor, park/unpark vehicles, generate tickets.
    - Add: Multiple floors, different vehicle/spot types (car, bike, EV), pricing strategy (hourly vs flat).
    - Refactor: Introduce interfaces for spot allocation strategy (Strategy pattern emerges), factory for creating spots/vehicles.
    - Add: Concurrency (multiple gates parking simultaneously — use Go channels/mutexes or Rust's Arc/Mutex).
    - Tests: Unit for allocation logic; integration for full flow.
    Challenge: Handle full lot, invalid operations gracefully. Discuss extensibility (add new vehicle type without changing core code).

- Resources for reference (only after trying yourself): GitHub repos like thesaltree/low-level-design-golang for Go examples; think in Rust terms for ownership.
- Output: Clean modular code with clear separation of concerns. README explaining initial vs refactored design.


---


### Project: In-Memory Key-Value Store / Cache with Persistence (LRU/LFU eviction, expiration, basic persistence to file/DB).

- Why industry-like? Many real services need fast caches (Redis-like). Teaches data structures, eviction policies, concurrency safety, serialization.
Steps:
- Minimal: Simple map-based store with Get/Set.
  - Add: LRU eviction (use doubly-linked list + hashmap — practice data structure integration).
  - Add: Expiration, multiple eviction policies (switch via interface — Strategy/Factory).
  - Concurrency: Thread-safe operations (Go: sync.RWMutex; Rust: tokio or std sync primitives).
  - Persistence: Simple file/JSON dump on shutdown or periodic.
  - Refactor: Apply SOLID — e.g., separate storage backend interface for easy swapping (in-memory vs persistent).
  - Tests + benchmarks: Measure throughput under concurrent load.
  - Challenge: Handle high concurrency without deadlocks/races; add rate limiting or observability hooks.

- Bonus for foreign jobs: Make it production-flavored — add graceful shutdown, config via env vars, basic CLI or HTTP wrapper (using net/http in Go or Axum in Rust).
- This directly helps system design interviews (you can discuss internals confidently).

---


### Project: URL Shortener Service (or Rate Limiter / Notification Service).

- Why practical? Common in product companies; involves encoding, storage, redirection, analytics, rate limits — full backend thinking.
- Steps:
  - Core: Shorten URL → redirect (base62 encoding, collision handling).
  - Add: User accounts (simple auth), click analytics, expiration.
  - Persistence: Integrate PostgreSQL or in-memory + file (use sqlx in Go or Diesel/SQLx in Rust).
  - Extensibility: Different shortening strategies or storage backends.
  - Concurrency & Scale: Handle many shorten/redirect requests safely; add distributed aspects discussion (even if single instance).
  - Refactor for maintainability: Clean layers (handler → service → repository → model). Introduce Observer if adding event notifications.
  - Tests: Mock dependencies for unit tests; integration with test DB.
  - Challenge: Make it "production-ready" — Dockerize, add basic CI (GitHub Actions), logging, error wrapping, graceful degradation.

- Alternative if you prefer: Expense Splitter (Splitwise-like) — groups, balances, settlements. Great for modeling complex relationships and transactions.

---

### Project: Mini Message Queue or Task Scheduler (inspired by Kafka/RabbitMQ basics) or a Simple Web Framework / API Layer.

- For Go: Focus on high-concurrency workers, job queuing with channels.
- For Rust: Emphasize safe concurrent data structures and zero-copy where possible.
- Steps: Build incrementally (in-memory queue → persistent → with workers). Refactor heavily as requirements grow (e.g., add priorities, retries, observability).
- Industry tie-in: Discuss how this would integrate with microservices (gRPC/HTTP), monitoring, etc.
Stretch: Add a small HTTP API on top and deploy to a free cloud tier if possible.

- If going Rust route: After 1–2 Go projects, redo one in Rust (e.g., the cache or URL shortener) to feel the difference in safety and performance. Rust projects like building a mini Redis-compatible store or high-perf components are excellent for this.




# LLD Interviewer & Mentor Prompt

# Role & Persona
Act as a Senior Software Engineer / System Architect (SDE-3 / SDE-2 with 3-5+ YoE) conducting a Low-Level Design (LLD) and Machine Coding interview. 
You are an expert in Object-Oriented Programming (OOP), SOLID principles, Separation of Concerns (SoC), concurrency, multithreading, and industry-standard design patterns.

# Core Directives
1. **Never Give the Solution Upfront:** Do NOT provide full architectures, class diagrams, or code solutions until I have explicitly asked for them or until I have written my own implementation first. I want to build my own mental models without memorizing your answers.
2. **Incremental Hints Only:** Act strictly like an interviewer. When I present an approach or code, do not point out all the flaws at once. Find the most critical issue (e.g., a massive SOLID violation or a concurrency flaw) and ask me a guiding question to help me discover it myself. Give me hints step-by-step.
3. **Start Bad, Improve Slowly:** We will always start with my minimal, basic (or even "bad") code. We will then iteratively refactor it, moving upwards from the worst problems to the micro-optimizations. Never skip steps. Move to the next issue only when the current one is solved.
4. **Demand SDE-2 Quality:** Do not accept simple "MVP" solutions. Push me on thread-safety, high-performance I/O, extensibility, and edge cases (like race conditions or graceful shutdowns).

# The "Why" Rule
Always explain the logic, thought process, and trade-offs behind every decision. If I choose a specific collection (like `ConcurrentHashMap` vs `HashMap`) or a specific pattern (like Factory vs Builder), challenge me on *why*, and provide your own breakdown of why one is better than the other for the specific use case.

# Mentor Mode
If I explicitly state that a concept is "beyond my knowledge" (e.g., advanced threading, specific Java internals, or a complex design pattern I haven't used), briefly switch from Interviewer to Mentor. Provide a clear, conceptual explanation with a minimal blueprint/code snippet to teach me the concept, then switch back to Interviewer mode so I can implement it myself.

# Visualizations & Documentation
When I ask you to visualize my design or document our learnings, write high-quality Mermaid `classDiagram` blocks. Format your explanations like a "System Design Masterclass" tutorial, emphasizing the advanced concepts, the concurrency problems, and the design patterns we discussed, so I can use it as a study guide later.

I am ready. I will provide the problem statement in my next message. Let me know you understand these instructions!



---

Stripe - job scheduler 
- capable of running 10k jobs per second
- every job should be run within 2 seconds of their execution time
- message queue - explore redis, kafka, rabitMQ (high availability with corum), sqs