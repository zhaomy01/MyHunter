package com.example.dllo.myhunter.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/18.
 */
public class AllCityBean {

    private CityDataBean city_data;

    private List<SortDataBean> sort_data;


    private List<String> date_data;

    private List<TagDataBean> tag_data;

    public CityDataBean getCity_data() {
        return city_data;
    }

    public void setCity_data(CityDataBean city_data) {
        this.city_data = city_data;
    }

    public List<SortDataBean> getSort_data() {
        return sort_data;
    }

    public void setSort_data(List<SortDataBean> sort_data) {
        this.sort_data = sort_data;
    }

    public List<String> getDate_data() {
        return date_data;
    }

    public void setDate_data(List<String> date_data) {
        this.date_data = date_data;
    }

    public List<TagDataBean> getTag_data() {
        return tag_data;
    }

    public void setTag_data(List<TagDataBean> tag_data) {
        this.tag_data = tag_data;
    }

    public static class CityDataBean {
        private OverseaCityBean oversea_city;
        private DomesticCityBean domestic_city;

        public OverseaCityBean getOversea_city() {
            return oversea_city;
        }

        public void setOversea_city(OverseaCityBean oversea_city) {
            this.oversea_city = oversea_city;
        }

        public DomesticCityBean getDomestic_city() {
            return domestic_city;
        }

        public void setDomestic_city(DomesticCityBean domestic_city) {
            this.domestic_city = domestic_city;
        }

        public static class OverseaCityBean {
            private List<String> hot_city_list;
            /**
             * name : 澳大利亚
             * children : ["悉尼"]
             */

            private List<AllCityListBean> all_city_list;

            public List<String> getHot_city_list() {
                return hot_city_list;
            }

            public void setHot_city_list(List<String> hot_city_list) {
                this.hot_city_list = hot_city_list;
            }

            public List<AllCityListBean> getAll_city_list() {
                return all_city_list;
            }

            public void setAll_city_list(List<AllCityListBean> all_city_list) {
                this.all_city_list = all_city_list;
            }

            public static class AllCityListBean {
                private String name;
                private List<String> children;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<String> getChildren() {
                    return children;
                }

                public void setChildren(List<String> children) {
                    this.children = children;
                }
            }
        }

        public static class DomesticCityBean {
            private List<String> hot_city_list;
            /**
             * name : 北海
             * children : []
             */

            private List<AllCityListBean> all_city_list;

            public List<String> getHot_city_list() {
                return hot_city_list;
            }

            public void setHot_city_list(List<String> hot_city_list) {
                this.hot_city_list = hot_city_list;
            }

            public List<AllCityListBean> getAll_city_list() {
                return all_city_list;
            }

            public void setAll_city_list(List<AllCityListBean> all_city_list) {
                this.all_city_list = all_city_list;
            }

            public static class AllCityListBean {
                private String name;
                private List<?> children;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }
    }

    public static class SortDataBean {
        private int selected;
        private int id;
        private String name;

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TagDataBean {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
