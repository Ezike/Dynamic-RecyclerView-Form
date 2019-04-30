package ezike.tobenna.petform.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import ezike.tobenna.petform.ui.base.BaseActivity
import ezike.tobenna.petform.ui.base.DaggerFragment

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}

/**
 * Synthetic sugaring to get instance of [ViewModel] for [Fragment].
 */
inline fun <reified T : ViewModel> DaggerFragment.getViewModel(): T {
    return ViewModelProviders.of(activity!!, viewModelFactory).get(T::class.java)
}
