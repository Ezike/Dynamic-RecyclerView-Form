package ezike.tobenna.petform.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ezike.tobenna.petform.ui.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
