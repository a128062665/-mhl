package mhl_0_5.view;

import mhl_0_5.domain.Employee;
import mhl_0_5.service.EmployeeService;
import mhl_0_5.utils.Utility;


public class MHLView {

    private boolean loop = true;
    private String key = "";
    private View view = new View();
    private EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    public void mainMenu(){

        while(loop){
            //显示一级菜单
            view.ViewOneMenu();
            //读取
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.print("请输入员工empId号：");
                    String empId = Utility.readString(10);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(20);
                    Employee employeeIdAndPwd = employeeService.getEmployeeIdAndPwd(empId, pwd);
                    //登录成功就会进入二级菜单
                    if (employeeIdAndPwd != null){
                        System.out.println("用户:" + employeeIdAndPwd.getName() + "登录成功");
                    //二级菜单
                        while (loop){
                            view.ViewTwoMenu();
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    //显示餐桌状态
                                    view.ViewTableState();
                                    break;
                                case "2":
                                    //预定餐桌
                                    view.orderDiningTable();
                                    break;
                                case "3":
                                    //显示所有菜品
                                    view.listMenu();
                                    break;
                                case "4":
                                    System.out.println("点餐服务");
                                    break;
                                case "5":
                                    System.out.println("查看账单");
                                    break;
                                case "6":
                                    System.out.println("结算账单");
                                    break;
                                case "9":
                                    System.out.println("退出满汉楼");
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请重新输入");
                                    break;
                            }
                        }
                    }else{
                        System.out.println("登录失败");
                    }

                    break;
                case "2":
                    System.out.println("退出成功");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }

        }


    }

}
