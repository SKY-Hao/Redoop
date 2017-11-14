package com.redoop.modules.admin.ceshi.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/13.
 */
@Entity
@Table(name = "dept")
public class Dept implements Serializable {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
    private Set<Emp> empSet = new HashSet<Emp>();

    /*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="deptId")	//一个部门可能有个员工
    private List<Emp> empList=new ArrayList<>();*/


    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", empSet=" + empSet +
                '}';
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

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }
}
