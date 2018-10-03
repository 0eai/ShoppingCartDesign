package include.hash.shoppingcartdesign.Util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import include.hash.shoppingcartdesign.model.Item;
import include.hash.shoppingcartdesign.model.cartItem;

public class Util {
    private static List<Item> itemList = new ArrayList<>();
    private static List<cartItem> cartList = new ArrayList<>();

    public static void init() {
        if (itemList.isEmpty()) {
            itemList.add(new Item("1", "https://images-na.ssl-images-amazon.com/images/I/71B7mMk-TzL._SL1500_.jpg", "Kingston DataTraveler SE9 16GB USB 2.0 Flash Drive (Gray)", 37, 650, "Kingston's DataTraveler SE9 USB Flash drive has a stylish metal casing with a large ring so it will attach easily. The small form factor makes it a great accessory for notebooks like Intel's new Ultrabook as well as tablets that offer USB ports. Its durable casing lets users securely carry this drive everywhere they go with their new devices. DataTraveler SE9 is covered by a five-year warranty, free technical support and legendary Kingston reliability. "));
            itemList.add(new Item("2", "https://images-na.ssl-images-amazon.com/images/I/613Dk%2BctMSL._SL1500_.jpg", "SanDisk Cruzer Blade 32GB USB Flash Drive ", 37, 800, "It's the small, swift way to save and transfer your digital content from computer to computer, or take it on-the-go. Simply store your pictures, music and other fun files onto the sleek Cruzer Blade USB flash drive and start sharing with your family and friends. You can also protect files on your USB flash drive from unauthorized access with the SanDisk Secure Access software and enjoy the added protection of secure online backup (up to 2GB optionally available) offered by YuuWaa."));
            itemList.add(new Item("3", "https://images-na.ssl-images-amazon.com/images/I/61Dy-4trcyL._SL1500_.jpg", "HP v236w 16GB USB 2.0 Pen Drive ", 47, 750, "This pen drive from HP is designed to be your ideal companion for taking important files with you on the go. The small and compact device offers a storage capacity of up to 16GB. This powerful drive transfers files in a blink of an eye. It is an extremely small device yet, delivers high- end speed, capacity, durability, and connectivity in a truly compact design. "));
            itemList.add(new Item("4", "https://images-na.ssl-images-amazon.com/images/I/613Dk%2BctMSL._SL1500_.jpg", "Sony 16GB USB Metal Pendrive (Silver) ", 45, 725, "The pen drive comes with a metallic body and a strap hole and a matte plastic grip for comfortable usage and carrying. It gives the pen drive durability due to metallic outer body casing. "));
            itemList.add(new Item("5", "https://images-na.ssl-images-amazon.com/images/I/613Dk%2BctMSL._SL1500_.jpg", "SanDisk Ultra Dual 32GB USB 3.0 OTG Pen Drive", 46, 1290, "The SanDisk Ultra Dual Drive m3.0 makes it easy to transfer content from your phone to your computer. With a micro-USB connector on one end and a USB 3.0 connector on the other, the drive lets you move content easily between your devices-from your AndroidTM smartphone or tablet to your laptop, PC or Mac computer1. The USB 3.0 connector is high-performance and backward-compatible with USB 2.0 ports. The SanDisk Memory Zone app2 for Android (available on Google Play) helps you manage your device's memory. "));
            itemList.add(new Item("6", "https://images-na.ssl-images-amazon.com/images/I/71OuOiQttxL._SL1500_.jpg", "Kingston DataTraveler 32GB USB 3.0 Flash Drive (Gray) ", 37, 900, "DataTraveler 50 is a lightweight USB Flash drive available in capacities from 8GB to 128GB. The drive’s compact, cap less design features a metal casing that complements any compatible device and colorful accents that range by drive capacity. Backward compatible with existing USB 2.0 ports for convenience, this USB 3.1 Gen 1 (USB 3.0) drive ensures easy data transfer between devices. DT 50 is backed by a five-year warranty, free technical support and legendary Kingston reliability. "));
        }
    }

    public static Item getItem(String id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getPID().equals(id)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public static void add2Cart(String id) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getPID().equals(id)) {
                return;
            }
        }
        cartList.add(new cartItem(id, 1));
    }

    public static boolean checkItemInCart(String id) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getPID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static List<cartItem> getCart() {
        return cartList;
    }

    public static void plusQ(int q, String id) {
        cartItem item = new cartItem(id, q);
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getPID().equals(id)) {
                //cartList.set(i, item);
                cartList.remove(i);
                cartList.add(i, item);
            }
        }
    }

    public static void minusQ(int q, String id) {
        cartItem item = new cartItem(id, q);
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getPID().equals(id)) {
                //cartList.set(i, item);
                cartList.remove(i);
                cartList.add(i, item);
            }
        }
    }

    public static void removeFromCart(String id) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getPID().equals(id)) {
                cartList.remove(i);
            }
        }
    }

    public static void removeAllFromCart() {
        for (int i = cartList.size() - 1; i >= 0; i--) {
            cartList.remove(i);
        }
    }

    public static double totalAllFromCart() {
        double total = 0.0;
        for (int i = 0; i < cartList.size(); i++) {
            Item item = getItem(cartList.get(i).getPID());
            final double price = item.getMrp() - (item.getDiscount() / 100.0 * item.getMrp());
            total = total + (price * cartList.get(i).getQ());
        }
        return total;
    }

    public static List<Item> getItemList() {
        return itemList;
    }

    public static List<cartItem> getCartList() {
        return cartList;
    }
}
