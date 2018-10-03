package include.hash.shoppingcartdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import include.hash.shoppingcartdesign.Util.Util;
import include.hash.shoppingcartdesign.model.Item;

public class ProductDetailsActivity extends AppCompatActivity implements
        View.OnClickListener {

    public static final String EXTRA = "EXTRA";
    private String extra;
    private Button addToCart;
    private ImageView imageView;
    private TextView name;
    private TextView discount;
    private TextView mrp;
    private TextView price;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
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

        addToCart = findViewById(R.id.add_to_cart);
        imageView = findViewById(R.id.product_img);
        name = findViewById(R.id.product_name);
        discount = findViewById(R.id.product_discount);
        mrp = findViewById(R.id.product_mrp);
        price = findViewById(R.id.product_price);
        desc = findViewById(R.id.product_desc);

        addToCart.setOnClickListener(this);
        extra = getIntent().getStringExtra(EXTRA);
        if (extra == null) {
            throw new IllegalArgumentException("Must pass EXTRA");
        }
        init(extra);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {
            startActivity(new Intent(ProductDetailsActivity.this, CartActivity.class));
            return true;
        }
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_cart:
                add2Cart(extra);
                addToCart.setEnabled(false);
                break;
        }
    }

    private void add2Cart(String id) {
        Util.add2Cart(id);
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }

    private void init(String id) {
        Item item = Util.getItem(id);
        try {
            Glide.with(ProductDetailsActivity.this).load(item.getUrl()).into(imageView);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        name.setText(item.getName());
        discount.setText(String.valueOf(item.getDiscount()) + getResources().getString(R.string.off));
        mrp.setText(getResources().getString(R.string.rs).concat(String.valueOf(item.getMrp())));
        price.setText(getResources().getString(R.string.rs).concat(String.valueOf((item.getMrp() - ((item.getDiscount() / 100.0) * item.getMrp())))));
        desc.setText(item.getDesc());

        if (Util.checkItemInCart(id)) {
            addToCart.setEnabled(false);
        }
    }
}
