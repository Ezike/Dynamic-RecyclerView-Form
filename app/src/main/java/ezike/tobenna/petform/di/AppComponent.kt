package ezike.tobenna.petform.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ezike.tobenna.petform.PetApplication
import ezike.tobenna.petform.di.module.ActivityModule
import ezike.tobenna.petform.di.module.AppModule
import ezike.tobenna.petform.di.module.SourceModule
import ezike.tobenna.petform.di.module.ViewModelModule
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
