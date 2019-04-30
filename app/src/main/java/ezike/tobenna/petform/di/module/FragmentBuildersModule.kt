package ezike.tobenna.petform.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ezike.tobenna.petform.ui.FormFragment


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFormFragment(): FormFragment
}
