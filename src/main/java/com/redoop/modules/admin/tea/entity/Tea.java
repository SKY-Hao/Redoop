package com.redoop.modules.admin.tea.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* Created by Administrator on 2018/5/18.
 * 可以删除TODO
 *
*/
@Entity
@Table(name = "tea")
public class Tea implements Serializable{

        @Id
        @GeneratedValue
        private String      id;
        private String      process;            //"选中→种植→采摘→加工→包装→物流→评价"
        private String      gradeshape;         //外形：芽头饱满,芽叶齐匀；
        private String      gradeodor;          //气味
        private String      gradeleaf;          //叶底：芽软鲜活，黄绿鲜嫩
        private String      gradetime;          //时间
        private String      gradesoupcolor;     //汤色：清澈明亮，色泽柔和；
        private String      sugwarmcup;         //温杯：用开水洗净茶具
        private String      sugtea;             //投茶：把茶叶投入洗净的杯中
        private String      sugwater;           //注水：把开水提高冲入水中
        private String      sugtaste;           //品茗：先嗅其香在品其味
        private String      production;         //贵州安顺春来茶业有限公司"）
        private String      environment;        //"植被指数0.5，湿度指数0.5，土壤指数0.8"

        private String      air;                //空气洁净指数：综合指数2.9，优良率96.3%"
        private String      water;              //水源清洁指数："根据《地表水环境质量标准》（GB3838-2002）评价标准，水质达到二级标准"
        private String      soil;               //土壤肥沃指数"PH值在5.8-6.8之间，偏酸性的黄壤地适宜茶树的生长"

        private String      img;                // "../enviroment.png"
        private String      weather;            //天气
        private String      ethhash;            //区块链hash
        private String      date;               //采摘时间

        private String      address;            //种植区域
        private String      iron;               //铁
        private String      zinc;               //锌
        private String      slightly;           //咯
        private String      cobalt;             //钴
        private String      nickel;             //镍
        private String      molybdenum;         //钼
        private String      lead;               //铅
        private String      rareearth;          //稀土

        //当时天气
        private String  thenbest;//最佳天气
        private String	temperature;//温度
        private String  thenhumidity;//湿度
        private String	thenultraviolet;//紫外线
        private String	thenwind;//风力
        private String	thenpress;//气压


        //采摘前后天气
        private String frontone;//第一天
        private String fronttwo;
        private String thenday;
        private String laterfour;
        private String laterfive;

        private String monthone;//第一天月份
        private String monthtwo;
        private String thenmonth;
        private String monthfour;
        private String monthfive;

        private String stateone;//第一天天气状况
        private String statetwo;
        private String thenstate;
        private String statefour;
        private String statefive;

        private String imgone;	//早上图片
        private String imgtwo;
        private String imgthen;
        private String imgfour;
        private String imgfive;

        private String highwdone;	//最高温度
        private String highwdtwo;
        private String highwdthen;
        private String highwdfour;
        private String highwdfive;

        private String lowwdone;	//最低温度
        private String lowwdtwo;
        private String lowwdthen;
        private String lowwdfour;
        private String lowwdfive;

        private String imgnightone;	//晚上图片
        private String imgnighttwo;
        private String imgnightthen;
        private String imgnightfour;
        private String imgnightfive;

        private String  directionone;//风向
        private String  directiontwo;
        private String  directionthen;
        private String  directionfour;
        private String  directionfive;

        private String  winpowerone;	//风力
        private String  winpowertwo;
        private String  winpowerthen;
        private String  winpowerfour;
        private String  winpowerfive;


        private String  statesone;	//优良状况
        private String  statestwo;
        private String  statesthen;
        private String  statesfour;
        private String  statesfive;


        private String altitude;        //海拔
        private String rainfall;        //降水量
        private String ph;              //PH
        private String land;            //土地特征
        private String surroundings;    //周围环境

