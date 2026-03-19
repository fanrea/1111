package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.hc.d;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.adsdk.ugeno.hc.d<UGFrameLayout> {
    private UGFrameLayout rs;

    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: xp, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout d() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.hc);
        this.rs = uGFrameLayout;
        uGFrameLayout.d(this);
        return this.rs;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        this.rs.setEventMap(this.mb);
        super.hc();
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public d.C0176d gb() {
        return new C0179d(this);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.widget.frame.d$d, reason: collision with other inner class name */
    public static class C0179d extends d.C0176d {
        protected int he;

        public C0179d(com.bytedance.adsdk.ugeno.hc.d dVar) {
            super(dVar);
            this.he = -1;
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        public void d(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.d(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.he = d(str2);
            }
        }

        private int d(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iHc = 0;
            for (String str2 : strArrSplit) {
                iHc |= hc(str2);
            }
            return iHc;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int hc(java.lang.String r6) {
            /*
                r5 = this;
                r6.hashCode()
                int r0 = r6.hashCode()
                r1 = 5
                r2 = 3
                r3 = 1
                r4 = -1
                switch(r0) {
                    case -1383228885: goto L52;
                    case -1364013995: goto L47;
                    case -348726240: goto L3c;
                    case 115029: goto L31;
                    case 3317767: goto L26;
                    case 108511772: goto L1b;
                    case 1063616078: goto L10;
                    default: goto Le;
                }
            Le:
                r6 = r4
                goto L5c
            L10:
                java.lang.String r0 = "center_horizontal"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L19
                goto Le
            L19:
                r6 = 6
                goto L5c
            L1b:
                java.lang.String r0 = "right"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L24
                goto Le
            L24:
                r6 = r1
                goto L5c
            L26:
                java.lang.String r0 = "left"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L2f
                goto Le
            L2f:
                r6 = 4
                goto L5c
            L31:
                java.lang.String r0 = "top"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L3a
                goto Le
            L3a:
                r6 = r2
                goto L5c
            L3c:
                java.lang.String r0 = "center_vertical"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L45
                goto Le
            L45:
                r6 = 2
                goto L5c
            L47:
                java.lang.String r0 = "center"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L50
                goto Le
            L50:
                r6 = r3
                goto L5c
            L52:
                java.lang.String r0 = "bottom"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L5b
                goto Le
            L5b:
                r6 = 0
            L5c:
                switch(r6) {
                    case 0: goto L6e;
                    case 1: goto L6b;
                    case 2: goto L68;
                    case 3: goto L65;
                    case 4: goto L63;
                    case 5: goto L70;
                    case 6: goto L61;
                    default: goto L5f;
                }
            L5f:
                r1 = r4
                goto L70
            L61:
                r1 = r3
                goto L70
            L63:
                r1 = r2
                goto L70
            L65:
                r1 = 48
                goto L70
            L68:
                r1 = 16
                goto L70
            L6b:
                r1 = 17
                goto L70
            L6e:
                r1 = 80
            L70:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.frame.d.C0179d.hc(java.lang.String):int");
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        /* renamed from: hc, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams d() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.d, (int) this.hc);
            layoutParams.leftMargin = (int) this.an;
            layoutParams.rightMargin = (int) this.h;
            layoutParams.topMargin = (int) this.gb;
            layoutParams.bottomMargin = (int) this.tt;
            layoutParams.gravity = this.he;
            return layoutParams;
        }
    }
}
