package ezike.tobenna.petform.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ezike.tobenna.petform.R
import ezike.tobenna.petform.utils.transact
import javax.inject.Inject

// Easy to switch base activity in future
typealias BaseActivity = DaggerActivity

/**
 * Activity providing Dagger support and [viewModelFactory] support
 */
abstract class DaggerActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    var frameId = -1

    private val manager = supportFragmentManager

    fun addFragment(fragment: Fragment, tag: String) {

        manager.transact {
            setCustomAnimations(
                R.anim.anim_slide_left_enter,
                R.anim.anim_slide_left_exit,
                R.anim.anim_slide_right_enter,
                R.anim.anim_slide_right_exit
            )
            add(frameId, fragment, tag)
            addToBackStack(tag)
        }
    }

    fun replaceFragmentInActivity(fragment: Fragment, tag: String) {

        manager.transact {
            setCustomAnimations(
                R.anim.anim_slide_left_enter,
                R.anim.anim_slide_left_exit,
                R.anim.anim_slide_right_enter,
                R.anim.anim_slide_right_exit
            )
            replace(frameId, fragment)
            addToBackStack(tag)
        }
    }
}
