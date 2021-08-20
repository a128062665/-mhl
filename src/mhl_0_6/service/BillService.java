package mhl_0_6.service;

import mhl_0_6.dao.BillDAO;
import mhl_0_6.domain.Bill;

import java.util.List;
import java.util.UUID;

public class BillService {

    BillDAO billDAO = new BillDAO();
    MenuService menuService = new MenuService();
    DiningTableService diningTableService = new DiningTableService();

    //生成账单 同时更新餐桌的状态
    /*
        id是自增长的，不需要传入
        billId：在方法里生成，不需要传入
        menuId：菜品编号，需要传入
        nums：点的份数，需要传入
        mongey：份数*菜品价格，不需要传入
        diningTableId：餐桌id，需要传入
        billDate：账单时间，实时生成即可，不需要传入
        state：餐桌状态，方法里修改，不需要传入
    */
    public boolean orderMenu(int menuId, int nums, int diningTableId){
        //自动生成不重复随机的UUID(字符串)
        String billId = UUID.randomUUID().toString();

        //价格
        //double money = menuService.getMenuObject(menuId).getPrice() * nums;

        //插入账单
        //这里的money通过menuService.getMenuObject(menuId).getPrice() * nums得到
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuObject(menuId).getPrice() * nums, diningTableId);
        //如果update接收到的有效行数是0，说明插入失败，给false，不修改状态
        if (update <= 0){
            return false;
        }
        //更新对应餐桌状态
        return diningTableService.updateDiningTableState(diningTableId,"就餐中");

    }

    //返回所有账单
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill",Bill.class);
    }

}
