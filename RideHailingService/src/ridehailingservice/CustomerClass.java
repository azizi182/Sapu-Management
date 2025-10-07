/*
 * 
 */
package ridehailingservice;

public class CustomerClass {

    private String name,number, pickup, pickoff;
    private int fare;

    public CustomerClass() {
    }

    public CustomerClass(String name, String number, String pickup, String pickoff,
             int fare) {
        this.name = name;
        this.number = number;
        this.pickup = pickup;
        this.pickoff = pickoff;
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String id) {
        this.number = id;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getPickoff() {
        return pickoff;
    }

    public void setPickoff(String pickoff) {
        this.pickoff = pickoff;
    }

    @Override
    public String toString() {
        return "CustomerClass{" + "name=" + name + ", number=" + number + ", pickup=" + pickup + ", pickoff=" + pickoff;
    }

}
