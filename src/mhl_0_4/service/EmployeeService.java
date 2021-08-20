package mhl_0_4.service;

import mhl_0_4.dao.EmployeeDAO;
import mhl_0_4.domain.Employee;

public class EmployeeService {
    //创建EmployeeDAO才能调用其方法
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //查找empId和pwd
    public Employee getEmployeeIdAndPwd(String empId, String pwd){
        //返回单行信息的方法
        Employee employee = employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?) ", Employee.class,empId,pwd);
        return employee;
    }


}
