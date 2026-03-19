package com.baidu.mobads.container.rewardvideo;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.container.util.cf;
import com.component.a.f.e;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ah extends cf.a {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ double c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ boolean f;
    final /* synthetic */ com.component.a.a.f g;
    final /* synthetic */ NativeRewardActivity h;

    ah(NativeRewardActivity nativeRewardActivity, boolean z, String str, double d, String str2, String str3, boolean z2, com.component.a.a.f fVar) {
        this.h = nativeRewardActivity;
        this.a = z;
        this.b = str;
        this.c = d;
        this.d = str2;
        this.e = str3;
        this.f = z2;
        this.g = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() throws JSONException {
        int iB;
        String str;
        if (this.h.T) {
            return;
        }
        this.h.mCurrentRewardMode = this.a ? 1 : 2;
        if (this.h.mCurrentRewardMode != 1) {
            iB = 0;
        } else {
            iB = com.baidu.mobads.container.util.ab.b(this.h.mAppContext, this.h.mAdInstanceInfo);
        }
        if (this.h.aw != null) {
            com.component.a.i.f.a(this.h.aw, this.h.aw.getBackground());
            e.f fVarH = com.component.a.i.f.c((View) this.h.aw).h();
            fVarH.a().put(TypedValues.Custom.S_COLOR, this.b);
            fVarH.a().put("alpha", this.c);
            this.h.aw.setBackground(com.component.a.i.r.a(this.h.mAppContext, fVarH));
        }
        if (this.h.ax != null) {
            if (this.h.mCurrentRewardMode == 1) {
                str = "打开应用或观看XXs";
            } else {
                str = "点击广告或观看XXs";
            }
            com.component.a.i.f.c((View) this.h.ax).f().put("src", str + this.d);
        }
        String str2 = this.e + this.d;
        if (this.h.mCurrentRewardMode == 1 && TextUtils.equals(this.e, "点击广告")) {
            str2 = iB == 200 ? "打开应用" + this.d : iB == 101 ? "安装并打开应用" + this.d : "下载并打开应用" + this.d;
        }
        if (this.h.as != null) {
            this.h.as.a(str2);
        }
        if (!TextUtils.isEmpty(this.h.au)) {
            str2 = this.h.au;
        }
        if (this.h.av != null) {
            this.h.av.a(str2);
            if (this.f && (this.h.mRootTemplateView instanceof ViewGroup) && this.g != null) {
                for (int i = 0; i < ((ViewGroup) this.h.mRootTemplateView).getChildCount(); i++) {
                    View childAt = ((ViewGroup) this.h.mRootTemplateView).getChildAt(i);
                    if ((childAt instanceof ViewGroup) && com.baidu.mobads.container.util.cf.a((ViewGroup) childAt, this.h.av)) {
                        int iA = com.baidu.mobads.container.util.bv.a(this.h.mAppContext, com.component.a.i.f.c((View) this.g).a(61));
                        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA);
                        int[] iArr = new int[2];
                        this.h.av.getLocationOnScreen(iArr);
                        int[] iArr2 = new int[2];
                        this.h.mRootTemplateView.getLocationOnScreen(iArr2);
                        marginLayoutParams.leftMargin = ((iArr[0] - iArr2[0]) + this.h.av.getWidth()) - iA;
                        marginLayoutParams.topMargin = ((iArr[1] - iArr2[1]) + (this.h.av.getHeight() / 2)) - (iA / 2);
                        ((ViewGroup) this.h.mRootTemplateView).addView(this.g, i + 1, marginLayoutParams);
                    }
                }
            }
        }
    }
}
