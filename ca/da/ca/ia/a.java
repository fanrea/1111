package ca.da.ca.ia;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AccountCacheHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends c {
    public final AccountManager c;
    public Account d;
    public final ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>();

    /* compiled from: AccountCacheHelper.java */
    /* renamed from: ca.da.ca.ia.a$a, reason: collision with other inner class name */
    public class RunnableC0029a implements Runnable {
        public final /* synthetic */ Account a;

        public RunnableC0029a(Account account) {
            this.a = account;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.e != null && a.this.e.size() > 0 && a.this.c != null) {
                    for (Map.Entry<String, String> entry : a.this.e.entrySet()) {
                        if (entry != null) {
                            a.this.c.setUserData(this.a, entry.getKey(), entry.getValue());
                        }
                    }
                    a.this.e.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a(Context context) {
        this.c = AccountManager.get(context);
    }

    @Override // ca.da.ca.ia.c
    public void a(String str, String str2) {
        Account account = this.d;
        if (account == null) {
            this.e.put(str, str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.c.setUserData(account, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // ca.da.ca.ia.c
    public String b(String str) {
        Account account = this.d;
        if (account == null) {
            return this.e.get(str);
        }
        try {
            return this.c.getUserData(account, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(Account account) {
        if (account != null) {
            this.d = account;
            ConcurrentHashMap<String, String> concurrentHashMap = this.e;
            if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                return;
            }
            this.b.post(new RunnableC0029a(account));
        }
    }

    @Override // ca.da.ca.ia.c
    public void a(String str) {
        AccountManager accountManager;
        ConcurrentHashMap<String, String> concurrentHashMap = this.e;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            this.e.remove(str);
        }
        try {
            Account account = this.d;
            if (account != null && (accountManager = this.c) != null) {
                accountManager.setUserData(account, str, null);
            }
        } catch (Exception unused) {
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(str);
        }
    }
}
