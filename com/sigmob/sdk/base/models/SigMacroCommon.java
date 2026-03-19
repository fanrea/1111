package com.sigmob.sdk.base.models;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.utils.m;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SigMacroCommon extends BaseMacroCommon {
    public static final String _ADSCENEID_ = "_ADSCENEID_";
    public static final String _ADSCENE_ = "_ADSCENE_";
    public static final String _BEGINTIME_ = "_BEGINTIME_";
    public static final String _BEHAVIOR_ = "_BEHAVIOR_";
    public static final String _CLICKAREA_ = "_CLICKAREA_";
    public static final String _CLICKID_ = "_CLICKID_";
    public static final String _CLICKSCENE_ = "_CLICKSCENE_";
    public static final String _COMPLETED_ = "_COMPLETED_";
    public static final String _CURRENCY_ = "_CURRENCY_";
    private static final String _DOWNTS_ = "_DOWNTS_";
    public static final String _DOWNX_ = "_DOWNX_";
    public static final String _DOWNY_ = "_DOWNY_";
    public static final String _ENDTIME_ = "_ENDTIME_";
    public static final String _FINALCLICK_ = "_FINALCLICK_";
    public static final String _HEIGHT_ = "_HEIGHT_";
    public static final String _HIGHESTLOSSPRICE_ = "_HIGHESTLOSSPRICE_";
    public static final String _ISNC_ = "_ISNC_";
    public static final String _IS_TRUNCATION_ = "_ISTRUNCATION_";
    public static final String _PLAYFIRSTFRAME_ = "_PLAYFIRSTFRAME_";
    public static final String _PLAYLASTFRAME_ = "_PLAYLASTFRAME_";
    public static final String _PROGRESS_ = "_PROGRESS_";
    public static final String _PUBLISHERPRICE_ = "_PUBLISHERPRICE_";
    public static final String _SCENE_ = "_SCENE_";
    public static final String _SETCLOSETIME_ = "_SETCLOSETIME_";
    public static final String _SHOWSKIPTIME_ = "_SHOWSKIPTIME_";
    public static final String _SLD_ = "_SLD_";
    public static final String _SLOTHEIGHT_ = "_SLOTHEIGHT_";
    public static final String _SLOTWIDTH_ = "_SLOTWIDTH_";
    public static final String _STATUS_ = "_STATUS_";
    public static final String _TEMPLATE_ = "_TEMPLATE_";
    public static final String _TYPE_ = "_TYPE_";
    private static final String _UPTS_ = "_UPTS_";
    public static final String _UPX_ = "_UPX_";
    public static final String _UPY_ = "_UPY_";
    public static final String _VIDEOTIME_ = "_VIDEOTIME_";
    public static final String _VMD5_ = "_VMD5_";
    public static final String _VURL_ = "_VURL_";
    public static final String _WIDTH_ = "_WIDTH_";
    private static final long serialVersionUID = 1;
    private static final long initialUptimeMillis = SystemClock.uptimeMillis();
    private static final long initialCurrentTimeMillis = System.currentTimeMillis();

    public static long convertUptimeMillisToCurrentTimeMillis(long uptimeMillis) {
        return initialCurrentTimeMillis + (uptimeMillis - initialUptimeMillis);
    }

    public static String getCoordinate(MotionEvent down, MotionEvent up, boolean isRaw) {
        Context contextE = b.e();
        return isRaw ? String.format(Locale.getDefault(), "%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(down.getRawX(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(down.getRawY(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(up.getRawX(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(up.getRawX(), contextE))) : String.format(Locale.getDefault(), "%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(down.getX(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(down.getY(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(up.getX(), contextE)), Integer.valueOf(Dips.pixelsToIntDips(up.getY(), contextE)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String getMacroValue(String macroName) {
        char c = 65535;
        try {
            switch (macroName.hashCode()) {
                case -1590308376:
                    if (macroName.equals(_BEGINTIME_)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1494891674:
                    if (macroName.equals(_TYPE_)) {
                        c = 0;
                        break;
                    }
                    break;
                case -662306149:
                    if (macroName.equals(_SLOTHEIGHT_)) {
                        c = 7;
                        break;
                    }
                    break;
                case -415971623:
                    if (macroName.equals(_HEIGHT_)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 853731986:
                    if (macroName.equals(_SCENE_)) {
                        c = 1;
                        break;
                    }
                    break;
                case 891331278:
                    if (macroName.equals(_BEHAVIOR_)) {
                        c = 3;
                        break;
                    }
                    break;
                case 973765784:
                    if (macroName.equals(_WIDTH_)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1179083118:
                    if (macroName.equals(_STATUS_)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2074198166:
                    if (macroName.equals(_SLOTWIDTH_)) {
                        c = 5;
                        break;
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
        switch (c) {
            case 0:
                return "1";
            case 1:
            case 2:
                return "0";
            case 3:
                return "2";
            case 4:
                return "0";
            case 5:
            case 6:
                return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
            case 7:
            case '\b':
                return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
            default:
                return "unFind";
        }
    }

    public String getCoordinate() {
        return String.format("%s,%s,%s,%s", getMarcoKey(_DOWNX_), getMarcoKey(_DOWNY_), getMarcoKey(_UPX_), getMarcoKey(_UPY_));
    }

    public String replaceWithDefault(String key) {
        String strReplaceWithDefault = super.replaceWithDefault(key);
        SigmobLog.d("macroProcess() called with:[" + key + "][" + strReplaceWithDefault + "]");
        if (m.b(strReplaceWithDefault) && !strReplaceWithDefault.equals("unFind")) {
            return strReplaceWithDefault;
        }
        try {
            String macroValue = getMacroValue(key);
            SigmobLog.d("macroProcess() called with: [" + key + "][" + macroValue + "]");
            if (!m.b(macroValue)) {
                return null;
            }
            if (macroValue.equals("unFind")) {
                return null;
            }
            return macroValue;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public void updateClickMarco(MotionEvent down, MotionEvent up, boolean isRaw) {
        int iNextInt;
        if (down == null) {
            iNextInt = new Random().nextInt(50);
            down = up;
        } else {
            iNextInt = 0;
        }
        Context contextE = b.e();
        float rawX = isRaw ? down.getRawX() : down.getX();
        float rawY = isRaw ? down.getRawY() : down.getY();
        float rawX2 = isRaw ? up.getRawX() : up.getX();
        float rawY2 = isRaw ? up.getRawY() : up.getY();
        addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(rawX, contextE)));
        addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(rawY, contextE)));
        addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(rawX2, contextE)));
        addMarcoKey(_UPY_, String.valueOf(Dips.pixelsToIntDips(rawY2, contextE)));
        addMarcoKey(_UPTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(up.getEventTime() + iNextInt)));
        addMarcoKey(_DOWNTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(down.getEventTime())));
        addMarcoKey(_SLD_, "0");
    }

    public void updateClickMarco(TouchLocation down, TouchLocation up) {
        if (down == null && up == null) {
            return;
        }
        if (up == null) {
            up = down;
        } else if (down == null) {
            down = up;
        }
        Context contextE = b.e();
        updateClickMarco(String.valueOf(Dips.pixelsToIntDips(down.getX(), contextE)), String.valueOf(Dips.pixelsToIntDips(down.getY(), contextE)), String.valueOf(Dips.pixelsToIntDips(up.getX(), contextE)), String.valueOf(Dips.pixelsToIntDips(up.getY(), contextE)));
        addMarcoKey(_SLD_, "0");
    }

    public void updateClickMarco(String dx, String dy, String ux, String uy) {
        Random random = new Random();
        addMarcoKey(_DOWNX_, dx);
        addMarcoKey(_DOWNY_, dy);
        addMarcoKey(_UPX_, ux);
        addMarcoKey(_UPY_, uy);
        if (dx.equals("-999")) {
            return;
        }
        addMarcoKey(_DOWNTS_, String.valueOf(System.currentTimeMillis()));
        addMarcoKey(_UPTS_, String.valueOf(System.currentTimeMillis() + random.nextInt(50)));
    }
}
