package userlist;

import java.io.*;
import java.util.*;

public class SqlProperties {
    private static final String str = new SqlProperties().sqlProp("str");
    private static final String str2 = new SqlProperties().sqlProp("str2");
    private static final String query = new SqlProperties().sqlProp("query");


    public String sqlProp(String name) {
        final String PROP = "/sql.properties";
        Properties properties = new Properties();
        String property = "";
        try (InputStream is = this.getClass().getResourceAsStream(PROP)) {
            properties.load(is);
            property = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}



