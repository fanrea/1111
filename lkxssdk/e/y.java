package lkxssdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lingku.xuanshang.core.ui.base.BaseActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class y {
    public RelativeLayout a;
    public ImageView b;
    public boolean c;
    public BaseActivity d;
    public boolean e;
    public boolean f;
    public RotateAnimation g;
    public boolean h;
    public TextView i;

    public y(BaseActivity baseActivity) {
        this.d = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return this.e;
    }

    public final void a() {
        BaseActivity baseActivity = this.d;
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        View viewInflate = View.inflate(baseActivity, eVarA.b.getResources().getIdentifier("lkxs_view_picker_loading", "layout", eVarA.c), null);
        lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
        this.b = (ImageView) viewInflate.findViewById(eVarA2.b.getResources().getIdentifier("webAnim", "id", eVarA2.c));
        lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
        this.a = (RelativeLayout) viewInflate.findViewById(eVarA3.b.getResources().getIdentifier("webCallRL", "id", eVarA3.c));
        lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
        this.i = (TextView) viewInflate.findViewById(eVarA4.b.getResources().getIdentifier("msg", "id", eVarA4.c));
        this.a.setOnTouchListener(new View.OnTouchListener() { // from class: lkxssdk.e.y$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.a(view, motionEvent);
            }
        });
        this.d.addContentView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        this.c = true;
        Context applicationContext = this.d.getApplicationContext();
        lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
        this.g = (RotateAnimation) AnimationUtils.loadAnimation(applicationContext, eVarA5.b.getResources().getIdentifier("lkxs_loading_ani_circle", "anim", eVarA5.c));
    }

    public void a(String str, boolean z, boolean z2) {
        if (!this.c) {
            a();
        }
        this.e = z;
        this.f = z2;
        this.a.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            str = "数据加载中...";
        }
        this.i.setText(str);
        if (this.h) {
            return;
        }
        this.h = true;
        this.b.startAnimation(this.g);
    }

    public void b() {
        this.e = false;
        this.f = false;
        if (this.h) {
            this.h = false;
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.clearAnimation();
            }
        }
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }
}
