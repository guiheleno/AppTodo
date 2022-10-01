package com.generation.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.todoapp.adapter.TarefaAdapter
import com.generation.todoapp.databinding.FragmentListBinding
import com.generation.todoapp.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listTarefa = listOf(
            Tarefa(
                "Estudar",
                "Revisar os conteúdos que foi passado durante a semana",
                "Guilherme",
                "2022-10-01",
                false,
                "Dia a dia"
            ),
            Tarefa(
                "Futebol",
                "Jogar bola com os amigos",
                "Guilherme",
                "2022-10-02",
                false,
                "Lazer"
            )
        )

        //Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefa)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}