package ezike.tobenna.petform.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ezike.tobenna.petform.di.base.ViewModelFactory
import ezike.tobenna.petform.di.base.ViewModelKey
import ezike.tobenna.petform.ui.PetViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PetViewModel::class)
    abstract fun bindNewsArticleViewModel(petViewModel: PetViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
