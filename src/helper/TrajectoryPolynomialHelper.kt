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
            var i = 0
            while (t > timeMomentsSortedList[i]) {
                ++i
                if (i == timeMomentsSortedList.size) {
                    throw IllegalArgumentException("Time is out of range")
                }
            }

            if (i == timeMomentsSortedList.size - 1) --i

            val coeff = polynomialMatrix[i]

            coeff[0] * t.pow(3) + coeff[1] * t.pow(2) + coeff[2] * t + coeff[3]
        }
    }
}