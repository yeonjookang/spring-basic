package kuit.springbasic.web.util;

import jakarta.servlet.http.HttpSession;
import kuit.springbasic.web.domain.User;

public class UserSessionUtils {
    public static User getUserFromSession(HttpSession session){
        Object user = session.getAttribute("user");
        if(user==null){
            return null;
        }
        return (User)user;
    }

    public static boolean isLoggedIn(HttpSession session){
        return getUserFromSession(session)!=null;
    }
}
