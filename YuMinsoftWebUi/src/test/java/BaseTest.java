import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

/**
 * Created by 刘正涛 on 2017/9/20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml"})
public class BaseTest {


   public static void main(String [] args){
       System.out.println(DigestUtils.md5DigestAsHex("boby123".getBytes()));
   }




}
