package mhl_0_2.service;

import mhl_0_2.dao.EmployeeDAO;
import mhl_0_2.domain.Employee;

public class EmployeeService {
    //创建EmployeeDAO才能调用其方法
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //查找empId和pwd
    public Employee getEmployeeIdAndPwd(String empId,String pwd){
        Employee employee = employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?) ",Employee.class,empId,pwd);
        return employee;
    }


}
