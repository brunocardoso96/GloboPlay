package dominando.android.globoplay.ui.feature.moviedetail.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dominando.android.globoplay.ui.feature.moviedetail.fragment.MovieInfoFragment

private val TAB_TITLES = arrayOf(
    "ASSISTA TAMBÉM",
    "DETALHES"
)

class MovieInfoAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MovieInfoFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return 2
    }
}