package com.sdl.swagger.meeting.entity;

/**
 * @author sundonglin
 * @date 2019/10/24 15:00
 */
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 账号对应员工的所在部门信息
 * @author 何霄刚
 * @date 2014-3-11
 */

@XmlRootElement(name = "employeeDepartment")
public class EmployeeDepartment implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1134841212974117871L;
    private Integer departmentId;
    private String departmentName;
    private String fullPath;
    private String deptPosition;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getDeptPosition() {
        return deptPosition;
    }

    public void setDeptPosition(String deptPosition) {
        this.deptPosition = deptPosition;
    }

}

