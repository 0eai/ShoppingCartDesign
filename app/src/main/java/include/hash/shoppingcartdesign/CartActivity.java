package include.hash.shoppingcartdesign;

import android.content.Intent;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import include.hash.shoppingcartdesign.Util.Util;
import include.hash.shoppingcartdesign.adapter.CartItemAdapter;
import include.hash.shoppingcartdesign.adapter.ItemAdapter;
import include.hash.shoppingcartdesign.model.Item;
import include.hash.shoppingcartdesign.model.cartItem;

public class CartActivity extends AppCompatActivity implements
        View.OnClickListener {

    private List<cartItem> itemList = new ArrayList<>();
    private CartItemAdapter mAdapter;
    private RecyclerView recycler;

    private Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                VectorDrawableCompat indicator
                        = VectorDrawableCompat.create(getResources(), R.drawable.arrow_left, getTheme());
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(true);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setHomeAsUpIndicator(indicator);
            }
        }

        recycler = findViewById(R.id.cart_recycler);
        checkout = findViewById(R.id.checkout_button);
        checkout.setOnClickListener(this);

        mAdapter = new CartItemAdapter(Util.getCartList(), getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkout_button:
                if (Util.getCartList().size() > 0) {
                    startActivity(new Intent(CartActivity.this, OrderSummaryActivity.class));
                } else {
                    Toast.makeText(this, "Cart is empty.\n Add item to cart", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
