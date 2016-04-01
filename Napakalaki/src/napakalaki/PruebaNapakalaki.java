/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author francisco
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0,
                                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco "
                            + "visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                            new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                            new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad "
                            + "del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 10, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                            new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                            new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de la rosa", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y "
                            + "te aburren mortalmente. Estás muerto");
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                            new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto");
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto");
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 "
                            + "niveles y un tesoro 2 manos visible", 2,
                            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                            new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
                            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                            new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros "
                + "visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El lenguas", 20, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos", 0,
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                            new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        System.out.println("Más de nivel 10 de combate:\n\n");
        more10CombatLevel(monstruos);
        System.out.println("Solo pérdida de niveles:\n\n");
        justLevelLose(monstruos);
        System.out.println("Más de 1 nivel de buen rollo:\n\n");
        more1LevelPrize(monstruos);
        System.out.println("Pérdida de algún tipo de tesoros:\n\n");
        specificTreasureLose(monstruos);
    }
    
    public static void more10CombatLevel(ArrayList<Monster> monsters){
        for (Monster element : monsters){
            if (element.getCombatLevel() > 10){
                System.out.println(element.toString());
            }
        }
    }
    
    public static void justLevelLose(ArrayList<Monster> monsters){
        for (Monster element : monsters){
            if ((element.getBadConsequence().getVisible() == 0) && (element.getBadConsequence().getHidden() == 0)){
                System.out.println(element.toString());
            }
        }
    }
    
    public static void more1LevelPrize(ArrayList<Monster> monsters){
        for (Monster element : monsters){
            if (element.getPrize().getLevel() > 1){
                System.out.println(element.toString());
            }
        }
    }
    
    public static void specificTreasureLose(ArrayList<Monster> monsters){
        for (Monster element : monsters){
            if (element.getBadConsequence().getVisible() < 0){
                System.out.println(element.toString());
            }
        }
    }
    
}
