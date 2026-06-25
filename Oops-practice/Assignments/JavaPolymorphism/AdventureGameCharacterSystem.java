
abstract class GameCharacter {
  String characterName;

  public GameCharacter(String characterName) {
    this.characterName = characterName;
  }

  abstract void performAttack();
}

class Warrior extends GameCharacter {
  public Warrior(String characterName) {
    super(characterName);
  }

  @Override
  void performAttack() {
    System.out.println(characterName + " (Warrior) attacks with a sword!");
  }
}

class Mage extends GameCharacter {
  public Mage(String characterName) {
    super(characterName);
  }

  @Override
  void performAttack() {
    System.out.println(characterName + " (Mage) casts a spell!");
  }
}

class Archer extends GameCharacter {
  public Archer(String characterName) {
    super(characterName);
  }

  @Override
  void performAttack() {
    System.out.println(characterName + " (Archer) shoots an arrow!");
  }
}

public class AdventureGameCharacterSystem {

  public static void startBattle(GameCharacter[] characters) {
    int warriorCount = 0, mageCount = 0, archerCount = 0;

    for (GameCharacter character : characters) {
      character.performAttack();

      if (character instanceof Warrior) {
        warriorCount++;
      } else if (character instanceof Mage) {
        mageCount++;
      } else if (character instanceof Archer) {
        archerCount++;
      }
    }

    System.out.println("\nBattle Summary:");
    System.out.println("Warriors: " + warriorCount);
    System.out.println("Mages: " + mageCount);
    System.out.println("Archers: " + archerCount);
  }

  public static void main(String[] args) {
    GameCharacter[] characters = {
        new Warrior("Conan"),
        new Mage("Gandalf"),
        new Archer("Legolas"),
        new Warrior("Arthur"),
        new Mage("Merlin")
    };

    startBattle(characters);
  }
}
