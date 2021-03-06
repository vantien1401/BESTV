/*
 * Copyright (C) 2018 Marcus Pimenta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.pimenta.bestv.castdetail.di

import android.app.Application
import com.pimenta.bestv.presentation.di.module.ApplicationModule
import com.pimenta.bestv.presentation.di.module.SchedulerModule
import com.pimenta.bestv.castdetail.di.module.CastRemoteDataSourceModule
import com.pimenta.bestv.castdetail.presentation.presenter.CastDetailsPresenter
import com.pimenta.bestv.castdetail.presentation.ui.fragment.CastDetailsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by marcus on 2019-08-28.
 */
@Singleton
@Component(
        modules = [
            ApplicationModule::class,
            CastRemoteDataSourceModule::class,
            SchedulerModule::class
        ]
)
interface CastDetailsFragmentComponent {

    fun inject(castDetailsFragment: CastDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance view: CastDetailsPresenter.View,
            @BindsInstance application: Application
        ): CastDetailsFragmentComponent
    }

    companion object {
        fun create(view: CastDetailsPresenter.View, application: Application): CastDetailsFragmentComponent =
                DaggerCastDetailsFragmentComponent.factory()
                        .create(view, application)
    }
}