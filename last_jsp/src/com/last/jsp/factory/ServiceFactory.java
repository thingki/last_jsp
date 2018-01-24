package com.last.jsp.factory;

import java.util.HashMap;
import java.util.Map;

import com.last.jsp.service.Service;
import com.last.jsp.service.impl.ClassServiceImpl;
import com.last.jsp.service.impl.CustomerServiceImpl;
import com.last.jsp.service.impl.MenuServiceImpl;
import com.last.jsp.service.impl.UserServiceImpl;

public class ServiceFactory {
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getInstance() {
		return new ServiceFactory();
	}
	private static Map<String, Service> serviceMap = new HashMap<String, Service>();
	static {
		serviceMap = new HashMap<String, Service>();
	}

	private void initInstance(String serviceName) {
		if (serviceName.equals("menu")) {
			serviceMap.put(serviceName, new MenuServiceImpl());
		}else if(serviceName.equals("user")) {
			serviceMap.put(serviceName, new UserServiceImpl());
		}else if(serviceName.equals("class")) {
			serviceMap.put(serviceName, new ClassServiceImpl());
		}else if(serviceName.equals("customer")) {
			serviceMap.put(serviceName, new CustomerServiceImpl());
		}
	}
	
	public Service getService(String serviceName) {
		if (!serviceMap.containsKey(serviceName)) {
			initInstance(serviceName);
		}
		return serviceMap.get(serviceName);
	}
}
