package ezike.tobenna.petform.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ezike.tobenna.petform.di.base.Injectable
import javax.inject.Inject

typealias BaseFragment = DaggerFragment

abstract class DaggerFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

}