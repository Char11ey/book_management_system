package utils;

import org.apache.commons.beanutils.BeanUtils;


import java.util.Map;

/**
 * @author Charley
 * @creat 2021-07-08 16:22
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int pareInt(String strInt, int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }
}
