package org.nanguo.lemall;

import org.junit.jupiter.api.Test;
import org.nanguo.lemall.business.admin.system.mapper.UmsResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysqlConnectionTest {

    @Autowired
    private UmsResourceMapper umsResourceMapper;

    @Test
    public void testMysqlQuery() {
        System.out.println(umsResourceMapper.selectList(null));
    }

}