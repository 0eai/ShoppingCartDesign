package include.hash.shoppingcartdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import include.hash.shoppingcartdesign.CartActivity;
import include.hash.shoppingcartdesign.R;
import include.hash.shoppingcartdesign.Util.Util;
import include.hash.shoppingcartdesign.model.Item;
import include.hash.shoppingcartdesign.model.cartItem;
import include.hash.shoppingcartdesign.viewholder.CartItemViewHolder;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder> {
    private List<cartItem> items;
    private Context context;

    public CartItemAdapter(List<cartItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CartItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final CartItemViewHolder holder, final int position) {
        final cartItem cartItem = items.get(position);
        final Item item = Util.getItem(cartItem.getPID());
        try {
            Glide.with(holder.itemView.getContext()).load(item.getUrl()).into(holder.productImage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        holder.productName.setText(item.getName());
        final double price = item.getMrp() - (item.getDiscount() / 100.0 * item.getMrp());
        holder.productPrice.setText(context.getResources().getString(R.string.rs).concat(String.valueOf(price * cartItem.getQ())));
        holder.q.setText(String.valueOf(cartItem.getQ()));
        holder.qMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ctr = Integer.parseInt(holder.q.getText().toString());
                if (ctr > 1) {
                    holder.q.setText(String.valueOf(ctr - 1));
                    Util.minusQ(Integer.parseInt(holder.q.getText().toString()) - 1, item.getPID());
                    holder.productPrice.setText(String.valueOf(price * (ctr - 1)));
                }

            }
        });
        holder.qPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ctr = Integer.parseInt(holder.q.getText().toString());
                holder.q.setText(String.valueOf(ctr + 1));
                Util.plusQ(Integer.parseInt(holder.q.getText().toString()) + 1, item.getPID());
                holder.productPrice.setText(String.valueOf(price * (ctr + 1)));
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.removeFromCart(item.getPID());
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Item removed from cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
