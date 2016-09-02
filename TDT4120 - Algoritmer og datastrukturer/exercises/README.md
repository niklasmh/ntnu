# TDT4120 - AlgDat
## Testing exercises
Be sure to use python ```3.x.x```.
To test each exercise, you can use the terminal (recommended) several ways.

### UNIX - Linux, Mac, [Windows with ubuntu bash](http://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/) or [putty](http://www.putty.org/)
***
To determine which version you are running, write
```bash
$ python -V
```

It should output ```3.x.x```, but if not, test ```python3```.

Now, to run each exercise, execute
```bash
$ python solution.py < input.txt
```

Even shorter, if ```python3``` is an alias for version 3.x.x (not ```python```), run
```bash
$ ./solution.py < input.txt
```

This can be done as the solution.py file has ```#!/usr/bin/python3``` as the first line. The shell will then run the shell script at that location. UNIX/Bash only!

Want to record time? Let the UNIX alias, time, save you. Just run
```bash
$ time ./solution.py < input.txt
123

real    0m0.061s
user    0m0.000s
sys     0m0.063s
```

Not enough? Run multiple times while getting the total time of each like this
```bash
$ for i in {1..10}; do time ./solution.py < input.txt; done
```

Or get the total (or both, just combine them). I recommend this method
```bash
$ time for i in {1..10}; do ./solution.py < input.txt; done > /dev/null
```

The last piece is for not doing output on the script inside the for loop. So just add
```bash
 > /dev/null   # UNIX
 > nul         # Windows
```
to fix massive outputs when you run 100 or 1000 tests.

#### More shortcuts
If you want to execute in even less commands, try creating a bash function in .bashrc
```bash
$ nano ~/.bashrc
# Now add
function algdat () {
        time for i in `seq $3`; do time python3 $1 < $2; done
}
# Ctrl+X -> J/Y to save
# Now restart the terminal or write the following
$ source ~/.bashrc
```
You can now, at the folder, run
```bash
algdat program.py input.txt 4 # Last arg is times to run
```

### Windows
***
If you are in Windows, be sure to add ```C:\Users\{User}\AppData\Local\Programs\Python\Python35-{version}``` to the environment variables.

To be sure python 2.x.x is not overriding the path, restart the terminal (cmd or powershell) and write
```bash
$ python -V
# Should output 3.x.x
```

If it's python 2.x.x, and you want python 2 as default, you can go into the ```C:\Users\{User}\AppData\Local\Programs\Python\Python35-{version}``` folder and rename ```python.exe``` to ```python3.exe```. Now you should restart the terminal and run
```bash
$ python3 -V
```
and it should output ```3.x.x```. More windows problems? Use [Google](https://google.com).

To run each exercise, go to the folder in the terminal with eighter cd (change directory), or by writing cmd in the File Explorer url. Then run
```bash
$ python solution.py < input.txt
```
dependent on your python keyword (```python``` or ```python3```) for version ```3.x.x```.
