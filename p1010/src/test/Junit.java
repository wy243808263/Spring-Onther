package test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shadow.extras.cxf.Hello;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Junit {

	@Resource
	private UserService userService;

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			List<User> users = (List<User>) userService.findByUserName(
					"3213231").getValue();
			System.out.println("当前用户数:" + users.size());
		}
	}

	/** CXF静态客户端测试 */
	@Test
	public void testWebService() {
		// 创建WebService客户端代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(Hello.class);
		// 设置WebService地址
		factory.setAddress("http://localhost/services/hello?wsdl");
		Hello client = (Hello) factory.create();
		System.out.println("invoke webservice...");
		String result = client.hello("test");
		// User user = helloClient.getUser();
		// System.out.println(user.getUsername());
		System.out.println(client.getNumber(50));
		System.out.println(result);
	}

}
