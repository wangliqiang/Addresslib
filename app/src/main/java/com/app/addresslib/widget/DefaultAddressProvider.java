package com.app.addresslib.widget;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.app.addresslib.model.Address;
import com.app.addresslib.model.City;
import com.app.addresslib.model.County;
import com.app.addresslib.model.Province;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王立强 on 2017/6/22.
 */

public class DefaultAddressProvider implements AddressProvider {

    Address address;

    public DefaultAddressProvider(Context context) {
        try {
            InputStreamReader isr = new InputStreamReader(context.getAssets().open("address.json"), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            address = JSON.parseObject(builder.toString(), Address.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void provideProvinces(AddressReceiver<Province> addressReceiver) {

        List<Province> provinceList = new ArrayList();
        for (int i = 0; i < address.getAddress().size(); i++) {
            Province province = new Province();
            province.id = i;
            province.name = address.getAddress().get(i).getName();
            provinceList.add(province);
        }
        addressReceiver.send(provinceList);
    }

    @Override
    public void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver) {
        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < address.getAddress().get(provinceId).getSub().size(); i++) {
            City city = new City();
            city.id = i;
            city.province_id = provinceId;
            city.name = address.getAddress().get(provinceId).getSub().get(i).getName();
            cityList.add(city);
        }
        addressReceiver.send(cityList);
    }

    @Override
    public void provideCountiesWith(int provinceId, int cityId, AddressReceiver<County> addressReceiver) {
        List<County> countyList = new ArrayList<>();
        for (int i = 0; i < address.getAddress().get(provinceId).getSub().get(cityId).getSub().size(); i++) {
            County county = new County();
            county.id = i;
            county.province_id = provinceId;
            county.city_id = cityId;
            county.name = address.getAddress().get(provinceId).getSub().get(cityId).getSub().get(i);
            countyList.add(county);
            Log.e("provinceId",provinceId+"");
            Log.e("cityId",cityId+"");
        }
        addressReceiver.send(countyList);
    }
}
