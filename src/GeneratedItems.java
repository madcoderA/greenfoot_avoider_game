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
      return new Star();
    }

    @Override
    int getX() {
      return 5 + Greenfoot.getRandomNumber(worldWidth - 10);
    }

    @Override
    int getY() {
      return -2;
    }
  },
  ENEMY(20) {
    @Override
    Actor getItem() {
      return new Enemy();
    }

    @Override
    int getX() {
      return Greenfoot.getRandomNumber(worldWidth - 20) + 10;
    }

    @Override
    int getY() {
      return -30;
    }

    @Override
    void nextLevel() {
      spawnRate += 4;
    }
  },
  CUPCAKE(10) {
    @Override
    Actor getItem() {
      return new Cupcake(getTargetX(), getTargetY(), 100);
    }

    @Override
    void nextLevel() {
      spawnRate += 2;
    }
  },
  CLOVER(10) {
    @Override
    Actor getItem() {
      return new Clover(getTargetX(), getTargetY(), 100);
    }

    @Override
    void nextLevel() {
      spawnRate += 2;
    }
  },
  ROCK(1) {
    @Override
    Actor getItem() {
      return new Rock(getTargetX(), getTargetY(), 100);
    }

    @Override
    void nextLevel() {
      spawnRate += 1;
    }
  };

  public static int worldWidth = 900;
  public static int worldHeight = 600;

  int spawnRate;

  GeneratedItems(int spawnRate) {
    this.spawnRate = spawnRate;
  }

  public boolean isGenerate() {
    return Greenfoot.getRandomNumber(1000) < spawnRate;
  }

  int getX() {
    return Greenfoot.getRandomNumber(100) < 50 ? worldWidth + 20 : -20;
  }

  int getY() {
    return Greenfoot.getRandomNumber(worldHeight / 2) + 30;
  }

  void nextLevel() {
  }

  abstract Actor getItem();

  private static int getTargetX() {
    return Greenfoot.getRandomNumber(worldWidth - 80) + 40;
  }

  private static int getTargetY() {
    return Greenfoot.getRandomNumber(worldHeight / 2) + 20;
  }
}