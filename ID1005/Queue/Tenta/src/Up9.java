	public static void sort (double[] tal)
	{
	
		double    p = 0;
		int       k = 0;

		for (int i = 0; i < tal.length - 1; i++)
		{
			k = i;
        
			for (int j = i + 1; j < tal.length; j++)
				if (tal[j] < tal[k]) //j och k kommer f� samma v�rde
					
            k = j;
			p = tal[i];
			tal[i] = tal[k];
			tal[k] = p;

			//algoritmen kan kallas en vektor sorterare, s�tter vektorerna j och k likadana.
		}
	}