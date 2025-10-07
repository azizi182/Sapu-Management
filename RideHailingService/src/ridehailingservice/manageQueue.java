package ridehailingservice;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class manageQueue {

    private CustomerClass matchedCustomer, frontCustomer, cc;
    private Queue<CustomerClass> customerQueue;
    private RiderClass matchedRider, frontRider, rc;
    private Queue<RiderClass> riderQueue;
    private Queue<NodePair> queuePair;
    NodePair np;
    Database db;
    private static manageQueue inst = null;

    public static manageQueue getInst() {
        if (inst == null) {
            inst = new manageQueue();
        }
        return inst;
    }

    public manageQueue() {
        customerQueue = new LinkedList<>();
        riderQueue = new LinkedList<>();
        db = new Database();
        queuePair = new LinkedList<>();
    }

    //-------------------------------------------------------------------
    public Queue<CustomerClass> getCustomerQueue() {
        return customerQueue;
    }

    public void enqueueCustomer(CustomerClass newCustomer) {
        customerQueue.add(newCustomer);
    }

    public CustomerClass dequeueCustomer() {

        CustomerClass getCustomer = customerQueue.poll();
        return getCustomer;
    }

    public boolean isEmptyCustomer() {
        return customerQueue.isEmpty();
    }

    public CustomerClass getFrontC() {
        return customerQueue.peek();
    }

    //-------------------------------------------------------------------------------
    public Queue<RiderClass> getRiderQueue() {
        return riderQueue;
    }

    public void enqueueRider(RiderClass newRider) {
        riderQueue.add(newRider);
        // db.addRider(newRider);
    }

    public RiderClass dequeueRider() {

        RiderClass getRider = riderQueue.poll();
        return getRider;
    }

    public boolean isEmptyRider() {
        return riderQueue.isEmpty();
    }

    public RiderClass getFrontR() {
        return riderQueue.peek();
    }

    //------------------------------------------------------------------------------
    public void enqueuePair(NodePair newPair) {
        queuePair.add(newPair);
    }

    public void dequeuePair() {
        queuePair.poll();
    }

    public boolean isEmptyPair() {
        return queuePair.isEmpty();
    }

    //-------------------------------------------------------------------
    public String matching() {
        if (isEmptyRider()) {
            return "No rider available now";
        }

        matchedCustomer = dequeueCustomer();
        matchedRider = dequeueRider();

        return "your rider is " + np.getRc();

    }

    public String process() throws InterruptedException {

        String msg = "";

        np = new NodePair(matchedCustomer, matchedRider);
        enqueuePair(np);
        for (int i = np.getCc().getFare(); i > 0; i--) {
            Thread.sleep(1000);
            msg += "you will arive at " + i;
        }

        dequeuePair();
        enqueueRider(matchedRider);
        return msg;

    }

}
