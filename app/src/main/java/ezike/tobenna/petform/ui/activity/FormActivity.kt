package ezike.tobenna.petform.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ezike.tobenna.petform.R
import ezike.tobenna.petform.data.model.Pages
import ezike.tobenna.petform.databinding.ActivityMainBinding
import ezike.tobenna.petform.ui.FormFragment
import ezike.tobenna.petform.ui.FormViewModel
import ezike.tobenna.petform.ui.base.BaseActivity
import ezike.tobenna.petform.utils.getViewModel
import timber.log.Timber

class FormActivity : BaseActivity() {

    private val viewModel by lazy { getViewModel<FormViewModel>() }

    private val page by lazy { viewModel.getCurrentPage() }

    private val tag by lazy { page.label.substring(5, 6) }

    private var fragment: FormFragment? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        frameId = R.id.frame

        if (savedInstanceState == null) {
            addFragment(page, tag)
        } else {
            fragment = supportFragmentManager.findFragmentByTag(tag) as FormFragment?
        }

        viewModel.elementLiveData.observe(this, Observer {
            Timber.d("map called")
            replaceFragmentInActivity(FormFragment.newInstance(it), tag)

        })

    }

    private fun addFragment(page: Pages, tag: String) {

        fragment = supportFragmentManager.findFragmentByTag(tag) as FormFragment?

        if (fragment == null) {

            Timber.d("Fragment null | new instance")

            fragment = FormFragment.newInstance(page)

            addFragment(fragment!!, tag)
        }

    }

    override fun onBackPressed() {
        finish()
    }

}
