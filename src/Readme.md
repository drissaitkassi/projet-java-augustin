
## Manuel d'Execution 

1) allez dans la methode main sous le fichier Start
   src/exec/Start.java

2) après execution du programme vous aurez un menu principale
   Qui va vous guider dans l'usage d'application

## Structure de Projet 
```
├── java-projet-akdriss.iml
└── src
    ├── Readme.md
    ├── data
    │   ├── ActionBDD.java
    │   ├── ActionBDDimpl.java
    │   └── ProgrammerBean.java
    ├── exec
    │   ├── AbsMenu.java
    │   ├── Main.java
    │   └── Start.java
    ├── exeptions
    │   ├── ExeptionGenerator.java
    │   └── NomberOfAddQueriesExceeded.java
    └── utils
        └── Constants.java
```

<br>

## Base de Donnée 

SGBD utilisé : PostgreSQL avec Pgadmin <br>  
Base de Donnée : javaprojet <br>
Port : 5432



## Traitement des Exeption 

### 1 - Exccès d'ajoute  "NomberOfAddQueriesExceeded" :

**C'est une exception génerer quand on essai d'ajouter plus de 100 tuples a notre 
base de donnée** 

*Le code ci-dessous vous permet de génerer l'Exception En Appelant La Method generateAddException()*

```
public class Start {
    public static void main(String[] args) throws SQLException {
    
      // run this code to start the programe 
      
       Menu menu = new Menu();
       menu.interfacePrincipale();
         
        //remove  comment on this code to generate NomberOfAddQueriesExceeded
        
          /*  ExeptionGenerator e=new ExeptionGenerator();
             e.generateAddException();  */
        
    }
}
```
### 2 - Suppression ou Modification avec un Id non Existant :

**Exeption de Suppression ou Modification Avec Gestion du Cas Ou La Base Et Vide 
Pour Eviter La Boucle Infini**

### 3 - Choix Menu Invalide 
**Exeption Lorsque  L'utilisateur Saisie un Choix Invalide**