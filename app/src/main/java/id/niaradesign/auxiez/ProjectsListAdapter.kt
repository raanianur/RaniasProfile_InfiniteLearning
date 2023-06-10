package id.niaradesign.auxiez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectsListAdapter(private val projectsdata: ArrayList<ProjectsData>) : RecyclerView.Adapter<ProjectsListAdapter.ProjectsViewHolder>() {
    class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectsName: TextView = itemView.findViewById(R.id.projects_name)
        val projectsDesc: TextView = itemView.findViewById(R.id.projects_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_projects, parent, false)
        return ProjectsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val (name, description) = projectsdata[position]
        holder.projectsName.text = name
        holder.projectsDesc.text = description

    }

    override fun getItemCount(): Int {
        return projectsdata.size
    }
}