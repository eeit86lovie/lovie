package com.kidscodetw.eeit.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
 
@ServerEndpoint("/video/{uid}")
public class WebRTCAdmin {
    private static final int MAX_COUNT = 20;
    private static final long MAX_TIME_OUT = 2 * 60 * 1000;
    // 使用者:發出的訊息
    private static final Map<String, String> user_user = Collections.synchronizedMap(new HashMap<String, String>()); 
    private static final Map<String, Session> sessions = Collections.synchronizedMap(new HashMap<String, Session>());
     
    @OnOpen
    public void onOpen(Session session, @PathParam("uid")String uid) {
        session.setMaxIdleTimeout(MAX_TIME_OUT);
        sessions.put(uid, session);
    }
 
    
    @OnClose
    public void onClose(Session session, @PathParam("uid")String uid) {
        remove(session, uid);
    }
 
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("uid")String uid) {
        try {
            if(uid != null && user_user.get(uid) != null && WebRTCAdmin.sessions.get(user_user.get(uid)) != null) {
                Session osession = sessions.get(user_user.get(uid));
                if(osession.isOpen())
                    osession.getAsyncRemote().sendText(new String(message.getBytes("utf-8")));
                else
                    this.nowaiting(osession);
            } else {
                this.nowaiting(session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    
    private void nowaiting(Session session) {
        session.getAsyncRemote().sendText("{\"type\" : \"nowaiting\"}");
    }
     
    /**
     * 是否可以继续创建通话房间
     * @return 可以：true；不可以false；
     */
    public static boolean canCreate() {
        return sessions.size() <= MAX_COUNT;
    }
     
    /**
     * 判断是否可以加入
     * @param oid 被申请对话的ID
     * @return 如果能加入返回：true；否则返回false；
     */
    public static boolean canJoin(String oid) {
        return !(oid != null && user_user.containsKey(oid) && user_user.get(oid) != null);
    }
     
    /**
     * 添加视频对象
     * @param uid 申请对话的ID
     * @param oid 被申请对话的ID
     * @return 是否是创建者：如果没有申请对话ID为创建者，否则为为加入者。创建者返回：true；加入者返回：false；
     */
    public static boolean addUser(String uid, String oid) {
        if(oid != null && !oid.isEmpty()) {
        	WebRTCAdmin.user_user.put(uid, oid);
        	WebRTCAdmin.user_user.put(oid, uid);
             
            return false;
        } else {
        	WebRTCAdmin.user_user.put(uid, null);
             
            return true;
        }
    }
     
    /**
     * 移除聊天用户
     * @param session 移除的session
     * @param uid 移除的UID
     */
    private static void remove(Session session, String uid) {
        String oid = user_user.get(uid);
         
        if(oid != null) user_user.put(oid, null); // 设置对方无人聊天
         
        sessions.remove(uid); // 异常session
        user_user.remove(uid); // 移除自己
         
        try {
            if(session != null && session.isOpen()) session.close(); // 关闭session
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
	
	

