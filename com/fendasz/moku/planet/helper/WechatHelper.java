package com.fendasz.moku.planet.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.fendasz.moku.planet.utils.LogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WechatHelper {
    private static String TAG = "WechatHelper";
    private static WechatHelper wechatHelper;

    private WechatHelper() {
    }

    public static WechatHelper getInstance() {
        WechatHelper wechatHelper2;
        synchronized (WechatHelper.class) {
            if (wechatHelper == null) {
                wechatHelper = new WechatHelper();
            }
            wechatHelper2 = wechatHelper;
        }
        return wechatHelper2;
    }

    public void toMiniProgram(String str, String str2, Context context) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        try {
            Object objInvoke = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getDeclaredMethod("createWXAPI", Context.class, String.class).invoke(null, context, str);
            if (objInvoke != null) {
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                Object objNewInstance = cls.newInstance();
                Field[] fields = cls.getFields();
                Log.d(TAG, str2);
                for (Field field : fields) {
                    String name = field.getName();
                    if ("miniprogramType".equals(name)) {
                        field.setInt(objNewInstance, 0);
                    } else if ("userName".equals(name)) {
                        field.set(objNewInstance, "gh_7219b1574313");
                    } else if ("path".equals(name)) {
                        field.set(objNewInstance, str2);
                    }
                }
                Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq");
                Class<?> cls3 = objInvoke.getClass();
                Object objInvoke2 = cls3.getMethod("isWXAppInstalled", new Class[0]).invoke(objInvoke, new Object[0]);
                if (objInvoke2 != null) {
                    try {
                        z = Boolean.parseBoolean(objInvoke2.toString());
                    } catch (Exception unused) {
                        LogUtils.logE(TAG, "no install wechat");
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(context, "请先安装微信", 0).show();
                        return;
                    }
                }
                Method method = cls3.getMethod("sendReq", cls2);
                cls3.getMethod("registerApp", String.class).invoke(objInvoke, str);
                method.invoke(objInvoke, objNewInstance);
            }
        } catch (ClassNotFoundException unused2) {
            LogUtils.logE(TAG, "not init wechat development environment");
        } catch (IllegalAccessException unused3) {
            LogUtils.logE(TAG, "not init wechat development environment");
        } catch (InstantiationException unused4) {
            LogUtils.logE(TAG, "not init wechat development environment");
        } catch (NoSuchMethodException unused5) {
            LogUtils.logE(TAG, "not init wechat development environment");
        } catch (NullPointerException unused6) {
            LogUtils.logE(TAG, "wechat error");
        } catch (InvocationTargetException unused7) {
            LogUtils.logE(TAG, "not init wechat development environment");
        }
    }
}
