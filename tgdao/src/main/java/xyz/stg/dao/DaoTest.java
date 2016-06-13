package xyz.stg.dao;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * Created by shitiangao on 16/6/7.
 */
public class DaoTest {
    public static void main(String[] args) {
        SqlSessionFactory factory = new DefaultSqlSessionFactory(new Configuration());
    }
}
