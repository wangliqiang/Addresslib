package com.app.addresslib.model;

import java.util.List;

/**
 * Created by 王立强 on 2017/6/22.
 */

public class Lists {
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean notEmpty(List list) {
        return list != null && list.size() > 0;
    }
}
