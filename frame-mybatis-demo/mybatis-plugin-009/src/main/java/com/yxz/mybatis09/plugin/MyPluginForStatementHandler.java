package com.yxz.mybatis09.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Description TODO
 * @Date 2025-03-14
 * @Created by Yolo
 */

@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})})
public class MyPluginForStatementHandler implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 获取并修改sql
        BoundSql boundSql1 = (BoundSql) metaObject.getValue("delegate.boundSql");
        String sql1 = boundSql1.getSql();

//        metaObject.setValue("delegate.boundSql.sql", sql1);


        BoundSql boundSql2 = statementHandler.getBoundSql();
        String sql2 = boundSql2.getSql();
//        Object parameterObject = boundSql.getParameterObject();
//        String sql = boundSql.getSql();
//        System.out.println("sql : " + sql);
//        System.out.println("parameterObject : " + parameterObject);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(this.getClass().getName() + "-------- setProperties---------");
    }
}
