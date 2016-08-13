# Task

Suppose that there is a basic problem.

## Task. Pass the exam.
- Subtask. Pass the test.
- Subtask. Complete task (one or few).

There should be a delegation of solving a one problem to one class,
next problem to next class, and so on.

Message initiator will have no explicit functional relationship with
its handler. To solve the problem, introduce a field to class that
identifies the problem. It remains only implement a sequence of
communications or calls between tasks.

As implementation introducing a `Handler` class or interface,
that defines a method which transmits message to next handler.
Moreover, implementation of the transfer process depends on task.