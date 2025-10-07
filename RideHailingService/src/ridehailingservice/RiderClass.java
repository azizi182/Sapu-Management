/*
 * 
 */
package ridehailingservice;

public class RiderClass {
    
    private String name , id ;
            private String  available;

    public RiderClass(String name, String id, String available) {
        this.name = name;
        this.id = id;
        this.available = available;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    @Override
    public String toString() {
        return "RiderClass " + "name=" + name + ", id=" + id  ;
    }
    
    
    
}
