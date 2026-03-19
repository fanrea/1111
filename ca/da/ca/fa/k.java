package ca.da.ca.fa;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.kuaishou.socket.nano.SocketMessages;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DisplayLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class k extends c {
    public final Context e;

    public k(Context context) {
        super(true, false);
        this.e = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException {
        String str;
        int iIntValue;
        ?? r1;
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2;
        DisplayMetrics displayMetrics3;
        int i = this.e.getResources().getDisplayMetrics().densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case 260:
            case 280:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case 420:
            case SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION_INFO /* 440 */:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
        DisplayMetrics displayMetrics4 = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            displayMetrics4 = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (defaultDisplay == null) {
                DisplayMetrics displayMetrics5 = this.e.getResources().getDisplayMetrics();
                if (displayMetrics5 != null) {
                    int i2 = displayMetrics5.widthPixels;
                    iIntValue = displayMetrics5.heightPixels;
                    r1 = i2;
                } else {
                    displayMetrics4 = null;
                }
            } else {
                defaultDisplay.getRealMetrics(displayMetrics4);
                ?? r0 = displayMetrics4.widthPixels;
                try {
                    int i3 = displayMetrics4.heightPixels;
                    r1 = r0;
                    iIntValue = i3;
                } catch (Throwable th3) {
                    displayMetrics4 = r0;
                    th = th3;
                    th.printStackTrace();
                    iIntValue = 0;
                    r1 = displayMetrics4;
                    ?? r3 = {r1, iIntValue};
                    jSONObject.put("resolution", r3[1] + "x" + r3[0]);
                    return true;
                }
            }
            ?? r32 = {r1, iIntValue};
            jSONObject.put("resolution", r32[1] + "x" + r32[0]);
            return true;
        }
        Method method = Display.class.getMethod("getRawHeight", new Class[0]);
        try {
            ?? IntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            try {
                iIntValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                r1 = IntValue;
            } catch (IllegalAccessException e) {
                e = e;
                displayMetrics3 = IntValue;
                e.printStackTrace();
                displayMetrics4 = displayMetrics3;
                iIntValue = 0;
                r1 = displayMetrics4;
                ?? r322 = {r1, iIntValue};
                jSONObject.put("resolution", r322[1] + "x" + r322[0]);
                return true;
            } catch (IllegalArgumentException e2) {
                e = e2;
                displayMetrics2 = IntValue;
                e.printStackTrace();
                displayMetrics4 = displayMetrics2;
                iIntValue = 0;
                r1 = displayMetrics4;
                ?? r3222 = {r1, iIntValue};
                jSONObject.put("resolution", r3222[1] + "x" + r3222[0]);
                return true;
            } catch (InvocationTargetException e3) {
                e = e3;
                displayMetrics = IntValue;
                e.printStackTrace();
                displayMetrics4 = displayMetrics;
                iIntValue = 0;
                r1 = displayMetrics4;
                ?? r32222 = {r1, iIntValue};
                jSONObject.put("resolution", r32222[1] + "x" + r32222[0]);
                return true;
            } catch (Throwable th4) {
                th = th4;
                displayMetrics4 = IntValue;
                th.printStackTrace();
                iIntValue = 0;
                r1 = displayMetrics4;
                ?? r322222 = {r1, iIntValue};
                jSONObject.put("resolution", r322222[1] + "x" + r322222[0]);
                return true;
            }
        } catch (IllegalAccessException e4) {
            e = e4;
            displayMetrics3 = null;
        } catch (IllegalArgumentException e5) {
            e = e5;
            displayMetrics2 = null;
        } catch (InvocationTargetException e6) {
            e = e6;
            displayMetrics = null;
        }
        ?? r3222222 = {r1, iIntValue};
        jSONObject.put("resolution", r3222222[1] + "x" + r3222222[0]);
        return true;
        iIntValue = 0;
        r1 = displayMetrics4;
        ?? r32222222 = {r1, iIntValue};
        jSONObject.put("resolution", r32222222[1] + "x" + r32222222[0]);
        return true;
    }
}
