package helper

import model.TrajectoryInputItemModel
import util.*
import kotlin.math.pow

class TrajectoryInterpolationViaPointsHelper(
    private val data: List<TrajectoryInputItemModel>
) {
    /**
     * Считает матрицу коэффициентов A на основе входных данных
     * Элементом матрицы A является a = (x, y)
     *
     * @return Матрицу, представленную в виде вложенного списка, элементами которой являются Pair<Double, Double>
     */
    fun calculateCoeffMatrix(): List<List<Pair<Double, Double>>> {
        val resultList = mutableListOf<List<Pair<Double, Double>>>()

        val sortedData = data.sortByTime()
        val k = sortedData.size

        for (i in 0 until k - 1) {
            val item = sortedData[i]
            val nextItem = sortedData[i + 1]

            val deltaT = nextItem.timeMoment - item.timeMoment

            val a0 = item.point
            val a1 = item.velocity
            val a2 = (3 * nextItem.point - 3 * item.point - 2 * item.velocity * deltaT - nextItem.velocity * deltaT) / deltaT.pow(2)
            val a3 = (2 * item.point + (item.velocity + nextItem.velocity) * deltaT - 2 * nextItem.point) / deltaT.pow(3)

            resultList.add(listOf(a0, a1, a2, a3))
        }

        return resultList
    }

    private fun List<TrajectoryInputItemModel>.sortByTime() = this.toMutableList().apply {
        sortWith(Comparator { o1, o2 ->
            return@Comparator if (o1.timeMoment == o2.timeMoment) {
                0
            } else if (o1.timeMoment > o2.timeMoment) {
                1
            } else {
                -1
            }
        })
    }
}