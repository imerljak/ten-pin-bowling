### Ten Pin Bowling Java

Java implementation of a ten-pin-bowling command-line calculator app.

This project is able to read from a formatted input file with scorings of a bowling game from of multiple players and
present it in a properly formatted result in the terminal.

#### How to build & run

This project uses `maven` dependency management system. To build it you can use the embedded maven wrapper.

> `./mvnw package`

The resulting build file will be present in the `./target` folder at the root of the project.
> `cd target && java -jar ten-pin-bowling.jar ../example_file.txt`


#### Goals

- [x] Clear separation of concerns
- [x] Keep code flexible enough to be able to add new score strategies
- [x] Calculate bowling score based on Traditional scoring system.
- [x] Keep testing coverage on non trivial classes above 80%
- [ ] Implement World Bowling scoring system.
- [ ] Allow to select score system to use when executing
