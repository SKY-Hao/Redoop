package com.redoop.modules.admin.huang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Entity
@Table(name = "dept")
public class Dept implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private String name;

    private Integer count;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private List<Userr> userrList;


    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", userrList=" + userrList +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Userr> getUserrList() {
        return userrList;
    }

    public void setUserrList(List<Userr> userrList) {
        this.userrList = userrList;
    }
}
