package ezike.tobenna.petform.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ezike.tobenna.petform.R
import ezike.tobenna.petform.databinding.ActivityMainBinding
import ezike.tobenna.petform.ui.adapter.FormAdapter
import ezike.tobenna.petform.ui.base.BaseActivity
import ezike.tobenna.petform.utils.getViewModel

class MainActivity : BaseActivity() {

    private val viewModel by lazy { getViewModel<FormViewModel>() }

    private val form by lazy { viewModel.getFormData() }

    private lateinit var binding: ActivityMainBinding

    private val formAdapter = FormAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel

        binding.recyclerView.setHasFixedSize(true)

        binding.recyclerView.adapter = formAdapter

    }
}
