/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author francisco
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    private CardDealer(){}
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
        
        shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0,
                                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco "
                            + "visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                            new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                            new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad "
                            + "del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, NumericBadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                            new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                            new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de la rosa", 13, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize, 0));
        
        badConsequence = new DeathBadConsequence("Estos unusedMonsters resultan bastante superficiales y "
                            + "te aburren mortalmente. Estás muerto");
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                            new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize, 0));
        
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto");
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize, 0));
        
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto");
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 "
                            + "niveles y un tesoro 2 manos visible", 2,
                            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                            new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                            new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize, 0));
        
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros "
                                                    + "visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                            new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize, 0));
        
        badConsequence = new SpecificBadConsequence("Pierdes una mano visible", 0,
                                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronuciable", 10, badConsequence, prize, -2));

        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles. Jajaja", 0, NumericBadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize, 2));

        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres");
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));

        badConsequence = new NumericBadConsequence("El gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente político", 8, badConsequence, prize, -2));

        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0,
                                                    new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
                                                    new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

        badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));

        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
        shuffleMonsters();
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Agaricus", 1));
        unusedCultists.add(new Cultist("Boletus", 2));
        unusedCultists.add(new Cultist("Daldinia", 1));
        unusedCultists.add(new Cultist("Bolbitius", 2));
        unusedCultists.add(new Cultist("Calvatia", 1));
        unusedCultists.add(new Cultist("Dermoloma", 1));
        
        shuffleCultists();
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    public Treasure nextTreasure(){
        Treasure nTre;
        if (!unusedTreasures.isEmpty()){
            nTre = unusedTreasures.get(0);
            unusedTreasures.remove(0);
        }
        else{
            unusedTreasures = usedTreasures;
            shuffleTreasures();
            usedTreasures = new ArrayList();
            nTre = unusedTreasures.get(0);
        }
        
        return nTre;
    }
    
    public Monster nextMonster(){
        Monster nMons;
        if (!unusedMonsters.isEmpty()){
            nMons = unusedMonsters.get(0);
            unusedMonsters.remove(0);
        }
        else{
            unusedMonsters = usedMonsters;
            shuffleMonsters();
            usedMonsters = new ArrayList();
            nMons = unusedMonsters.get(0);
        }
        
        return nMons;
    }
    
    public Cultist nextCultist(){
        Cultist nCult = unusedCultists.get(0);
        unusedCultists.remove(0);
        return nCult;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
    }
}
