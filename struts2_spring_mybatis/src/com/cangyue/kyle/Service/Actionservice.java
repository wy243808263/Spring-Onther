package com.cangyue.kyle.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cangyue.kyle.mybatipse.mapper.Usermybatipse;
import com.cangyue.kyle.mybatipse.po.User;

@Service
public class Actionservice implements com.cangyue.kyle.Service.Service{

	@Autowired
	private Usermybatipse usermybatipse;
	
	public void test(){
		User user=usermybatipse.get(1);
		System.out.println(user.toString());
	}

}
