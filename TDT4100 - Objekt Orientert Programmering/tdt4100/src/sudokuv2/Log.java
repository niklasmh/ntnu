package sudokuv2;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> log = new ArrayList<>();
    private int step = 0;

    /**
     * Contructor of the log handler with no arguments.
     */
    public Log () {
    }

    /**
     * Contructor of the log handler.
     *
     * @param log = list of moves in this format: a 5 9 -> Field at (0, 5) with 9
     * @param step = steps in the game. Could be a few steps behind when starting up
     */
    public Log (List<String> log, int step) {
        this.log = log;
        this.step = step;
    }

    /**
     * Appending a move to the last from step. Does need to remove further log as it has changed its past.
     *
     * @param move = what move which should replace at the step counter
     */
    public void append (String move) {
        log.subList(this.step, log.size()).clear();
        log.add(move);
        this.step++;
    }

    /**
     * Decrease the stepper by one if possible.
     */
    public boolean undo () {

        if (this.step > 0) {
            this.step--;
            return true;
        }

        return false;
    }

    /**
     * Increase the stepper by one if possible.
     */
    public boolean redo () {

        if (this.step < this.log.size()) {
            this.step++;
            return true;
        }

        return false;
    }

    /**
     * Set the stepper to an integer. Should not be able to step further than log or less than 0.
     *
     * @param step = number between 0 and log length
     */
    public boolean setStep (int step) {

        if (step >= 0 && step <= this.log.size()) {
            this.step = step;
            return true;
        }

        return false;
    }

    /**
     * Returns the private stepper.
     *
     * @return = the stepper
     */
    public int getStep () {
        return this.step;
    }

    /**
     * Returns the private size.
     *
     * @return = the size
     */
    public int getSize () {
        return this.log.size();
    }

    /**
     * Returns the log as a list of moves.
     *
     * @return = a list of strings
     */
    public List<String> getLog () {
        return this.log;
    }

    /**
     * Returns the log as a string of moves.
     *
     * @return = a string
     */
    public String getLogFormatted () {
        return String.join(",", this.log);
    }

    /**
     * Returns the log as a string of moves with pointer at step.
     *
     * @return = a string
     */
    public String getLogFormatted (int step) {
        String formatted = "";
        for (int i = 0; i < log.size(); i++) {
            if (i == step) {
                formatted += "->";
            }

            formatted += log.get(i);

            if (i < log.size() - 1) {
                formatted += ",";
            }
        }
        return formatted;
    }

    /**
     * Sets the log and stepper.
     *
     * @param log = a list of moves
     * @param step = an integer between 0 and the log size
     */
    public void setLog (List<String> log, int step) {
        this.log = log;

        if (step >= 0) {
            if (step >= this.log.size()) {
                this.step = this.log.size();
            } else {
                this.step = step;
            }
        } else {
            this.step = 0;
        }
    }
}
