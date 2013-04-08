package test.dbutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import test.spring.Utils;

public class DbutilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource ds = (DataSource) Utils.getSpringBean("bonecp");
		try {
			test(ds);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void test(DataSource dataSource) throws SQLException{
		ResultSetHandler<Object[]> h = new ResultSetHandler<Object[]>() {
		    public Object[] handle(ResultSet rs) throws SQLException {
		        if (!rs.next()) {
		            return null;
		        }
		    
		        ResultSetMetaData meta = rs.getMetaData();
		        int cols = meta.getColumnCount();
		        Object[] result = new Object[cols];

		        for (int i = 0; i < cols; i++) {
		            result[i] = rs.getObject(i + 1);
		        }

		        return result;
		    }
		};
		
		QueryRunner run = new QueryRunner(dataSource);

		Object[] result = run.query(
		     "SELECT * FROM user WHERE name=?", h, "demo");
	}
}
