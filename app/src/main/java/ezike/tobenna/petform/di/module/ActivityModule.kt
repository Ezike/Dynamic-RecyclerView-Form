package ezike.tobenna.petform.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ezike.tobenna.petform.ui.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
