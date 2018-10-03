package include.hash.shoppingcartdesign.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import include.hash.shoppingcartdesign.R;

public class OrderSummaryViewHolder extends RecyclerView.ViewHolder {
    public ImageView productImage;
    public TextView productName;
    public TextView productPrice;
    public TextView q;

    public OrderSummaryViewHolder(View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.product_img);
        productName = itemView.findViewById(R.id.product_name);
        productPrice = itemView.findViewById(R.id.total_price);
        q = itemView.findViewById(R.id.quantaty);
    }
}
