package include.hash.shoppingcartdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import include.hash.shoppingcartdesign.Util.Util;
import include.hash.shoppingcartdesign.adapter.CartItemAdapter;
import include.hash.shoppingcartdesign.adapter.OrderSummaryAdapter;
import include.hash.shoppingcartdesign.model.cartItem;

public class OrderSummaryActivity extends AppCompatActivity   implements
        View.OnClickListener{

    private List<cartItem> itemList = new ArrayList<>();
    private OrderSummaryAdapter mAdapter;
    private RecyclerView recycler;

    private Button payButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        recycler = findViewById(R.id.recycler);
        payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(this);

        mAdapter = new OrderSummaryAdapter(Util.getCartList(), getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(mAdapter);
        payButton.setText("Pay Rs. " + Util.totalAllFromCart() + " On Delivery");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.payButton:
                pay();
                break;
        }
    }
    private void pay() {
        Util.removeAllFromCart();
        finish();
    }

    private void init() {

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
