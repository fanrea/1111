package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.ss.ttm.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d50 {
    private static Boolean a;

    public static float a(View view) {
        return pro.getFresult(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE, 1, view);
    }

    static int a(Rect rect, Rect rect2) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_HEAAVV2_PTS_MS_CORRECTION, 1, rect, rect2);
    }

    private static int a(View view, ViewGroup viewGroup) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VC1_BLOCKLIST, 1, view, viewGroup);
    }

    public static Pair<Boolean, Integer> a(View view, int i) {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_HCHIP_ADAPTIVE_WORKAROUND, 1, view, Integer.valueOf(i));
    }

    public static Pair<Boolean, Integer> a(View view, int i, int i2) {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND, 1, view, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static void a(int i, int i2, int i3, Object... objArr) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_DELAY_TIME, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), objArr);
    }

    public static boolean a(Context context, View view, int i) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_WASTE_BYTE, 1, context, view, Integer.valueOf(i));
    }

    public static boolean a(Context context, View view, int i, boolean z) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_TONEW, 1, context, view, Integer.valueOf(i), Boolean.valueOf(z));
    }

    public static boolean b(Context context, View view, int i, boolean z) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CPPBYTEVC1CODEC_OPT, 1, context, view, Integer.valueOf(i), Boolean.valueOf(z));
    }

    private static boolean b(View view) {
        return pro.getZresult(581, 1, view);
    }

    private static boolean b(View view, int i) {
        return pro.getZresult(582, 1, view, Integer.valueOf(i));
    }

    public static boolean c(View view) {
        return pro.getZresult(583, 1, view);
    }
}
