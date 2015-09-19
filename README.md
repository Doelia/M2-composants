# Cours HMIN 304, Composants et reutilisation

## Utilisation
Importer le repertoire **eclise/composants** dans Eclipse (Version Mars)

## Les designs patterns

### MVC, Modèle vue controleur
Sépare les données, les traitements et l'affichage.
- **Modele** : Représente les données, effectue les accès à la base (composant)
- **Controleur** : Gère les évenements (input), demande les appels à la vue
- **Vue** : Met en forme l'affichage renvoyé par le **modèle**, intercepte les évents de l'user et les propage au **controleur**. 

D'après le patron de conception **observateur/observable**, la vue est un « observateur » du modèle qui est lui « observable ».




## TP1

