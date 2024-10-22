package repositories.Knight

import data_models.KnightModel


abstract class AbstractKnightRepository {
    abstract fun getKnightModel() : KnightModel
}