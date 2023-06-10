package id.niaradesign.auxiez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SkillsFragment : Fragment() {
    private lateinit var skillsRecyclerView: RecyclerView
    private lateinit var skillsListAdapter: SkillsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_skills, container, false)

        skillsRecyclerView = rootView.findViewById(R.id.rv_skills)
        skillsListAdapter = SkillsListAdapter(getSkillsData())
        skillsRecyclerView.adapter = skillsListAdapter
        skillsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }

    private fun getSkillsData(): ArrayList<SkillsData> {
        val skillsNameArray = resources.getStringArray(R.array.skills_name)
        val skillsProgArray = resources.obtainTypedArray(R.array.skills_progbar)
        val skillsDescArray = resources.getStringArray(R.array.skills_desc)

        val skillsDataList = ArrayList<SkillsData>()

        for (i in skillsNameArray.indices) {
            val skillsData = SkillsData(
                skillsNameArray[i],
                skillsProgArray.getResourceId(i, -1),
                skillsDescArray[i]
            )
            skillsDataList.add(skillsData)
        }

        skillsProgArray.recycle()

        return skillsDataList
    }
}