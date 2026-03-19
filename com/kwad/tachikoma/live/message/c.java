package com.kwad.tachikoma.live.message;

import android.graphics.Color;
import android.support.v7.widget.al;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.framework.tachikoma.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends com.kwad.tachikoma.live.message.a<LiveMessage, a> {
    @Override // android.support.v7.widget.al.a
    public final int getItemViewType(int i) {
        return 1;
    }

    @Override // android.support.v7.widget.al.a
    public final /* bridge */ /* synthetic */ al.x b(ViewGroup viewGroup, int i) {
        return b(viewGroup);
    }

    private static a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(com.kwad.tachikoma.e.hP().hQ().wrapper().wrapContextIfNeed(viewGroup.getContext())).inflate(a.c.ksad_live_message_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v7.widget.al.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(a aVar, int i) {
        a(aVar, (LiveMessage) this.CV.get(i));
    }

    private static void a(a aVar, LiveMessage liveMessage) {
        String str = liveMessage.userName + ":  ";
        SpannableString spannableString = new SpannableString(str + liveMessage.content);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#9EE0F7")), 0, str.length(), 17);
        aVar.Db.setText(spannableString);
    }

    public static class a extends al.x {
        public TextView Db;

        public a(View view) {
            super(view);
            this.Db = (TextView) view.findViewById(a.b.ksad_msg_tv);
        }
    }
}
