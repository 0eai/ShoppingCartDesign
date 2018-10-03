package include.hash.shoppingcartdesign.model;

public class cartItem {
    private String pID;
    private int q;

    public cartItem(String pID, int q) {
        this.pID = pID;
        this.q = q;
    }

    public String getPID() {
        return pID;
    }

    public void setPID(String pID) {
        this.pID = pID;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

}
