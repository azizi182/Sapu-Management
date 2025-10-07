/*
 * 
 */
package ridehailingservice;

public class NodePair {

    private CustomerClass cc;
    private RiderClass rc;
    
    public NodePair(CustomerClass cc , RiderClass rc){
        this.cc = cc;
        this.rc = rc;
    }

    public CustomerClass getCc() {
        return cc;
    }

    public void setCc(CustomerClass cc) {
        this.cc = cc;
    }

    public RiderClass getRc() {
        return rc;
    }

    public void setRc(RiderClass rc) {
        this.rc = rc;
    }

}
