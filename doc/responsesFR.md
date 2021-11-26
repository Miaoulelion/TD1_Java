## Exercice 1

**1. Create a new project called JavaAvance and add a new package called fr.dauphine.javaavance.td1.**

**2. What happens when you type sysout and press Ctrl + space in a main method ?**
=> On voit les méthodes possibles ressemblant au texte “sysout”. Si on appuie sur “Enter”, cela colle System.out.println();

**3. Same question with toStr then Ctrl + space inside a class ?**
=>  On voit les méthodes possibles ressemblant au texte “toStr”. Si on appuie sur “Enter”, la structure de la méthode toString() est créée :
@Override
public String toString() {
	TODO();
	return super.toString();
}

**4. Same question with main then Ctrl + space inside a class ?**
=> On voit les méthodes possibles ressemblant au texte “main”. Si on appuie sur “Enter”, la méthode main est créée : 
public static void main(String[] args) {
	
}

**5. Create a new int field called foo inside the class. What happens if you type Ctrl + space inside the class, what if you now type set then press Ctrl + space ?**
=> On voit les méthodes possibles à implémenter. On voit notamment que Eclipse nous propose de créer les méthodes getFoo() et setFoo(int). 
On voit les différentes possibilités à faire ressemblant au texte “set”. On voit donc qu’il nous propose de créer la méthode setFoo(int).

**6. Select the class name. Que What happens if you type Alt+Shift+R ? Samequestion with the int field foo.**
=> Cela permet de refactoriser le nom de la classe. Plus simplement, cela permet de changer le nom de la classe en mettant à jour toutes les références de cette classe. On peut également refactoriser le champ foo qui changera toutes les références de cette variable pour ne pas avoir d’erreur.

**7. (at home) It is sometime useful to check the source code from the JDK. Down-load the file called src.zip from Oracle's website. (on CRIO desktop stations it is already installed in /usr/local/jdk*/src.zip) and attach it in Window - Preferences { Installed JREs - Edit - rt.jar - Source Attachment. Now declare a String variable and clic on String with Ctrl key pressed. What happens ?**
=> Cela nous mène à la classe String où on peut voir toutes les méthodes associés etc...






## Exercice 2 : 



**1. Why does it work ?**
Create a new class Point with two private fields x and y. Add a method with
the following code :
Point p=new Point();
System.out.println(p.x+" "+p.y)

=> Cela fonctionne car les champs privés d’une classe sont accessibles à l’intérieur de celle-ci. Ainsi, on peut créer une méthode utilisant x et y à l’intérieur de l’objet Point.

**2. Create a class TestPoint with a main and the same code as before. What happens ? How can we fix it ?**

=> Deux exceptions sont levées (“The field Point.x is not visible, The field Point.y is not visible”). Pour corriger ce problème, il faut créer des méthodes publiques (getter) qui permettront de renvoyer les valeurs de x et de y.

	public int getX() {
		return this.x;
	}

**3. Why do you need to set all fields visibility to private ?**

=> L’encapsulation est importante pour conserver l’intégrité d’un objet. Si les champs d’un objet sont publics, tout le monde peut y accéder et changer les valeurs des champs d’une manière potentiellement inappropriée. 
 
**4. What is an accessor ? Do we have to do it here ?**

=> Un “accessor” est une méthode qui permet d’accéder à une valeur de champ (cf. réponse à la question 2. avec notre “getter”). Nous en avons nécessairement besoin ici si l’on souhaite accéder aux valeurs de coordonnées (x,y) en dehors de l’objet Point.

**5. Create a constructor with two arguments (called px and py). What is the problem ?**

=> Lorsqu’aucun constructeur n’est défini, un constructeur par défaut est appelé. En créant un constructeur avec deux arguments, cela “remplace” le constructeur par défaut. Lors de la compilation une exception “The constructor Point() is undefined” est levée car le constructeur sans argument n’est plus défini.

**6. Modify the parameters of the constructor to call them x and y. What happens ?**

=> Les erreurs précédentes restent inchangées. Néanmoins, aucune nouvelle erreur n’apparaît, les paramètres x et y ne sont pas confondus avec this.x et this.y.

**7. We would like to keep track of the number of Points that have been created so far. How to proceed ?**

Un champ static de type int peut être ajouté à la classe Point. Ce champ s'incrémente à chaque instanciation de la classe. Un accessor doit être ajouté (getcpt()) pour accéder à la valeur du compteur en dehors de la classe.

