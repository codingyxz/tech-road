package com.yxz.jdbc.pool;

import com.yxz.jdbc.util.JDBCUtils_V1;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    /**
     * @throws SQLException
     * @Description 测试DBCP的数据库连接池技术
     */
    //方式一：不推荐
    @Test
    public void testGetConnection() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setDriverClassName(JDBCUtils_V1.DRIVER_CLASS);
        source.setUrl(JDBCUtils_V1.URL);
        source.setUsername(JDBCUtils_V1.USER);
        source.setPassword(JDBCUtils_V1.PASSWORD);

        //还可以设置其他涉及数据库连接池管理的相关属性：
        source.setInitialSize(10);
        source.setMaxActive(10);
        //。。。

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    //方式二：推荐：使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties pros = new Properties();

        //方式1：
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式2：
//        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));


        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }


}