        @Override
        public String toString() {
                return "Tea{" +
                        "id=" + id +
                        ", process='" + process + '\'' +
                        ", gradeshape='" + gradeshape + '\'' +
                        ", gradeodor='" + gradeodor + '\'' +
                        ", gradeleaf='" + gradeleaf + '\'' +
                        ", gradetime='" + gradetime + '\'' +
                        ", gradesoupcolor='" + gradesoupcolor + '\'' +
                        ", sugwarmcup='" + sugwarmcup + '\'' +
                        ", sugtea='" + sugtea + '\'' +
                        ", sugwater='" + sugwater + '\'' +
                        ", sugtaste='" + sugtaste + '\'' +
                        ", production='" + production + '\'' +
                        ", environment='" + environment + '\'' +
                        ", air='" + air + '\'' +
                        ", water='" + water + '\'' +
                        ", soil='" + soil + '\'' +
                        ", img='" + img + '\'' +
                        ", weather='" + weather + '\'' +
                        ", ethhash='" + ethhash + '\'' +
                        ", date='" + date + '\'' +
                        ", address='" + address + '\'' +
                        ", iron='" + iron + '\'' +
                        ", zinc='" + zinc + '\'' +
                        ", slightly='" + slightly + '\'' +
                        ", cobalt='" + cobalt + '\'' +
                        ", nickel='" + nickel + '\'' +
                        ", molybdenum='" + molybdenum + '\'' +
                        ", lead='" + lead + '\'' +
                        ", rareearth='" + rareearth + '\'' +
                        ", thenbest='" + thenbest + '\'' +
                        ", temperature='" + temperature + '\'' +
                        ", thenhumidity='" + thenhumidity + '\'' +
                        ", thenultraviolet='" + thenultraviolet + '\'' +
                        ", thenwind='" + thenwind + '\'' +
                        ", thenpress='" + thenpress + '\'' +
                        ", frontone='" + frontone + '\'' +
                        ", fronttwo='" + fronttwo + '\'' +
                        ", thenday='" + thenday + '\'' +
                        ", laterfour='" + laterfour + '\'' +
                        ", laterfive='" + laterfive + '\'' +
                        ", monthone='" + monthone + '\'' +
                        ", monthtwo='" + monthtwo + '\'' +
                        ", thenmonth='" + thenmonth + '\'' +
                        ", monthfour='" + monthfour + '\'' +
                        ", monthfive='" + monthfive + '\'' +
                        ", stateone='" + stateone + '\'' +
                        ", statetwo='" + statetwo + '\'' +
                        ", thenstate='" + thenstate + '\'' +
                        ", statefour='" + statefour + '\'' +
                        ", statefive='" + statefive + '\'' +
                        ", imgone='" + imgone + '\'' +
                        ", imgtwo='" + imgtwo + '\'' +
                        ", imgthen='" + imgthen + '\'' +
                        ", imgfour='" + imgfour + '\'' +
                        ", imgfive='" + imgfive + '\'' +
                        ", highwdone='" + highwdone + '\'' +
                        ", highwdtwo='" + highwdtwo + '\'' +
                        ", highwdthen='" + highwdthen + '\'' +
                        ", highwdfour='" + highwdfour + '\'' +
                        ", highwdfive='" + highwdfive + '\'' +
                        ", lowwdone='" + lowwdone + '\'' +
                        ", lowwdtwo='" + lowwdtwo + '\'' +
                        ", lowwdthen='" + lowwdthen + '\'' +
                        ", lowwdfour='" + lowwdfour + '\'' +
                        ", lowwdfive='" + lowwdfive + '\'' +
                        ", imgnightone='" + imgnightone + '\'' +
                        ", imgnighttwo='" + imgnighttwo + '\'' +
                        ", imgnightthen='" + imgnightthen + '\'' +
                        ", imgnightfour='" + imgnightfour + '\'' +
                        ", imgnightfive='" + imgnightfive + '\'' +
                        ", directionone='" + directionone + '\'' +
                        ", directiontwo='" + directiontwo + '\'' +
                        ", directionthen='" + directionthen + '\'' +
                        ", directionfour='" + directionfour + '\'' +
                        ", directionfive='" + directionfive + '\'' +
                        ", winpowerone='" + winpowerone + '\'' +
                        ", winpowertwo='" + winpowertwo + '\'' +
                        ", winpowerthen='" + winpowerthen + '\'' +
                        ", winpowerfour='" + winpowerfour + '\'' +
                        ", winpowerfive='" + winpowerfive + '\'' +
                        ", statesone='" + statesone + '\'' +
                        ", statestwo='" + statestwo + '\'' +
                        ", statesthen='" + statesthen + '\'' +
                        ", statesfour='" + statesfour + '\'' +
                        ", statesfive='" + statesfive + '\'' +
                        ", altitude='" + altitude + '\'' +
                        ", rainfall='" + rainfall + '\'' +
                        ", ph='" + ph + '\'' +
                        ", land='" + land + '\'' +
                        ", surroundings='" + surroundings + '\'' +
                        '}';
        }

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

