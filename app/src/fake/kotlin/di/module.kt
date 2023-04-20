package di

import com.geekbrains.tests.presenter.RepositoryContract
import org.koin.dsl.module
import repository.FakeGitHubRepository

val module = module {
	single<RepositoryContract> { FakeGitHubRepository() }
}