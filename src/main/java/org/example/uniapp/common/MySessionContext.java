package org.example.uniapp.common;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MySessionContext {
    private static final Map<String, HttpSession> HASH_MAP = new HashMap<>();

    public static String sessionId;

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            sessionId = session.getId();
            HASH_MAP.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            HASH_MAP.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession() {
        if (sessionId == null)
            return null;
        return HASH_MAP.get(sessionId);
    }
}
