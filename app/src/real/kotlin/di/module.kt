package di

import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.GitHubApi
import com.geekbrains.tests.view.search.MainActivity
import org.koin.dsl.module
import repository.GitHubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val module = module {
	single<RepositoryContract> { GitHubRepository(get<Retrofit>().create(GitHubApi::class.java)) }
	single<Retrofit> {
		Retrofit.Builder()
		.baseUrl(MainActivity.BASE_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build() }
}