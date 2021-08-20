package mhl_0_6.service;

import mhl_0_6.dao.MenuDAO;
import mhl_0_6.domain.Menu;

import java.util.List;

public class MenuService {
    ////创建MenuDAO才能调用其方法
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有菜品
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //根据id返回对象
    public Menu getMenuObject(int id){
        return menuDAO.querySingle("select * from menu where id = ?",Menu.class,id);
    }

}
