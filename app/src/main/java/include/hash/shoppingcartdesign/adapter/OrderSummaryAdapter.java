package include.hash.shoppingcartdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import include.hash.shoppingcartdesign.R;
import include.hash.shoppingcartdesign.Util.Util;
import include.hash.shoppingcartdesign.model.Item;
import include.hash.shoppingcartdesign.model.cartItem;
import include.hash.shoppingcartdesign.viewholder.OrderSummaryViewHolder;

public class OrderSummaryAdapter extends RecyclerView.Adapter<OrderSummaryViewHolder> {
    private List<cartItem> items;
    private Context context;

    public OrderSummaryAdapter(List<cartItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public OrderSummaryViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_summary_item, parent, false);
        return new OrderSummaryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final OrderSummaryViewHolder holder, final int position) {
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
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
