package com.example.myapplication.presentation.character

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.CharactersFactory
import com.example.CharactersFactory.mockCharacters
import com.example.myapplication.data.model.*
import com.example.myapplication.data.state.ResourceState
import com.example.myapplication.domain.model.Characters
import com.example.myapplication.domain.repository.CharacterRepository
import com.example.myapplication.domain.usecase.CharactersUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mockito
import kotlin.test.assertEquals


class CharactersViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher =  UnconfinedTestDispatcher()

    private val repository = mockk<CharacterRepository>()

    private val useCase = mockk<CharactersUseCase>()

    private val viewModel = CharactersViewModel(useCase)

    private val getCharacters = mockCharacters()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun getCharacters_return_success() {
        //GIVEN
        every { repository.getCharacterRepository() } returns flow {emit(getCharacters)}

        //WHEN
        viewModel.getCharacters()

        //THEN
        assertEquals(ResourceState.Success(getCharacters), viewModel.descriptionCharacter.value)
    }

    @Test
    fun getCharacters_return_error() {
        every { repository.getCharacterRepository() } returns flow {emit(getCharacters)}
        viewModel.getCharacters()
        assertEquals("Error message", viewModel.error.value)
    }

}