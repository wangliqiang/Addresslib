package com.app.addresslib.widget;

import com.app.addresslib.model.City;
import com.app.addresslib.model.County;
import com.app.addresslib.model.Province;

import java.util.List;

/**
 * Created by 王立强 on 2017/6/22.
 */

public interface AddressProvider {
    void provideProvinces(AddressReceiver<Province> addressReceiver);

    void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver);

    void provideCountiesWith(int ProvinceId, int cityId, AddressReceiver<County> addressReceiver);

    interface AddressReceiver<T> {
        void send(List<T> data);
    }
}
