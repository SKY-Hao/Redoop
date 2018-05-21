package com.redoop.modules.admin.solution.entity;

import com.redoop.modules.admin.customer.entity.Customer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 说明：行业版本及案例实体类
 * 包名：cn.itweet.tea.admin.solution
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间：2017年10月16日16:20:56
 */
@Entity
@Table(name = "solution")
public class Solution implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;              //ID

    private String name;            //0：解决方案  1：成功案例
    private String title;           //标题
    private String solutionpic;     //图片
    private String solutionpicnamne; //图片名称
    private String intro;           //简介（成功案例简介）

    @Column(name = "content",columnDefinition="TEXT")
    private String content;         //内容

    private String author;          //作者（发布人）
    private Date authortime;        //时间（发布时间）
    private int state;              //前台是否展示0：展示 1：不展示

    private String outline;         //概要（和简报更新概要同步）

    @Override
    public String toString() {
        return "Solution{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", solutionpic='" + solutionpic + '\'' +
                ", solutionpicnamne='" + solutionpicnamne + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", authortime=" + authortime +
                ", state=" + state +
                ", outline='" + outline + '\'' +
                '}';
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSolutionpic() {
        return solutionpic;
    }

    public void setSolutionpic(String solutionpic) {
        this.solutionpic = solutionpic;
    }

    public String getSolutionpicnamne() {
        return solutionpicnamne;
    }

    public void setSolutionpicnamne(String solutionpicnamne) {
        this.solutionpicnamne = solutionpicnamne;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getAuthortime() {
        return authortime;
    }

    public void setAuthortime(Date authortime) {
        this.authortime = authortime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
