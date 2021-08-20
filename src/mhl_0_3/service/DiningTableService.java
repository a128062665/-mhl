package mhl_0_3.service;

import mhl_0_3.dao.DiningTableDAO;
import mhl_0_3.domain.DiningTable;

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

}
