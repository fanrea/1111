package com.fendasz.moku.planet.helper;

import android.content.Context;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AliyunHelper {
    private static final int NEED_ALIPAY_CODE = 8001;
    private static final String TAG = "MOKU_AliyunHelper=>";
    private static AliyunHelper aliyunHelper;
    private static String aliyunKey;
    private static Boolean isInit;
    private static Boolean needAliyun;

    public interface SessionCallBack {
        void onSession(Integer num, String str, String str2);
    }

    private AliyunHelper() {
    }

    public static AliyunHelper getInstance() {
        AliyunHelper aliyunHelper2;
        synchronized (AlipayHelper.class) {
            if (aliyunHelper == null) {
                aliyunHelper = new AliyunHelper();
            }
            aliyunHelper2 = aliyunHelper;
        }
        return aliyunHelper2;
    }

    public void init(Integer num, String str) {
        LogUtils.logD(TAG, "init aliyun healper,code:" + num);
        aliyunKey = str;
        setNeedAliyun(num);
    }

    public boolean needGetKey() {
        String str;
        LogUtils.logD(TAG, "needGetKey_needAliyun:" + needAliyun + ",aliyunKey:" + aliyunKey);
        Boolean bool = needAliyun;
        if (bool != null && bool.booleanValue() && (str = aliyunKey) != null && !StringUtils.isEmpty(str)) {
            return false;
        }
        LogUtils.logD(TAG, "needGetKey true");
        return true;
    }

    public void uploadDeviceToken(Context context, final SessionCallBack sessionCallBack) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        LogUtils.logD(TAG, "uploadDeviceToken invoke，needAliyun:" + needAliyun);
        Boolean bool = needAliyun;
        if (bool == null || !bool.booleanValue()) {
            LogUtils.logD(TAG, "uploadDeviceToken not need used aliyun device");
            return;
        }
        try {
            LogUtils.logD(TAG, "init invoke start");
            Class<?> cls = Class.forName("net.security.device.api.SecurityDevice");
            Object objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (objInvoke == null || !cls.isInstance(objInvoke)) {
                return;
            }
            cls.getDeclaredMethod(PointCategory.INIT, Context.class, String.class, Class.forName("net.security.device.api.SecurityInitListener")).invoke(objInvoke, context, aliyunKey, Proxy.newProxyInstance(AliyunHelper.class.getClassLoader(), new Class[]{Class.forName("net.security.device.api.SecurityInitListener")}, new InvocationHandler() { // from class: com.fendasz.moku.planet.helper.AliyunHelper.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    try {
                        if (method.getName().equals("onInitFinish")) {
                            System.out.println("Initialization finished with result code: " + ((Integer) objArr[0]).intValue());
                        }
                    } catch (Exception e) {
                        sessionCallBack.onSession(7700, "resources not find", null);
                        LogUtils.logI(AliyunHelper.TAG, "error msg:" + e.getMessage());
                    }
                    return null;
                }
            }));
            Object objInvoke2 = cls.getDeclaredMethod("getSession", new Class[0]).invoke(objInvoke, new Object[0]);
            Class<?> cls2 = Class.forName("net.security.device.api.SecuritySession");
            Field declaredField = cls2.getDeclaredField("code");
            Field declaredField2 = cls2.getDeclaredField("session");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(objInvoke2)).intValue();
            final String str = (String) declaredField2.get(objInvoke2);
            LogUtils.logD(TAG, "SecuritySession code: " + iIntValue);
            LogUtils.logD(TAG, "SecuritySession session: " + str);
            if (str == null || StringUtils.isEmpty(str)) {
                return;
            }
            ApiDataHelper.getApiDataHelper().uploadAliyunSession(context, str, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.helper.AliyunHelper.2
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, Object obj) throws Exception {
                    LogUtils.logD(AliyunHelper.TAG, "uploadAliyunToken success");
                    SessionCallBack sessionCallBack2 = sessionCallBack;
                    if (sessionCallBack2 != null) {
                        sessionCallBack2.onSession(Integer.valueOf(i), "success", str);
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str2) throws Exception {
                    LogUtils.logD(AliyunHelper.TAG, "uploadAliyunToken error,code:" + i + ",message:" + str2);
                    SessionCallBack sessionCallBack2 = sessionCallBack;
                    if (sessionCallBack2 != null) {
                        sessionCallBack2.onSession(Integer.valueOf(i), str2, str);
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e.getMessage());
            if (sessionCallBack != null) {
                sessionCallBack.onSession(7700, "resources not find", null);
            }
        } catch (IllegalAccessException e2) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e2.getMessage());
            if (sessionCallBack != null) {
                sessionCallBack.onSession(7700, "resources not find", null);
            }
        } catch (NoSuchFieldException e3) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e3.getMessage());
            if (sessionCallBack != null) {
                sessionCallBack.onSession(7700, "resources not find", null);
            }
        } catch (NoSuchMethodException e4) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e4.getMessage());
            if (sessionCallBack != null) {
                sessionCallBack.onSession(7700, "resources not find", null);
            }
        } catch (NullPointerException e5) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e5.getMessage());
        } catch (InvocationTargetException e6) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e6.getMessage());
            if (sessionCallBack != null) {
                sessionCallBack.onSession(7700, "resources not find", null);
            }
        } catch (Exception e7) {
            LogUtils.logE(TAG, "uploadDeviceToken error");
            LogUtils.logI(TAG, "error msg:" + e7.getMessage());
        }
    }

    private void setNeedAliyun(Integer num) {
        LogUtils.logD(TAG, "setNeedAliyun_code:" + num);
        if (num != null && 8001 == num.intValue()) {
            needAliyun = true;
        } else {
            needAliyun = false;
        }
    }
}
