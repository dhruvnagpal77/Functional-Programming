Properties of functional programming:

It is all about giving 1st class status to functions which allows us to do the following:
1: Storing functions in variables.
2: Passing functions to methods.
3: Returning functions from methods.

Characteristics of Functional Programming:
1: Focuses on what to do not how to do.
2: Doesn't have any mutation(variable changing it's value/state)

Lambda expression is a shortcut method eg: element -> System.out.println(element) or (number1, number2) -> number1 + number2

stream() returns the stream of object of type of collection

There are 2 kinds of operations we do on streams

1: Intermediate operations:
It takes a stream of element & either reduce the no. of things in stream or map one element to another.
The result of an intermediate operation is another stream.
On a stream you can execute any no. of intermediate operations.
Eg: filter, sorted(), distinct(), map.

2: Terminal operations:
It takes the stream of elements & process/consumer them.
The result of terminal operation is either to consume the list or return one result back aka it's not a stream.
There can only be one terminal operation that can be executed on a stream since the output of terminal operation is not a stream.
Eg: forEach, reduce.