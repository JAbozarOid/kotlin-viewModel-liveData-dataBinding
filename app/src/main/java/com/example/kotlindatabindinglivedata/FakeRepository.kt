package com.example.kotlindatabindinglivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitNames: List<String> = listOf(
        "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig", "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    private val _currentRandomFruitName = MutableLiveData<String>()
    // because _currentRandomFruitName is the private we need the public val currenrandomfruitname
    // why we do this, because we don't want to expose _currentRandomFruitName out of this class so we want to change the value of _currentRandomFruitName just inside of this class
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }

}