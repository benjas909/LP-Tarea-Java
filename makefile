JFLAGS = -Xlint:all

JC = javac

JVM = java

MAIN = JavaQuest

JAVAS := $(wildcard all/GraphGenerator/*.java) $(wildcard all/nodo/*.java) $(wildcard all/personaje/*.java) $(wildcard all/*.java) $(wildcard JavaQuest.java)

CLASSES := $(JAVAS:.java=.class)

all: $(CLASSES)

.PHONY: all clean run

%.class: %.java
	$(JC) $(JFLAGS) $^

run: $(CLASSES)
	$(JVM) $(MAIN)

clean:
	rm -rf $(CLASSES)