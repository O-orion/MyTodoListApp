package com.example.mytodolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.R
import com.example.mytodolist.adapter.TaskAdapter
import com.example.mytodolist.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragments.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragments : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        val recycleView = view.findViewById<RecyclerView>(R.id.rvTasks);
        val btn_newTask = view.findViewById<FloatingActionButton>(R.id.btn_newTask);

        recycleView.layoutManager = LinearLayoutManager(requireContext());

        val tasks = listOf(
            Task("Estudar Kotlin", "10:00 - 11:00", "Revisar RecyclerView"),
            Task("Desenhar UI", "11:30 - 12:30", "Fazer telas do app"),
            Task("Ler Medium", "14:00 - 15:00", "Artigo sobre Android moderno")
        )

        recycleView.adapter = TaskAdapter(tasks) { task ->
            findNavController().navigate(R.id.action_homeFragment_to_taskInfoFragment);
        }


        btn_newTask.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_newTaskFragment)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragments.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragments().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}