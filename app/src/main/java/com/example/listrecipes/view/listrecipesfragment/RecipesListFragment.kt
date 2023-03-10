package com.example.listrecipes.view.listrecipesfragment

import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.listrecipes.data.ListRecipes
import com.example.listrecipes.view.adapters.ListRecipesAdapter
import com.example.listrecipes.view.adapters.RecipesAdapterListener
import com.example.listrecipies.databinding.FragmentListRecipesBinding


class RecipesListFragment : Fragment(), RecipesAdapterListener {

    private var _binding: FragmentListRecipesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RecipesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadRecipes()
        viewModel.recipes.observe(viewLifecycleOwner){ recipes ->
            val adapter = ListRecipesAdapter(recipes, this)
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //клик по полю в списке открывает страницу с детальной информацией
    override fun onRecipeItemClick(recipe: ListRecipes) {
        val action =                //почемуто не подключается
//        findNavController().navigate()
//        findNavController().popBackStack()
    }

    override fun onFavoriteClick(recipe: ListRecipes) {
        viewModel.onRecipeFavoriteClick(recipe)
    }
}