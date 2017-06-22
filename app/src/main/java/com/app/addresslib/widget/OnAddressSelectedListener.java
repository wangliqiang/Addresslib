package com.app.addresslib.widget;

import com.app.addresslib.model.City;
import com.app.addresslib.model.County;
import com.app.addresslib.model.Province;

/**
 * Created by 王立强 on 2017/6/22.
 */

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county);
}
