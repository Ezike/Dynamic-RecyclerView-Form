package ezike.tobenna.petform.di.module

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder().build()!!

    @Singleton
    @Provides
    fun provideContext(application: Application) = application.applicationContext!!

}


