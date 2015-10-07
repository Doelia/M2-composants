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

## Résumé des séances

### Séance 16/09

- Cours **"Des objets aux composants"**
	- http://www.lirmm.fr/~dony/notesCours/cintrocomp.pdf
- TD/TP : Document support en anglais sur le pattern Visitor
	- https://github.com/Doelia/M2-composants/raw/master/TD-TP-1-2.pdf
	- 3 première questions
    - TP à avancer.


### Séance 23/09

- Cours : Suite et fin du cours **"Des objets aux composants"**
    - Listing des problèmes :
        - L'expression du requis
        - L'expression des architectures (il faut un UML pour les comprendre)
        - La séparation aspects fonctionnels/non fonctionnels
    - Défintion d'un composant et des différences apppoches
        - Approche générale avec les ADLS (UML Component)
        - Approche Framework (COM+, CORBA, ESB, web services...)
        - Approche langage de Proy
- TP : Suite du TP sur le patten Visitor
    - Pattern [Double Dispatch](https://fr.wikibooks.org/wiki/Patrons_de_conception/Double-dispatch) (pour compatiblité Java)

### Séance 30/09
Cours annulé, pas encore reporté.

### Séance 07/10

- Cours de 1h30 sur NetBeans et la programmation orientée composants
- TP NetBeans OK (création et utilisation de composants en interface graphique)
