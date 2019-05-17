package store.web.servlet;

import store.domain.PageModel;
import store.domain.Product;
import store.service.ProductService;
import store.service.serviceImp.ProductServiceImp;
import store.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends BaseServlet {

        public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
            //获取商品pid
            String pid=request.getParameter("pid");
            //根据商品pid查询商品信息
            ProductService ProductService=new ProductServiceImp();
            Product product=ProductService.findProductByPid(pid);
            //将获取到的商品放入request
            request.setAttribute("product", product);
            //转发到/jsp/product_info.jsp
            return "/jsp/product_info.jsp";
        }

        //findProductsByCidWithPage
        public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

            //获取cid,num
            String cid=request.getParameter("cid");
            int curNum=Integer.parseInt(request.getParameter("num"));
            //调用业务层功能:以分页形式查询当前类别下商品信息
            //返回PageModel对象(1_当前页商品信息	2_分页	s3_url)
            ProductService ProductService=new ProductServiceImp();
            PageModel pm=ProductService.findProductsByCidWithPage(cid,curNum);
            //将PageModel对象放入request
            request.setAttribute("page", pm);
            //转发到/jsp/product_list.jsp
            return  "/jsp/product_list.jsp";
        }
}

