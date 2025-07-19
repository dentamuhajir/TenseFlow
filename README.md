# 🌊 TenseFlow

**TenseFlow** is an educational Java-based project that explores how English grammar, especially verb tenses, can be represented using programming logic. Designed for programmers who want to improve their English — or learners who love thinking in code.

---

## 🧠 Concept

Instead of just memorizing grammar rules, TenseFlow allows you to **visualize and simulate** English grammar using:
- Java functions to represent **verb tenses**
- Conditional logic to simulate **sentence structures**
- Flow-based diagrams and explanations to teach **grammar as logic**

---

## 🚀 Goals

- Help learners understand **English grammar logically**
- Enable programmers to see grammar as a form of **computational thinking**
- Explore how **Natural Language Structures** can be built from code

---

## 📚 Features (Planned)

- ✅ Present Simple, Present Continuous, Present Perfect as Java functions
- 🔁 Sentence pattern simulator (Subject + Verb + Object)
- 🧪 Input/output for practice (e.g. generate sentence → user matches the correct tense)
- 🧠 Grammar rules defined as programmable logic
- 🔍 Possible future support for other languages (Bahasa, Japanese)

---

## 💻 Sample: Verb-ing Logic in Java

```java
public class VerbIngConverter {
    public static String toVerbIng(String verb) {
        if (verb.endsWith("e") && !verb.equals("be")) {
            return verb.substring(0, verb.length() - 1) + "ing"; // make → making
        } else if (verb.matches(".*[aeiou][bcdfghjklmnpqrstvwxyz]$")) {
            return verb + verb.charAt(verb.length() - 1) + "ing"; // run → running
        } else {
            return verb + "ing"; // play → playing
        }
    }
}
