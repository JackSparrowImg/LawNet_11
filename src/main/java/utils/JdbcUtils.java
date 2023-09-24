package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

    /**
     * Created by dushao 2022/10/24
     * 数据库链接工具类
     */
public class JdbcUtils {
    public static DataSource dataSource;
    static {
        try {
            //1.加载配置文件
            Properties properties = new Properties();
            //反射机制
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            System.out.println(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *获取数据库连接
     * @return 返回数据库连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void close(Statement statement,Connection connection){
        close(null,statement,connection);
    }

    /**
     * @param connection 待关闭的连接对象
     * @param resultSet 待关闭的存储查询结果的对象
     * @param statement 待关闭的执行静态语句的sql对象
     * @return
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
