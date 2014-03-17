/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.beanutils.BeanMap;

/**
 *
 * @author Ibatis
 */
public class MapUtils {

    /**
     * Creates a new instance of IbatisUtil
     */
    public static Map processBean(Object bean) {
        Map map = new HashMap();
        try {
            BeanMap beanMap = new BeanMap(bean);
            Iterator it = beanMap.keyIterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = (String) beanMap.get(key);
                if(value != null)
                    map.put(key, value);
            }
        } catch (Exception ex) {
        }
        return map;
    }

    public static Map processBean(Object... beans) {
        Map map = new HashMap();
        BeanMap beanMap;
        try {
            for (Object bean : beans) {
                beanMap = new BeanMap(bean);
                Iterator it = beanMap.keyIterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = (String) beanMap.get(key);
                    if(value != null)
                        map.put(key, value);
                }
            }
        } catch (Exception ex) {
        }
        return map;
    }

}
