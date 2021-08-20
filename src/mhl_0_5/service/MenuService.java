package mhl_0_5.service;

import mhl_0_5.dao.MenuDAO;
import mhl_0_5.domain.Menu;

import java.util.List;

public class MenuService {
    ////创建MenuDAO才能调用其方法
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有菜品
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }

}
