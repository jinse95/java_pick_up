package javalang.静态代理;

import com.mysql.jdbc.JDBC4Connection;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @author J
 **/
public class ConnectionProxy extends JDBC4Connection {

    public ConnectionProxy(String hostToConnectTo, int portToConnectTo, Properties info, String databaseToConnectTo, String url) throws SQLException {
        super(hostToConnectTo, portToConnectTo, info, databaseToConnectTo, url);
    }


}
