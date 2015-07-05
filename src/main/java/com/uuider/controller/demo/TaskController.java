package com.uuider.controller.demo;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  <a href="mailto:xingsan.zhang@gmail.com">zhangpl</a>
 * @version 2015年6月14日
 */
@Controller
@RequestMapping("task")
public class TaskController {
	
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse resp) {
		
		/*Map<Task> tasks = Collections.synchronizedMap(map);
		Task task = new Task();
		Thread t = new Thread(task);
		t.start();*/
		
		return "task/index";
	}
	
	class Task implements Runnable{

		@Override
		public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println("--->>>"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
