package sorts;
import java.text.*;

public class Counter {
  public int comparisons = 0;
  public int dataMoves = 0;
  private DecimalFormat myFormatter = new DecimalFormat("###,###");

  public Counter(int comparisons,int dataMoves) {
    this.comparisons = comparisons;
    this.dataMoves = dataMoves;
  }

  public Counter() {
    this(0,0);
  }

  public void clear() { comparisons = dataMoves = 0; }

  @Override
  public String toString() {
    return "comparisons: " + myFormatter.format(comparisons)
            + "  dataMoves: " + myFormatter.format(dataMoves)
            + ", total: " + myFormatter.format(comparisons + dataMoves);
  }
}
