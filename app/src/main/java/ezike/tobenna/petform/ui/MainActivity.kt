package ezike.tobenna.petform.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import ezike.tobenna.petform.R
import ezike.tobenna.petform.data.model.Pages
import ezike.tobenna.petform.databinding.ActivityMainBinding
import ezike.tobenna.petform.ui.base.BaseActivity
import ezike.tobenna.petform.utils.getViewModel

class MainActivity : BaseActivity() {

    private val viewModel by lazy { getViewModel<FormViewModel>() }

    private val form by lazy { viewModel.getFormData() }

    private val page by lazy { form!!.pages[currentPageNumber] }

    private var currentPageNumber: Int = 0

    private var fragment: FormFragment? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState != null) {
            currentPageNumber = savedInstanceState.getInt(CURRENT_PAGE_NUMBER_KEY)
        }

        setUpFragment(page)
    }

    private fun setUpFragment(page: Pages) {

        frameId = R.id.frame

        tag = "$currentPageNumber"

        val fragmentManager = supportFragmentManager

        fragment = fragmentManager.findFragmentByTag(tag) as FormFragment?

        if (fragment == null) {

            fragment = FormFragment.newInstance(page, currentPageNumber, checkPageNumber())

            addFragment(fragment!!, fragmentManager, tag)
        }

    }

    private fun checkPageNumber(): Int {

        if (currentPageNumber == 0) {
            return PagePosition.FIRST
        } else if (currentPageNumber < form!!.pages.lastIndex) {
            return PagePosition.BETWEEN
        }
        return PagePosition.LAST
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.putInt(CURRENT_PAGE_NUMBER_KEY, currentPageNumber)
        super.onSaveInstanceState(outState, outPersistentState)
    }


    companion object {
        const val CURRENT_PAGE_NUMBER_KEY = "page_number_main_activity"
    }
}

object PagePosition {
    const val FIRST = 0
    const val BETWEEN = 1
    const val LAST = 2
}