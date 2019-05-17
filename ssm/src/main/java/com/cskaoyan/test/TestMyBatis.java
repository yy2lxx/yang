package com.cskaoyan.test;

import com.cskaoyan.dao.AccountDao;
import com.cskaoyan.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);

        List<Account> list = dao.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        session.close();
        in.close();

    }

    @Test
    public void run2() throws Exception{
        Account account = new Account();
        account.setName("上原");
        account.setMoney(500d);

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);

        dao.saveAccount(account);
        session.commit();

        session.close();
        in.close();

    }
}
