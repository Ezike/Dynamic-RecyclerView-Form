package ezike.tobenna.petform.di

import dagger.Binds
import dagger.Module
import ezike.tobenna.petform.data.local.DataSource
import ezike.tobenna.petform.data.local.LocalDataSource
import ezike.tobenna.petform.data.model.Form

@Module
abstract class SourceModule {

    @Binds
    abstract fun provideLocalSource(localDataSource: LocalDataSource): DataSource<Form>

}