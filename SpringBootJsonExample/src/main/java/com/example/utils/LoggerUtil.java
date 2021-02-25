package com.example.utils;



import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {
	
	static Logger logger = LogManager.getLogger(LoggerUtil.class);
	
	public static void log(Level level ,String source ,String id ,String msg) {
		String host = "HostNameUnavailable";
		try {
			host = InetAddress.getLocalHost().getHostName();
		}
		catch(UnknownHostException ex) {
			System.err.println("unable to get local host name"+ex);
			ex.printStackTrace();
			
		}
		
		String moduleName = "ARICIPHHANDLER";
		MapMessage map = new MapMessage();
		map.put("appId", moduleName);
		map.put("hostname",host);
		if(level==Level.ERROR) {
			map.put("level","ERROR");
		}
		else if(level==Level.WARN) {
			map.put("level", "WARN");
			}
		else if(level==Level.DEBUG) {
			map.put("level", "DEBUG");
		}
		else if(level==Level.FATAL) {
			map.put("level", "FATAL");
		}
		else if(level==Level.INFO) {
			map.put("level", "INFO");
		}
		else {
		map.put("level", "ERROR");
		}
		map.put("source", source);
		map.put("id", id);
		map.put("msg", msg);
		
		logger.log(Level.getLevel("TIVOLI"),map);
		//map.put(candidateKey, value);
	}

}
