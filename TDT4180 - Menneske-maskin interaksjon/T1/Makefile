.PHONY: all

all:;@echo Yep. This project has a makefile.

calculator:;@make -s run cp=SceneBuilder class=Calculator
converter:;@make -s run cp=FXML class=CurrencyConverter
wordfeud:;@make -s run cp=JavaFx class=Wordfeud

# Aliases
1:="calculator"
2:="converter"
3:="wordfeud"

1:;@make -s $(1)
2:;@make -s $(2)
3:;@make -s $(3)

run:
	@echo Compiling ${class}.java...
	@javac ${cp}\${class}.java
	@echo Running ${class}.java...
	@java -cp ${cp} ${class}
