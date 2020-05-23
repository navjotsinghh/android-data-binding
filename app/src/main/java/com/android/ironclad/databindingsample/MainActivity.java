package com.android.ironclad.databindingsample;

import android.os.Bundle;

import com.android.ironclad.databindingsample.databinding.ActivityMainBinding;
import com.android.ironclad.databindingsample.models.Product;
import com.android.ironclad.databindingsample.util.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    // data binding
    ActivityMainBinding mBinding;

    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Products products = new Products();
        mProduct = products.PRODUCTS[0];

        mBinding.setProduct(mProduct);

        mBinding.setIMainActivity(this);
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog chooseQuantityDialog = new ChooseQuantityDialog();
        chooseQuantityDialog.show(getSupportFragmentManager(), getString(R.string.dialog_quantity_title));
    }

    @Override
    public void chooseQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }
}
