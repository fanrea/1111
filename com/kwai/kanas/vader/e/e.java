package com.kwai.kanas.vader.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.e.g;
import com.kwai.kanas.vader.persistent.LogRecordDatabase;
import com.kwai.middleware.azeroth.async.DefaultThreadFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class e {
    private static final String a = "SequenceIdGenerator";
    private final SharedPreferences h;
    private final LogRecordDatabase i;
    private final g j;
    private int k;
    private int l;
    private int m;
    private final com.kwai.kanas.vader.b n;
    private final String b = "SequenceId";
    private final String c = "SeqId";
    private final String d = "CustomKeys";
    private int e = 1;
    private final Map<Channel, Integer> f = new HashMap();
    private final Map<String, Integer> g = new HashMap();
    private final Map<Channel, Integer> o = new HashMap();
    private final ThreadPoolExecutor p = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new DefaultThreadFactory("seqIdGenerator"), new ThreadPoolExecutor.DiscardPolicy());

    public e(Context context, LogRecordDatabase logRecordDatabase, com.kwai.kanas.vader.b bVar) {
        this.h = context.getSharedPreferences("SequenceId", 0);
        this.i = logRecordDatabase;
        this.n = bVar;
        g.a aVarL = g.l();
        a(aVarL);
        b(aVarL);
        c(aVarL);
        this.o.putAll(this.f);
        this.j = aVarL.a(0).b(0).c(0).a();
        Log.d(a, "SequenceIdGenerator init done.");
    }

    public int a(Channel channel) {
        return this.o.get(channel).intValue() - 1;
    }

    public synchronized d a(Channel channel, String str) {
        int iIntValue;
        d dVarA;
        int i = this.e;
        this.e = i + 1;
        int iIntValue2 = this.f.get(channel).intValue();
        this.f.put(channel, Integer.valueOf(iIntValue2 + 1));
        if (this.g.keySet().contains(str)) {
            iIntValue = this.g.get(str).intValue();
            this.g.put(str, Integer.valueOf(iIntValue + 1));
        } else {
            iIntValue = 0;
            this.g.put(str, 1);
        }
        c();
        dVarA = d.a(i, iIntValue2, iIntValue, System.currentTimeMillis());
        this.k++;
        Log.d(a, "Next sequenceId: " + dVarA);
        return dVarA;
    }

    public synchronized g a() {
        return this.j.j().a(this.k).b(this.l).c(this.m).a();
    }

    private void a(g.a aVar) {
        int iF;
        this.e = this.h.getInt("SeqId", 1);
        aVar.a(h.a(Integer.valueOf(this.e)));
        try {
            iF = this.i.a().f() + 1;
            aVar.b(h.a(Integer.valueOf(iF)));
        } catch (SQLiteException e) {
            this.n.a(e);
            aVar.b(h.a((Exception) e));
            iF = 1;
        }
        if (iF > this.e) {
            this.n.a("seqId_mismatch", "nextSeqId : " + this.e + " nextDbSeqId: " + iF);
            this.e = iF;
        }
    }

    private void b(g.a aVar) {
        int iA;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (Channel channel : Channel.values()) {
            int i = this.h.getInt(channel.name(), 1);
            map.put(channel, h.a(Integer.valueOf(i)));
            try {
                iA = this.i.a().a(channel) + 1;
                map2.put(channel, h.a(Integer.valueOf(iA)));
            } catch (SQLiteException e) {
                this.n.a(e);
                map2.put(channel, h.a((Exception) e));
                iA = 1;
            }
            if (iA > i) {
                this.n.a("channel_seqId_mismatch", "channel: " + channel.name() + " nextSeqId : " + i + " nextDbSeqId: " + iA);
                i = iA;
            }
            this.f.put(channel, Integer.valueOf(i));
        }
        aVar.a(map);
        aVar.b(map2);
    }

    private void c(g.a aVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Set<String> stringSet = this.h.getStringSet("CustomKeys", new HashSet());
        if (stringSet != null) {
            for (String str : stringSet) {
                int i = 1;
                int i2 = this.h.getInt(str, 1);
                map.put(str, h.a(Integer.valueOf(i2)));
                try {
                    int iA = this.i.a().a(str) + 1;
                    map2.put(str, h.a(Integer.valueOf(iA)));
                    i = iA;
                } catch (SQLiteException e) {
                    this.n.a(e);
                    map2.put(str, h.a((Exception) e));
                }
                if (i > i2) {
                    this.n.a("custom_seqId_mismatch", "custom_type: " + str + " nextSeqId : " + i2 + " nextDbSeqId: " + i);
                    i2 = i;
                }
                this.g.put(str, Integer.valueOf(i2));
            }
        }
        aVar.c(map);
        aVar.d(map2);
    }

    private void c() {
        this.p.execute(new Runnable() { // from class: com.kwai.kanas.vader.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.d();
                } catch (Exception e) {
                    e.this.n.a(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        SharedPreferences.Editor editorEdit = this.h.edit();
        editorEdit.putInt("SeqId", this.e).putInt(Channel.REAL_TIME.name(), this.f.get(Channel.REAL_TIME).intValue()).putInt(Channel.HIGH_FREQ.name(), this.f.get(Channel.HIGH_FREQ).intValue()).putInt(Channel.NORMAL.name(), this.f.get(Channel.NORMAL).intValue());
        for (String str : this.g.keySet()) {
            editorEdit.putInt(str, this.g.get(str).intValue());
        }
        boolean zCommit = editorEdit.commit();
        this.l++;
        if (!zCommit) {
            this.m++;
            this.n.a(new IOException("SharedPreference commit failed."));
        }
    }

    public synchronized void b() {
        this.e = 1;
        Iterator<Map.Entry<Channel, Integer>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            this.f.put(it.next().getKey(), 1);
        }
        Iterator<Map.Entry<String, Integer>> it2 = this.g.entrySet().iterator();
        while (it2.hasNext()) {
            this.g.put(it2.next().getKey(), 1);
        }
        d();
    }

    void a(int i, TimeUnit timeUnit) throws InterruptedException {
        this.p.awaitTermination(i, timeUnit);
    }
}
