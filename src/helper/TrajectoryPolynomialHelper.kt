package helper

import util.plus
import util.times
import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * Хелпер, который на основе полиномиальной матрицы генерирует полиномиальную лямбду
 */
class TrajectoryPolynomialHelper(
    private val polynomialMatrix: List<List<Pair<Double, Double>>>,
    timeMoments: List<Double>
) {

    private val timeMomentsSortedList = timeMoments.toMutableList().apply { sort() }.toList()

    init {
        if (polynomialMatrix.any { it.size != 4 })
            throw IllegalArgumentException("PolynomialMatrix must be (n x 4) size, where n is timeMoments.size - 1")
    }

    /**
     * @return Лямбда, которая является полиномом траектории и содержит ссылку на хелпер
     */
    fun createPolynomial(): (time: Double) -> Pair<Double, Double> {
        return { t ->
            var k = 0
            for (i in 0 until timeMomentsSortedList.size - 1) {
                if (t in timeMomentsSortedList[i]..timeMomentsSortedList[i + 1]) k = i
            }

            val deltaT = t - timeMomentsSortedList[k]

            val coeff = polynomialMatrix[k]

            coeff[3] * deltaT.pow(3) + coeff[2] * deltaT.pow(2) + coeff[1] * deltaT + coeff[0]
        }
    }

    /**
     * @return Лямбда, которая является производной полинома траектории и содержит ссылку на хелпер
     */
    fun createDiffPolynomial(): (time: Double) -> Pair<Double, Double> {
        return { t ->
            var k = 0
            for (i in 0 until timeMomentsSortedList.size - 1) {
                if (t in timeMomentsSortedList[i]..timeMomentsSortedList[i + 1]) k = i
            }

            val deltaT = t - timeMomentsSortedList[k]

            val coeff = polynomialMatrix[k]

            3 * coeff[3] * deltaT.pow(2) + 2 * coeff[2] * deltaT + coeff[1]
        }
    }
}