package com.component.a.g.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.cf;
import com.component.a.g.c.e;
import com.component.a.i.f;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aa extends com.component.a.g.c.e {
    private f a;
    private h b;
    private g c;
    private d d;
    private e e;

    public static abstract class i extends com.component.a.d.c {
        private a a;
        AtomicInteger p;
        boolean q;

        public interface a {
            void a();

            void a(boolean z);
        }

        protected abstract void a();

        protected abstract void b();

        protected abstract void c();

        protected abstract void d();

        protected abstract void e();

        i(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.p = new AtomicInteger(0);
            this.q = eVar.e(-1) == 1;
        }

        final void i() {
            a();
            b();
        }

        public void j() {
            this.p.set(1);
            c();
        }

        public void k() {
            if (!this.p.compareAndSet(1, 2)) {
                return;
            }
            d();
        }

        public void l() {
            if (this.p.getAndSet(3) == 3) {
                return;
            }
            e();
        }

        public void a(a aVar) {
            this.a = aVar;
        }

        protected void m() {
            if (this.a != null) {
                this.a.a();
            }
        }

        protected void b(boolean z) {
            if (this.a != null) {
                this.a.a(z);
            }
        }
    }

    public static abstract class j extends i {
        private final List<Runnable> a;
        protected final int k;
        protected int l;

        j(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.a = new CopyOnWriteArrayList();
            JSONObject jSONObjectC = eVar.c();
            this.k = jSONObjectC.optInt("delay_time", AVMDLDataLoader.KeyIsFileKeyRule);
            this.l = jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, 5000);
        }

        protected void a(cf.a aVar, long j) {
            this.a.add(aVar);
            postDelayed(aVar, j);
        }

        protected void n() {
            Iterator<Runnable> it = this.a.iterator();
            while (it.hasNext()) {
                removeCallbacks(it.next());
            }
            this.a.clear();
        }

        @Override // com.component.a.g.c.aa.i
        protected void b() {
            if (!this.q) {
                setVisibility(8);
                return;
            }
            setVisibility(4);
            n();
            if (this.k >= 0) {
                a(new bh(this), this.k);
            }
        }

        @Override // com.component.a.g.c.aa.i
        protected void c() {
            if (this.l >= 0) {
                a(new bi(this), this.l);
            }
        }

        @Override // com.component.a.g.c.aa.i
        protected void d() {
            n();
        }

        @Override // com.component.a.g.c.aa.i
        protected void e() {
            n();
        }
    }

    public static class c extends j {
        final AnimatorSet a;
        View b;
        com.component.a.a.q d;
        com.component.a.a.f e;
        com.component.a.a.f f;
        com.component.a.a.f g;
        com.component.a.a.q h;
        View i;
        View j;

        c(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.a = new AnimatorSet();
            eVar.c();
        }

        private Animator a(View view, int i) {
            return com.baidu.mobads.container.util.animation.e.a(view, i, new ai(this, view));
        }

        private Animator b(View view, int i) {
            return com.baidu.mobads.container.util.animation.e.a(view, i, new aj(this, view));
        }

        private Animator c(View view, int i) {
            com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(view).b(0).a(240).b("0.9").c("1.02").a(a.b.SCALE);
            com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(view).b(240).a(120).b("1.02").c("1").a(a.b.SCALE);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVarA);
            arrayList.add(aVarA2);
            return com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(view).b(i).a(arrayList).a(a.b.GROUP));
        }

        private void a(List<com.component.a.a.f> list, View view) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.component.a.a.f> it = list.iterator();
            int i = SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_CANCEL_APPLY;
            while (it.hasNext()) {
                arrayList.add(a(it.next(), i));
                i += 80;
            }
            arrayList.add(a(view, 1360));
            arrayList.add(a(this.d, 1360));
            arrayList.add(b(this.h, 1520));
            arrayList.add(c(this.i, 1520));
            arrayList.add(c(this.j, 1520));
            this.a.playTogether(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.component.a.a.f> list, com.component.a.a.f fVar) {
            n();
            list.remove(fVar);
            fVar.f();
            a(list, (View) fVar);
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "flip_card_close_view");
            this.d = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "flip_card_start_text", com.component.a.a.q.class);
            this.e = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "flip_card_left", com.component.a.a.f.class);
            this.f = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "flip_card_center", com.component.a.a.f.class);
            this.g = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "flip_card_right", com.component.a.a.f.class);
            this.h = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "flip_card_finish_text", com.component.a.a.q.class);
            this.i = com.component.a.g.c.e.findViewByName(mapA, "flip_card_finish_image");
            this.j = com.component.a.g.c.e.findViewByName(mapA, "flip_card_finish_button");
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            if (this.h != null) {
                this.h.setVisibility(4);
            }
            if (this.i != null) {
                this.i.setVisibility(4);
            }
            if (this.j != null) {
                this.j.setVisibility(4);
            }
            ArrayList<com.component.a.a.f> arrayList = new ArrayList();
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            for (com.component.a.a.f fVar : arrayList) {
                if (fVar != null) {
                    fVar.setOnClickListener(new ak(this, arrayList, fVar));
                }
            }
            com.component.a.i.f lifeCycle = getLifeCycle();
            lifeCycle.a((f.a) new al(this, lifeCycle));
            if (this.b != null) {
                this.b.setOnClickListener(new am(this));
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            m();
        }

        private void f() {
            getLifeCycle().f();
            this.a.cancel();
            if (this.e != null) {
                this.e.s();
            }
            if (this.f != null) {
                this.f.s();
            }
            if (this.g != null) {
                this.g.s();
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        public void d() {
            f();
            b(false);
            com.baidu.mobads.container.util.animation.e.b(this, com.baidu.mobads.container.util.animation.a.a(this).a(new JSONArray().put("scale")).a(160).a(a.b.EXIT).i());
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            f();
            b(true);
            setVisibility(4);
            cf.b(this);
        }
    }

    public static class a extends i {
        static String[] a = {"立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至", "小寒", "大寒", "春天", "夏天", "秋天", "冬天"};
        View b;
        com.component.a.a.q d;
        com.component.a.a.q e;
        com.component.a.a.q f;
        com.component.a.a.q g;
        View h;
        View i;
        com.component.a.a.q j;
        View k;
        final int l;
        final String m;
        final String n;
        boolean o;

        a(Context context, com.component.a.f.e eVar, String str) {
            super(context, eVar);
            this.o = false;
            this.l = eVar.c().optInt("skiptime", 10000);
            this.m = str;
            int length = a.length;
            String[] strArr = a;
            double dRandom = Math.random();
            double d = length;
            Double.isNaN(d);
            this.n = strArr[((int) (dRandom * d)) % length];
        }

        public int f() {
            if (!this.o) {
                return 0;
            }
            this.o = false;
            return this.l;
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "answer_card_con");
            this.d = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "answer_card_reward", com.component.a.a.q.class);
            this.e = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "answer_card_first_text", com.component.a.a.q.class);
            this.f = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "answer_card_second_text", com.component.a.a.q.class);
            this.g = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "answer_card_exit", com.component.a.a.q.class);
            this.h = com.component.a.g.c.e.findViewByName(mapA, "answer_card_result_con");
            this.i = com.component.a.g.c.e.findViewByName(mapA, "answer_card_result_right");
            this.j = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "answer_card_right_reward_text", com.component.a.a.q.class);
            this.k = com.component.a.g.c.e.findViewByName(mapA, "answer_card_result_error");
        }

        @Override // com.component.a.g.c.aa.i
        protected void b() {
            com.component.a.a.q qVar;
            com.component.a.a.q qVar2;
            if (this.h != null) {
                this.h.setVisibility(4);
            }
            if (this.i != null) {
                this.i.setVisibility(4);
            }
            if (this.k != null) {
                this.k.setVisibility(4);
            }
            com.component.a.i.f lifeCycle = getLifeCycle();
            lifeCycle.a((f.a) new ac(this, lifeCycle));
            if (this.d != null) {
                a(this.d, "-xx", "-" + (this.l / 1000));
            }
            if (this.j != null) {
                a(this.j, "-xx", "-" + (this.l / 1000));
            }
            if (this.e != null && this.f != null) {
                if (Math.round(Math.random()) == 0) {
                    qVar2 = this.e;
                    qVar = this.f;
                } else {
                    qVar = this.e;
                    qVar2 = this.f;
                }
                qVar2.setText(this.m);
                qVar2.setOnClickListener(new ad(this));
                qVar.setText(this.n);
                qVar.setOnClickListener(new ae(this));
            }
            if (this.g != null) {
                this.g.setOnClickListener(new af(this));
            }
        }

        @Override // com.component.a.g.c.aa.i
        protected void c() {
        }

        private void a(View view, int i) {
            com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(view).a(200).b("0.9").c("1").a(a.b.SCALE);
            com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(view).a(200).b("0").c("1").a(a.b.ALPHA);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVarA);
            arrayList.add(aVarA2);
            com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(view).b(i).a(arrayList).a(a.b.GROUP));
        }

        private void a(View view, int i, int i2) {
            com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(view).a(120).b("1").c("0.9").a(a.b.SCALE);
            com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(view).a(120).b("1").c("0").a(a.b.ALPHA);
            ArrayList arrayList = new ArrayList();
            if (i != 2) {
                arrayList.add(aVarA);
            }
            if (i != 1) {
                arrayList.add(aVarA2);
            }
            com.baidu.mobads.container.util.animation.e.b(view, com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(view).b(i2).a(arrayList).a(a.b.GROUP)));
        }

        @Override // com.component.a.g.c.aa.i
        public void d() {
            getLifeCycle().f();
            b(false);
            a(this, 2, 0);
        }

        @Override // com.component.a.g.c.aa.i
        protected void e() {
            b(true);
            getLifeCycle().f();
            setVisibility(4);
            cf.b(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (this.b != null) {
                a(this.b, 0, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            this.o = z;
            if (z && this.i != null) {
                this.i.setVisibility(0);
            } else if (this.k != null) {
                this.k.setVisibility(0);
            }
            if (this.h != null) {
                a(this.h, 120);
                a(this.h, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISCONNECTED_CPU_TRACK);
            }
            a(this, 2, MediaPlayer.MEDIA_PLAYER_OPTION_DISCONNECTED_CPU_TRACK);
            this.p.set(2);
        }

        private static void a(TextView textView, String str, String str2) {
            if (textView == null || TextUtils.isEmpty(textView.getText())) {
                return;
            }
            String strReplace = textView.getText().toString().replace(str, str2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strReplace);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SupportMenu.CATEGORY_MASK);
            int iIndexOf = strReplace.indexOf(str2);
            if (iIndexOf >= 0) {
                spannableStringBuilder.setSpan(foregroundColorSpan, iIndexOf, str2.length() + iIndexOf, 33);
                textView.setText(spannableStringBuilder);
            }
        }
    }

    public static class f extends j {
        private j a;
        private View b;
        private View d;
        private com.component.a.a.f e;
        private com.component.a.a.f f;
        private com.component.a.a.f g;
        private com.component.a.d.c h;
        private com.component.a.d.c i;
        private com.component.feed.ax j;

        f(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.l = -1;
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_title");
            this.d = com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_subtitle");
            this.e = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_lottie_enter", com.component.a.a.f.class);
            this.f = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_lottie_left", com.component.a.a.f.class);
            this.g = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_lottie_right", com.component.a.a.f.class);
            this.h = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_click_left", com.component.a.d.c.class);
            this.i = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_click_right", com.component.a.d.c.class);
            this.j = (com.component.feed.ax) com.component.a.g.c.e.findViewByName(mapA, "interact_front_flip_card_close", com.component.feed.ax.class);
        }

        void a(j jVar) {
            if (jVar != null) {
                this.a = jVar;
                if (!jVar.q) {
                    this.q = false;
                }
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            super.b();
            cf.a(this.h, new a(this.f));
            cf.a(this.i, new a(this.g));
            cf.a(this.j, new ap(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            this.j.setVisibility(4);
            com.baidu.mobads.container.util.animation.a.a(this).a(new JSONArray().put("alpha")).a(200).a(a.b.ENTER).i();
            if (this.e != null) {
                this.e.f();
            }
            a(new aq(this), 2000L);
            a(new ar(this), com.alipay.sdk.m.u.b.a);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            clearAnimation();
            cf.b(this);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            k();
            if (this.a != null) {
                this.a.post(new at(this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        class a implements View.OnClickListener {
            private final com.component.a.a.f b;

            a(com.component.a.a.f fVar) {
                this.b = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.b != null) {
                    f.this.n();
                    cf.a(f.this.e, 4);
                    cf.a(f.this.b, 4);
                    cf.a(f.this.d, 4);
                    cf.a(f.this.j, 4);
                    this.b.a(new au(this));
                    this.b.setVisibility(0);
                    this.b.f();
                }
            }
        }
    }

    public static class h extends j {
        private j a;
        private View b;
        private View d;
        private View e;
        private View f;
        private View g;
        private View h;
        private com.component.a.a.f i;
        private com.component.a.a.f j;
        private com.component.feed.ax m;
        private com.component.a.a.f n;

        h(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.l = -1;
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_title");
            this.d = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_subtitle");
            this.e = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_btn");
            this.f = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_container");
            this.g = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_bar");
            this.h = com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_lotties");
            this.n = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_btn_finger", com.component.a.a.f.class);
            this.i = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_lottie_enter", com.component.a.a.f.class);
            this.j = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_atmosphere", com.component.a.a.f.class);
            this.m = (com.component.feed.ax) com.component.a.g.c.e.findViewByName(mapA, "interact_front_pack_rain_close", com.component.feed.ax.class);
        }

        void a(j jVar) {
            if (jVar != null) {
                this.a = jVar;
                if (!jVar.q) {
                    this.q = false;
                }
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            super.b();
            cf.a(this.f, new ba(this));
            cf.a(this.m, new bb(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            this.m.setVisibility(4);
            com.baidu.mobads.container.util.animation.a.a(this).a(new JSONArray().put("alpha")).a(200).a(a.b.ENTER).i();
            if (this.i != null) {
                this.i.f();
            }
            if (this.n != null) {
                this.n.f();
            }
            a(new bc(this), 2000L);
            a(new bd(this), com.alipay.sdk.m.u.b.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            n();
            a(this.b);
            a(this.d);
            a(this.e);
            a(this.h);
            a(this.n);
            b(this.g);
            if (this.j != null && this.j.D()) {
                this.j.setOnClickListener(new be(this));
                this.j.a(new bf(this));
                this.j.setVisibility(0);
                this.j.i(3000);
                this.j.f();
                return;
            }
            g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            k();
            if (this.a != null) {
                this.a.post(new bg(this));
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            clearAnimation();
            cf.b(this);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            d();
        }

        private void a(View view) {
            if (view != null) {
                com.baidu.mobads.container.util.animation.a.a(view).a(new JSONArray().put("alpha")).a(200).a(a.b.EXIT).i();
            }
        }

        private void b(View view) {
            if (view != null) {
                com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(view).a(320).b("0").c("1").a(a.b.SCALE_X);
                com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(view).a(200).b("0").c("1").a(a.b.ALPHA);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVarA);
                arrayList.add(aVarA2);
                com.baidu.mobads.container.util.animation.e.a(view, com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(view).a(arrayList).a(a.b.GROUP)));
            }
        }
    }

    public static class g extends j {
        private j a;
        private View b;
        private com.component.a.a.f d;
        private com.component.a.a.f e;
        private com.component.feed.ax f;
        private com.component.a.a.f g;

        g(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.l = -1;
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "interact_front_lucky_bag_container");
            this.d = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_lucky_bag_main_lottie", com.component.a.a.f.class);
            this.e = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_lucky_bag_gesture", com.component.a.a.f.class);
            this.f = (com.component.feed.ax) com.component.a.g.c.e.findViewByName(mapA, "interact_front_lucky_bag_close", com.component.feed.ax.class);
            this.g = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_front_lucky_bag_transition_lottie", com.component.a.a.f.class);
        }

        void a(j jVar) {
            if (jVar != null) {
                this.a = jVar;
                if (!jVar.q) {
                    this.q = false;
                }
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            super.b();
            cf.a(this.b, new av(this));
            cf.a(this.f, new aw(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            com.baidu.mobads.container.util.animation.a.a(this).a(new JSONArray().put("alpha")).a(200).a(a.b.ENTER).i();
            com.baidu.mobads.container.util.animation.a.a(this.b).a(new JSONArray().put("scale")).a(200).a(a.b.ENTER).i();
            if (this.d != null) {
                this.d.f();
            }
            if (this.e != null) {
                this.e.f();
            }
            com.baidu.mobads.container.util.animation.a.a(this.f).a(new JSONArray().put("alpha")).a(100).b(2000).a(a.b.ENTER).i();
            a(new ax(this), com.alipay.sdk.m.u.b.a);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            clearAnimation();
            cf.b(this);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            k();
            if (this.a != null) {
                this.a.post(new ay(this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            n();
            if (this.g != null && this.g.D()) {
                com.baidu.mobads.container.util.animation.a.a(this.b).a(new JSONArray().put("scale")).a(200).a(a.b.EXIT).i();
                this.g.a(new az(this));
                this.g.setVisibility(0);
                this.g.f();
                return;
            }
            f();
        }
    }

    public static class d extends j {
        private com.component.a.a.f a;
        private View b;
        private View d;
        private com.component.a.a.q e;
        private com.component.a.a.q f;
        private com.component.a.a.q g;

        d(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.a = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_background_lottie", com.component.a.a.f.class);
            this.b = com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_main_container");
            this.d = com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_close");
            this.e = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_main_card_center_money_symbol", com.component.a.a.q.class);
            this.f = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_main_card_center_money_number", com.component.a.a.q.class);
            this.g = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "interact_back_coupon_main_card_center_coupon_text", com.component.a.a.q.class);
            cf.a(this.f, this.e);
            cf.a(this.f, this.g);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            setVisibility(4);
            if (this.b != null) {
                this.b.setVisibility(4);
            }
            n();
            cf.a(this.d, new an(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            setVisibility(0);
            if (this.a != null) {
                this.a.setVisibility(0);
                this.a.f();
            }
            if (this.b != null) {
                com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(this.b).a(320).b("0.5").c("1").a(a.b.SCALE);
                com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(this.b).a(200).b("0").c("1").a(a.b.ALPHA);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVarA);
                arrayList.add(aVarA2);
                com.baidu.mobads.container.util.animation.e.a(this.b, com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(this.b).a(arrayList).a(a.b.GROUP)));
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            clearAnimation();
            cf.b(this);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            d();
        }
    }

    public static class e extends j {
        private com.component.a.a.f a;
        private com.component.a.a.f b;
        private View d;
        private View e;

        e(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.a = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_back_welfare_background_lottie", com.component.a.a.f.class);
            this.b = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "interact_back_welfare_countdown", com.component.a.a.f.class);
            this.d = com.component.a.g.c.e.findViewByName(mapA, "interact_back_welfare_main_container");
            this.e = com.component.a.g.c.e.findViewByName(mapA, "interact_back_welfare_close");
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            setVisibility(4);
            if (this.d != null) {
                this.d.setVisibility(4);
            }
            n();
            cf.a(this.e, new ao(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            setVisibility(0);
            if (this.a != null) {
                this.a.setVisibility(0);
                this.a.f();
            }
            if (this.d != null) {
                com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(this.d).a(320).b("0.5").c("1").a(a.b.SCALE);
                com.baidu.mobads.container.util.animation.a aVarA2 = com.baidu.mobads.container.util.animation.a.a(this.d).a(200).b("0").c("1").a(a.b.ALPHA);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVarA);
                arrayList.add(aVarA2);
                com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(this.d).a(arrayList).a(a.b.GROUP));
            }
            if (this.b != null) {
                this.b.f();
            }
            com.baidu.mobads.container.util.animation.a.a(this.e).a(new JSONArray().put("alpha")).a(100).b(2000).a(a.b.ENTER).i();
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            clearAnimation();
            cf.b(this);
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void e() {
            super.e();
            d();
        }
    }

    public static class b extends j {
        private com.component.a.a.q a;
        private com.component.a.a.q b;
        private com.component.a.a.f d;
        private View e;
        private String f;
        private int g;
        private int h;
        private long i;
        private long j;

        static /* synthetic */ int a(b bVar, int i) {
            int i2 = bVar.g - i;
            bVar.g = i2;
            return i2;
        }

        b(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.h = 3000;
            this.i = -1L;
            this.j = -1L;
            this.g = this.l;
            this.h = eVar.c().optInt("taskTime", 3) * 1000;
        }

        @Override // com.component.a.g.c.aa.i
        protected void a() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.b = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "click_reward_card_countdown_text", com.component.a.a.q.class);
            this.a = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "click_reward_card_button_text", com.component.a.a.q.class);
            this.d = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "click_reward_finger_lottie", com.component.a.a.f.class);
            this.e = com.component.a.g.c.e.findViewByName(mapA, "click_reward_close");
            this.f = com.component.a.i.f.c((View) this.b).o("XX秒后自动关闭");
            if (this.b != null && this.g >= 0) {
                double d = this.g;
                Double.isNaN(d);
                this.b.setText(this.f.replace("XX", String.valueOf((int) Math.round(d / 1000.0d))));
            }
        }

        public void f() {
            this.i = System.currentTimeMillis();
        }

        public void a(boolean z) {
            if (!z && System.currentTimeMillis() - this.i > 5000) {
                return;
            }
            this.j = System.currentTimeMillis();
        }

        public boolean g() {
            if (this.i > 0 && this.j > 0 && System.currentTimeMillis() - this.j >= this.h) {
                return true;
            }
            this.j = -1L;
            return false;
        }

        public void a(String str) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                this.a.setText(str);
            }
        }

        public com.component.a.a.f h() {
            if (this.d != null) {
                cf.c(this.d);
            }
            return this.d;
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void b() {
            setVisibility(4);
            n();
            cf.a(this.e, new ag(this));
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void c() {
            super.c();
            com.baidu.mobads.container.util.animation.a.a(this).a(200).a(new JSONArray().put("alpha")).a(a.b.ENTER).i();
            if (this.l > 0) {
                a(new ah(this), 200L);
            } else {
                this.b.setVisibility(4);
            }
        }

        @Override // com.component.a.g.c.aa.j, com.component.a.g.c.aa.i
        protected void d() {
            super.d();
            com.baidu.mobads.container.util.animation.a.a(this).a(200).a(new JSONArray().put("alpha")).a(a.b.EXIT).i();
        }
    }

    public aa(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null) {
            return super.onPrepareView(view, null);
        }
        String strM = eVar.m("");
        if (TextUtils.equals("flip_card", strM)) {
            return new c(this.mAppContext, eVar);
        }
        if (TextUtils.equals("answer_card", strM)) {
            String appName = this.mAdInfo.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = this.mAdInfo.getTitle();
            }
            if (!TextUtils.isEmpty(appName) && appName.length() > 6) {
                appName = appName.substring(0, 6);
            }
            return new a(this.mAppContext, eVar, appName);
        }
        if (TextUtils.equals("click_reward", strM)) {
            return new b(this.mAppContext, eVar);
        }
        if (TextUtils.equals("interact_front_flip_card", strM)) {
            this.a = new f(this.mAppContext, eVar);
            if (this.d != null) {
                this.a.a((j) this.d);
            }
            if (this.e != null) {
                this.a.a((j) this.e);
            }
            return this.a;
        }
        if (TextUtils.equals("interact_front_pack_rain", strM)) {
            this.b = new h(this.mAppContext, eVar);
            if (this.d != null) {
                this.b.a((j) this.d);
            }
            if (this.e != null) {
                this.b.a((j) this.e);
            }
            return this.b;
        }
        if (TextUtils.equals("interact_front_lucky_bag", strM)) {
            this.c = new g(this.mAppContext, eVar);
            if (this.d != null) {
                this.c.a((j) this.d);
            }
            if (this.e != null) {
                this.c.a((j) this.e);
            }
            return this.c;
        }
        if (TextUtils.equals("interact_back_coupon", strM)) {
            this.d = new d(this.mAppContext, eVar);
            if (this.a != null) {
                this.a.a((j) this.d);
            }
            if (this.b != null) {
                this.b.a((j) this.d);
            }
            if (this.c != null) {
                this.c.a((j) this.d);
            }
            return this.d;
        }
        if (TextUtils.equals("interact_back_welfare", strM)) {
            this.e = new e(this.mAppContext, eVar);
            if (this.a != null) {
                this.a.a((j) this.e);
            }
            if (this.b != null) {
                this.b.a((j) this.e);
            }
            if (this.c != null) {
                this.c.a((j) this.e);
            }
            return this.e;
        }
        if (TextUtils.equals("span_card", eVar.s(""))) {
            return new ab(this, this.mAppContext, eVar);
        }
        return super.onPrepareView(view, eVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        View viewE = dVar.e();
        if (eVarF != null && viewE != null && (viewE instanceof i)) {
            ((i) viewE).i();
        }
    }
}
