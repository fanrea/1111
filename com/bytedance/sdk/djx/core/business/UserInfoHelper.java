package com.bytedance.sdk.djx.core.business;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.bytedance.sdk.djx.utils.SP;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UserInfoHelper {
    private static final String DEFAULT_AVATAR = "";
    private static final String DEFAULT_USERNAME = "游客";
    private static final String SP_KEY_AVATAR = "userinfo_avatar";
    private static final String SP_KEY_TIMESTAMP = "userinfo_timestamp";
    private static final String SP_KEY_USERNAME = "userinfo_username";
    private static volatile UserInfoHelper sInstance;
    private String avatar = SP.defaults().getString(SP_KEY_AVATAR, "");
    private String userName = SP.defaults().getString(SP_KEY_USERNAME, DEFAULT_USERNAME);
    private Long timeStamp = Long.valueOf(SP.defaults().getLong(SP_KEY_TIMESTAMP, 0));

    public static UserInfoHelper getInstance() {
        if (sInstance == null) {
            synchronized (UserInfoHelper.class) {
                if (sInstance == null) {
                    sInstance = new UserInfoHelper();
                }
            }
        }
        return sInstance;
    }

    public void setUserInfo(final Bitmap bitmap, final String str) {
        new Thread(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.UserInfoHelper.1
            @Override // java.lang.Runnable
            public void run() {
                UserInfoHelper userInfoHelper = UserInfoHelper.this;
                userInfoHelper.avatar = userInfoHelper.bitmapExecution(bitmap);
                SP.defaults().put(UserInfoHelper.SP_KEY_AVATAR, UserInfoHelper.this.avatar);
                if (UserInfoHelper.this.userName.contentEquals(str)) {
                    return;
                }
                UserInfoHelper.this.userName = str;
                UserInfoHelper.this.timeStamp = Long.valueOf(System.currentTimeMillis());
                if (UserInfoHelper.this.timeStamp.longValue() != 0) {
                    UserInfoHelper userInfoHelper2 = UserInfoHelper.this;
                    userInfoHelper2.timeStamp = Long.valueOf(userInfoHelper2.timeStamp.longValue() / 1000);
                }
                SP.defaults().put(UserInfoHelper.SP_KEY_USERNAME, UserInfoHelper.this.userName);
                SP.defaults().put(UserInfoHelper.SP_KEY_TIMESTAMP, UserInfoHelper.this.timeStamp.longValue());
            }
        }).start();
    }

    public void clearUserInfo() {
        this.avatar = "";
        this.userName = DEFAULT_USERNAME;
        this.timeStamp = 0L;
        SP.defaults().put(SP_KEY_AVATAR, this.avatar);
        SP.defaults().getString(SP_KEY_USERNAME, this.userName);
        SP.defaults().getLong(SP_KEY_TIMESTAMP, this.timeStamp.longValue());
    }

    public String getAvatar(Long l) {
        return (this.timeStamp.longValue() != 0 && this.timeStamp.longValue() <= l.longValue()) ? this.avatar : "";
    }

    public String getUserName(Long l) {
        return (this.timeStamp.longValue() != 0 && this.timeStamp.longValue() <= l.longValue()) ? this.userName : DEFAULT_USERNAME;
    }

    public String bitmapExecution(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = 40;
        Matrix matrix = new Matrix();
        matrix.postScale(f / width, f / height);
        return bitmapToBase64(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String bitmapToBase64(android.graphics.Bitmap r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L5a
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r3 = 100
            r5.compress(r2, r3, r1)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r1.flush()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r1.close()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            byte[] r5 = r1.toByteArray()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r2.<init>()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            java.lang.String r3 = "data:image/png;base64,"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r3 = 0
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r3)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            java.lang.StringBuilder r5 = r2.append(r5)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r0 = r1
            goto L5b
        L33:
            r5 = move-exception
            goto L39
        L35:
            r5 = move-exception
            goto L4c
        L37:
            r5 = move-exception
            r1 = r0
        L39:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L69
            r1.flush()     // Catch: java.io.IOException -> L45
            r1.close()     // Catch: java.io.IOException -> L45
            goto L69
        L45:
            r5 = move-exception
            r5.printStackTrace()
            goto L69
        L4a:
            r5 = move-exception
            r0 = r1
        L4c:
            if (r0 == 0) goto L59
            r0.flush()     // Catch: java.io.IOException -> L55
            r0.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            r0.printStackTrace()
        L59:
            throw r5
        L5a:
            r5 = r0
        L5b:
            if (r0 == 0) goto L68
            r0.flush()     // Catch: java.io.IOException -> L64
            r0.close()     // Catch: java.io.IOException -> L64
            goto L68
        L64:
            r0 = move-exception
            r0.printStackTrace()
        L68:
            r0 = r5
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.UserInfoHelper.bitmapToBase64(android.graphics.Bitmap):java.lang.String");
    }
}
