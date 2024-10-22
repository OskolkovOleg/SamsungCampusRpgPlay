package repositories.wizard

import data_models.WizardModel


abstract class AbstractWizardRepository {
    abstract fun getWizardModel() : WizardModel
}