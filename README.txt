Simulation of Flu Epidemic project

Version : 13.12.2015
Authors : Baisangour Akhmadov, Arnaud Zago, Liavona Zhelanosava
Group 2, SI3.

------------- COMPILE AND RUN -------------
To compile the project :
	mkdir build
	mkdir build/classes
	javac -d build/classes src/oop/flu/*.java

To run the application :
	java -cp build/classes oop.flu.TestMainClasses

--------------- DESCRIPTION ---------------
The application run the simulation of a flu epidemic based on conditions
given on Moodle. 
The application creates a 2D field filled with different
living beings (humans, pigs, ducks and chickens) and simulates a spread of
flu. 
If a living being dies it is removed from the field.
Humans can move on the field (animals cannot).
The state of one living being can be determined by specific color :
RED for HEALTHY
LightGray for CONTAGIOUS
MAGENTA for DEAD
CYAN for RECOVERING and IMUN

Graphic interface was taken from rabbits&foxes project.

We also impelemt next variants :
- if human is not dead after recovering from its disease he becomes resistant to infections;
- vaccination??

--------------- PARAMETERS ---------------
The simulation has its default parameters (see in Simulation.java)
Field width = 25
Field height = 25
Population rate = 50%
Neighbourhood type = 4-neighbours
User may change these parameters when run the application.

The times of diseases are fixed (see in Disease.java)
