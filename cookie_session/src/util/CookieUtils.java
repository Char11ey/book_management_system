package util;

import javax.servlet.http.Cookie;

/**
 * @author Charley
 * @creat 2021-07-13 20:02
 */
public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies){
        for(Cookie cookie : cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
