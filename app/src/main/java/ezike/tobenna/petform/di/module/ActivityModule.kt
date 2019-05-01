package ezike.tobenna.petform.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ezike.tobenna.petform.ui.activity.FormActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): FormActivity
}
