package lkxssdk.m0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public static b a = null;
    public static Field b = null;
    public static Field c = null;
    public static boolean d = false;
    public lkxssdk.m0.a e;
    public Context f = lkxssdk.a.a.d();

    public static class a extends Handler {
        public Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler handler = this.a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public void a(String str, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        lkxssdk.m0.a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
        }
        lkxssdk.m0.a aVar2 = new lkxssdk.m0.a(this.f);
        this.e = aVar2;
        aVar2.setDuration(i);
        lkxssdk.m0.a aVar3 = this.e;
        aVar3.getClass();
        RelativeLayout relativeLayout = new RelativeLayout(aVar3.a);
        RelativeLayout relativeLayout2 = new RelativeLayout(aVar3.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(lkxssdk.a0.b.a(200.0f), -2);
        layoutParams.addRule(13);
        TextView textView = new TextView(aVar3.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        textView.setGravity(17);
        int iA = lkxssdk.a0.b.a(16.0f);
        textView.setPadding(iA, iA, iA, iA);
        textView.setText(Html.fromHtml(str));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(8);
        gradientDrawable.setColor(Color.parseColor("#cc000000"));
        textView.setBackgroundDrawable(gradientDrawable);
        relativeLayout2.addView(textView, layoutParams2);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(relativeLayout2, layoutParams);
        aVar3.setView(relativeLayout);
        lkxssdk.m0.a aVar4 = this.e;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 25 || i2 == 24) {
            try {
                if (!d) {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    b = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = b.getType().getDeclaredField("mHandler");
                    c = declaredField2;
                    declaredField2.setAccessible(true);
                    d = true;
                }
                Object obj = b.get(aVar4);
                c.set(obj, new a((Handler) c.get(obj)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.e.show();
    }
}
