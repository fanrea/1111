package com.baidu.mobads.container.util.animation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab extends c.a {
    final /* synthetic */ aa a;
    private Shader b;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void a(float f, View view) {
        this.b = this.a.e.a(f, view, this.a.f);
        if (a.EnumC0133a.BACKGROUND.equals(this.a.a) && this.a.j != null && this.b != null) {
            this.a.j.getPaint().setShader(this.b);
        }
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void a(float f, Canvas canvas, c cVar) {
        Paint paint;
        if (a.EnumC0133a.PAINT.equals(this.a.a) && (paint = (Paint) cVar.a(a.a)) != null && this.b != null) {
            this.a.e.a(paint.getColor());
            paint.setShader(this.b);
        }
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void b(float f, Canvas canvas, c cVar) {
        Paint paint;
        if (a.EnumC0133a.PAINT.equals(this.a.a) && (paint = (Paint) cVar.a(a.a)) != null) {
            paint.setShader(null);
        }
    }
}
