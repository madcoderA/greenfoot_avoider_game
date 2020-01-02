import greenfoot.*;

/**
 * GeneratedItems
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-02
 */
enum GeneratedItems {
  STAR(350) {
    @Override
    Actor getItem() {
      final Star star = new Star();
      final GreenfootImage image = star.getImage();

      if (Greenfoot.getRandomNumber(1000) < 300) {
        // this is a close bright star
        star.setSpeed(3);
        image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
        image.scale(4, 4);
      } else {
        // this is a further dim star
        star.setSpeed(2);
        image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
        image.scale(2, 2);
      }

      star.setImage(image);
      return star;
    }
  },
  ENEMY(20) {
    @Override
    Actor getItem() {
      return new Enemy();
    }
  },
  CUPCAKE(10) {
    @Override
    Actor getItem() {
      return new Cupcake(getTargetX(), getTargetY(), 100);
    }
  },
  CLOVER(10) {
    @Override
    Actor getItem() {
      return new Clover(getTargetX(), getTargetY(), 100);
    }
  },
  ROCK(1) {
    @Override
    Actor getItem() {
      return new Rock(getTargetX(), getTargetY(), 100);
    }
  };

  public static int worldWidth = 900;
  public static int worldHeight = 600;

  int spawnRate;

  GeneratedItems(int spawnRate) {
    this.spawnRate = spawnRate;
  }

  int getX() {
    return Greenfoot.getRandomNumber(worldWidth - 20) + 10;
  }

  int getY() {
    return -30;
  }

  public boolean isGenerate() {
    return Greenfoot.getRandomNumber(1000) < spawnRate;
  }

  abstract Actor getItem();

  private static int getTargetX() {
    return Greenfoot.getRandomNumber(worldWidth - 80) + 40;
  }

  private static int getTargetY() {
    return Greenfoot.getRandomNumber(worldHeight / 2) + 20;
  }
}