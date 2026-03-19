package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aj {
    public static String c(Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bu.x(context, z)));
    }

    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", hu(aVar.getWidth())).replace("__HEIGHT__", hu(aVar.getHeight())).replace("__DOWN_X__", hu(aVar.aoT())).replace("__DOWN_Y__", hu(aVar.aoU())).replace("__UP_X__", hu(aVar.aoV())).replace("__UP_Y__", hu(aVar.aoW()));
    }

    public static String aD(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(m.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(m.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(m.dg(context))).replace("__DEVICE_HEIGHT__", String.valueOf(m.dh(context)));
    }

    private static String hu(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }

    public static class a {
        private int cmm;
        private int cmn;
        private int cmo;
        private int cmp;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.cmm = -1;
            this.cmn = -1;
            this.cmo = -1;
            this.cmp = -1;
        }

        public a(int i, int i2) {
            this.cmm = -1;
            this.cmn = -1;
            this.cmo = -1;
            this.cmp = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final void p(float f, float f2) {
            this.cmm = (int) f;
            this.cmn = (int) f2;
        }

        public final void q(float f, float f2) {
            this.cmo = (int) f;
            this.cmp = (int) f2;
        }

        public final void ac(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int aoT() {
            return this.cmm;
        }

        public final int aoU() {
            return this.cmn;
        }

        public final int aoV() {
            return this.cmo;
        }

        public final int aoW() {
            return this.cmp;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.cmm + ", mDownY=" + this.cmn + ", mUpX=" + this.cmo + ", mUpY=" + this.cmp + '}';
        }
    }
}
