package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class myListener
 *
 */

public class myListener implements HttpSessionListener {

	private static int sessionNum = 0; // use to cal how many users are online?

	public static int getSessionNum() {
		return sessionNum;
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
//		System.out.println(arg0.getSession() + "創建了！！");
//		System.out.println(sessionNum);
//		sessionNum++; // user online.
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
//		System.out.println("session銷毀了！！");
//		sessionNum--; // user offline
	}

}
