# TDT4120 - AlgDat
## Testing exercises
Be sure to use python ```2.7.x```.
To test each exercise, you can use the terminal (recommended) several ways.

### UNIX - Linux, Mac, [Windows with ubuntu bash](http://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/) or [putty](http://www.putty.org/)

To determine which version you are running, write
```bash
$ python -V
```

It should output ```2.7.x```, but if not, test ```python27``` or ```python2```.

Now, to run each exercise, execute
```bash
$ python solution.py < input.txt
```

Even shorter, if ```python``` is version 2.7.x (not ```python27```), run
```bash
$ ./solution.py < input.txt
```

### Windows
If you are in Windows, be sure to add ```C:/Python27/``` to the environment variables.

To be sure python >= 3 is not overriding the path, restart the terminal (cmd or powershell) and write
```bash
$ python -V
# Should output 2.7.x
```

If it's python 3.x.x, and you want python 3 as default, you can go into the ```C:/Python27/``` folder and rename ```python.exe``` to ```python27.exe```. Now you should restart the terminal and run
```bash
$ python27 -V
```
and it should output ```2.7.x```. More windows problems? Use [Google](https://google.com).

To run each exercise, go to the folder in the terminal with eighter cd (change directory), or by writing cmd in the File Explorer url. Then run
```bash
$ python solution.py < input.txt
```
dependent on your python keyword for version ```2.7.x```.
