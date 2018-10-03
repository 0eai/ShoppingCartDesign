package include.hash.shoppingcartdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import java.util.List;

import include.hash.shoppingcartdesign.CartActivity;
import include.hash.shoppingcartdesign.ProductDetailsActivity;
import include.hash.shoppingcartdesign.R;
import include.hash.shoppingcartdesign.model.Item;
import include.hash.shoppingcartdesign.viewholder.ItemViewHolder;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private List<Item> items;
    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        final Item item = items.get(position);
        try {
            Glide.with(holder.itemView.getContext()).load(item.getUrl()).into(holder.productImage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        holder.productName.setText(item.getName());
        holder.productDiscount.setText(String.valueOf(item.getDiscount()) + context.getResources().getString(R.string.off));
        holder.productPrice.setText(context.getResources().getString(R.string.rs).concat(String.valueOf((item.getMrp() - ((item.getDiscount() / 100.0) * item.getMrp())))));
        holder.productMrp.setText(context.getResources().getString(R.string.rs).concat(String.valueOf(item.getMrp())));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra(ProductDetailsActivity.EXTRA, item.getPID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
