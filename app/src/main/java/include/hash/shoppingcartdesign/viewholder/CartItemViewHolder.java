package include.hash.shoppingcartdesign.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import include.hash.shoppingcartdesign.R;

public class CartItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView productImage;
    public TextView productName;
    public TextView productPrice;
    public ImageView qPlus;
    public ImageView qMinus;
    public TextView q;
    public ImageView remove;

    public CartItemViewHolder(View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.product_img);
        productName = itemView.findViewById(R.id.product_name);
        productPrice = itemView.findViewById(R.id.product_price);
        q = itemView.findViewById(R.id.quantaty);
        qPlus = itemView.findViewById(R.id.plus_q);
        qMinus = itemView.findViewById(R.id.minus_q);
        remove = itemView.findViewById(R.id.remove_from_cart);
    }
}
