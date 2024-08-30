package Test;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void userFindByIdTest() {
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper = new
                SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession实例
        SqlSession session = sqlMapper.openSession();
        //传入参数查询，返回结果
        User user = session.selectOne("findById", 1);
        //输出结果
        System.out.println(user.getUname());
        user = new User();
        // user.setUid(3);
       /* user.setUname("张三1");
        user.setUage(201);
        int rowsAffected = session.insert("insertUser", user);
        System.out.println("影响行数：" + rowsAffected);
        session.commit();*/
        //关闭session
        session.close();
    }
}

/*
*         List<Map<String, Object>> list = session.selectList("selectList");
        list.forEach(map -> {
            map.forEach((key, value) -> {
                System.out.println("Key: " + key + ", Value: " + value);
            });
        });
        System.out.println(list);
* */

