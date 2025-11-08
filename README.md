# Banking V2 (Java + JUnit4)

A minimal, OOP‑style banking domain written in plain Java with unit tests in **JUnit 4**.  
This repo contains these core types:

- `Bank` — manages customers, logins, and inter‑account transfers.
- `Client` — a customer with one or more `BankAccount`s, plus a bank‑side ID and PIN.
- `BankAccount` — balance keeping with deposit/withdraw semantics.
- `BankTest` — JUnit 4 tests that exercise typical user flows (login/logout, deposits, withdrawals, transfers, and edge cases).

---

## Quick start

You can use **Maven** (recommended) or compile manually.

### Option A — Maven (recommended)

1) Create the standard Maven layout and move files:

```
src/
├─ main/
│  └─ java/
│     ├─ Bank.java
│     ├─ Client.java
│     └─ BankAccount.java
└─ test/
   └─ java/
      └─ BankTest.java
```

2) Put the provided `pom.xml` in the project root and run:

```bash
# clean build + run tests
mvn -q clean test

# run tests with full output
mvn test

# package (produces a JAR under target/)
mvn -q clean package
```

> Maven will fetch **JUnit 4.13.2** automatically. The build is set to **Java 17**; change in the `pom.xml` if you need another version.

### Option B — Manual compile (no build tool)

If you prefer **javac** without Maven, download the JUnit jars (junit-4.13.2 and hamcrest-core-1.3) and put them under a `lib/` directory, then:

**macOS/Linux:**

```bash
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar *.java
java  -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore BankTest
```

**Windows (PowerShell/CMD):**

```powershell
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" *.java
java  -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore BankTest
```

> If your code is in packages, compile and run from the project root and use the correct package‑qualified class names.

---

## What this version covers

- Registering new clients with bank‑side IDs and **PIN**s.
- Creating accounts and **deposit / withdraw** operations.
- **Transfers** between accounts/clients (with balance checks).
- **Login / logout** flow validated via tests.
- Basic **input validation** (e.g., negative amounts, null checks).

> The exact set of assertions depends on your `BankTest`. Keep tests and code aligned.

---

## Project scripts & structure

```
.
├─ .github/workflows/ci.yml     # GitHub Actions: build & test on push/PR
├─ .gitignore                   # Java, IntelliJ, Maven ignores
├─ CHANGELOG.md                 # Keep a simple history of changes
├─ CONTRIBUTING.md              # Contributing guide
├─ LICENSE                      # MIT by default (change if you prefer)
├─ pom.xml                      # Maven build (JUnit 4 + Surefire)
├─ Bank.java
├─ BankAccount.java
├─ BankTest.java
└─ Client.java
```

---

## Continuous Integration (CI)

A ready‑to‑use **GitHub Actions** workflow is included. After you push this repo to GitHub:

- The workflow runs `mvn -q -B clean test` for every push and pull request on `main`.
- The status badge (below) will light up automatically once your repo is public.

```
[![CI](https://github.com/<your-user>/<your-repo>/actions/workflows/ci.yml/badge.svg)](https://github.com/<your-user>/<your-repo>/actions/workflows/ci.yml)
```

> Replace `<your-user>/<your-repo>` with your GitHub path.

---

## How to work with IntelliJ IDEA

- **Open** the project (File → Open → project root).  
- If using Maven: IntelliJ detects `pom.xml` and configures JDK & JUnit automatically.  
- To run tests: right‑click `BankTest` → **Run 'BankTest'**.  
- If you don’t use Maven, add the JUnit jars as **Project Libraries** and set the classpath in your Run Configuration.

---

## Common pitfalls

- **Wrong classpath** when running JUnit (cannot find symbol / NoClassDefFoundError).  
  Make sure the **JUnit and Hamcrest** jars are on the `-cp` runtime path.
- **Package mismatch** between files and folders.  
  Folder structure must mirror your `package` statements.
- **IntelliJ uses a different JDK** than your terminal.  
  Check *File → Project Structure → SDK* and *mvn -v* are consistent.

---

## Roadmap / Ideas

- Replace JUnit4 with **JUnit 5** and migrate tests.  
- Add **exceptions** (e.g., `InsufficientFundsException`) instead of boolean returns.  
- Persist data to a file or in‑memory database.  
- Add a small **CLI** menu for manual testing.

---

## License

This project is licensed under the **MIT License** (see [LICENSE](LICENSE)).

---

## Author

**Saeid Shahriari** — Data Engineer & MLOps · Java course project @ Vrije Universiteit Brussel (VUB).
