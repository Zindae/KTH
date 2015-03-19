
public class CesarCipher extends Cipher {

  public CesarCipher(long key) {
    super(key);
  }

  public char encryptChar(char plainChar) {
    int plainOrder = plainChar - 'A';
    int cryptoOrder = (plainOrder + (int) key) % 26;
    return (char) ('A' + cryptoOrder);
  }

  public char decryptChar(char cryptoChar) {
    int cryptoOrder = cryptoChar - 'A';
    int plainOrder = (cryptoOrder + 26 - (int) key) % 26;
    return (char) ('A' + plainOrder);
  }

}
