package net.security.device.api;

import android.content.Context;
import net.security.device.api.id.DeviceID;
import net.security.device.api.id.IGAID;
import net.security.device.api.id.IGAIDGetter;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class SecurityDevice {
    private static SecurityDevice s_instance;
    private String userAppKey;
    private Context ctx = null;
    private boolean isInited = false;
    private Thread initThread = null;
    private Thread otherThread = null;

    private native SecuritySessionId getSessionIdRaw();

    private native SecuritySession getSessionRaw();

    public static native String gs(String str);

    private native int initRaw(Context context, String str, int i);

    private native void lxRaw();

    private native void otherThreadInit(Context context, String str);

    private native void reportUserDataRaw(String str, String str2);

    public static native void reserved0();

    public static native void reserved1();

    private native void setAppKeyRaw(Context context, String str);

    private native void setId1Raw(String str);

    private native void setId2Raw(String str);

    private native void setUrlHost(String str, String str2);

    static {
        System.loadLibrary("securitydevice");
        s_instance = new SecurityDevice();
    }

    public static SecurityDevice getInstance() {
        return s_instance;
    }

    private Context getCtx() {
        return this.ctx;
    }

    private void initCommon(Context context, String str, SecurityInitListener securityInitListener, final int i) {
        if (context == null || str == null || str.isEmpty()) {
            if (securityInitListener != null) {
                securityInitListener.onInitFinish(10010);
                return;
            }
            return;
        }
        if (this.isInited) {
            if (securityInitListener != null) {
                securityInitListener.onInitFinish(10000);
                return;
            }
            return;
        }
        this.isInited = true;
        this.userAppKey = str;
        this.ctx = context.getApplicationContext();
        SecurityUtil.utilInit();
        setAppKeyRaw(this.ctx, this.userAppKey);
        if (this.initThread == null) {
            Thread thread = new Thread(new Runnable() { // from class: net.security.device.api.SecurityDevice.1
                @Override // java.lang.Runnable
                public void run() {
                    SecurityDevice.getInstance().runInit(i);
                }
            });
            this.initThread = thread;
            thread.start();
        }
        if (this.otherThread == null) {
            Thread thread2 = new Thread(new Runnable() { // from class: net.security.device.api.SecurityDevice.2
                @Override // java.lang.Runnable
                public void run() {
                    SecurityDevice.getInstance().otherThreadRun();
                }
            });
            this.otherThread = thread2;
            thread2.start();
        }
        if (securityInitListener != null) {
            securityInitListener.onInitFinish(10000);
        }
    }

    public void init(Context context, String str, SecurityInitListener securityInitListener) {
        initCommon(context, str, securityInitListener, 0);
    }

    public void initV6(Context context, String str, SecurityInitListener securityInitListener) {
        initCommon(context, str, securityInitListener, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runInit(int i) {
        initRaw(getCtx(), this.userAppKey, i);
        this.isInited = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void otherThreadRun() {
        otherThreadInit(getCtx(), this.userAppKey);
    }

    public SecuritySession getSession() {
        return getSessionRaw();
    }

    public void reportUserData(int i, String str) {
        reportUserDataRaw(String.valueOf(i + 10000), str);
    }

    public void setServer(String str, String str2) {
        if (str.isEmpty()) {
            return;
        }
        setUrlHost(str, str2);
    }

    public void lx() {
        lxRaw();
    }

    public boolean getId1() {
        IOAID ioaidWithOAID;
        Context context = this.ctx;
        if (context == null || (ioaidWithOAID = DeviceID.withOAID(context)) == null || !ioaidWithOAID.supportOAID()) {
            return false;
        }
        ioaidWithOAID.doGet(new IOAIDGetter() { // from class: net.security.device.api.SecurityDevice.3
            @Override // net.security.device.api.id.IOAIDGetter
            public void onOAIDGetError(Exception exc) {
            }

            @Override // net.security.device.api.id.IOAIDGetter
            public void onOAIDGetComplete(String str) {
                SecurityDevice.this.setId1(str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId1(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        setId1Raw(str);
    }

    public boolean getId2() {
        IGAID igaidWithGAID;
        Context context = this.ctx;
        if (context == null || (igaidWithGAID = DeviceID.withGAID(context)) == null || !igaidWithGAID.supportGAID()) {
            return false;
        }
        igaidWithGAID.doGet(new IGAIDGetter() { // from class: net.security.device.api.SecurityDevice.4
            @Override // net.security.device.api.id.IGAIDGetter
            public void onGAIDGetError(Exception exc) {
            }

            @Override // net.security.device.api.id.IGAIDGetter
            public void onGAIDGetComplete(String str) {
                SecurityDevice.this.setId2(str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId2(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        setId2Raw(str);
    }

    public SecuritySessionId getSessionId() {
        if (!this.isInited) {
            SecuritySessionId securitySessionId = new SecuritySessionId();
            securitySessionId.code = 10001;
            securitySessionId.sessionId = "";
            return securitySessionId;
        }
        return getSessionIdRaw();
    }

    public static long getTestArtMethod() {
        try {
            return SecurityUtil.getArtMethod(SecurityDevice.class.getDeclaredMethod("reserved0", new Class[0]));
        } catch (Exception unused) {
            return 0L;
        }
    }
}
