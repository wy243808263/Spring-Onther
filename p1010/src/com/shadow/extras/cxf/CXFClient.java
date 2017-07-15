package com.shadow.extras.cxf;

import java.lang.reflect.Method;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * CXF客户端测试程序
 * 
 * @author shadow
 * 
 */
public class CXFClient {

	public static void main(String[] args) {
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory
				.newInstance();
		Client client = factory
				.createClient("http://localhost/services/query?wsdl");
		Object user = null;
		try {
			user = Thread.currentThread().getContextClassLoader().loadClass(
					"com.shadow.extras.cxf.User").newInstance();
			Method method = user.getClass().getMethod("setUsername",
					String.class);
			method.invoke(user, "test");
			Object[] result = client.invoke("queryUser", user, 50);
			if (result != null && result.length > 0) {
				System.out.println(result[0].getClass()
						.getMethod("getUsername").invoke(result[0]));
			}

			Object[] result2 = client.invoke("queryCount", 101);
			if (result2 != null && result2.length > 0) {
				System.out.println(result2[0]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
