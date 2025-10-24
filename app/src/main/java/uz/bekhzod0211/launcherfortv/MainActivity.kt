package uz.bekhzod0211.launcherfortv

import android.app.UiModeManager
import android.content.Intent
import android.content.pm.ResolveInfo
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.bekhzod0211.launcherfortv.adapter.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)

        var isTv = isRunningOnTv();
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = if (isTv) {
            GridLayoutManager(this, 5) // сетка для TV
        } else {
            LinearLayoutManager(this) // список для телефона
        }

        val apps = loadInstalledApps()
        adapter = MyAdapter(apps, isTv = isTv) { app ->
            try {
                val launchIntent = packageManager.getLaunchIntentForPackage(app.activityInfo.packageName)
                if (launchIntent != null) startActivity(launchIntent)
                else Toast.makeText(this, "Невозможно запустить приложение", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Ошибка запуска", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView.adapter = adapter
    }

    private fun loadInstalledApps(): List<ResolveInfo> {
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        return packageManager.queryIntentActivities(intent, 0)
    }

    private fun isRunningOnTv(): Boolean {
        val uiModeManager = getSystemService(UI_MODE_SERVICE) as UiModeManager
        return uiModeManager.currentModeType == Configuration.UI_MODE_TYPE_TELEVISION
    }
}