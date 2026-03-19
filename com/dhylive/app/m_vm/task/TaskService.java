package com.dhylive.app.m_vm.task;

import com.dhylive.app.data.task.TJData;
import com.dhylive.app.data.task.XSData;
import com.dhylive.app.net.BaseResp;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* compiled from: TaskService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006H§@¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\tH§@¢\u0006\u0002\u0010\u000fJ\\\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\u0012\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00062\b\b\u0003\u0010\u0014\u001a\u00020\u00062\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\tH§@¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\tH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/dhylive/app/m_vm/task/TaskService;", "", "getTJTaskList", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/task/TJData;", "page", "", "limit", NetworkDefine.PARAM_TOKEN, "", "type", "(IILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTJToken", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getXSTaskList", "Lcom/dhylive/app/data/task/XSData;", "sort", "searchNotBm", "searchNotDone", "searchTypeName", "(IILjava/lang/String;IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getXSToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface TaskService {
    @GET("https://api.91taojin.com.cn/app/json/act/getList")
    Object getTJTaskList(@Query("Page") int i, @Query("Limit") int i2, @Query("Token") String str, @Query("ListType") Integer num, Continuation<? super BaseResp<TJData>> continuation);

    @GET
    Object getTJToken(@Url String str, Continuation<? super BaseResp<? extends Map<String, String>>> continuation);

    @GET("https://api.xuanshangwa.com.cn/web/unionApi/act/task_list")
    Object getXSTaskList(@Query("page") int i, @Query("limit") int i2, @Query(NetworkDefine.PARAM_TOKEN) String str, @Query("sort") int i3, @Query("search_not_bm") int i4, @Query("search_not_done") int i5, @Query("search_type_name") String str2, Continuation<? super BaseResp<XSData>> continuation);

    @GET
    Object getXSToken(@Url String str, Continuation<? super BaseResp<? extends Map<String, String>>> continuation);

    /* compiled from: TaskService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getTJTaskList$default(TaskService taskService, int i, int i2, String str, Integer num, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTJTaskList");
            }
            if ((i3 & 2) != 0) {
                i2 = 20;
            }
            int i4 = i2;
            if ((i3 & 8) != 0) {
                num = null;
            }
            return taskService.getTJTaskList(i, i4, str, num, continuation);
        }

        public static /* synthetic */ Object getXSTaskList$default(TaskService taskService, int i, int i2, String str, int i3, int i4, int i5, String str2, Continuation continuation, int i6, Object obj) {
            if (obj == null) {
                return taskService.getXSTaskList(i, (i6 & 2) != 0 ? 10 : i2, str, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? 0 : i5, (i6 & 64) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getXSTaskList");
        }
    }
}
