package store.web.servlet;

import store.domain.Category;
import store.domain.Product;
import store.service.CategoryService;
import store.service.ProductService;
import store.service.serviceImp.CategoryServiceImp;
import store.service.serviceImp.ProductServiceImp;
import store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

      /*  CategoryService CategoryService = new CategoryServiceImp();
        List<Category> list = CategoryService.getAllCats();
        req.setAttribute("allCats",list);*/

        //调用业务层查询最新商品,查询最热商品,返回2个集合
        ProductService ProductService=new ProductServiceImp();
        List<Product> list01=ProductService.findHots();
        List<Product> list02=ProductService.findNews();
        //将2个集合放入到request
        req.setAttribute("hots", list01);
        req.setAttribute("news", list02);



        return "/jsp/index.jsp";
    }
}
