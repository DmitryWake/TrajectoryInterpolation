package util

import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomLine
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.geom.geomVLine
import jetbrains.letsPlot.label.labs
import jetbrains.letsPlot.label.xlab
import jetbrains.letsPlot.letsPlot

/**
 * Рисует график траектории в файл "trajectoryGraphic.png" по указанному пути
 *
 * @param data список вида (x, y)
 * @param path путь, куда сохранится файл с графиком
 * @param keyPoints ключевые точки, помеченные другим цветом
 */
fun drawTrajectoryGraphic(data: List<Pair<Double, Double>>, path: String, keyPoints: List<Pair<Double, Double>>) {

    val keyPointData = mapOf(
        "keyX" to keyPoints.map { it.first },
        "keyY" to keyPoints.map { it.second },
    )

    val graphicData = mapOf(
        "x" to data.map { it.first },
        "y" to data.map { it.second }
    )

    val fig = letsPlot(graphicData) + geomPoint(color = "dark_green") {
        x = "x"
        y = "y"
    } + geomPoint(keyPointData,color = "red") {
        x = "keyX"
        y = "keyY"
    }

    ggsave(fig, "trajectoryGraphic.png", path = path)
}

/**
 * Рисует график траекторий x и y в файл "positionGraphic.png" по указанному пути
 *
 * @param data список вида (time, point), где point - (x, y)
 * @param path путь, куда сохранится файл с графиком
 * @param keyPoints ключевые точки, помеченные как вертикальная прямая
 */
fun drawPositionGraphic(data: List<Pair<Double, Pair<Double, Double>>>, path: String, keyPoints: List<Double>) {
    val graphicData = mapOf(
        "x" to data.map { it.second.first },
        "y" to data.map { it.second.second },
        "time" to data.map { it.first }
    )

    val keyPointsData = mapOf("T" to keyPoints)

    val fig = letsPlot(graphicData) + geomLine(color = "dark_green") {
        x = "time"
        y = "x"
    } + geomLine(color = "red") {
        x = "time"
        y = "y"
    } + geomVLine(keyPointsData, linetype = "dashed") {
        this.xintercept = "T"
    }

    ggsave(fig, "positionGraphic.png", path = path)
}

/**
 * Рисует график скорости x и y в файл "positionGraphic.png" по указанному пути
 *
 * @param data список вида (time, velocity), где velocity - (x, y)
 * @param path путь, куда сохранится файл с графиком
 * @param keyPoints ключевые точки, помеченные как вертикальная прямая
 */
fun drawVelocityGraphic(data: List<Pair<Double, Pair<Double, Double>>>, path: String, keyPoints: List<Double>) {
    val graphicData = mapOf(
        "x" to data.map { it.second.first },
        "y" to data.map { it.second.second },
        "time" to data.map { it.first }
    )

    val keyPointsData = mapOf("T" to keyPoints)

    val fig = letsPlot(graphicData) + geomLine(color = "dark_green") {
        x = "time"
        y = "x"
    } + geomLine(color = "red") {
        x = "time"
        y = "y"
    } + geomVLine(keyPointsData, linetype = "dashed") {
        this.xintercept = "T"
    }

    ggsave(fig, "velocityGraphic.png", path = path)
}