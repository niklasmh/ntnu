package sudokuv2;

public class Field {
    public int val, type; // Types: 1 - placed, 2 - input

    public Field() {
        this(0, 2);
    }

    public Field(int val, int type) {
        this.val = val;
        this.type = type;
    }

    public boolean setField(int val) {

        if (type != 1) {

            if (val >= 0 && val < 10) {
                this.val = val;

                return true;
            } else {
                throw new IllegalStateException("Not a number between 0-9.");
            }
        }

        return false;
    }

    public int getVal() {
        return val;
    }

    public int getType() {
        return type;
    }

    public String toString() {

        String print = "";

        if (getType() == 2 && getVal() == 0) {
            print += " . ";
        } else if (getType() == 2) {
            print += " " + getVal() + "";
        } else if (getType() == 1) {
            print += "(" + getVal() + ")";
        }

        return print;
    }
}
