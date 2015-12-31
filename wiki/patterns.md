
## Les designs patterns

### Factory (Fabrique)
Vu au cours 1 du 16/09_

### Singleton
Oblige un objet à n'exister sous une seule instance.
Doit être vu comme une contrainte et non pas comme un outil.

### Composite
_Utilisé dans le TP1 (Fichiers/dossiers)_

Permet de former un arbre binaire récursif. Utilisé généralement pour les arborescences.
La classe Composant contient les méthodes de traitement abstraites. (exemple: ls pour dir/file)

<a href="https://fr.wikipedia.org/wiki/Objet_composite">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Composite_UML_class_diagram_fr.svg/960px-Composite_UML_class_diagram_fr.svg.png" width="450" >
</a>


### Observer

Des objets **Observer** (ayant une mèthode onNotify()) se connectent à un **Observable** (ici Subject).

<a href="https://fr.wikipedia.org/wiki/Observateur_(patron_de_conception)">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Observer.svg/854px-Observer.svg.png" width="500" >
</a>


### Vistor
_Utlisé dans le TP1 (Fichiers/dossiers)_

Permet d'obtenir le même effet que d'ajouter une nouvelle méthode virtuelle à un ensemble de classe qui ne le permet pas.

Approche private/client code.

<a href="https://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)">
<img src="https://upload.wikimedia.org/wikipedia/commons/f/fc/Visitorpattern.png" width="500" >
</a>


Contrainte : On accède uniquement à la partie publique de l'objet visité.

Si on est dans un pattern Composite, ajouter dans la méthode accept le parcours puis les autres accepts. Exemple :
```java
@Override
public void accept(Visitor v) {
	v.visiteDirectory(this);
	for (StorageElement s : listeDossier) {
		s.accept(v);
	}
}
```

- Facilité : Ajouter de opérations
- Contre facilité : Ajouter de nouvelles classes


### MVC, Modèle vue controleur

Est une combinaison des patrons **Observer**, **Stratégie** et **Composite**, qui forme ainsi un patron d'architecture

Sépare les données, les traitements et l'affichage.
- **Modele** : Représente les données, effectue les accès à la base (composant)
- **Controleur** : Gère les évenements (input), demande les appels à la vue
- **Vue** : Met en forme l'affichage renvoyé par le **modèle**, intercepte les évents de l'user et les propage au **controleur**.

D'après le patron de conception **observateur/observable**, la vue est un « observateur » du modèle qui est lui « observable ».
