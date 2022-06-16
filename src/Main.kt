import helper.TrajectoryInterpolationViaPointsHelper
import helper.TrajectoryPolynomialHelper
import model.TrajectoryInputItemModel

fun main() {
    val data = listOf(
        TrajectoryInputItemModel(timeMoment = 0.0, point = 0.0 to 0.0, velocity = 0.0 to 0.0),
        TrajectoryInputItemModel(timeMoment = 1.0, point = 0.0 to 1.0, velocity = 1.0 to 0.0),
        TrajectoryInputItemModel(timeMoment = 2.0, point = 1.0 to 1.0, velocity = 0.0 to -1.0),
        TrajectoryInputItemModel(timeMoment = 3.0, point = 1.0 to 0.0, velocity = 0.0 to 0.0),
    )

    val interpolationHelper = TrajectoryInterpolationViaPointsHelper(data)

    val interpolationMatrix = interpolationHelper.calculateCoeffMatrix()

    val polynomialHelper = TrajectoryPolynomialHelper(
        polynomialMatrix = interpolationMatrix,
        timeMoments = data.map { it.timeMoment }
    )

    val polynomial = polynomialHelper.createPolynomial()

    var t = 0.0
    val step = 0.1
    val result = mutableListOf<Pair<Double, Double>>()

    while (t < 3) {
        result.add(polynomial.invoke(t))
        t += step
    }

    println(result)
}