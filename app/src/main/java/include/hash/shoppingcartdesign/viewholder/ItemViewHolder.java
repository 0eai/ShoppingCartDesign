package include.hash.shoppingcartdesign.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import include.hash.shoppingcartdesign.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView productImage;
    public TextView productDiscount;
    public TextView productName;
    public TextView productPrice;
    public TextView productMrp;

    public ItemViewHolder(View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.product_img);
        productDiscount = itemView.findViewById(R.id.product_discount);
        productName = itemView.findViewById(R.id.product_name);
        productPrice = itemView.findViewById(R.id.product_price);
        productMrp = itemView.findViewById(R.id.product_mrp);
    }
}
