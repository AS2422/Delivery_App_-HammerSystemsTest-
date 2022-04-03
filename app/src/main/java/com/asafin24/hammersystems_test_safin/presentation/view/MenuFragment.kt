package com.asafin24.hammersystems_test_safin.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.asafin24.hammersystems_test_safin.R
import com.asafin24.hammersystems_test_safin.databinding.FragmentMenuBinding
import com.asafin24.hammersystems_test_safin.presentation.adapters.BannerAdapter
import com.asafin24.hammersystems_test_safin.presentation.adapters.CategoryAdapter
import com.asafin24.hammersystems_test_safin.presentation.adapters.ProductAdapter
import com.asafin24.hammersystems_test_safin.presentation.viewModel.MenuViewModel
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment(), CategoryAdapter.Listener {

    lateinit var binding: FragmentMenuBinding
    private val bannerAdapter = BannerAdapter()
    private val categoryAdapter = CategoryAdapter(this)
    private val productAdapter = ProductAdapter()
    private lateinit var menuViewModel: MenuViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        popupMenu(fragment_menu)
    }

    private fun init() {
        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuViewModel.getMenu()

        binding.carousel.adapter = bannerAdapter
        binding.rvCategoryMenu.adapter = categoryAdapter
        binding.rvProducts.adapter = productAdapter

        menuViewModel.menuList.observe(viewLifecycleOwner) { list ->
            list.body().let {
                productAdapter.setList(it!!.results)
            }
        }
    }

    override fun onClickCategory(category: View) {
        category.tv_category_name.setTextColor(ContextCompat.getColor(requireContext(),
            R.color.categoryTextSelect
        ))
        category.cv_category.setCardBackgroundColor(ContextCompat.getColor(requireContext(),
            R.color.categorySelect
        ))
    }

    override fun unClickCategory(category: View) {
        category.tv_category_name.setTextColor(ContextCompat.getColor(requireContext(),
            R.color.categoryText
        ))
        category.cv_category.setCardBackgroundColor(ContextCompat.getColor(requireContext(),
            R.color.background
        ))
    }

    private fun popupMenu(view: View) {

        val popupMenu = androidx.appcompat.widget.PopupMenu(view.context,btn_select_city)
        popupMenu.inflate(R.menu.cities_menu)
        popupMenu.setOnMenuItemClickListener {
            btn_select_city.text = it.toString()
            true
        }

        binding.btnSelectCity.setOnClickListener {
            try {
                val popup = androidx.appcompat.widget.PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true

                val menu = popup.get(popupMenu)
                menu.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu,true)

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                popupMenu.show()
            }
        }
    }
}