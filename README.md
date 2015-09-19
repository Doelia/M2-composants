# M2-composants
Cours HMIN 304, Composants et reutilisation

## Utilisation
Importer le repertoire **eclise/composants** dans Eclipse (Version Mars)

## Les designs patterns

### Singleton
Oblige un objet à n'exister sous une seule instance.
Doit être vu comme une contrainte et non pas comme un outil.

### Composite
_Utilisé dans le TP1 (Fichiers/dossiers)_

![](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Composite_UML_class_diagram_fr.svg/960px-Composite_UML_class_diagram_fr.svg.png)

[Wikipedia](https://fr.wikipedia.org/wiki/Objet_composite)

### Observer
![](https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Observer.svg/854px-Observer.svg.png)
[Wikipedia](https://fr.wikipedia.org/wiki/Observateur_(patron_de_conception))

### Vistor
_Utlisé dans le TP1 (Fichiers/dossiers)_

### MVC, Modèle vue controleur

Est une combinaison des patrons **Observateur**, **Stratégie** et **Composite**, qui forme ainsi un patron d'architecture

Sépare les données, les traitements et l'affichage.
- **Modele** : Représente les données, effectue les accès à la base (composant)
- **Controleur** : Gère les évenements (input), demande les appels à la vue
- **Vue** : Met en forme l'affichage renvoyé par le **modèle**, intercepte les évents de l'user et les propage au **controleur**. 

D'après le patron de conception **observateur/observable**, la vue est un « observateur » du modèle qui est lui « observable ».




## TP1
