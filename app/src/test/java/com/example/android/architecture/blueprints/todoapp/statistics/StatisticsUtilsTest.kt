package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.hamcrest.number.IsNaN.notANumber
import org.junit.Assert.assertThat
import org.junit.Test
import kotlin.math.sqrt

class StatisticsUtilsTest {

    @Test
    fun `getActiveAndCompletedStats No Completed, Returns Hundred Zero`() {
        val tasks = listOf(
                Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun `getActiveAndCompletedStats No Active Returns Zero Hundred`() {
        val tasks = listOf(
                Task("title", "desc", isCompleted = true)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun `getActiveAndCompletedStats Both Returns Forty Sixty`() {
        val tasks = listOf(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }

    @Test
    fun `getActiveAndCompletedStats Error Returns Zeros`() {
        val result = getActiveAndCompletedStats(null)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun `getActiveAndCompletedStats Empty Returns Zeros`() {
        val result = getActiveAndCompletedStats(emptyList())

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun testSquareRootOfMinusOneIsNotANumber() {
        assertThat(sqrt(-1.0), `is`(notANumber()))
    }
}