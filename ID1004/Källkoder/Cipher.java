
/**
 * Abstrakt superklass f�r olika chiffer.
 * @author fki@kth.se
 */
public abstract class Cipher {

  /**
   * H�ller krypteringsnyckeln.
   */
  protected final long key;

  /**
   * Konstruktor med nyckel. Subklassers konstruktorer b�r anropa
   * denna konstruktor f�r att installera nyckeln.
   * @param key Nyckeln som chiffret anv�nder.
   */
  public Cipher(long key) {
    this.key = key;
  }

  /**
   * Krypterar ett tecken och returnerar det.
   * @param plainChar Ett tecken i klartext, endast A-Z
   * @return Det krypterade tecknet, endast A-Z
   */
  public abstract char encryptChar(char plainChar);

  /**
   * Dekrypterar ett tecken och returnerar det.
   * @param cryptoChar Ett tecken i kryptotext, endast A-Z
   * @return Tecknet i klartest, A-Z
   */
  public abstract char decryptChar(char cryptoChar);

}
