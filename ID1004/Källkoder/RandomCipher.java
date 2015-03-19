import java.util.Random;

public class RandomCipher extends Cipher {

  private Random rnd;

  public RandomCipher(long key) {
    super(key);
    // Initiera slumptalsgeneratorn med nyckeln.
    rnd = new Random(key);
  }

    // Dra nästa slumptal 0-25 som nyckel.
  public char encryptChar(char plainChar) {
    int nextKey = rnd.nextInt(26);
    int plainOrder = plainChar - 'A';
    int cryptoOrder = (plainOrder + nextKey) % 26;
    return (char) ('A' + cryptoOrder);
  }

    // Dra nästa slumptal 0-25 som nyckel.
  public char decryptChar(char cryptoChar) {
    int nextKey = rnd.nextInt(26);
    int cryptoOrder = cryptoChar - 'A';
    int plainOrder = (cryptoOrder + 26 - nextKey) % 26;
    return (char) ('A' + plainOrder);
  }

}
