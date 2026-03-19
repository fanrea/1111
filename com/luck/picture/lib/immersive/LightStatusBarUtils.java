package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.kuaishou.socket.nano.SocketMessages;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LightStatusBarUtils {
    public static void setLightStatusBarAboveAPI23(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            setLightStatusBar(activity, z, z2, z3, z4);
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setLightStatusBar(activity, false, false, false, z);
    }

    public static void setLightStatusBar(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int lightStatusBarAvailableRomType = RomUtils.getLightStatusBarAvailableRomType();
        if (lightStatusBarAvailableRomType == 1) {
            if (RomUtils.getMIUIVersionCode() >= 7) {
                setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
                return;
            } else {
                setMIUILightStatusBar(activity, z, z2, z3, z4);
                return;
            }
        }
        if (lightStatusBarAvailableRomType == 2) {
            setFlymeLightStatusBar(activity, z, z2, z3, z4);
        } else {
            if (lightStatusBarAvailableRomType != 3) {
                return;
            }
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
        }
    }

    private static boolean setMIUILightStatusBar(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        initStatusBarStyle(activity, z, z2);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z4 ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            return false;
        }
    }

    private static boolean setFlymeLightStatusBar(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        boolean z5 = true;
        if (activity == null) {
            return false;
        }
        initStatusBarStyle(activity, z, z2);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z4 ? i | i2 : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
        } catch (Exception unused) {
            z5 = false;
        }
        try {
            if (RomUtils.getFlymeVersion() < 7) {
                return true;
            }
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            return true;
        } catch (Exception unused2) {
            setAndroidNativeLightStatusBar(activity, z, z2, z3, z4);
            return z5;
        }
    }

    private static void setAndroidNativeLightStatusBar(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            if (z3) {
                Window window = activity.getWindow();
                if (Build.VERSION.SDK_INT >= 21) {
                    if (z && z2) {
                        if (z4 && Build.VERSION.SDK_INT >= 23) {
                            window.getDecorView().setSystemUiVisibility(ErrorCode.EXECUTE_HYDRA_FAILED);
                        } else {
                            window.getDecorView().setSystemUiVisibility(256);
                        }
                    } else if (z || z2) {
                        if (z || !z2) {
                            return;
                        }
                        if (z4 && Build.VERSION.SDK_INT >= 23) {
                            window.getDecorView().setSystemUiVisibility(9472);
                        } else {
                            window.getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
                        }
                    } else if (z4 && Build.VERSION.SDK_INT >= 23) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
                    }
                }
            } else {
                View decorView = activity.getWindow().getDecorView();
                if (z4 && Build.VERSION.SDK_INT >= 23) {
                    decorView.setSystemUiVisibility(8192);
                } else {
                    decorView.setSystemUiVisibility(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void initStatusBarStyle(Activity activity, boolean z, boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            if (z && z2) {
                activity.getWindow().getDecorView().setSystemUiVisibility(256);
                return;
            }
            if (!z && !z2) {
                activity.getWindow().getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
            } else {
                if (z || !z2) {
                    return;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
            }
        }
    }
}
