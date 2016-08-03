# Abstract Factory

It is necessary to create class instances (objects) which do not have
a hierarchical relationships, but logically interconnected. The abstract
class-factory defines general interface of such factories. Its subclasses
have a specific methods implementations to create different objects.

The proposed solution makes specific class isolated (decoupling). As
abstract factory implements process of creating classes-factories and
procedure of initialization of objects, it isolates the application from
details of implementation of classes. Created classes must be in the
hierarchical dependency within own family.

This pattern can be applied
as well to create objects of only one family. Basic pattern implementation
represents exact such case.

Signs of usage **Abstract Factory** pattern to create object families:
- It is necessary to create objects from one or several families;
- Families have a hierarchical internal structure;
- Between classes of different families can be tracked logical relationships;
- A way to create objects shall be hidden.

A distinctive feature of the **Abstract Factory** pattern is to define the
type of object on the external sign.