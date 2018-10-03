package include.hash.shoppingcartdesign.model;


public class Item {
    private String pID;
    private String imgUrl;
    private String name;
    private int discount;
    private int mrp;
    private String desc;

    public Item(String pID, String imgUrl, String name, int discout, int mrp, String desc) {
        this.pID = pID;
        this.imgUrl = imgUrl;
        this.name = name;
        this.discount = discout;
        this.mrp = mrp;
        this.desc = desc;
    }

    public String getPID() {
        return pID;
    }

    public void setPID(String pID) {
        this.pID = pID;
    }

    public String getUrl() {
        return imgUrl;
    }

    public void setUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }
}