package util

import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomLine
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.letsPlot

/**
 * Рисует график траектории в файл "trajectoryGraphic.png" по указанному пути
 *
 * @param data список вида (x, y)
 * @param path путь, куда сохранится файл с графиком
 */
fun drawTrajectoryGraphic(data: List<Pair<Double, Double>>, path: String) {
    val graphicData = mapOf(
        "x" to data.map { it.first },
        "y" to data.map { it.second }
    )

    val fig = letsPlot(graphicData) + geomPoint(color = "dark_green") {
        x = "x"
        y = "y"
    }

    ggsave(fig, "trajectoryGraphic.png", path = path)
}

/**
 * Рисует график траекторий x и y в файл "positionGraphic.png" по указанному пути
 *
 * @param data список вида (time, point), где point - (x, y)
 * @param path путь, куда сохранится файл с графиком
 */
fun drawPositionGraphic(data: List<Pair<Double, Pair<Double, Double>>>, path: String) {
    val graphicData = mapOf(
        "x" to data.map { it.second.first },
        "y" to data.map { it.second.second },
        "time" to data.map { it.first }
    )

    val fig = letsPlot(graphicData) + geomLine(color = "dark_green") {
        x = "time"
        y = "x"
    } + geomLine(color = "red") {
        x = "time"
        y = "y"
    }

    ggsave(fig, "positionGraphic.png", path = path)
}

/**
 * Рисует график скорости x и y в файл "positionGraphic.png" по указанному пути
 *
 * @param data список вида (time, velocity), где velocity - (x, y)
 * @param path путь, куда сохранится файл с графиком
 */
fun drawVelocityGraphic(data: List<Pair<Double, Pair<Double, Double>>>, path: String) {
    val graphicData = mapOf(
        "x" to data.map { it.second.first },
        "y" to data.map { it.second.second },
        "time" to data.map { it.first }
    )

    val fig = letsPlot(graphicData) + geomLine(color = "dark_green") {
        x = "time"
        y = "x"
    } + geomLine(color = "red") {
        x = "time"
        y = "y"
    }

    ggsave(fig, "velocityGraphic.png", path = path)
}