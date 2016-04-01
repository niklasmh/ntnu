package sudokuv2;

public class Field {
    public int val, type; /** Types: 1 -> placed, 2 -> input */

    /**
     * Empty contructor with default 0 as value and 2 as default (input).
     */
    public Field() {
        this(0, 2);
    }

    /**
     * Contructor setting the val and type when creating the board.
     *
     * @param val = value of the field
     * @param type = one of the three states of the field: empty (val not mattering), placed and input
     */
    public Field(int val, int type) {
        this.val = val;
        this.type = type;
    }

    /**
     * Sets a field and returns true if the process was successful.
     *
     * @param val = a value between 0-9
     * @return = true if success
     */
    public boolean setField(int val) {

        if (this.type != 1) {

            if (val >= 0 && val < 10) {
                this.val = val;

                return true;
            } else {
                throw new IllegalStateException("Not a number between 0-9.");
            }
        }

        return false;
    }

    /**
     * Returns the val.
     *
     * @return = the private val
     */
    public int getVal() {
        return this.val;
    }

    /**
     * Returns the type.
     *
     * @return = the private type
     */
    public int getType() {
        return this.type;
    }

    /**
     * Returns a string block defining the field.
     * (x) -> default
     *  x  -> input
     *  .  -> empty
     *
     * @return = string of the block
     */
    public String toString() {

        if (this.getType() == 2 && this.getVal() == 0) {
            return " . ";
        } else if (this.getType() == 2) {
            return " " + this.getVal() + "";
        } else if (this.getType() == 1) {
            return "(" + this.getVal() + ")";
        }

        return "";
    }
}
