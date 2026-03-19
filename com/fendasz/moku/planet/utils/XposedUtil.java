package com.fendasz.moku.planet.utils;

import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.kuaishou.weapon.p0.an;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class XposedUtil {
    private static final String TAG = "mogu_xposed_u=>";
    private static volatile boolean flag = false;
    private static volatile XposedUtil xposedUtil;
    private static HashMap<String, Field> FIELDCACHE = new HashMap<>();
    private static HashMap<String, Method> METHODCACHE = new HashMap<>();
    private static HashMap<String, Constructor<?>> CONSTRUCTORCACHE = new HashMap<>();
    private static String KEY_WORD = "moku";

    private XposedUtil() throws IllegalAccessException {
        synchronized (XposedUtil.class) {
            if (flag) {
                throw new IllegalAccessException("xposed invoke error");
            }
            if (xposedUtil != null) {
                throw new IllegalAccessException("xposed invoke error");
            }
            flag = true;
        }
    }

    public static synchronized XposedUtil getInstance() throws IllegalAccessException {
        XposedUtil xposedUtil2;
        synchronized (XposedUtil.class) {
            if (xposedUtil == null) {
                xposedUtil = new XposedUtil();
            }
            xposedUtil2 = xposedUtil;
        }
        return xposedUtil2;
        return xposedUtil2;
    }

    public boolean hasXposedHelpers() {
        return tryLoadXposed(an.a);
    }

    public boolean isNative() {
        return SystemUtils.isNative(getClass()) || SystemUtils.isNative(SystemUtils.class) || SystemUtils.isNative(MokuUtils.class) || SystemUtils.isNative(PhoneInfoUtils.class);
    }

    private boolean tryLoadXposed(String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, IllegalArgumentException {
        try {
            Object objNewInstance = ClassLoader.getSystemClassLoader().loadClass(str).newInstance();
            Field declaredField = objNewInstance.getClass().getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof HashMap) {
                Iterator it = ((Map) obj).entrySet().iterator();
                while (it.hasNext()) {
                    if (((String) ((Map.Entry) it.next()).getKey()).toLowerCase().contains(KEY_WORD)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