        public String getGradeshape() {
                return gradeshape;
        }

        public void setGradeshape(String gradeshape) {
                this.gradeshape = gradeshape;
        }

        public String getGradeodor() {
                return gradeodor;
        }

        public void setGradeodor(String gradeodor) {
                this.gradeodor = gradeodor;
        }

        public String getGradeleaf() {
                return gradeleaf;
        }

        public void setGradeleaf(String gradeleaf) {
                this.gradeleaf = gradeleaf;
        }

        public String getGradetime() {
                return gradetime;
        }

        public void setGradetime(String gradetime) {
                this.gradetime = gradetime;
        }

        public String getGradesoupcolor() {
                return gradesoupcolor;
        }

        public void setGradesoupcolor(String gradesoupcolor) {
                this.gradesoupcolor = gradesoupcolor;
        }

        public String getSugwarmcup() {
                return sugwarmcup;
        }

        public void setSugwarmcup(String sugwarmcup) {
                this.sugwarmcup = sugwarmcup;
        }

        public String getSugtea() {
                return sugtea;
        }

        public void setSugtea(String sugtea) {
                this.sugtea = sugtea;
        }

        public String getSugwater() {
                return sugwater;
        }

        public void setSugwater(String sugwater) {
                this.sugwater = sugwater;
        }

        public String getSugtaste() {
                return sugtaste;
        }

