package com.redoop.modules.admin.tea.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/18.
 */
@Entity
@Table(name = "tea")
public class Tea implements Serializable{

        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        private String      id;             //ID
        private String      process;      //"选中→种植→采摘→加工→包装→物流→评价"
        private String      grade;        //外形：芽头饱满,芽叶齐匀；汤色：清澈明亮，色泽柔和；叶底：芽软鲜活，黄绿鲜嫩
        private String      suggest;           //温杯：用开水洗净茶具；投茶:把茶叶投入洗净的杯中；
        private String      production;        //贵州安顺春来茶业有限公司"）
        private String      environment;          //"植被指数0.5，湿度指数0.5，土壤指数0.8"
        private String      air;         //综合指数2.9，优良率96.3%",
        private String      water;     //"根据《地表水环境质量标准》（GB3838-2002）评价标准，水质达到二级标准",

        private String      soil;         //"PH值在5.8-6.8之间，偏酸性的黄壤地适宜茶树的生长",
        private String      mineral;    //"铜：20.59，锌：52.03，铬：0.35，钴：0.0813，镍：15.17，

        private  String   img; // "../enviroment.png"

        private String  weather;
        /*private String temp;    //"22"

        private String  humidity;       //:"67%"
        private String  UVintensity;    //最弱
        private String  windDirection;  //北风3级
        private String  pha;       //1017pha
        private String  high;   //高温24°C
        private String  type;   //晴
        private String  low;    //低温11°C
        private String  date;   //3日星期六
*/

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getProcess() {
                return process;
        }

        public void setProcess(String process) {
                this.process = process;
        }

        public String getGrade() {
                return grade;
        }

        public void setGrade(String grade) {
                this.grade = grade;
        }



        public String getSuggest() {
                return suggest;
        }

        public void setSuggest(String suggest) {
                this.suggest = suggest;
        }

        public String getProduction() {
                return production;
        }

        public void setProduction(String production) {
                this.production = production;
        }

        public String getEnvironment() {
                return environment;
        }

        public void setEnvironment(String environment) {
                this.environment = environment;
        }

        public String getAir() {
                return air;
        }

        public void setAir(String air) {
                this.air = air;
        }

        public String getWater() {
                return water;
        }

        public void setWater(String water) {
                this.water = water;
        }

        public String getSoil() {
                return soil;
        }

        public void setSoil(String soil) {
                this.soil = soil;
        }

        public String getMineral() {
                return mineral;
        }

        public void setMineral(String mineral) {
                this.mineral = mineral;
        }

        public String getImg() {
                return img;
        }

        public void setImg(String img) {
                this.img = img;
        }

        public String getWeather() {
                return weather;
        }

        public void setWeather(String weather) {
                this.weather = weather;
        }

        @Override
        public String toString() {
                return "Tea{" +
                        "id='" + id + '\'' +
                        ", process='" + process + '\'' +
                        ", grade='" + grade + '\'' +
                        ", suggest='" + suggest + '\'' +
                        ", production='" + production + '\'' +
                        ", environment='" + environment + '\'' +
                        ", air='" + air + '\'' +
                        ", water='" + water + '\'' +
                        ", soil='" + soil + '\'' +
                        ", mineral='" + mineral + '\'' +
                        ", img='" + img + '\'' +
                        ", weather='" + weather + '\'' +
                        '}';
        }
}
