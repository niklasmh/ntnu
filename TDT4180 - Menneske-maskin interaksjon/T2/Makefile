.PHONY: all

all:;@make -s run cp=src class=App pk=application

run:
	@echo Compiling ${class}.java...
	@javac ${cp}/${pk}/*.java
	@echo Running ${class}.java...
	@java -cp ${cp} ${pk}.${class}
