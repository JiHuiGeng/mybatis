package com.geng.test;

import com.geng.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //查询所有数据
        List<Flower> list = session.selectList("a.b.selectAll");
        for (Flower flower : list) {
            System.out.println(flower.toString());
        }
        //查询数据行数
        int i = session.selectOne("a.b.selectOne");
        System.out.println(i);
        Map<Object, Object> map = session.selectMap("a.b.selectMap", "name");
        System.out.println(map);
        session.close();
    }
}
