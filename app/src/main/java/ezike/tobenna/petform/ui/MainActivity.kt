package ezike.tobenna.petform.ui

import android.os.Bundle
import ezike.tobenna.petform.R
import ezike.tobenna.petform.ui.base.BaseActivity
import ezike.tobenna.petform.utils.getViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel by lazy { getViewModel<PetViewModel>() }

    private val pet by lazy { viewModel.getFormData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sample.text = pet?.pages.toString()

    }
}
