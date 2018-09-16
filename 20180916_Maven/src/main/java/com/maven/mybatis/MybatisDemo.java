package com.maven.mybatis;

import com.maven.mybatis.dao.StudentDao;
import com.maven.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.InputStream;

public class MybatisDemo {
    private SqlSessionFactory sessionFactory = null;
    private SqlSession session = null;
    @Before
    public void init() throws Exception {
        InputStream stream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");

        sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        session = sessionFactory.openSession();
    }

    @Test
    public void selectTest() throws Exception {
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findById("0001");

        System.out.println(student);
    }

    @Test
    public void insertTest() throws Exception {
        StudentDao studentDao = session.getMapper(StudentDao.class);
        studentDao.addOne(new Student("0002", "Tom", 6));

        session.commit(); // 没有commit，数据提交不到数据库
    }

    @Test
    public void updateTest() throws Exception {
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findById("0002");
        if (student != null){
            student.setAge(26);
            studentDao.update(student);
        }

        session.commit(); // 没有commit，数据提交不到数据库
    }

    @Test
    public  void deleteTest() throws Exception {
        StudentDao studentDao = session.getMapper(StudentDao.class);
        studentDao.deleteById("0002");

        session.commit(); // 没有commit，数据提交不到数据库
    }

    @After
    public void release(){
        session.close();
    }
}
