package com.example.tvlauncher;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/tvlauncher/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Luz/bekhzod0211/launcherfortv/adapter/MyAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isRunningOnTv", "", "loadInstalledApps", "", "Landroid/content/pm/ResolveInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private uz.bekhzod0211.launcherfortv.adapter.MyAdapter adapter;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.util.List<android.content.pm.ResolveInfo> loadInstalledApps() {
        return null;
    }
    
    private final boolean isRunningOnTv() {
        return false;
    }
}