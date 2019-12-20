package com.allaber.dota2db.Item;

import java.util.List;

public class Hero {
    String name;
    String Image;
    String Attribute;
    String AttackType;
    String Complexity;

    double StandardStrange;
    double StandardAgility;
    double StandardIntelect;

    double StrangeGainsPerLevel;
    double AgilityGainsPerLevel;
    double IntelectGainsPerLevel;

    double StandardHealthRegen;
    double StandardManaRegen;

    double StandardSpeed;

    double StandardAttackSpeed;
    double StandardDamage;
    double StandardArmor;
    double StandardMagicResist;

    String TurnRate;
    String VisionRange;
    String AttactRange;
    String ProjectileSpeed;

    String stringLeftLvl25;
    String stringRightLvl25;

    String stringLeftLvl20;
    String stringRightLvl20;

    String stringLeftLvl15;
    String stringRightLvl15;

    String stringLeftLvl10;
    String stringRightLvl10;

    int textQuickDamag;
    int textRolesSupport;
    int textRolesForest;
    int textRolesFarm;
    int textRolesEscape;
    int textRolesSiege;
    int textRolesControl;
    int textRolesPersistence;
    int textRolesInitiation;
    String textBiographyText;

    String textBuyItemsText;
    int colEarlyGame;
    int colMidGame;
    int colLateGame;
    int colDependsOnSituation;
    int colPopularItems;
    int ColAbilitys;
    List<Ability> abilities;


    public int getColDependsOnSituation() {
        return colDependsOnSituation;
    }

    public void setColDependsOnSituation(int colDependsOnSituation) {
        this.colDependsOnSituation = colDependsOnSituation;
    }

    public int getColEarlyGame() {
        return colEarlyGame;
    }

    public void setColEarlyGame(int colEarlyGame) {
        this.colEarlyGame = colEarlyGame;
    }

    public int getColMidGame() {
        return colMidGame;
    }

    public void setColMidGame(int colMidGame) {
        this.colMidGame = colMidGame;
    }

    public int getColLateGame() {
        return colLateGame;
    }

    public void setColLateGame(int colLateGame) {
        this.colLateGame = colLateGame;
    }

    public int getColPopularItems() {
        return colPopularItems;
    }

    public void setColPopularItems(int colPopularItems) {
        this.colPopularItems = colPopularItems;
    }


    public String getTextBuyItemsText() {
        return textBuyItemsText;
    }

