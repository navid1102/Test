package com.petroiranco.test

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent


//TODO: Optimize below methods

//private fun method_1(isChecked: Boolean, isActivated: Boolean): Boolean {
//    return when {
//        isChecked && isActivated -> true
//        isChecked && !isActivated -> false
//        !isChecked && !isActivated -> true
//        !isChecked && isActivated -> false
//        else -> false
//    }
//}
//--------------------------------------------
private fun refactor_method_1(isChecked: Boolean, isActivated: Boolean): Boolean {
    return isChecked == isActivated
}
//------------------------------------------

//private fun method_2(list: List<Int>): List<Int> {
//    val result = mutableListOf<Int>()
//
//    fun helper(list: List<Int>) {
//        if (list.isEmpty()) {
//            return
//        }
//
//        if (list.first() % 2 == 1) {
//            result.add(list.first())
//        }
//
//        helper(list.drop(1))
//    }
//
//    helper(list)
//
//    return result
//}
//*************************************************************
private fun refactor_method_2(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()

    list.let {
        list.forEach { first ->
            if (first % 2 == 1) result.add(first)
        }
    }?.run {

    }
    return result
}

//----------------------------------------------------------------
//private fun countDown(n: Int): List<Int> {
//    if (n == 0) {
//        return listOf(0)
//    }
//    return mutableListOf(n).also { it.addAll(countDown(n - 1)) }
//}
//***********************************************
private fun refactorContDown(n: Int): List<Int> {

    val list = mutableListOf<Int>()
    for (i in n downTo 0 step 1) {
        list.add(i)
    }
    return list
}


//---------------------------------------------------------------------

//TODO: Implement below methods

private fun containsRange(range1: IntRange, range2: IntRange): Boolean {
    TODO("not implemented")
}

//***********************************************
private fun refactorSumNumbersUntil(n: Int): Int {
    val list = mutableListOf<Int>()

    list.addAll(0.until(n + 1))
    return list.sum()
}


//TODO: Write Unit Test for below methods

private fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
    val i1Str = i1.toString()
    val i2Str = i2.toString()

    if (i1Str.length != i2Str.length) {
        return false
    }

    val frequencyCounter1 = i1Str.groupingBy { it }.eachCount()
    val frequencyCounter2 = i2Str.groupingBy { it }.eachCount()
    return frequencyCounter1 == frequencyCounter2
}

private fun binarySearch(list: List<Char>, element: Char): Int {
    var left = 0
    var right = list.size - 1

    while (left <= right) {
        val middle = (right + left) / 2

        if (list[middle] == element)
            return middle

        if (list[middle] < element)
            left = middle + 1
        else
            right = middle - 1
    }

    return -1
}


//class UnitTests {
//
//    @Test
//    fun testMethod_1() {
//        Assert.assertEquals(true, method_1(isChecked = true, isActivated = true))
//        Assert.assertEquals(false, method_1(isChecked = true, isActivated = false))
//        Assert.assertEquals(false, method_1(isChecked = false, isActivated = true))
//        Assert.assertEquals(true, method_1(isChecked = false, isActivated = false))
//    }
//
//    @Test
//    fun testMethod_2() {
//        Assert.assertEquals(listOf(17, 21, 33), method_2(listOf(17, 21, 44, 33, 16)))
//        Assert.assertEquals(listOf<Int>(), method_2(listOf()))
//        Assert.assertEquals(listOf<Int>(), method_2(listOf(2, 4, 28)))
//    }
//
//    @Test
//    fun testContainsRange() {
//        Assert.assertEquals(true, containsRange(12..17, 15..17))
//        Assert.assertNotEquals(true, containsRange(5..7, 1..12))
//    }
//
//    @Test
//    fun testSumNumbersUntil() {
//        Assert.assertEquals(28, sumNumbersUntil(7))
//        Assert.assertNotEquals(10, sumNumbersUntil(3))
//    }
//
//    @Test
//    fun testCountDown() {
//        Assert.assertEquals(listOf(4, 3, 2, 1, 0), countDown(4))
//        Assert.assertEquals(listOf(0), countDown(0))
//    }
//
//    @Test
//    fun testEqualDigitFrequency() {
//        TODO("not implemented")
//    }
//
//    @Test
//    fun testBinarySearch() {
//        TODO("not implemented")
//    }
//}


//TODO: Optimize below code

private data class User(val name: String, val age: Int)
private enum class Type { REMOTE, LOCAL, MOCK }

//--------------*********************************-----------------------
//can you give me your gitlabAccount that i add you on my test project?
//i did  not have enough time for complete  below part but i have test project in my gitlab .
//you can evaluation me with it. tanks
// my Phone Number 09385027514

private class Repository {

    private fun saveUser(user: User, type: Type) {
        when (type) {
            Type.MOCK -> MockDataSource().saveUser(user)
            Type.LOCAL -> LocalDataSource().saveUser(user)
            Type.REMOTE -> RemoteDataSource().saveUser(user)
        }
    }
}

private class RemoteDataSource() {

    fun saveUser(user: User) {
        // some code to save user on server
    }
}

private class LocalDataSource() : KoinComponent {

//    val allQueues: Flow<List<User>> =userDao.getAllQueues()
//
//    @WorkerThread
//    suspend fun insert(user:User) = withContext(
//        Dispatchers.IO) {
//        userDao.insert(user)
//    }
//
//
//    @WorkerThread
//    suspend fun deleteAllQueues()= withContext(Dispatchers.IO){
//        userDao.deleteAll()
//    }


    fun saveUser(user: User) {
        // some code to save user on local database
    }
}

private class MockDataSource {
    fun saveUser(user: User) {
        // some code to save fake user
    }
}
