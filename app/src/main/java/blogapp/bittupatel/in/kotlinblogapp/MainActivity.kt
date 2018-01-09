package blogapp.bittupatel.`in`.kotlinblogapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import blogapp.bittupatel.`in`.kotlinblogapp.fragments.CategoryFragment
import blogapp.bittupatel.`in`.kotlinblogapp.fragments.FavFragment
import blogapp.bittupatel.`in`.kotlinblogapp.fragments.HomeFragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AHBottomNavigation.OnTabSelectedListener {
    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        when (position) {
            0 -> {
                val fragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
            1 -> {
                val fragment = CategoryFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
            2 -> {
                val fragment = FavFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnTabSelectedListener(this)
        this.createNavItems()

    }

    private fun createNavItems() {
        //CREATE ITEMS
        val home = AHBottomNavigationItem("Home", R.drawable.ic_home_black_48dp)
        val category = AHBottomNavigationItem("Category", R.drawable.ic_list_black_48dp)
        val fav = AHBottomNavigationItem("Favourite", R.drawable.ic_favorite_black_48dp)

        //ADD PROPERTIES
        navigation.addItem(home)
        navigation.addItem(category)
        navigation.addItem(fav)

        //SET PROPERTIES
        navigation.defaultBackgroundColor = Color.parseColor("#ffffff")
        navigation.accentColor = Color.parseColor("#FFC107")
        navigation.inactiveColor = Color.parseColor("#BDBDBD")

        navigation.currentItem = 0
    }
}

