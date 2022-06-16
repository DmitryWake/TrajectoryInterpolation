import helper.TrajectoryInterpolationViaPointsHelper
import helper.TrajectoryPolynomialHelper
import model.TrajectoryInputItemModel
import util.drawPositionGraphic
import util.drawTrajectoryGraphic
import util.drawVelocityGraphic

fun main() {
    // Входные данные
    val data = listOf(
        TrajectoryInputItemModel(timeMoment = 0.0, point = 0.0 to 0.0, velocity = 0.0 to 0.0),
        TrajectoryInputItemModel(timeMoment = 1.0, point = 0.0 to 1.0, velocity = 1.0 to 0.0),
        TrajectoryInputItemModel(timeMoment = 2.0, point = 1.0 to 1.0, velocity = 0.0 to -1.0),
        TrajectoryInputItemModel(timeMoment = 3.0, point = 1.0 to 0.0, velocity = 0.0 to 0.0),
    )

    val interpolationHelper = TrajectoryInterpolationViaPointsHelper(data)

    // Матрица для полинома интерполяции
    val interpolationMatrix = interpolationHelper.calculateCoeffMatrix()

    val polynomialHelper = TrajectoryPolynomialHelper(
        polynomialMatrix = interpolationMatrix,
        timeMoments = data.map { it.timeMoment }
    )

    // Полином, как лямбда функция
    val polynomial = polynomialHelper.createPolynomial()
    val diffPolynomial = polynomialHelper.createDiffPolynomial()

    // Начальное время
    var t = 0.0
    // Шаг
    val step = 0.01

    // Результат полинома для всех t
    val result = mutableListOf<Pair<Double, Pair<Double, Double>>>()
    // Результат производной полинома для всех t
    val resultDiff = mutableListOf<Pair<Double, Pair<Double, Double>>>()

    while (t < 3) {
        result.add(t to polynomial.invoke(t))
        resultDiff.add(t to diffPolynomial.invoke(t))
        t += step
    }

    // Рисуем графики
    drawTrajectoryGraphic(result.map { it.second }, PATH)
    drawPositionGraphic(result, PATH)
    drawVelocityGraphic(resultDiff, PATH)
}

// Тут указывается путь, куда будут сохранены рисунки с графиками
private const val PATH = ""