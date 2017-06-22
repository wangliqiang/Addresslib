package com.app.addresslib.model;

import java.util.List;

/**
 * Created by 王立强 on 2017/6/21.
 */

public class Address {

    private List<AddressBean> address;

    public List<AddressBean> getAddress() {
        return address;
    }

    public void setAddress(List<AddressBean> address) {
        this.address = address;
    }

    public static class AddressBean {
        /**
         * name : 北京
         * sub : [{"name":"北京市","sub":["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","密云县","延庆县"],"zipcode":"100000"}]
         */

        private String name;
        private List<SubBean> sub;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubBean> getSub() {
            return sub;
        }

        public void setSub(List<SubBean> sub) {
            this.sub = sub;
        }

        public static class SubBean {
            /**
             * name : 北京市
             * sub : ["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","密云县","延庆县"]
             * zipcode : 100000
             */

            private String name;
            private String zipcode;
            private List<String> sub;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public List<String> getSub() {
                return sub;
            }

            public void setSub(List<String> sub) {
                this.sub = sub;
            }
        }
    }
}