        public void setSugtaste(String sugtaste) {
                this.sugtaste = sugtaste;
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

        public String getEthhash() {
                return ethhash;
        }

        public void setEthhash(String ethhash) {
                this.ethhash = ethhash;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getIron() {
                return iron;
        }

        public void setIron(String iron) {
                this.iron = iron;
        }

        public String getZinc() {
                return zinc;
        }

        public void setZinc(String zinc) {
                this.zinc = zinc;
        }

        public String getSlightly() {
                return slightly;
        }

        public void setSlightly(String slightly) {
                this.slightly = slightly;
        }

        public String getCobalt() {
                return cobalt;
        }

        public void setCobalt(String cobalt) {
                this.cobalt = cobalt;
        }

        public String getNickel() {
                return nickel;
        }

        public void setNickel(String nickel) {
                this.nickel = nickel;
        }

        public String getMolybdenum() {
                return molybdenum;
        }

        public void setMolybdenum(String molybdenum) {
                this.molybdenum = molybdenum;
        }

        public String getLead() {
                return lead;
        }

        public void setLead(String lead) {
                this.lead = lead;
        }

        public String getRareearth() {
                return rareearth;
        }

        public void setRareearth(String rareearth) {
                this.rareearth = rareearth;
        }

        public String getThenbest() {
                return thenbest;
        }

        public void setThenbest(String thenbest) {
                this.thenbest = thenbest;
        }

        public String getTemperature() {
                return temperature;
        }

        public void setTemperature(String temperature) {
                this.temperature = temperature;
        }

        public String getThenhumidity() {
                return thenhumidity;
        }

        public void setThenhumidity(String thenhumidity) {
                this.thenhumidity = thenhumidity;
        }

        public String getThenultraviolet() {
                return thenultraviolet;
        }

        public void setThenultraviolet(String thenultraviolet) {
                this.thenultraviolet = thenultraviolet;
        }

        public String getThenwind() {
                return thenwind;
        }

        public void setThenwind(String thenwind) {
                this.thenwind = thenwind;
        }

        public String getThenpress() {
                return thenpress;
        }

        public void setThenpress(String thenpress) {
                this.thenpress = thenpress;
        }

        public String getFrontone() {
                return frontone;
        }

        public void setFrontone(String frontone) {
                this.frontone = frontone;
        }

        public String getFronttwo() {
                return fronttwo;
        }

        public void setFronttwo(String fronttwo) {
                this.fronttwo = fronttwo;
        }

        public String getThenday() {
                return thenday;
        }

        public void setThenday(String thenday) {
                this.thenday = thenday;
        }

        public String getLaterfour() {
                return laterfour;
        }

        public void setLaterfour(String laterfour) {
                this.laterfour = laterfour;
        }

        public String getLaterfive() {
                return laterfive;
        }

        public void setLaterfive(String laterfive) {
                this.laterfive = laterfive;
        }

        public String getMonthone() {
                return monthone;
        }

        public void setMonthone(String monthone) {
                this.monthone = monthone;
        }

        public String getMonthtwo() {
                return monthtwo;
        }

        public void setMonthtwo(String monthtwo) {
                this.monthtwo = monthtwo;
        }

        public String getThenmonth() {
                return thenmonth;
        }

        public void setThenmonth(String thenmonth) {
                this.thenmonth = thenmonth;
        }

        public String getMonthfour() {
                return monthfour;
        }

        public void setMonthfour(String monthfour) {
                this.monthfour = monthfour;
        }

        public String getMonthfive() {
                return monthfive;
        }

        public void setMonthfive(String monthfive) {
                this.monthfive = monthfive;
        }

        public String getStateone() {
                return stateone;
        }

        public void setStateone(String stateone) {
                this.stateone = stateone;
        }

        public String getStatetwo() {
                return statetwo;
        }

        public void setStatetwo(String statetwo) {
                this.statetwo = statetwo;
        }

        public String getThenstate() {
                return thenstate;
        }

        public void setThenstate(String thenstate) {
                this.thenstate = thenstate;
        }

        public String getStatefour() {
                return statefour;
        }

        public void setStatefour(String statefour) {
                this.statefour = statefour;
        }

        public String getStatefive() {
                return statefive;
        }

        public void setStatefive(String statefive) {
                this.statefive = statefive;
        }

        public String getImgone() {
                return imgone;
        }

        public void setImgone(String imgone) {
                this.imgone = imgone;
        }

        public String getImgtwo() {
                return imgtwo;
        }

        public void setImgtwo(String imgtwo) {
                this.imgtwo = imgtwo;
        }

        public String getImgthen() {
                return imgthen;
        }

        public void setImgthen(String imgthen) {
                this.imgthen = imgthen;
        }

        public String getImgfour() {
                return imgfour;
        }

        public void setImgfour(String imgfour) {
                this.imgfour = imgfour;
        }

        public String getImgfive() {
                return imgfive;
        }

        public void setImgfive(String imgfive) {
                this.imgfive = imgfive;
        }

        public String getHighwdone() {
                return highwdone;
        }

        public void setHighwdone(String highwdone) {
                this.highwdone = highwdone;
        }

        public String getHighwdtwo() {
                return highwdtwo;
        }

        public void setHighwdtwo(String highwdtwo) {
                this.highwdtwo = highwdtwo;
        }

        public String getHighwdthen() {
                return highwdthen;
        }

        public void setHighwdthen(String highwdthen) {
                this.highwdthen = highwdthen;
        }

        public String getHighwdfour() {
                return highwdfour;
        }

        public void setHighwdfour(String highwdfour) {
                this.highwdfour = highwdfour;
        }

        public String getHighwdfive() {
                return highwdfive;
        }

        public void setHighwdfive(String highwdfive) {
                this.highwdfive = highwdfive;
        }

        public String getLowwdone() {
                return lowwdone;
        }

        public void setLowwdone(String lowwdone) {
                this.lowwdone = lowwdone;
        }

        public String getLowwdtwo() {
                return lowwdtwo;
        }

        public void setLowwdtwo(String lowwdtwo) {
                this.lowwdtwo = lowwdtwo;
        }

        public String getLowwdthen() {
                return lowwdthen;
        }

        public void setLowwdthen(String lowwdthen) {
                this.lowwdthen = lowwdthen;
        }

        public String getLowwdfour() {
                return lowwdfour;
        }

        public void setLowwdfour(String lowwdfour) {
                this.lowwdfour = lowwdfour;
        }

        public String getLowwdfive() {
                return lowwdfive;
        }

        public void setLowwdfive(String lowwdfive) {
                this.lowwdfive = lowwdfive;
        }

        public String getImgnightone() {
                return imgnightone;
        }

        public void setImgnightone(String imgnightone) {
                this.imgnightone = imgnightone;
        }

        public String getImgnighttwo() {
                return imgnighttwo;
        }

        public void setImgnighttwo(String imgnighttwo) {
                this.imgnighttwo = imgnighttwo;
        }

        public String getImgnightthen() {
                return imgnightthen;
        }

        public void setImgnightthen(String imgnightthen) {
                this.imgnightthen = imgnightthen;
        }

        public String getImgnightfour() {
                return imgnightfour;
        }

        public void setImgnightfour(String imgnightfour) {
                this.imgnightfour = imgnightfour;
        }

        public String getImgnightfive() {
                return imgnightfive;
        }

        public void setImgnightfive(String imgnightfive) {
                this.imgnightfive = imgnightfive;
        }

        public String getDirectionone() {
                return directionone;
        }

        public void setDirectionone(String directionone) {
                this.directionone = directionone;
        }

        public String getDirectiontwo() {
                return directiontwo;
        }

        public void setDirectiontwo(String directiontwo) {
                this.directiontwo = directiontwo;
        }

        public String getDirectionthen() {
                return directionthen;
        }

        public void setDirectionthen(String directionthen) {
                this.directionthen = directionthen;
        }

        public String getDirectionfour() {
                return directionfour;
        }

        public void setDirectionfour(String directionfour) {
                this.directionfour = directionfour;
        }

        public String getDirectionfive() {
                return directionfive;
        }

        public void setDirectionfive(String directionfive) {
                this.directionfive = directionfive;
        }

        public String getWinpowerone() {
                return winpowerone;
        }

        public void setWinpowerone(String winpowerone) {
                this.winpowerone = winpowerone;
        }

        public String getWinpowertwo() {
                return winpowertwo;
        }

        public void setWinpowertwo(String winpowertwo) {
                this.winpowertwo = winpowertwo;
        }

        public String getWinpowerthen() {
                return winpowerthen;
        }

        public void setWinpowerthen(String winpowerthen) {
                this.winpowerthen = winpowerthen;
        }

        public String getWinpowerfour() {
                return winpowerfour;
        }

        public void setWinpowerfour(String winpowerfour) {
                this.winpowerfour = winpowerfour;
        }

        public String getWinpowerfive() {
                return winpowerfive;
        }

        public void setWinpowerfive(String winpowerfive) {
                this.winpowerfive = winpowerfive;
        }

        public String getStatesone() {
                return statesone;
        }

        public void setStatesone(String statesone) {
                this.statesone = statesone;
        }

        public String getStatestwo() {
                return statestwo;
        }

        public void setStatestwo(String statestwo) {
                this.statestwo = statestwo;
        }

        public String getStatesthen() {
                return statesthen;
        }

        public void setStatesthen(String statesthen) {
                this.statesthen = statesthen;
        }

        public String getStatesfour() {
                return statesfour;
        }

        public void setStatesfour(String statesfour) {
                this.statesfour = statesfour;
        }

        public String getStatesfive() {
                return statesfive;
        }

        public void setStatesfive(String statesfive) {
                this.statesfive = statesfive;
        }

        public String getAltitude() {
                return altitude;
        }

        public void setAltitude(String altitude) {
                this.altitude = altitude;
        }

        public String getRainfall() {
                return rainfall;
        }

        public void setRainfall(String rainfall) {
                this.rainfall = rainfall;
        }

        public String getPh() {
                return ph;
        }

        public void setPh(String ph) {
                this.ph = ph;
        }

        public String getLand() {
                return land;
        }

        public void setLand(String land) {
                this.land = land;
        }

        public String getSurroundings() {
                return surroundings;
        }

        public void setSurroundings(String surroundings) {
                this.surroundings = surroundings;
        }
}
