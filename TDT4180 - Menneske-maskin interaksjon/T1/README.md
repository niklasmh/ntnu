# First technical assignment in TDT4180

The assignment asked to recreate some application designs with different approaches:
 - SceneBuilder - A program generating FXML with GUI.
 - FXML - Just plain FXML.
 - JavaFx - Making elements in Java.

## Run

Be sure to install JDK and JRE 8+.

When using make, you can use tabcompletion.

```bash
$ make converter # Run FXML construction.
$ make calculator # Run SceneBuilder contruction.
$ make wordfeud # Run JavaFx construction.
```

You can also just choose file:

```bash
$ make run cp={FOLDER} class={FILE} # (cp = ClassPath, same as folder.)
```
