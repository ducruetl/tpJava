import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {
        String nom;
        int naissance, pointure;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("BONJOUR !");
        System.out.println();
        System.out.print("Donnez votre nom : ");
        nom = lecteur.nextLine();
        System.out.print("Donnez votre année de naissance : ");
        naissance = lecteur.nextInt();
        lecteur.nextLine();
        System.out.print("Donnez votre pointure : ");
        pointure = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println();

        pointure = pointure * 5;
        System.out.println("(1) On multiplie votre pointure par 5 : " + pointure);
        pointure = pointure + 50;
        System.out.println("(2) 0n ajoute 50 : " + pointure);
        pointure = pointure * 20;
        System.out.println("(3) On multiplie par 20 : " + pointure);
        pointure = pointure + 1023;
        System.out.println("(4) 0n ajoute 1023 : " + pointure);
        pointure = pointure - naissance;
        System.out.println("(5) On soustrait votre année de naissance :");

        System.out.println("----------------");
        System.out.println("RESULTAT = " + pointure);
        System.out.println("----------------");
        System.out.println("Les 2 premiers chiffres sont : " + pointure / 100);
        System.out.println("> C'est votre pointure !!!");
        System.out.println();
        System.out.println("Les 2 derniers chiffres sont : " + pointure % 100);
        System.out.println("> C'est l'âge que vous atteignez cette année !!!");
        System.out.println();
        System.out.println("AU REVOIR " + nom);
    }
}
