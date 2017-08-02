# This Java application is built on environment described followed
* macOS 10.12.5 (Darwin Kernel Version 16.6.0)
* JDK 1.8.0_91
* Apache Maven 3.5.0
* Microsoft Visual Code 1.13.1 (IDE)
* The application is desiged to be compatibale in other platforms but it has not been tested.

# Before running the program
* Make sure you have installed JDK 1.8 or above
* Make sure you have Maven 3.5.0 installed

# Dependencies of the application
* JUnit 4.1.2

# Application Design
* I aim to make this application lightweight yet flexible enough for further development. So Apache Maven is used, for the sake of easier dependencies management, and the handy test and build features. Though JUnit is the only dependency in the current version, developers might enrich the function by adding new dependencies via POM configuration. JUnit is chosen as the test framework for its popularity and tight integration with Maven. Every build wil be successfully only if all the test cases are passed, otherwise fail. It ensures the quality of the software by forcing developers to take care of all requirements even he/she just changes a single line of code, but which may affect multiple functions. For the test cases, as the program produce visual effect after a valid command. I assert the expected visual layout to the actual command line result, that I believe it is the most effective way to test it.

# Exceptional cases
* There are some exceptional cases I have handled in the application:
* Canvas size is too small (3 x 3)
* Canvas size is too big (120 x 150)
* Canvas must be created before any operation (except Quit)
* The number of parameters checking
* It is invalid to draw beyond the canvas size
* Only horizontal and vertical line can be drawn
* The color parameter of Fill function only accept one character

# Run the program
1. Initialize the Maven repository

```
mvn clean
```

2. Compile the source code to generate the class files (which will be located in folder"target")

```
mvn compile
```

3. Compile, run tests, and build the application as a jar (which will be located in folder "target")

```
mvn package
```

4. Run the application in command line

```java
java -cp target/m41highway.drawingApp-0.1.0.jar com.m41highway.drawing.DrawingApp
```