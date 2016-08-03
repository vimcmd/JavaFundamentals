# Factory Method

It is necessary to determine the mechanism of creation of objects
based on certain criteria for the classes which are in hierarchical
structure. Class-factory and it subclasses are allowed to create
instances using general interface, and subclasses decide which instance
should be created. This interface may be contained in the abstract class,
interface or even in a normal class. Factory Method does not have information
about a specific type of object being created, but knows about a top level class
of the hierarchy of created objects. **Factory Method** - the basis for
functioning of the **Abstract Factory**.