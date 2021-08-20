package mhl_0_3.view;

import mhl_0_3.domain.DiningTable;
import mhl_0_3.service.DiningTableService;

import java.util.List;

public class View {

    DiningTableService diningTableService = new DiningTableService();
    //一级菜单
    public void ViewOneMenu(){
        System.out.println("------满汉楼------");
        System.out.println("1 登录满汉楼");
        System.out.println("2 退出满汉楼");
    }
    //二级菜单
    public void ViewTwoMenu(){
        System.out.println("------二级菜单------");
        System.out.println("1 显示餐桌状态");
        System.out.println("2 预定餐桌");
        System.out.println("3 显示所有菜品");
        System.out.println("4 点餐服务");
        System.out.println("5 查看账单");
        System.out.println("6 结算账单");
        System.out.println("9 退出满汉楼");
        System.out.print("请输入对应数字：");
    }
    //餐桌状态
    public void ViewTableState(){
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            //会调用DiningTable的toString方法
            System.out.println(diningTable);
        }
    }

}
