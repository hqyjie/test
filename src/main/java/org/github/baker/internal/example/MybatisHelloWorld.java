package org.github.baker.internal.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.github.baker.internal.entity.User;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年10月20日
 * @modifytime:
 */
public class MybatisHelloWorld {

    public static void main(String[] args) {
        String resource = "Configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();
            try {
                User user = (User)session.selectOne("org.github.baker.internal.inter.UserInterface.selectById", 2);
                Long l = user.getCreateTime().getTime();
                System.out.println(new Date().getTime());
                System.out.println(user.getCreateTime());
                System.out.println(l);


            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
