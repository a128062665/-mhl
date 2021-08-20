package mhl_0_5.view;

import mhl_0_5.domain.DiningTable;
import mhl_0_5.domain.Menu;
import mhl_0_5.service.DiningTableService;
import mhl_0_5.service.MenuService;
import mhl_0_5.utils.Utility;

import java.util.List;

public class View {

    DiningTableService diningTableService = new DiningTableService();
    MenuService menuService = new MenuService();

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

    //预定餐桌
    public void orderDiningTable(){
        System.out.println("----预定餐桌----");
        System.out.println("请选择要预定的餐桌号(-1退出)：");
        int orderId = Utility.readInt();
        if (orderId == -1){
            System.out.println("----成功取消预定----");
            return;
        }
        //确定是否预定
        //readConfirmSelection()让用户输入Y/N，可小写
        char key = Utility.readConfirmSelection();
        if(key == 'Y'){//'Y'要预定
            //判断该餐桌id是否存在 如果返回null说明不存在
            DiningTable diningTableId = diningTableService.getDiningTableId(orderId);
            if(diningTableId == null){
                System.out.println("----预定餐桌不存在----");
                return;
            }
            //判断餐桌的状态，如果不为空说明不能预定
            if (!("空".equals(diningTableId.getState()))){
                System.out.println("----该餐桌不可预定----");
                return;
            }
            //此时剩下的状态只有"空"，可以对该餐桌进行预定，要求输入预定名字和电话
            System.out.print("请输入预定人名字：");
            String orderName = Utility.readString(10);
            System.out.println("请输入预订人电话：");
            String orderTel = Utility.readString(15);
            //对餐桌进行预定，更新状态
            if(diningTableService.orderDiningTable(orderId, orderName, orderTel)){
                System.out.println("预定餐桌成功~");
            }else {
                System.out.println("系统出现错误，预定餐桌失败~");
            }
        }else {//不是'Y'的情况，即是'N'
            System.out.println("----成功取消预定----");
        }
    }

    //显示所有菜品
    public void listMenu(){
        System.out.println("\n编号\t\t菜品\t\t\t类别\t\t\t价格");
        //输出菜品，自动调用Menu的toString
        for (Menu menu : menuService.list()) {
            System.out.println(menu);
        }
    }


}
