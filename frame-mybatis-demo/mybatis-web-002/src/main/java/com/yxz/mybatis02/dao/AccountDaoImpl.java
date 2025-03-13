package com.yxz.mybatis02.dao;

import com.yxz.mybatis02.pojo.Account;
import com.yxz.mybatis02.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description TODO
 * @Date 2025-03-$Proxy8
 * @Created by Yolo
 */
public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActno(String arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.selectOne("account.selectByActno", arg0);
    }

    @Override
    public int updateByActno(Account arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.update("account.updateByActno", arg0);
    }
}
