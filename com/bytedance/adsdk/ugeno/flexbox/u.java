package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout;
import com.bytedance.adsdk.ugeno.hc.d;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends com.bytedance.adsdk.ugeno.hc.d<FlexboxLayout> {
    private int hr;
    private int ox;
    private int p;
    private int rs;
    private int tj;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: xp, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout d() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.hc);
        flexboxLayout.d(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        ((FlexboxLayout) this.u).setFlexDirection(this.rs);
        ((FlexboxLayout) this.u).setFlexWrap(this.tj);
        ((FlexboxLayout) this.u).setJustifyContent(this.ox);
        ((FlexboxLayout) this.u).setAlignItems(this.p);
        ((FlexboxLayout) this.u).setAlignContent(this.hr);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public d.C0176d gb() {
        return new d(this);
    }

    public static class d extends d.C0176d {
        public int ba;
        public int fs;
        public int he;
        public int j;
        public float s;
        public int us;
        public float vv;
        public int z;
        public float zw;

        public d(com.bytedance.adsdk.ugeno.hc.d dVar) {
            super(dVar);
            this.he = 1;
            this.vv = 0.0f;
            this.zw = 0.0f;
            this.j = -1;
            this.s = -1.0f;
            this.us = -1;
            this.z = -1;
            this.fs = 16777215;
            this.ba = 16777215;
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        public void d(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.d(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.s = c(str2);
                    break;
                case "order":
                    this.he = d(str2);
                    break;
                case "flexShrink":
                    this.zw = b(str2);
                    break;
                case "flexGrow":
                    this.vv = hc(str2);
                    break;
                case "alignSelf":
                    this.j = u(str2);
                    break;
            }
        }

        private int d(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                mq.d(e);
                return 1;
            }
        }

        private float hc(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                mq.d(e);
                return 0.0f;
            }
        }

        private float b(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                mq.d(e);
                return 0.0f;
            }
        }

        private float c(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                mq.d(e);
                return -1.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int u(java.lang.String r8) {
            /*
                r7 = this;
                r8.hashCode()
                int r0 = r8.hashCode()
                r1 = 4
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                r6 = -1
                switch(r0) {
                    case -1881872635: goto L3e;
                    case -1720785339: goto L33;
                    case -1364013995: goto L28;
                    case 1384876188: goto L1d;
                    case 1744442261: goto L12;
                    default: goto L10;
                }
            L10:
                r8 = r6
                goto L48
            L12:
                java.lang.String r0 = "flex_end"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L1b
                goto L10
            L1b:
                r8 = r1
                goto L48
            L1d:
                java.lang.String r0 = "flex_start"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L26
                goto L10
            L26:
                r8 = r2
                goto L48
            L28:
                java.lang.String r0 = "center"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L31
                goto L10
            L31:
                r8 = r3
                goto L48
            L33:
                java.lang.String r0 = "baseline"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L3c
                goto L10
            L3c:
                r8 = r4
                goto L48
            L3e:
                java.lang.String r0 = "stretch"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L47
                goto L10
            L47:
                r8 = r5
            L48:
                switch(r8) {
                    case 0: goto L54;
                    case 1: goto L53;
                    case 2: goto L51;
                    case 3: goto L4f;
                    case 4: goto L4d;
                    default: goto L4b;
                }
            L4b:
                r1 = r6
                goto L54
            L4d:
                r1 = r4
                goto L54
            L4f:
                r1 = r5
                goto L54
            L51:
                r1 = r3
                goto L54
            L53:
                r1 = r2
            L54:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.u.d.u(java.lang.String):int");
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        /* renamed from: hc, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.d d() {
            FlexboxLayout.d dVar = new FlexboxLayout.d((int) this.d, (int) this.hc);
            dVar.leftMargin = (int) this.an;
            dVar.rightMargin = (int) this.h;
            dVar.topMargin = (int) this.gb;
            dVar.bottomMargin = (int) this.tt;
            dVar.b(this.he);
            dVar.c(this.j);
            dVar.d(this.vv);
            dVar.hc(this.zw);
            dVar.b(this.s);
            return dVar;
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        public String toString() {
            return "LayoutParams{mWidth=" + this.d + ", mHeight=" + this.hc + ", mMargin=" + this.u + ", mMarginLeft=" + this.an + ", mMarginRight=" + this.h + ", mMarginTop=" + this.gb + ", mMarginBottom=" + this.tt + ", mParams=" + this.np + ", mOrder=" + this.he + ", mFlexGrow=" + this.vv + ", mFlexShrink=" + this.zw + ", mAlignSelf=" + this.j + ", mFlexBasisPercent=" + this.s + ", mMinWidth=" + this.us + ", mMinHeight=" + this.z + ", mMaxWidth=" + this.fs + ", mMaxHeight=" + this.ba + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.p = k(str2);
                break;
            case "flexDirection":
                this.rs = mk(str2);
                break;
            case "alignContent":
                this.hr = e(str2);
                break;
            case "flexWrap":
                this.tj = mq(str2);
                break;
            case "justifyContent":
                this.ox = uo(str2);
                break;
        }
    }

    int mk(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int mq(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int uo(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int k(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1881872635: goto L35;
                case -1720785339: goto L2b;
                case -1364013995: goto L21;
                case 1384876188: goto L17;
                case 1744442261: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            java.lang.String r0 = "flex_end"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r5
            goto L40
        L17:
            java.lang.String r0 = "flex_start"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r2
            goto L40
        L21:
            java.lang.String r0 = "center"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r4
            goto L40
        L2b:
            java.lang.String r0 = "baseline"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r3
            goto L40
        L35:
            java.lang.String r0 = "stretch"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r1
            goto L40
        L3f:
            r7 = -1
        L40:
            if (r7 == 0) goto L4c
            if (r7 == r5) goto L4b
            if (r7 == r4) goto L4a
            if (r7 == r3) goto L49
            return r1
        L49:
            return r3
        L4a:
            return r4
        L4b:
            return r5
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.u.k(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int e(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1881872635: goto L40;
                case -1364013995: goto L36;
                case -932331738: goto L2c;
                case 1384876188: goto L22;
                case 1682480591: goto L18;
                case 1744442261: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "flex_end"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r6
            goto L4b
        L18:
            java.lang.String r0 = "space_between"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r3
            goto L4b
        L22:
            java.lang.String r0 = "flex_start"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r2
            goto L4b
        L2c:
            java.lang.String r0 = "space_around"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r4
            goto L4b
        L36:
            java.lang.String r0 = "center"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r5
            goto L4b
        L40:
            java.lang.String r0 = "stretch"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r1
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L5a
            if (r8 == r6) goto L59
            if (r8 == r5) goto L58
            if (r8 == r4) goto L57
            if (r8 == r3) goto L56
            return r1
        L56:
            return r4
        L57:
            return r3
        L58:
            return r5
        L59:
            return r6
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.u.e(java.lang.String):int");
    }
}
