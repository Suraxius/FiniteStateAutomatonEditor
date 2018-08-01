# Create the bin directory to sort all the class files into
bin : manifest src
	mkdir -p bin
	javac -d bin/ -s src/ @manifest

# Create a file that lists all the java files under src/ (used by javac)
manifest : $(shell find -L src/ -type f)
	find -L src/ -iname "*.java" > manifest

#Create a java archive file (JAR) for distribution
jar : bin
	jar cfev fsae.jar com.svenluthi.fsae.Main -C bin pub ../images

# Run
run : bin
	java -cp bin com.svenluthi.fsae.Main

#Compile and run test on change of source files
onChange :
	while true; do inotifywait src/bup/*/*.java -e modify,moved_to; make run; done

# Clean up the mess:
clean :
	rm -f manifest
	rm -Rf bin/
	rm -f fsae.jar