    public void setTextBuyItemsText(String textBuyItemsText) {
        this.textBuyItemsText = textBuyItemsText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAttribute() {
        return Attribute;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }

    public String getAttackType() {
        return AttackType;
    }

    public void setAttackType(String attackType) {
        AttackType = attackType;
    }

    public String getComplexity() {
        return Complexity;
    }

    public void setComplexity(String complexity) {
        Complexity = complexity;
    }

    public double getStandardStrange() {
        return StandardStrange;
    }

    public void setStandardStrange(double standardStrange) {
        StandardStrange = standardStrange;
    }

    public double getStandardAgility() {
        return StandardAgility;
    }

    public void setStandardAgility(double standardAgility) {
        StandardAgility = standardAgility;
    }

    public double getStandardIntelect() {
        return StandardIntelect;
    }

    public void setStandardIntelect(double standardIntelect) {
        StandardIntelect = standardIntelect;
    }

    public double getStrangeGainsPerLevel() {
        return StrangeGainsPerLevel;
    }

    public void setStrangeGainsPerLevel(double strangeGainsPerLevel) {
        StrangeGainsPerLevel = strangeGainsPerLevel;
    }

    public double getAgilityGainsPerLevel() {
        return AgilityGainsPerLevel;
    }

    public void setAgilityGainsPerLevel(double agilityGainsPerLevel) {
        AgilityGainsPerLevel = agilityGainsPerLevel;
    }

    public double getIntelectGainsPerLevel() {
        return IntelectGainsPerLevel;
    }

    public void setIntelectGainsPerLevel(double intelectGainsPerLevel) {
        IntelectGainsPerLevel = intelectGainsPerLevel;
    }

    public double getStandardHealthRegen() {
        return StandardHealthRegen;
    }

    public void setStandardHealthRegen(double standardHealthRegen) {
        StandardHealthRegen = standardHealthRegen;
    }

    public double getStandardManaRegen() {
        return StandardManaRegen;
    }

    public void setStandardManaRegen(double standardManaRegen) {
        StandardManaRegen = standardManaRegen;
    }

    public double getStandardSpeed() {
        return StandardSpeed;
    }

    public void setStandardSpeed(double standardSpeed) {
        StandardSpeed = standardSpeed;
    }

    public double getStandardAttackSpeed() {
        return StandardAttackSpeed;
    }

    public void setStandardAttackSpeed(double standardAttackSpeed) {
        StandardAttackSpeed = standardAttackSpeed;
    }

    public double getStandardDamage() {
        return StandardDamage;
    }

    public void setStandardDamage(double standardDamage) {
        StandardDamage = standardDamage;
    }

    public double getStandardArmor() {
        return StandardArmor;
    }

    public void setStandardArmor(double standardArmor) {
        StandardArmor = standardArmor;
    }

    public double getStandardMagicResist() {
        return StandardMagicResist;
    }

    public void setStandardMagicResist(double standardMagicResist) {
        StandardMagicResist = standardMagicResist;
    }

    public String getTurnRate() {
        return TurnRate;
    }

    public void setTurnRate(String turnRate) {
        TurnRate = turnRate;
    }

    public String getVisionRange() {
        return VisionRange;
    }

    public void setVisionRange(String visionRange) {
        VisionRange = visionRange;
    }

    public String getAttactRange() {
        return AttactRange;
    }

    public void setAttactRange(String attactRange) {
        AttactRange = attactRange;
    }

    public String getProjectileSpeed() {
        return ProjectileSpeed;
    }

    public void setProjectileSpeed(String projectileSpeed) {
        ProjectileSpeed = projectileSpeed;
    }

    public String getStringLeftLvl25() {
        return stringLeftLvl25;
    }

    public void setStringLeftLvl25(String stringLeftLvl25) {
        this.stringLeftLvl25 = stringLeftLvl25;
    }

    public String getStringRightLvl25() {
        return stringRightLvl25;
    }

    public void setStringRightLvl25(String stringRightLvl25) {
        this.stringRightLvl25 = stringRightLvl25;
    }

    public String getStringLeftLvl20() {
        return stringLeftLvl20;
    }

    public void setStringLeftLvl20(String stringLeftLvl20) {
        this.stringLeftLvl20 = stringLeftLvl20;
    }

    public String getStringRightLvl20() {
        return stringRightLvl20;
    }

    public void setStringRightLvl20(String stringRightLvl20) {
        this.stringRightLvl20 = stringRightLvl20;
    }

    public String getStringLeftLvl15() {
        return stringLeftLvl15;
    }

    public void setStringLeftLvl15(String stringLeftLvl15) {
        this.stringLeftLvl15 = stringLeftLvl15;
    }

    public String getStringRightLvl15() {
        return stringRightLvl15;
    }

    public void setStringRightLvl15(String stringRightLvl15) {
        this.stringRightLvl15 = stringRightLvl15;
    }

    public String getStringLeftLvl10() {
        return stringLeftLvl10;
    }

    public void setStringLeftLvl10(String stringLeftLvl10) {
        this.stringLeftLvl10 = stringLeftLvl10;
    }

    public String getStringRightLvl10() {
        return stringRightLvl10;
    }

    public void setStringRightLvl10(String stringRightLvl10) {
        this.stringRightLvl10 = stringRightLvl10;
    }

    public int getTextQuickDamag() {
        return textQuickDamag;
    }

    public void setTextQuickDamag(int textQuickDamag) {
        this.textQuickDamag = textQuickDamag;
    }

    public int getTextRolesSupport() {
        return textRolesSupport;
    }

    public void setTextRolesSupport(int textRolesSupport) {
        this.textRolesSupport = textRolesSupport;
    }

    public int getTextRolesForest() {
        return textRolesForest;
    }

    public void setTextRolesForest(int textRolesForest) {
        this.textRolesForest = textRolesForest;
    }

    public int getTextRolesFarm() {
        return textRolesFarm;
    }

    public void setTextRolesFarm(int textRolesFarm) {
        this.textRolesFarm = textRolesFarm;
    }

    public int getTextRolesEscape() {
        return textRolesEscape;
    }

    public void setTextRolesEscape(int textRolesEscape) {
        this.textRolesEscape = textRolesEscape;
    }

    public int getTextRolesSiege() {
        return textRolesSiege;
    }

    public void setTextRolesSiege(int textRolesSiege) {
        this.textRolesSiege = textRolesSiege;
    }

    public int getTextRolesControl() {
        return textRolesControl;
    }

    public void setTextRolesControl(int textRolesControl) {
        this.textRolesControl = textRolesControl;
    }

    public int getTextRolesPersistence() {
        return textRolesPersistence;
    }

    public void setTextRolesPersistence(int textRolesPersistence) {
        this.textRolesPersistence = textRolesPersistence;
    }

    public int getTextRolesInitiation() {
        return textRolesInitiation;
    }

    public void setTextRolesInitiation(int textRolesInitiation) {
        this.textRolesInitiation = textRolesInitiation;
    }

    public String getTextBiographyText() {
        return textBiographyText;
    }

    public void setTextBiographyText(String textBiographyText) {
        this.textBiographyText = textBiographyText;
    }

    public int getColAbilitys() {
        return ColAbilitys;
    }

    public void setColAbilitys(int colAbilitys) {
        ColAbilitys = colAbilitys;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

}
