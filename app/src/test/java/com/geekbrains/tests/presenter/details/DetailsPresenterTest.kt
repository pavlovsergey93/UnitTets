package com.geekbrains.tests.presenter.details

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DetailsPresenterTest {
	@Mock
	private lateinit var presenter: DetailsPresenter

	@Mock
	private lateinit var viewContract: ViewDetailsContract

	private var countMock: Int = 10

	@Before
	fun setUp() {
		MockitoAnnotations.openMocks(this)
	}

	@Test
	fun setCounter_Test() {
		presenter.setCounter(countMock)
		verify(presenter).setCounter(eq(10))
	}

	@Test
	fun onIncrement_Test() {
		viewContract.setCount(++countMock)
		verify(viewContract).setCount(eq(11))

	}

	@Test
	fun onDecrement_Test() {
		viewContract.setCount(--countMock)
		verify(viewContract).setCount(eq(9))
	}

	@Test
	fun onAttach_Test() {
		presenter.onAttach(viewContract)
		val instance = presenter.javaClass
		instance.declaredFields.forEach {
			it.isAccessible = true
			if (it.name == "view") {
				Assert.assertEquals(viewContract, it.get(presenter))
			}
		}
	}

	@Test
	fun onDetach_Test(){
		presenter.onDetach()
		val instance = presenter.javaClass
		instance.declaredFields.forEach {
			it.isAccessible = true
			if (it.name == "view") {
				Assert.assertNull(it.get(presenter))
			}
		}
	}
}