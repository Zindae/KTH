public class TestCipher {

    public static void testCipher(Cipher enCipher,
				  Cipher deCipher,
				  String inputText)
    {

	Message msg = new Message();

	String cryptoText = msg.encryptString(enCipher, inputText);

	String plainText = msg.decryptString(deCipher, cryptoText);

	System.out.println("Input:      " + plainText);

	System.out.println("Cryptotext: " + cryptoText);

	System.out.println(msg.formatCrypto(cryptoText));
    
	System.out.println("Plaintext:  " + plainText);

	System.out.print("Encryption and decryption ");
	if (inputText.equals(plainText)) {
	    System.out.println("successful");
	}
	else {
	    System.out.println("does not match");
	}
	System.out.println();
    }

    public static void main(String [] args) {
	long key = Long.parseLong(args[0]);
	String inputText = args[1].toUpperCase();

	System.out.println("Testing CesarCipher");
	testCipher(new CesarCipher(key),
		   new CesarCipher(key),
		   inputText);

	System.out.println("Testing RandomCipher");
	testCipher(new RandomCipher(key),
		   new RandomCipher(key),
		   inputText);
    }
}