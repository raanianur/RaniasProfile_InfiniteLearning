package id.niaradesign.auxiez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProjectsFragment : Fragment() {
    private lateinit var projectsRecyclerView: RecyclerView
    private lateinit var projectsListAdapter: ProjectsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_projects, container, false)

        projectsRecyclerView = rootView.findViewById(R.id.rv_projects)
        projectsListAdapter = ProjectsListAdapter(getProjectsData())
        projectsRecyclerView.adapter = projectsListAdapter
        projectsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }

    private fun getProjectsData(): ArrayList<ProjectsData> {
        val projectsNameArray = resources.getStringArray(R.array.projects_name)
        val projectsDescArray = resources.getStringArray(R.array.projects_desc)

        val projectsDataList = ArrayList<ProjectsData>()

        for (i in projectsNameArray.indices) {
            val projectsData = ProjectsData(
                projectsNameArray[i],
                projectsDescArray[i]
            )
            projectsDataList.add(projectsData)
        }

        return projectsDataList
    }
}