package com.bytedance.adsdk.ugeno.d.hc;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.d.u;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    public hc(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, String str, TreeMap<Float, String> treeMap) {
        super(context, bVar, str, treeMap);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.d.hc.hc$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[u.values().length];
            d = iArr;
            try {
                iArr[u.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[u.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[u.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[u.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[u.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[u.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[u.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[u.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[u.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void hc() {
        float fUo;
        switch (AnonymousClass1.d[this.c.ordinal()]) {
            case 1:
                fUo = this.h.uo();
                break;
            case 2:
                fUo = this.h.k();
                break;
            case 3:
                fUo = this.h.e();
                break;
            case 4:
                fUo = this.h.cb();
                break;
            case 5:
                fUo = this.h.w();
                break;
            case 6:
                fUo = this.h.yo();
                break;
            case 7:
                fUo = this.h.rf();
                break;
            case 8:
                fUo = this.h.jh();
                break;
            case 9:
                fUo = this.h.sy();
                break;
            default:
                fUo = 0.0f;
                break;
        }
        this.u.add(Keyframe.ofFloat(0.0f, fUo));
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public void d(float f, String str) {
        float fD;
        if (this.hc.startsWith(u.TRANSLATE.d()) || this.c == u.BORDER_RADIUS) {
            fD = gb.d(this.d, com.bytedance.adsdk.ugeno.an.b.d(str, 0.0f));
        } else {
            fD = com.bytedance.adsdk.ugeno.an.b.d(str, 0.0f);
        }
        this.u.add(Keyframe.ofFloat(f, fD));
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc.d
    public TypeEvaluator an() {
        return new FloatEvaluator();
    }
}
