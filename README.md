#Operating System Process ManagementSimulation

In this homework, you are expected to implement a basic “Operating System
Process Management Simulation” application using Java.This homework will cover
the topics given below:

1. Linked Lists
2. List ADT (Abstract Data Type)
3. Priority Queue ADT (Abstract Data Type)

Assume that you are designing aprocess management systemfor an operating
system. In this system, different processes with various priorities “request”
computing time from the operating system. Only one process can be compute data
given time. In other words, there is no parallel computing.

There are three types of process in the system:

1. High → Priority: 1
2. Normal → Priority: 2
3. Low → Priority: 3

At any given time systemcan have differentnumber ofprocesses. Thesystems
should keep all the processes in a list.

The Process class should implement the following IProcessinterface:

_public interface IProcess {_

```
public String getType();
```
```
public int getPriority();
```
```
public String toString();
```
```
...
```
_}_


You can assume that all processes request computation at the same time.The
computations should be placed in a queue-based structure with **a FIFO approach
with priorities.**

Inthissystem, each“ _computation_ ”has an occupation time that denote show many
nano seconds the operating system will be occupied. Your application should keep
statistics about the estimated waiting time for each _process_ ,and this waiting time is
equal tothe sum of occupation time of all **prior** _computations_.

An **outline** of the Computation class is given below:

_public Computation {_

```
private int id;
```
```
private IProcess process;
```
```
private int occupation;
```
```
public String toString();
```
```
...//Constructors,gettersetterand
other helper methods
```
```
}
```
```
// unique computation id in [1,1000]
```
```
// the process that makes computation request
```
```
// needed time for the computation
```
You are expected to create 3 simulations. Each simulation should have 3, 5, and 10
random processes respectively. Furthermore, for each simulation there should be a
corresponding priority computation queue. The simulations should be connected to
each other in a linked list fashion.

Your application should print some statistics at theend of each simulation which are:

```
● Simulation Number
● Representation of the Computation Queue
● Total number of computations for the simulation
● Total and average waiting times
● Total number of computations for each specific typeof process
● Total and average waiting time for each specific typeof process
```

Summary of the Requirements

1. Create 3 simulations (which are linked to each other) with 3, 5, and 10 random
    processes.
2. Place processes in a list for each simulation.
3. Create a “computation queue ” for each simulation in which each computation
    should have a random occupation time (between 1-10ns).
4. For each simulation, print statistics.

The output of your program for the first simulationshould look something like this:

Simulation Number: 1
Computation Queue: P2,High,10ns ← P1,High,2ns ← P3,Low,7ns
Total numbers of computations : 3

Total waiting time: 12
Average waiting time: 4

Total number of computations for High: 2
Total number of computations for Normal: 0
Total number of computations for Low: 1

Total waiting time for High: 12
Average waiting time for High: 6

Total waiting time for Normal: 0
Average waiting time for Normal: 0

Total waiting time for Low: 12
Average waiting time for Low: 12
