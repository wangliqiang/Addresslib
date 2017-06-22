package com.app.addresslib;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.app.addresslib.model.City;
import com.app.addresslib.model.County;
import com.app.addresslib.model.Province;
import com.app.addresslib.widget.BottomDialog;
import com.app.addresslib.widget.OnAddressSelectedListener;

public class MainActivity extends AppCompatActivity implements OnAddressSelectedListener {

    Button click;
    BottomDialog dialog;

    String provinceName;
    String cityName;
    String countyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new BottomDialog(MainActivity.this);
                dialog.setOnAddressSelectedListener(MainActivity.this);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setWindowAnimations(R.style.Animation_Bottom_Dialog);
                dialog.show();
            }
        });
    }

    @Override
    public void onAddressSelected(Province province, City city, County county) {
        provinceName = (province == null ? "" : province.name);
        cityName = (city == null ? "" : city.name);
        countyName = (county == null ? "" : county.name);
        dialog.dismiss();
        Log.e("content：", provinceName + cityName + countyName);
    }
}
