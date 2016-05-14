package eksamen;

/**
 * Created by Niklas on 14.05.2016.
 */
public class JellyBeanBox {
    private String flavor;
    private int beanCount;

    public void addBeans (int n) {
        this.setBeanCount(this.getBeanCount() + n);
    }

    public void removeBeans (int n) {
        this.setBeanCount(this.getBeanCount() - n);
    }

    public void setFlavor (String f) {
        this.flavor = f;
    }

    public void setBeanCount (int bc) {
        if (bc < 0) {
            throw new IllegalArgumentException("U cant set bean count to a negative number");
        }

        this.beanCount = bc;
    }

    public String getFlavor () {
        return this.flavor;
    }

    public int getBeanCount () {
        return this.beanCount;
    }

    @Override
    public String toString() {
        return this.getFlavor()+ " " + this.getBeanCount();
    }
}
