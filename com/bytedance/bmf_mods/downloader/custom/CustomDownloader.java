package com.bytedance.bmf_mods.downloader.custom;

import android.content.Context;
import android.os.Build;
import com.bytedance.bmf_mods.common.FileUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods_api.BmfException;
import com.bytedance.bmf_mods_api.IDownloadCallback;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CustomDownloader.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0014H\u0002J\f\u0010\u001b\u001a\u00020\u0014*\u00020\u0014H\u0002¨\u0006\u001d"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/CustomDownloader;", "Lcom/bytedance/bmf_mods/downloader/IDownloader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "download", "", "modelName", "", "cacheDirName", "tag", "sdkVersion", "modelPathBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "params", "", "downloadCallback", "Lcom/bytedance/bmf_mods_api/IDownloadCallback;", "modelFile", "Ljava/io/File;", "dirFullPath", TKDownloadReason.KSAD_TK_MD5, "modelFileName", "expectedMd5", "makeTempFileFormal", "", "tempFile", "Companion", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CustomDownloader implements IDownloader {
    private static final CopyOnWriteArraySet<String> downloadingFiles = new CopyOnWriteArraySet<>();

    public CustomDownloader(Context context) {
        if (context != null) {
            SoLoader.getInstance().setContext(context);
        }
    }

    @Override // com.bytedance.bmf_mods.downloader.IDownloader
    public void download(final String modelName, String cacheDirName, String tag, String sdkVersion, final StringBuilder modelPathBuilder, Map<String, String> params, final IDownloadCallback downloadCallback) {
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(modelPathBuilder, "modelPathBuilder");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(downloadCallback, "downloadCallback");
        String str = params.get("host");
        if (!(str == null || str.length() == 0)) {
            String str2 = params.get("accessKey");
            if (!(str2 == null || str2.length() == 0)) {
                synchronized (CustomDownloader.class) {
                    CopyOnWriteArraySet<String> copyOnWriteArraySet = downloadingFiles;
                    if (copyOnWriteArraySet.contains(modelName)) {
                        Logging.e("Another task is downloading the same model: " + modelName);
                        downloadCallback.callback(-100041);
                        return;
                    }
                    copyOnWriteArraySet.add(modelName);
                    final File modelDownloadDir = FileUtils.getModelDownloadDir(SoLoader.getInstance().getAppContext(), cacheDirName);
                    if (!modelDownloadDir.exists()) {
                        boolean zMkdirs = modelDownloadDir.mkdirs();
                        Logging.d("create model cache dir success: " + zMkdirs);
                        if (!zMkdirs) {
                            downloadCallback.callback(-100042);
                            copyOnWriteArraySet.remove(modelName);
                            return;
                        }
                    }
                    CustomDavinciRepo customDavinciRepo = CustomDavinciRepo.INSTANCE;
                    String str3 = params.get("host");
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = str3;
                    String str5 = params.get("accessKey");
                    if (str5 == null) {
                        str5 = "";
                    }
                    String str6 = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(str6, "MODEL");
                    customDavinciRepo.getDownloadUrl(str4, str5, modelName, str6, params.get("appID"), params.get("appVersion"), params.get("platformSdkVersion"), params.get("deviceId"), new Function4<Integer, String, String, String, Unit>() { // from class: com.bytedance.bmf_mods.downloader.custom.CustomDownloader.download.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            invoke(((Number) obj).intValue(), (String) obj2, (String) obj3, (String) obj4);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i, String str7, String str8, String str9) {
                            if (i == 0) {
                                CustomDownloader customDownloader = CustomDownloader.this;
                                String absolutePath = modelDownloadDir.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "fileModelCacheDir.absolutePath");
                                File fileModelFile = customDownloader.modelFile(absolutePath, modelName, str8 == null ? "" : str8);
                                FileUtils fileUtils = FileUtils.INSTANCE;
                                if (str8 == null) {
                                    str8 = "";
                                }
                                if (!fileUtils.checkFileReady(fileModelFile, str8)) {
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass1(fileModelFile, CustomDownloader.this, str9, modelPathBuilder, downloadCallback, null), 2, null);
                                } else {
                                    modelPathBuilder.setLength(0);
                                    modelPathBuilder.append(fileModelFile.getAbsolutePath());
                                    Logging.d("Model file already exists.");
                                    downloadCallback.callback(1);
                                }
                            } else {
                                Logging.e("code: " + i + ", msg: " + str7);
                                downloadCallback.callback(i);
                            }
                            CustomDownloader.downloadingFiles.remove(modelName);
                        }

                        /* compiled from: CustomDownloader.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
                        @DebugMetadata(c = "com.bytedance.bmf_mods.downloader.custom.CustomDownloader$download$2$1", f = "CustomDownloader.kt", i = {}, l = {88, 93}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.bytedance.bmf_mods.downloader.custom.CustomDownloader$download$2$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ IDownloadCallback $downloadCallback;
                            final /* synthetic */ File $file;
                            final /* synthetic */ StringBuilder $modelPathBuilder;
                            final /* synthetic */ String $url;
                            Object L$0;
                            int label;
                            final /* synthetic */ CustomDownloader this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(File file, CustomDownloader customDownloader, String str, StringBuilder sb, IDownloadCallback iDownloadCallback, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$file = file;
                                this.this$0 = customDownloader;
                                this.$url = str;
                                this.$modelPathBuilder = sb;
                                this.$downloadCallback = iDownloadCallback;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$file, this.this$0, this.$url, this.$modelPathBuilder, this.$downloadCallback, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                Object obj2;
                                Object obj3;
                                File fileTempFile;
                                CustomDavinciRepo customDavinciRepo;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    File file = this.$file;
                                    CustomDownloader customDownloader = this.this$0;
                                    String str = this.$url;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        FileUtils.INSTANCE.deleteIfExist(file);
                                        fileTempFile = customDownloader.tempFile(file);
                                        FileUtils.INSTANCE.deleteIfExist(fileTempFile);
                                        customDavinciRepo = CustomDavinciRepo.INSTANCE;
                                        Intrinsics.checkNotNull(str);
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (customDavinciRepo.downloadFile(str, fileTempFile)) {
                                        if (customDownloader.makeTempFileFormal(fileTempFile)) {
                                            obj2 = Result.constructor-impl(Unit.INSTANCE);
                                            obj3 = obj2;
                                            StringBuilder sb = this.$modelPathBuilder;
                                            File file2 = this.$file;
                                            IDownloadCallback iDownloadCallback = this.$downloadCallback;
                                            if (Result.isSuccess-impl(obj3)) {
                                                sb.setLength(0);
                                                sb.append(file2.getAbsolutePath());
                                                Logging.d("Download model file success, path: " + ((Object) sb));
                                                CoroutineContext main = Dispatchers.getMain();
                                                CustomDownloader$download$2$1$2$1 customDownloader$download$2$1$2$1 = new CustomDownloader$download$2$1$2$1(iDownloadCallback, null);
                                                this.L$0 = obj3;
                                                this.label = 1;
                                                if (BuildersKt.withContext(main, customDownloader$download$2$1$2$1, this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        } else {
                                            throw new IllegalStateException("Check failed.".toString());
                                        }
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                } else {
                                    if (i != 1) {
                                        if (i == 2) {
                                            ResultKt.throwOnFailure(obj);
                                            return Unit.INSTANCE;
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    obj3 = this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                }
                                IDownloadCallback iDownloadCallback2 = this.$downloadCallback;
                                Throwable th2 = Result.exceptionOrNull-impl(obj3);
                                if (th2 != null) {
                                    Logging.e("Download model file failure, " + th2.getMessage());
                                    CoroutineContext main2 = Dispatchers.getMain();
                                    CustomDownloader$download$2$1$3$1 customDownloader$download$2$1$3$1 = new CustomDownloader$download$2$1$3$1(iDownloadCallback2, null);
                                    this.L$0 = obj3;
                                    this.label = 2;
                                    if (BuildersKt.withContext(main2, customDownloader$download$2$1$3$1, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    });
                    return;
                }
            }
        }
        downloadCallback.callback(BmfException.INPUT_PARAM_INVALID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File modelFile(String dirFullPath, String modelName, String md5) {
        return new File(dirFullPath, modelFileName(modelName, md5));
    }

    private final String modelFileName(String modelName, String expectedMd5) {
        return modelName + '_' + expectedMd5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File tempFile(File file) {
        return FilesKt.resolveSibling(file, file.getCanonicalPath() + ".tmp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean makeTempFileFormal(File file) {
        Object obj;
        String canonicalPath;
        try {
            Result.Companion companion = Result.Companion;
            canonicalPath = file.getCanonicalPath();
            Intrinsics.checkNotNullExpressionValue(canonicalPath, "canonicalPath");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (file.renameTo(FilesKt.resolveSibling(file, StringsKt.removeSuffix(canonicalPath, (CharSequence) ".tmp")))) {
            obj = Result.constructor-impl(Unit.INSTANCE);
            return Result.isSuccess-impl(obj);
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