public class Point {
	private int x;
	private int y;
	private static int cpt=0;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		++cpt;
	}
	
	public Point (Point p2) {
		this.x=p2.getX();
		this.y=p2.getY();
		++cpt;
	}
}

**8. Write a second contructor with a single Point p2 argument that copies the coordinates from p2 into the current Point. How does the compiler know which constructor to call ?**

=> Il appelle le constructeur correspondant aux types et aux nombre d’arguments.

**9. Update the class so that a call to System.out.println(point); will print the point coordinates as follows : (x, y).**

=> Nous avons implémenté la méthode toString :

	@Override
	public String toString() {
		return this.x + " " + this.y;
	}


## Exercice 3 : 

**1. What does this code print ? Why ?**

=> La première écriture booléenne est “True” car les deux variables ont la même référence mémoire, tandis que la seconde renvoie false car bien que les deux objets p1 et p3 ont des champs égaux, ils n’ont pas le même espace mémoire. 

**2. 2. Write a method isSameAs(Point) that will return true if the two points have the same coordinates.**

	public boolean isSameAs(Point p) {
		if(p.getX()==this.x && p.getY()==this.y) {
			return true;
		}
		return false;
	}

**3. What is the problem with this code ? Read the documentation of indexOf and check which method is called. Modify the Point class to fix this problem.**

=> Le problème est qu’on va faire list.indexOf(p3) alors que ce point n’est pas dans la liste. De plus, on l’appel list.indexOf(p2) va retourner true car p1 et p2 sont le “même” objet (ils partagent le même espace mémoire). La méthode equals() est appelée dans la méthode indexOf().
Ainsi, pour résoudre ce problème, il faut implémenter les méthodes equals() et hashcode() pour la classe Point, ce qui permet à la méthode indexOf() de List d’identifier les instances de Point “égales”.

##Exercice 4 : 

**Write a method add that can be used to add a new point to the line. What happens if we add more points that the maximum capacity of the array ? What to do about it ?**

=> Lorsqu’on dépasse la capacité du tableau, une exception est levée : “java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2”. Nous pourrions empêcher l’ajout d’une Point supplémentaire dans la méthode add() lorsque this.pointCapacity est égal à this.array.length, ou encore lever une exception.

**5. What happens if null is given instead of an actual Point object ? What if you do add(null) before ? Read about Objects.requireNonNull(o).**

=> Si on donne “null” au lieu d’un objet “Point”, rien ne se passe, la méthode add() fonctionne et la référence “null” est ajoutée au tableau de Point. L’utilisation de Objects.requireNonNull(o) permet de tester l’objet donné en paramètre et de lever une exception lorsque l’objet est null. Ainsi, lorsque null est donné en paramètre de la méthode add(), l’exception java.lang.NullPointerException est levée.

**6. Update the class and use a LinkedList instead of an array (and remove the maximum capacity limit). How to update pointCapacity, nbPoints and contains ?**

=> En utilisant une LinkedList et en retirant la limite de capacité, la méthode pointCapacity() qui renvoyait la capacité maximale de Point contenus dans l’objet Polyline n’a plus d’utilité et doit être supprimée. Concernant la méthode contains(), on peut la réimplémenter en utilisant la méthode contains() de notre LinkedList :

	public boolean contains(Point p1) {
		return this.listPoints.contains(p1);
	}
Enfin, pour la méthode nbPoints(), nous pouvons utiliser la méthode size() de LinkedList tel que :

	public int nbPoints() {
		return this.listPoints.size();
	}
Cela renverra le nombre de Point contenu dans la liste de Polyline.

## Exercice 5 :

**1. Add a method translate(dx, dy) in Point. What are the different options to write this method ?**

On peut créer une méthode void qui somme les valeurs des coordonnées de notre Point avec ces deltas (dx et dy) comme suit :

	public void translate(int dx, int dy) {
		this.x+=dx;
		this.y+=dy;
	}


**2. A circle can be represented with a center and a radius. Write a new Circle class. Don’t forget the constructor.**

**3. Write the toString method.**

	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + ", area =" + this.area() + " ]";
	}


**4. Write the translate(dx, dy) that translate the circle**

	public void translate(int dx, int dy) {
		this.center.translate(dx, dy);
	}

**5. What is the problem with this code ? How to avoid it ?**
Point p=new Point(1,2); 
Circle c=new Circle(p,1); 
Circle c2=new Circle(p,2); 
c2.translate(1,1); 
System.out.println(c+" "+c2);

