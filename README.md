# pathfinderconsumer

To run pathfinderconsumer please run first pathfinder, then start consumer. 

After start of pathfinderconsumer ther will be following console menu shown:

[full smkoke test: 1 -> 2 -> 5 -> 3 -> 5 -> 4 -> 0]
Smoke-test graph menu: 
1: Create
2: Read (id:1)
3: Update (id:1)
4: Delete (id:1)
5: Dijkstra btwn 1-7
0: Exit


To manual trigger smoke tests please run commands in following order: 1 -> 2 -> 5 -> 3 -> 5 -> 4 -> 0.

Have fun!

# task description
```
The goal of this project is to create and proove remote service for
finding path in predefined graph.
The solution should solve three main tasks:
- design and implement protocol/api exposed by the service (any protocol
and framework. even can be generated from openapi)
- implement and proove corectness of business logic (aka algorithm) of
defining graph/map (static resources, hardcoded or dynamic - pick and
suitable) and finding path (any algorithm)
- implement client which can connect and make calls to the service
(interactive or hardcoded smoke tests)

Please implement tasks in Java (8+). If you wish, You can use any
framework or library you find useful as long as the use is justified.

Remember:

We value YOUR time! The less code the better - as long as it's written
and maintained by You ;-)
We value YOUR work as well. Please commit all small steps, all WIPs
snippets - anything that is valueable and You don't want to miss.
But most of all we value OUR COOPERATION. After all we seek people to
join team not "one man army". If you have any questions/doubts before,
during or after the task - we're here for You feel free to ask.
```
