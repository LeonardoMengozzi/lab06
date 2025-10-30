# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
leo05@MSI MINGW64 ~/Desktop
$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git es61
Cloning into 'es61'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.


2. Ci si assicuri di avere localmente entrambi i branch remoti
leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)


3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master` e da qui si esegua il merge di `feature`
leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.


4. Si noti che viene generato un **merge conflict**!
leo05@MSI MINGW64 ~/Desktop/es61 (master|MERGING)
$ git diff master origin/feature
diff --git a/HelloWorld.java b/HelloWorld.java
index 4f5d9b7..ed370d1 100644
--- a/HelloWorld.java
+++ b/HelloWorld.java
@@ -1,11 +1,9 @@
 public final class HelloWorld {

-       public static void main(final String[] args) {
-               System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
-       }
+       private static final String AUTHOR = "Danilo Pianini";

-       public static int procNumber() {
-               return Runtime.getRuntime().availableProcessors();
+       public static void main(final String[] args) {
+               System.out.println("This program has been realised by " + AUTHOR);
        }

 }

leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git checkout feature
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'

leo05@MSI MINGW64 ~/Desktop/es61 (feature)
$ git log --graph --all --oneline
* bed943f (HEAD -> feature, origin/feature) Print author information
| * 8e0f29c (origin/master, origin/HEAD, master) Change HelloWorld to print the number of available processors
|/
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld


5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git remote add myRemote https://github.com/LeonardoMengozzi/Lab6ex61Punto5.git


8. Si faccia push del branch `master` sul proprio repository
 git push myRemote master
info: please complete authentication in your browser...
Enumerating objects: 18, done.
Counting objects: 100% (18/18), done.
Delta compression using up to 20 threads
Compressing objects: 100% (14/14), done.
Writing objects: 100% (18/18), 1.85 KiB | 316.00 KiB/s, done.
Total 18 (delta 5), reused 10 (delta 2), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (5/5), done.
remote:
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/LeonardoMengozzi/Lab6ex61Punto5/pull/new/master
remote:
To https://github.com/LeonardoMengozzi/Lab6ex61Punto5.git
 * [new branch]      master -> master


9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
leo05@MSI MINGW64 ~/Desktop/es61 (master)
$ git branch --set-upstream-to=myRemote/master
branch 'master' set up to track 'myRemote/master'.