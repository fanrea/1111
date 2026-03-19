package com.dhylive.app.m_vm.main;

import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.dhylive.app.data.mine.AdOrderEcpm;
import com.dhylive.app.data.mine.AdOrderInfo;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.data.mine.NovelInfo;
import com.dhylive.app.data.mine.VipLevelInfo;
import com.dhylive.app.data.mine.WithdrawData;
import com.dhylive.app.data.mine.WithdrawInfo;
import com.dhylive.app.data.mine.WithdrawSettingInfo;
import com.dhylive.app.data.mine.WxPayInfo;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseManager;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.BaseRespKt;
import com.dhylive.app.net.ErrorResp;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.net.ListData;
import com.dhylive.app.net.NetworkApi;
import com.dhylive.app.net.SuccessResp;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: MainManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\u0006\u0010\u0015\u001a\u00020\nJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00070\u0006J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006J\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u0006J\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00070\u0006J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00070\u0006J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u0006J\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010(\u001a\u00020\u0010J\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ$\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/dhylive/app/m_vm/main/MainManager;", "Lcom/dhylive/app/net/BaseManager;", "()V", "mainService", "Lcom/dhylive/app/m_vm/main/MainService;", "applyWithdraw", "Lkotlinx/coroutines/flow/Flow;", "Lcom/dhylive/app/net/BaseResp;", "", "param", "Lcom/dhylive/app/net/HashMapNonNull;", "bindAlipay", "bindBankCard", "createAdOrder", "Lcom/dhylive/app/data/mine/AdOrderInfo;", "createAliPayOrder", "", "createWxPayOrder", "Lcom/dhylive/app/data/mine/WxPayInfo;", "getAdOrderEcpm", "Lcom/dhylive/app/data/mine/AdOrderEcpm;", "params", "getConfiguration", "Lcom/dhylive/app/data/mine/ConfigurationInfo;", "getConvertMoney", "getJumpLog", "getNovelSetting", "Lcom/dhylive/app/data/mine/NovelInfo;", IFunc.IVK_GET_USER_INFO, "Lcom/dhylive/app/data/user/UserData;", "getVipLevelList", "Lcom/dhylive/app/data/mine/VipLevelInfo;", "getWaitWithDraw", "Lcom/dhylive/app/net/ListData;", "Lcom/dhylive/app/data/mine/WithdrawData;", "getWithdrawList", "Lcom/dhylive/app/data/mine/WithdrawInfo;", "getWithdrawSetting", "Lcom/dhylive/app/data/mine/WithdrawSettingInfo;", "successWithDraw", "id", "updateAdOrder", "updateUserInfo", "image", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MainManager extends BaseManager {
    private final MainService mainService = (MainService) NetworkApi.INSTANCE.create(MainService.class);

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/user/UserData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getUserInfo$1", f = "MainManager.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09221 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends UserData>>, Object> {
        int label;

        C09221(Continuation<? super C09221> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09221(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<UserData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getUserInfo((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<UserData>> getUserInfo() {
        return request(new C09221(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/net/HashMapNonNull;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$updateUserInfo$1", f = "MainManager.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$updateUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09291 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends HashMapNonNull>>, Object> {
        final /* synthetic */ String $image;
        final /* synthetic */ HashMapNonNull $param;
        int label;
        final /* synthetic */ MainManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09291(String str, HashMapNonNull hashMapNonNull, MainManager mainManager, Continuation<? super C09291> continuation) {
            super(1, continuation);
            this.$image = str;
            this.$param = hashMapNonNull;
            this.this$0 = mainManager;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09291(this.$image, this.$param, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends HashMapNonNull>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
                String str = this.$image;
                if (str != null) {
                    File file = new File(str);
                    type.addFormDataPart(ILogConst.AD_CLICK_AVATAR, file.getName(), RequestBody.INSTANCE.create(file, MediaType.INSTANCE.parse("multipart/form-data")));
                }
                for (Map.Entry<String, Object> entry : this.$param.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(key);
                    type.addFormDataPart(key, value.toString());
                }
                List<MultipartBody.Part> listParts = type.build().parts();
                this.label = 1;
                obj = this.this$0.mainService.updateUserInfo(listParts, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BaseResp baseResp = (BaseResp) obj;
            if (baseResp.getCode() == 0) {
                return new SuccessResp(this.$param);
            }
            return new ErrorResp(baseResp.getCode(), baseResp.getMsg());
        }
    }

    public final Flow<BaseResp<HashMapNonNull>> updateUserInfo(HashMapNonNull param, String image) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09291(image, param, this, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/ConfigurationInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getConfiguration$1", f = "MainManager.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getConfiguration$1, reason: invalid class name and case insensitive filesystem */
    static final class C09181 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends ConfigurationInfo>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09181(HashMapNonNull hashMapNonNull, Continuation<? super C09181> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09181(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<ConfigurationInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getConfiguration(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<ConfigurationInfo>> getConfiguration(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09181(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getJumpLog$1", f = "MainManager.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getJumpLog$1, reason: invalid class name and case insensitive filesystem */
    static final class C09201 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        int label;

        C09201(Continuation<? super C09201> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09201(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getJumpLog((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Object>> getJumpLog() {
        return request(new C09201(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/NovelInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getNovelSetting$1", f = "MainManager.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getNovelSetting$1, reason: invalid class name and case insensitive filesystem */
    static final class C09211 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends NovelInfo>>, Object> {
        int label;

        C09211(Continuation<? super C09211> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09211(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<NovelInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getNovelSetting((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<NovelInfo>> getNovelSetting() {
        return request(new C09211(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$createAliPayOrder$1", f = "MainManager.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$createAliPayOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09151 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends String>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09151(HashMapNonNull hashMapNonNull, Continuation<? super C09151> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09151(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<String>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.createAliPayOrder(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<String>> createAliPayOrder(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09151(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WxPayInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$createWxPayOrder$1", f = "MainManager.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$createWxPayOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09161 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends WxPayInfo>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09161(HashMapNonNull hashMapNonNull, Continuation<? super C09161> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09161(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<WxPayInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.createWxPayOrder(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<WxPayInfo>> createWxPayOrder(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09161(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WithdrawSettingInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getWithdrawSetting$1", f = "MainManager.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getWithdrawSetting$1, reason: invalid class name and case insensitive filesystem */
    static final class C09261 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends WithdrawSettingInfo>>, Object> {
        int label;

        C09261(Continuation<? super C09261> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09261(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<WithdrawSettingInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getWithdrawSetting((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<WithdrawSettingInfo>> getWithdrawSetting() {
        return request(new C09261(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$bindAlipay$1", f = "MainManager.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$bindAlipay$1, reason: invalid class name and case insensitive filesystem */
    static final class C09121 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09121(HashMapNonNull hashMapNonNull, Continuation<? super C09121> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09121(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.bindAlipay(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Object>> bindAlipay(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09121(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$bindBankCard$1", f = "MainManager.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$bindBankCard$1, reason: invalid class name and case insensitive filesystem */
    static final class C09131 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09131(HashMapNonNull hashMapNonNull, Continuation<? super C09131> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09131(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.bindBankCard(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Object>> bindBankCard(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09131(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WithdrawInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getWithdrawList$1", f = "MainManager.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getWithdrawList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09251 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends WithdrawInfo>>, Object> {
        int label;

        C09251(Continuation<? super C09251> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09251(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<WithdrawInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getWithdrawList((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<WithdrawInfo>> getWithdrawList() {
        return request(new C09251(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$applyWithdraw$1", f = "MainManager.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$applyWithdraw$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HashMapNonNull hashMapNonNull, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new AnonymousClass1(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.applyWithdraw(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return BaseRespKt.convertEmpty((BaseResp) obj);
        }
    }

    public final Flow<BaseResp<Object>> applyWithdraw(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new AnonymousClass1(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/AdOrderInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$createAdOrder$1", f = "MainManager.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$createAdOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09141 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends AdOrderInfo>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09141(HashMapNonNull hashMapNonNull, Continuation<? super C09141> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09141(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<AdOrderInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.createAdOrder(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<AdOrderInfo>> createAdOrder(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09141(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$updateAdOrder$1", f = "MainManager.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$updateAdOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09281 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends String>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09281(HashMapNonNull hashMapNonNull, Continuation<? super C09281> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09281(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<String>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.updateAdOrder(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<String>> updateAdOrder(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09281(param, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/AdOrderEcpm;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getAdOrderEcpm$1", f = "MainManager.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getAdOrderEcpm$1, reason: invalid class name and case insensitive filesystem */
    static final class C09171 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends AdOrderEcpm>>, Object> {
        final /* synthetic */ HashMapNonNull $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09171(HashMapNonNull hashMapNonNull, Continuation<? super C09171> continuation) {
            super(1, continuation);
            this.$params = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09171(this.$params, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<AdOrderEcpm>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getAdOrderEcpm(this.$params, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<AdOrderEcpm>> getAdOrderEcpm(HashMapNonNull params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return request(new C09171(params, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/VipLevelInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getVipLevelList$1", f = "MainManager.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getVipLevelList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09231 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends VipLevelInfo>>, Object> {
        int label;

        C09231(Continuation<? super C09231> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09231(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<VipLevelInfo>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getVipLevelList((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<VipLevelInfo>> getVipLevelList() {
        return request(new C09231(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/net/ListData;", "Lcom/dhylive/app/data/mine/WithdrawData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getWaitWithDraw$1", f = "MainManager.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getWaitWithDraw$1, reason: invalid class name and case insensitive filesystem */
    static final class C09241 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends ListData<WithdrawData>>>, Object> {
        int label;

        C09241(Continuation<? super C09241> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09241(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<ListData<WithdrawData>>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getWaitWithDraw((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<ListData<WithdrawData>>> getWaitWithDraw() {
        return request(new C09241(null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$successWithDraw$1", f = "MainManager.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$successWithDraw$1, reason: invalid class name and case insensitive filesystem */
    static final class C09271 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends String>>, Object> {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09271(String str, Continuation<? super C09271> continuation) {
            super(1, continuation);
            this.$id = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09271(this.$id, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<String>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.successWithDraw(this.$id, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<String>> successWithDraw(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return request(new C09271(id, null));
    }

    /* compiled from: MainManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainManager$getConvertMoney$1", f = "MainManager.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainManager$getConvertMoney$1, reason: invalid class name and case insensitive filesystem */
    static final class C09191 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09191(HashMapNonNull hashMapNonNull, Continuation<? super C09191> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainManager.this.new C09191(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MainManager.this.mainService.getConvertMoney(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<Object>> getConvertMoney(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09191(param, null));
    }
}
