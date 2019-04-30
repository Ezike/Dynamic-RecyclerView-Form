package ezike.tobenna.petform.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ezike.tobenna.petform.di.base.ViewModelFactory
import ezike.tobenna.petform.di.base.ViewModelKey
import ezike.tobenna.petform.ui.FormViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FormViewModel::class)
    abstract fun bindNewsArticleViewModel(formViewModel: FormViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
