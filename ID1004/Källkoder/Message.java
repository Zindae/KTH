
public class Message {

  public String encryptString(Cipher cipher, String str) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
      sb.append(cipher.encryptChar(str.charAt(i)));
    }
    return sb.toString();
  }

  public String decryptString (Cipher cipher, String str) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
      sb.append(cipher.decryptChar(str.charAt(i)));
    }
    return sb.toString();
  }

  public String formatCrypto (String str) {
    StringBuffer sb = new StringBuffer ();
    int col = 1;
    for (int i = 0; i < str.length(); i++) {
      if ((i % 5) == 0) {
	sb.append(' ');
      }
      if ((i % 25) == 0) {
	sb.append('\n');
      }
      sb.append(str.charAt(i));
    }
    sb.append('\n');
    return sb.toString();
  }
}
