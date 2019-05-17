package store.web.servlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;
import store.domain.Category;
import store.service.CategoryService;
import store.service.serviceImp.CategoryServiceImp;
import store.utils.JedisUtils;
import store.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {

    public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Jedis jedis = JedisUtils.getJedis();
        String jsonStr = jedis.get("allCats");

       if(null==jsonStr||"".equals(jsonStr)) {

           CategoryService CategoryService = new CategoryServiceImp();
           List<Category> list = CategoryService.getAllCats();
           jsonStr = JSONArray.fromObject(list).toString();
           System.out.println(jsonStr);

           jedis.set("allCats",jsonStr);
           System.out.println("redis缓存中没有数据");
           resp.setContentType("application/json;charset=utf-8");
           resp.getWriter().print(jsonStr);
       }else {
           System.out.println("redis缓存中有数据");
           resp.setContentType("application/json;charset=utf-8");
           resp.getWriter().print(jsonStr);
       }

       JedisUtils.closeJedis(jedis);

       return null;

    }
}
