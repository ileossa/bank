# 2. The Dependency Inversion Principle

Date: 2019-12-17

## Status

Accepted

## Context

I can use to implement well-structured, highly-decoupled, and reusable software components. Like how save any transaction, in File or Database ? 

We don't need inversion of control (IoC), like SpringFramwork. Just keep stupid, not to complex with huge framwork.

To understand the motivation behind the DIP, let's start with its formal definition, given by Robert C. Martin in his book, [Agile Software Development: Principles, Patterns, and Practices:](https://www.pearson.com/us/higher-education/program/Martin-Agile-Software-Development-Principles-Patterns-and-Practices/PGM272869.html)

    High-level modules should not depend on low-level modules. Both should depend on abstractions.
    Abstractions should not depend on details. Details should depend on abstractions.

So, it's clear that at the core, the DIP is about inverting the classic dependency between high-level and low-level components by abstracting away the interaction between them.

In traditional software development, high-level components depend on low-level ones. Thus, it's hard to reuse the high-level components.

## Decision
```
+--------------------------------------------------------------------------+
|                            High-level package                            |
|                                                                          |
|                                                                          |
|  +-------------------+                    +---------------------------+  |
|  |                   |                    |                           |  |
|  |  <<CustomerDao>>  +<-------------------+   CustomerService         |  |
|  |                   |                    |                           |  |
|  +--------+----------+                    +---------------------------+  |
|           ^                                                              |
|           |                                                              |
|           |                                                              |
+--------------------------------------------------------------------------+
            |
            |
+----------------------------------------------+
|           |      Low-level package           |
|           |                                  |
|           |                                  |
|           |                                  |
|  +--------+---------------+                  |
|  |                        |                  |
|  |   SimpleCustomerDao    |                  |
|  |                        |                  |
|  +------------------------+                  |
|                                              |
|                                              |
+----------------------------------------------+
```

## Consequences

Code more complex. Simplification to adapt code for the future and tests.
