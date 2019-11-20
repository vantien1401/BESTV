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

package com.pimenta.bestv.feature.workdetail.data.remote.datasource

import com.pimenta.bestv.BuildConfig
import com.pimenta.bestv.common.data.model.remote.CastListResponse
import com.pimenta.bestv.common.data.model.remote.TvShowPageResponse
import com.pimenta.bestv.common.data.model.remote.VideoListResponse
import com.pimenta.bestv.feature.workdetail.data.remote.api.TvShowDetailTmdbApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by marcus on 20-10-2019.
 */
class TvShowRemoteDataSource @Inject constructor(
    private val tvShowDetailTmdbApi: TvShowDetailTmdbApi
) {

    fun getCastByTvShow(tvShowId: Int): Single<CastListResponse> =
            tvShowDetailTmdbApi.getCastByTvShow(tvShowId, BuildConfig.TMDB_API_KEY, BuildConfig.TMDB_FILTER_LANGUAGE)

    fun getRecommendationByTvShow(tvShowId: Int, page: Int): Single<TvShowPageResponse> =
            tvShowDetailTmdbApi.getRecommendationByTvShow(tvShowId, BuildConfig.TMDB_API_KEY, BuildConfig.TMDB_FILTER_LANGUAGE, page)

    fun getSimilarByTvShow(tvShowId: Int, page: Int): Single<TvShowPageResponse> =
            tvShowDetailTmdbApi.getSimilarByTvShow(tvShowId, BuildConfig.TMDB_API_KEY, BuildConfig.TMDB_FILTER_LANGUAGE, page)

    fun getVideosByTvShow(tvShowId: Int): Single<VideoListResponse> =
            tvShowDetailTmdbApi.getVideosByTvShow(tvShowId, BuildConfig.TMDB_API_KEY, BuildConfig.TMDB_FILTER_LANGUAGE)
}