package repositories.robot

import data_models.RobotModel


abstract class AbstractRobotRepository {
    abstract fun getRobotModel() : RobotModel
}