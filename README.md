# M2-composants
Cours HMIN 304, Composants et reutilisation

## Résumé des séances

### Séance 16/09

- Cours **Des objets aux composants**
	- http://www.lirmm.fr/~dony/notesCours/cintrocomp.pdf
- TD/TP : Document support en anglais sur le pattern Visitor
	- https://github.com/Doelia/M2-composants/raw/master/0916_visitor/TD-TP-1-2.pdf
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
M. Dony
- Cours de 1h30 sur NetBeans et la programmation orientée composants
- TP NetBeans OK (création et utilisation de composants en interface graphique)
	- Projet netbeans : netbeans/Appli1

### Séance 14/10
- Cours de 1h30 sur [JAspect Java](http://www.lirmm.fr/~dony/notesCours/aspects.pdf)
  - Programmation orientée aspéects
  - Cours manqué à 75%
- (TP d'initiation à AspectJ](http://www.lirmm.fr/~dony/enseig/RC/TP-Aspects.pdf)
  - Configuration
    - Installation sous Eclipse Kepler
    - Téléchargements avec Install Software : https://eclipse.org/ajdt/downloads/
    - Configuration pour compiler : JavaSE-1.6 (Java SE 7 [1.7.0_79]) et aspectj.runtime_1.7.3
  - Utilisation
	 - Voir le fichier Helloaspects pour des exemples avec passage de paramètre

### Séance 21/10
Pas cours

### Séance 04/11
M. Dony  
- Cours de 1h30 sur [JEE](http://www.lirmm.fr/~dony/notesCours/cejb.pdf)
  - Amphi 6.01
  - Une feuille de note prise (résumé introduction sur les applis n tiers)
  - Cours terminé
  - Pas mal de parties obseletes...
- Commencement [TP](http://www.lirmm.fr/~tibermacin/ens/gmin30f/tp/01_ejb/tp_ejb1.pdf)
  - Sur les composants EJB
  - TP1 sur le composant EJB + client web OK

### Séance 11/11
Pas cours (férié)

### Séance 18/11
Intervenant M. Tibermacine n°1
- Support de cours/tp : http://www.lirmm.fr/~tibermacin/ens/gmin30f/
- Cours de 1h30
    - [Programmation par composants avec Spring](http://www.lirmm.fr/~tibermacin/ens/gmin30f/cours/cours1.pdf) OK
    - Début [Programmation par composants avec OSGi](http://www.lirmm.fr/~tibermacin/ens/gmin30f/cours/cours2.pdf)
- TP
    - Début TP2, commencé, codé mais pas testé
        - But : envoyer par mail et ajouter des infos depuis un autre XML
        - Fork du TP1, projet netbeans
        - Pour le MailerMDB, je n'ai pas réussi à créér un "jms/" avec "Project Destination". J'ai du créer deux modules depuis l'admin du serveur GlassFish :
            - jms/MailContentQueueFactory en Factory
            - jms/MailContentQueue en Destination Ressource
- Fait à la maison :
    - TP3 : exercite 1 et 2, execrice 3 pas fait (c'est faire du clic clic pour générer une API)
    - Une bonne partie du TP4

### Séance 25/11
Intervenant M. Tibermacine n°2
- Cours de 1h30
    - Suite et fin [Programmation par composants avec OSGi](http://www.lirmm.fr/~tibermacin/ens/gmin30f/cours/cours2.pdf)
    - [Développement par plugins](http://www.lirmm.fr/~tibermacin/ens/gmin30f/cours/cours3.pdf)
- TP noté : exercice 2 (REST) du TP2

### Séance 2/12
Intervenant Laurent Deruelle, Dr. en informatique, Ingénieur à la société Berger-Levrault, n°1
- Cours général sur le contexte industriel : Pourquoi la réutilisablité ?
  - Termes : Framework, approche, pratique, boite à outils, API, composant
- Annonce d'un TP à faire et à rendre, sujet donné à l'oral
    - Fork du TP3 JEE
    - Pas à rendre finalement (annonce du 8/12)

![](http://i.prntscr.com/e3c0621774d844b088d9411678d54b46.png)

### Séance 9/12
Intervenant Laurent Deruelle, n°2
- Cours général sur "Réutilisation et composants"
    - Réutilisabilité passive vs. active
    - Quelques régles en conception : SOLID
        - S : Signe Responsibility Principe : Une seule resposonsablité pas class
        - O : Open/closed principe : ouvert aux exentsions, efrmé aux modifications
        - L : Design par contrat
        - I : Plusieurs interfaces simple plutôt qu'une complexe
        - D : Dépendendre des interfaces plutôt que des classes concrètes
    - Intégration continue
        - "Processus d'assemblage et de vérification périodique et automatique"
        - Tester régulièrement de façon automatique le programme : compilation, test unitaires...
        - But : Détecter les anomalies lors de la phase où ils sont introduits
        - Représente un investissement pour l'entreprise
        - Note : la priorité d'un bug est relative à celui qui la relève
    - Apache MAVEN
        - Gestionnaire de dépendance
        - Format XML
    - Sérialisation

## Mémento des abrev. JEE
- JEE Java Entreprise éditon
- EJB Java Bean Entreprise
    - Type Session Bean
- JPA Poussé par hibernate (?)
- JMS Java Message Service. Le truc des boites aux lettres es jms:// dans lesquels on peut laisser des messages
- MDE Message Driven Bean. Un type de JBE que permet de récupérer des messages postés dans des JMS
- Servlet. permet de mettre de l'html dans du JAVA
- JSP Java Server Page. permet de mettre du java dans du HTML. Sera intégré comme une servlet ensuite

- ORM object-relational mapping  : truc pour gérer la BD
