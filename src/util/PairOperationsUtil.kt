package util

operator fun Pair<Double, Double>.plus(pair: Pair<Double, Double>): Pair<Double, Double> =
    Pair(this.first + pair.first, this.second + pair.second)

operator fun Pair<Double, Double>.minus(pair: Pair<Double, Double>): Pair<Double, Double> =
    Pair(this.first - pair.first, this.second - pair.second)

operator fun Pair<Double, Double>.div(k: Double): Pair<Double, Double> =
    Pair(this.first / k, this.second / k)

operator fun Pair<Double, Double>.times(k: Int): Pair<Double, Double> =
    Pair(this.first * k, this.second * k)

operator fun Int.times(pair: Pair<Double, Double>): Pair<Double, Double> =
    Pair(pair.first * this, pair.second * this)

operator fun Pair<Double, Double>.times(k: Double): Pair<Double, Double> =
    Pair(this.first * k, this.second * k)

operator fun Double.times(pair: Pair<Double, Double>): Pair<Double, Double> =
    Pair(pair.first * this, pair.second * this)