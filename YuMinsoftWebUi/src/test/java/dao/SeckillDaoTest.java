package dao;

import com.niuchatao.pw.dao.SeckillDao;
import com.niuchatao.pw.entries.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置spring和junit整合,Junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void testReduceNumber() throws Exception {
      //int customid=seckillDao.reduceNumber();
    }

    @Test
    public void testQueryById() throws Exception {
        long myid=1000;
        Seckill seckill= seckillDao.queryById(myid);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
       int offset = 2,limit=3;
        List<Seckill> list = new ArrayList<Seckill>();
        list = seckillDao.queryAll(offset,limit);
        System.out.println(list.toString());

    }
}