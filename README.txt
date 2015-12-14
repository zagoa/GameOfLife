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
If a living being dies it is removed from the field the next step.
Humans can move on the field (animals cannot).

Different types of being are identified by different colors:
-BLUE for Humans
-PINK/PURPLE for Pigs
-YELLOW for Chickens
-GREEN for Ducks
Their state (Healthy,Sick,Contagious,Dead) is identified with a darker color (the closer they are to death, the darker the color is). If they are dead the color is black.
For humans, immunised humans are identified by a light blue color.

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
