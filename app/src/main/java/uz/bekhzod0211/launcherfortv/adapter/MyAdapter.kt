package uz.bekhzod0211.launcherfortv.adapter

import android.content.pm.ResolveInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.bekhzod0211.launcherfortv.R

class MyAdapter(
    private val apps: List<ResolveInfo>,
    private val isTv: Boolean,
    private val onClick: (ResolveInfo) -> Unit
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.appIcon)
        val name: TextView = view.findViewById(R.id.appName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if (isTv) R.layout.item_app_tv else R.layout.item_app_mobile
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = apps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = apps[position]
        val pm = holder.itemView.context.packageManager
        holder.icon.setImageDrawable(info.loadIcon(pm))
        holder.name.text = info.loadLabel(pm)
        holder.itemView.setOnClickListener { onClick(info) }

        if (isTv) {
            holder.itemView.isFocusable = true
            holder.itemView.isFocusableInTouchMode = true
            holder.itemView.setOnFocusChangeListener { v, hasFocus ->
                v.scaleX = if (hasFocus) 1.1f else 1.0f
                v.scaleY = if (hasFocus) 1.1f else 1.0f
            }
        }
    }
}