package mhl_0_7.service;

import mhl_0_7.dao.DiningTableDAO;
import mhl_0_7.domain.DiningTable;

import java.util.List;

public class DiningTableService {

    //定义DiningTableDAO对象才能调用其方法
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌信息
    public List<DiningTable> list(){
        //返回多条信息的方法
        List<DiningTable> diningTables = diningTableDAO.queryMulti("select id , state from diningtable", DiningTable.class);
        return diningTables;
    }

    //根据id查询餐桌
    public DiningTable getDiningTableId(int id){
        //如果返回null说明不存在
        return diningTableDAO.querySingle("select * from diningtable where id = ?", DiningTable.class,id);
    }

    //预定餐桌  如果可以预定则修改餐桌信息
    public boolean orderDiningTable(int id ,String orderName,String orderTel){
        int update = diningTableDAO.update("update diningtable set orderName = ? ,orderTel = ?, state = '已预定' where id = ?", orderName, orderTel, id);
        //如果 update > 0 会返回true
        //update方法返回的是生效行数，如果是0说明没生效，返回false
        return update > 0;
    }

    //更新餐桌状态
    public boolean updateDiningTableState(int id , String state){
        int update = diningTableDAO.update("update diningtable set state = ? where id = ?", state, id);
        return update > 0;
    }

    //初始化餐桌
    public boolean resetDingingTable(int id){
        //设置餐桌状态为'空' ， orderName和orderTel为''
        int update = diningTableDAO.update("update diningtable set state = '空',orderName = '',orderTel = '' where id = ?",id);
        return update > 0;
    }

}
