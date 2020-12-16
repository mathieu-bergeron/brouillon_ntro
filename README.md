# Brouillon Ntro

## Exemples d'applications

1. Application de validation

        $ sh gradlew testerAt

1. Application de tests de performance

    * lancée après avoir fermer l'application de validation

## Survol du code

1. Pour gérer l'asynchrone: `src/main/java/ca/ntro/core/promises/Promise.java`

### Application de validation

1. Classe principale: `src/main/java/tutoriels/core/swing/ValidationApp.java`
    * méthode `step01InstallViewPromises` installe la vue principale
    * méethode `step02InstallModelPromises` installe le modèle principal

1. Vue principale: `src/main/java/tutoriels/core/swing/views/ValidationAppMainViewSwing.java`

1. Modèle principal: `src/main/java/tutoriels/core/models/reports/ReportModel.java`

1. `ViewModel` principal: `src/main/java/tutoriels/core/models/reports/ReportViewModel.java`

1. Les attributs observés (et stoqués dans la DB) sont dans:

    * `src/main/java/tutoriels/core/models/reports/ReportNodeModel.java`

### Stoquer un modèle dans un Store

1. Voir p.ex. le code de validation 

    * `src/main/java/tutoriels/core/Validator.java`

1. Un attribut est sauvegardé dans le store lorsque modifié, p.ex:

    * `src/main/java/ca/ntro/core/models/properties/stored/simple/StoredProperty.java`

### Application de tests de performance

1. Classe principale: `src/main/java/tutoriels/core/performance_app/swing/PerformanceApp.java`
    * méthode `step01InstallViewPromises` installe la vue principale
    * méethode `step02InstallModelPromises` installe le modèle principal

## TODO

1. renommage: `NtroView`, `NtroModel`, `NtroApp`, `NtroMessage`

1. découper ainsi:
    * `NtroView`, `NtroModel`
    * `MessageModel` (pour accepter des messages et modifier le modèle)
    * `ViewModel`  (pour observer le modèle et afficher)

* mais laisser tomber `ViewModel extends Model`

* plutôt:
    * `ViewModel<M extends NtroModel, V extends NtroView>` avec la méthode `observeModelAndUpdateView(M model, V view)`
        * XXX: comment canceller les observateurs quand la vue est détruite?
            * méthode: `clearObservers`
        * Autre option: laisser l'application installer les observateurs:
            * `installViewModel()`
            * `removeViewModel()`
                
    * `MessageModel<M extends NtroModel>` avec la méthode `receiveMessagesAndUpdateModel(M model)`


* `NtroMessage`
    * `message.forwardToServer()`

* revoir l'implantation de `StoredString`