=> Le problème avec ce code est que les deux cercles ont le même Point pour centre. Ainsi, lors de l’utilisation de la méthode translate() par le Cercle c2, cela entraîne également la translation de c1.
Pour résoudre ce problème, on pourrait créer une copie du Point passé en paramètre lors de la création du cercle. Ainsi, les centres de c1 et c2 auraient des adresses mémoires différentes.

public Circle(Point center, int radius) {
	if(radius<=0) {
		throw new IllegalArgumentException("Circle() : radius can't be negative.");
	}
	Objects.requireNonNull(center);
	this.center=new Point(center.getX(), center.getY());
	this.radius=radius;
}

**6. What would be the problem with a getCenter() method that would return the center ? To find out, consider the following code ?**
Circle c=new Circle(new Point(1,2), 1); 
c.getCenter().translate(1,1); 
System.out.println(c);

=> Résultat du Syso :
Circle [center=2 3, radius=1]

=> La méthode getCenter() renvoie le Point qui définit le centre du cercle (Circle) qui possède lui même la méthode translate(). Donc, il serait possible de modifier les coordonnées du centre du cercle de manière inappropriée, sans passer par la méthode translate() propre au cercle. Un moyen d’éviter ce problème est d’envoyer une copie, un Point qui a les mêmes coordonnées que celles du centre.

Résultat du Syso après modification : Circle [center=1 2, radius=1]

**7. Add area() and update toString() to print the area as well.**

	public double area() {
		return 2*Math.PI*this.radius;
	}

    @Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + ", area =" + this.area() + " ]";
	}


**8. Add a contains(Point p) method to return true if p is inside the circle (hint :use Pythagoras theorem).**

	public boolean contains(Point p) {
		double distance = Math.sqrt((Math.pow(p.getX()-center.getX(), 2.0)+Math.pow(p.getY()-center.getY(), 2.0)));
		if(distance>this.radius) { //radius is automatically casted into double.
			return false;
		}
		return true;
	}


**9. Add contains(Point p, Circle...circles) that will return true of the point is inside one of the circles ? What other change should you do about the method declaration ? Why ?**

=> Il serait préférable de déclarer la méthode static pour qu’elle puisse être utilisée sans instancier inutilement d’objets Circle.

	public static boolean contains(Point p, Circle...circles) {
		for(Circle c : circles) {
			if(c.contains(p)){
				return true;
			}
		}
		return false;
	}

## Exercice 6 : 

**1. Should you use inheritance ?**

=> Nous pourrions utiliser l’héritage pour créer la classe Ring en la faisant hériter de Circle. En effet, un Ring a lui aussi un rayon (même deux, un pour chaque cercle le constituant), un centre, une aire et peut également se translater. Avec l’héritage, notre constructeur créerait un Circle grâce au super constructeur, et un second Circle qui serait contenu dans la nouvelle classe (cf. classe RingInheritance). 

public RingInheritence(Point center, int inRadius, int outRadius) {
	super(center, inRadius);
	if((inRadius<=0||outRadius<=0)||
			inRadius>=outRadius) {
		throw new IllegalArgumentException("RingInheritence() : inRadius = "+inRadius + " outRadius="+outRadius);
	}
	this.outCircle= new Circle(center, outRadius);
}


L’avantage de l’héritage est de factoriser le code. Toutefois, cette manière de procéder nous fera implémenter une nouvelle version des méthodes toString() et area() car elles ne sont pas exactement les mêmes pour un anneau et pour un cercle.

Autrement, nous pourrions utiliser la classe Circle en instanciant deux cercles au sein de la classe Ring (cf. classe Ring), et ce, sans utiliser d’héritage.

**2. Write a new class Ring, with a center and two radius (beware, the inner radius must always be smaller than the outer one.**


**3. Write equals.**

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((outCircle == null) ? 0 : outCircle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RingInheritence other = (RingInheritence) obj;
		if (outCircle == null) {
			if (other.outCircle != null)
				return false;
		} else if (!outCircle.equals(other.outCircle))
			return false;
		return true;
	}

**4. On veut afficher un anneau avec son centre, son rayon et son rayon interne. Quel est le problème si on fait System.out.println(ring); sans code supplémentaire ? Le corriger.**

=> La méthode toString() doit être implémentée de manière à faire apparaître ces éléments, sans quoi l’objet Ring utilisera la méthode toString() héritée d’Object ou de Circle, si on choisit d’utiliser l’héritage. Ainsi elle renverra soit le nom de la classe suivi de la valeur de hachage de l’objet, soit son rayon en omettant le rayon interne/externe.
