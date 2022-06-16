package model

/**
 * Модель айтема входящих данных для рассчета траектории
 *
 * @property timeMoment - момент времени
 * @property point - пара <Double, Double>, хранящая точку в момент timeMoment
 * @property velocity - пара <Double, Double>, хранящий точку в момент timeMoment
 *
 * @author Nikolaevskiy Dmitriy
 */
data class TrajectoryInputItemModel(
    val timeMoment: Double,
    val point: Pair<Double, Double>,
    val velocity: Pair<Double, Double>
)