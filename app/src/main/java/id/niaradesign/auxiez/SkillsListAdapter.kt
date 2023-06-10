package id.niaradesign.auxiez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SkillsListAdapter(private val skillsdata: ArrayList<SkillsData>) : RecyclerView.Adapter<SkillsListAdapter.SkillsViewHolder>() {
    class SkillsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val skillsName: TextView = itemView.findViewById(R.id.skill_name)
        val skillsDesc: TextView = itemView.findViewById(R.id.skill_desc)
        val skillsProg: ImageView = itemView.findViewById(R.id.skill_prog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_skills, parent, false)
        return SkillsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val (name, photo, description) = skillsdata[position]
        holder.skillsName.text = name
        holder.skillsProg.setImageResource(photo)
        holder.skillsDesc.text = description

    }

    override fun getItemCount(): Int {
        return skillsdata.size
    }
}

