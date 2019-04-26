package ezike.tobenna.petform.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ezike.tobenna.petform.PetApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // Dagger support
        AndroidInjectionModule::class,

        // App
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        SourceModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(petApplication: PetApplication)
}
