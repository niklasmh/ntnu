package eksamen;

/**
 * Created by Niklas on 14.05.2016.
 */
public class Start {
    public static void main (String[] args) {
        JellyBeanBox j1 = new JellyBeanBox();
        j1.setFlavor("B");
        j1.setBeanCount(0);

        JellyBeanBox j2 = new JellyBeanBox();
        j2.setFlavor("CC");
        j2.setBeanCount(0);

        System.out.println(j1);
        System.out.println(j2);


        j1.addBeans(15);
        j1.removeBeans(5);
        j2.addBeans(100);
        j1.addBeans(10);
        j2.removeBeans(20);

        System.out.println(j1);
        System.out.println(j2);

        JellyBeanCustomer nils = new JellyBeanCustomer(1, "niels");
        JellyBeanCustomer ole = new JellyBeanCustomer(2, "ole");

        System.out.println(nils);
        System.out.println(ole);

        nils.orderBeans(2000);
        nils.orderBeans(60);
        ole.orderBeans(50);
        ole.orderBeans(50);
        ole.orderBeans(50);
        ole.orderBeans(50);

        System.out.println(nils);
        System.out.println(ole);
    }
}
