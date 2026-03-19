package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;
import com.qq.e.comm.plugin.q6;
import com.qq.e.comm.plugin.rl;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j00 {
    public static rl a(xz xzVar, rl.b bVar, boolean z) throws JSONException {
        d00 d00Var = new d00(xzVar, bVar, xzVar.b().C1() && !z);
        xzVar.n = 3;
        if (d00Var.a() != null) {
            return d00Var;
        }
        xzVar.c().d(null);
        vz vzVar = new vz(xzVar, bVar);
        xzVar.n = 10;
        return vzVar;
    }

    static View a(FrameLayout frameLayout, String str, View.OnClickListener onClickListener, boolean z) {
        r40 r40Var = new r40(frameLayout.getContext(), str);
        r40Var.b(12, yu.b(frameLayout.getContext(), frameLayout.getHeight()) - 12, frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) r40Var.getLayoutParams();
        int i = pz.g;
        layoutParams.bottomMargin = i;
        layoutParams.bottomMargin = (z ? pz.k : 0) + i;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = 0;
        layoutParams.gravity = 83;
        r40Var.setLayoutParams(layoutParams);
        r40Var.a(onClickListener);
        r40Var.setId(8);
        return r40Var;
    }

    static Pair<FrameLayout.LayoutParams, FrameLayout.LayoutParams> a(boolean z) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pz.j);
        layoutParams.gravity = 80;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        int i = pz.g;
        layoutParams2.leftMargin = i;
        layoutParams2.bottomMargin = i;
        if (z) {
            i = (i * 2) + pz.b;
        }
        layoutParams2.rightMargin = i;
        return new Pair<>(layoutParams, layoutParams2);
    }

    static Pair<FrameLayout.LayoutParams, FrameLayout.LayoutParams> a(boolean z, int i, boolean z2, q6.b bVar, boolean z3) {
        int i2 = pz.g;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pz.b, pz.a);
        layoutParams.setMargins(i2, i2, i2, i2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(i2 - bVar.a, i2 - bVar.b, i2 - bVar.c, i2 - bVar.d);
        if (z || i == 0 || i == 1) {
            layoutParams2.gravity = BadgeDrawable.TOP_END;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            layoutParams2.topMargin += z2 ? pz.e : 0;
        } else if (i == 2) {
            layoutParams2.gravity = BadgeDrawable.TOP_START;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            layoutParams2.topMargin += z2 ? pz.e : 0;
        } else {
            layoutParams2.gravity = BadgeDrawable.BOTTOM_END;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            int i3 = layoutParams2.bottomMargin + (z2 ? pz.e : 0);
            layoutParams2.bottomMargin = i3;
            layoutParams2.bottomMargin = i3 + (z3 ? pz.k : 0);
        }
        return new Pair<>(layoutParams2, layoutParams);
    }

    static View a(Context context, View.OnClickListener onClickListener) {
        ImageView imageView = new ImageView(context);
        imageView.setId(4);
        q1.a(imageView);
        imageView.setOnClickListener(onClickListener);
        return imageView;
    }

    public static ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAJAAAAAAqDuP8AAADOElEQVRYCc2YvU8UQRiH947EeBo0xpgAKiGSyFFY2x6F0YbaWEHChc5/wP+EBBNJbKwsqIwFtBReY3FAkBBIhPhRINFL0Jz+nr2by9ywOzv3Bb7Jb/d25n1nnrzzsTuXizq3gkLuS/ek69JwU7pFJ00d674rbUs1KdhywZ5RNC3fh9K4lA+Mq8tvX9qQqiExIUAAPJLuhjTo8TlQ3XsJwFTzAZGFxxJZ6aeRrXcS2TtjQ2dKGgXMk2fSg5T6XorvKJhsM7/+uA0lAQGzIN12nfv4fENtFaWPUhuUC8QwkZlBwqj52K7oOiYB9Tcu0cUFeqKyQQyT6c+9k6nL0o6pICPGWE39nsCmbd/dbCWxjw3E0r4oa/VtgKZF4t1n8vl8tLi4ODE6OnoplBpfYojNMPqGobXjZg5VuVyeWFpamqtUKuWpqSkmpNfwwZcYYr3OjcqYAXSWOfPHa6urq5+Pjo6+joyM3FpfX5/3QVGHD77EEOttvFEJQwEgXpSZOT08PDwtlUqvsqBcGGKIbfTpvcYsXCa9blbl1tbWLx9UEgwxVhNZPyd5l81LE1KwJXVMsD1MgHcIQxN7AD2XbvLUiblQxJo50yUMTXwH6IUUvJSJMmZDUcb86gGGJk4zJzNeaZaTpdV1Ww4Qn50dW7FYvLq2tjbXHKYvWasvsIOTroBcGA3TCkPVB6gYiA/yYEuCYTVlbQmBHRyTod1A5ygNxsT3AWoXID4l66bRtDsvSnvOMExJ+wxlMzMzK/bwBb6QYdgGqCbtp4GY8tnZ2TFrn0mEMb6bm5s/bShiTZ3nDkPNLFte/U89zhGfELy1eVEGvpsiMgPM8vLyXr2eOQhv1H/VAMGyIHm/iXAakB2o3Ze0zZAZ4xB3Udbqe8giYPnzbcS56TxtQ519MB3aQJSxBTBsnAbOw+jvrZR6DKKCbYBDXOZnqnx6sW8Kfi39thtxM0QdJ0kObyzVQWWKzADDltNmSUA4GCgOcf2eU8wZhqktM3qOzV72psy9j6vgv/g7xgWbVgFHFQDt7cL1s5/remAHJitVuyLtd0iG3NiCCjipTErXpOGmdGv9pfdDvz9JLJAz80RlqfYPCdtkviGWkfgAAAAASUVORK5CYII="));
        return imageView;
    }
}
