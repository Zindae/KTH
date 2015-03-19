/**
 * This class implements a general implementation of an Infinite Impulse Response
 * (IIR) filter, in a Direct Form II computation.
 * @author fki
 *
 */
public class Filter {
	
	// Filter coefficients, i.e. weights.
	protected float a0, a1, a2, b0, b1, b2;
	
	// The two delay stages of the IIR filter.
	protected float [] z = new float[2];
	
	/**
	 * This method will process an input buffer of sampled signal, applying
	 * the filter defined by the coefficients using a Direct Form II computation.
	 * @param inn The input samples (read from)
	 * @param out The output samples (written to)
	 * @return The out array
	 */
	public float [] process (float [] inn, float [] out) {
		for (int i = 0; i < inn.length; i++) {
			float x = inn[i];
			float temp = x - (a1 * z[0]) - (a2 * z[1]);
			out[i] = (temp * b0) + (b1 * z[0]) + (b2 * z[1]);
			z[1] = z[0];
			z[0] = temp;
		}
		return out;
	}
	
	// Computation constants.
	protected double a;
	protected double omega;
	protected double sin;
	protected double cos;
	protected double alpha;
	protected double beta;
	
	// Computes a set of constants that are useful in computation of a particular filter.
	protected void setConstants(double sampleRate, double fqHz, double q, double gaindB) {
		a = Math.pow(10d, (gaindB / 40d));
		omega = (2d * Math.PI * fqHz) / sampleRate;
		sin = Math.sin(omega);
		cos = Math.cos(omega);
		alpha = sin / (2d * q);
		beta = Math.sqrt(a) / q;
	}
	
	/**
	 * This method is expected to be overriden in subclasses that define different kinds of filters.
	 */
	protected void setFilterCharacter() {
		// Here is where the filter coefficients are computed. In a subclass
		// this method is what needs to be overriden. But here we just set
		// unity amplification, and the signal is passed through unchanged.
		a0 = 1;
		a1 = 0;
		a2 = 0;
		b0 = 1;
		b1 = 0;
		b2 = 0;
		
	}
	
	/**
	 * This method prescales the filter coefficients with a0 which is a gain
	 * factor. This saves a little time in method process above.
	 */
	protected void normalizeConstants() {
		a1 /= a0;
		a2 /= a0;
		b0 /= a0;
		b1 /= a0;
		b2 /= a0;
	}
	
	/**
	 * Defines the filter in terms of its parameters. 
	 * @param sampleRate The system sample rate in Hertz, e.g. 44100.0
	 * @param fqHz The filter frequency in Hertz
	 * @param q The Q value, or bandwidth of the filter, reasonable values are 0.2 - 3
	 * @param gaindB Gain dB (only for certain kinds of filters)
	 */
	public void setFilter(double sampleRate, double fqHz, double q, double gaindB) {
		
		// Set up the constants for our parameters
		setConstants(sampleRate, fqHz, q, gaindB);
		
		// Computer and set the filter coefficients according to filter type.
		setFilterCharacter();
		
		// Normalize coefficients for efficient processing.
		normalizeConstants();
	}

					
}
