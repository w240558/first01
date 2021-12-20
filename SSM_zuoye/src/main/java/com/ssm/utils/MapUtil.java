package com.ssm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Closeable;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SSM_zuoye
 * @description:
 * @author: wen
 * @create: 2021-12-13 09:49
 * @version:1.0
 **/
public class MapUtil {
    private static SqlSessionFactory factory;

    static {
        String resources = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resources);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        if (factory != null) {
            return factory.openSession();
        }
        return null;
    }

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}