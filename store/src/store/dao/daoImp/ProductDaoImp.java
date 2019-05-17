package store.dao.daoImp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import org.apache.commons.dbutils.handlers.ScalarHandler;
import store.dao.ProductDao;
import store.domain.Product;
import store.utils.JDBCUtils;

import java.util.List;

public class ProductDaoImp implements ProductDao {


    @Override
    public Product findProductByPid(String pid) throws Exception {
        String sql = "SELECT * FROM product WHERE pid = ?" ;
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
    }

    @Override
    public List<Product> findHots() throws Exception {
        String sql = "SELECT * FROM product WHERE pflag = 0 AND is_hot=1 ORDER BY pdate DESC LIMIT 0,9" ;
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return  qr.query(sql, new BeanListHandler<Product>(Product.class));


    }

    @Override
    public List<Product> findNews() throws Exception {
        String sql = "SELECT * FROM product WHERE pflag = 0   ORDER BY pdate DESC LIMIT 0,9" ;
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return  qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    @Override
    public int findTotalRecords(String cid) throws Exception {
        String sql="select count(*) from product where cid =?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        Long num=(Long)qr.query(sql, new ScalarHandler(),cid);
        return num.intValue();
    }

    @Override
    public List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws Exception {
        String sql="select * from product where cid=? limit ? , ?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);
    }
}
