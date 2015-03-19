package sorts;

import java.util.*;

public class ShowAlgorithms {
  public static String positionString(Object[] A) {
    String Pos[] = new String[A.length];
    for (int i = 0; i < Pos.length; ++i) {
      String fmt = "%" + String.valueOf(A[i]).length() + "s";
      Pos[i] = String.format(fmt, "" + i);
    }
    String pos_str = Arrays.toString(Pos);
    pos_str =
      pos_str.replace("[", " ").replace("]", " ").replace(",", " ");
    return "  " + pos_str + " <= positions";
  }
  private static final String[] NAMES = {"selection", "insertion", "shell", "quick", "merge", "heap"};
  public static final int SELECT = 0, INSERT = 1, SHELL = 2, QUICK = 3, MERGE = 4, HEAP = 5;

  public static String getName(int which) {
    String name = NAMES[which];
    name += "Sort";
    if (which == QUICK) {
      name += "(cutoff=" + QUICKSORT_CUTOFF + ")";
    }
    return name;
  }

  private static String repeat(String s, int times) {
    String output = "";
    for (int i = 0; i < times; ++i) {
      output += s;
    }
    return output;
  }

  private static void setAnnotateChar(char c) {
    annotateChar = c;
  }
  private static char annotateChar = '^';

  private static <E> void highlightPositions(
    List<Integer> pos, E[] a, int toIndex, char annotateC) {
    String annotateS = String.valueOf(annotateC);

    String s[] = new String[toIndex];
    for (int i = 0; i < s.length; ++i) {
      s[i] = repeat(" ", a[i].toString().length());
    }
    for (int p : pos) {
      s[p] = repeat(annotateS, a[p].toString().length());
    }
    StringBuffer buf = new StringBuffer(Arrays.toString(s));

    for (int i = 0; i < buf.length(); ++i) {
      if (buf.charAt(i) != annotateC) {
        buf.setCharAt(i, ' ');
      }
    }
    System.out.println("  " + buf);
  }

  private static <E> void highlightPositionWith(int pos, E[] a, String annot) {
    String s[] = new String[pos + 1];
    for (int i = 0; i < pos; ++i) {
      s[i] = repeat(" ", a[i].toString().length());
    }
    s[pos] = "*" + repeat(" ", annot.length() - 1);
    StringBuffer buf = new StringBuffer(Arrays.toString(s));

    int i = 0;
    while (buf.charAt(i) != '*') {
      buf.setCharAt(i++, ' ');
    }
    for (int j = 0; j < annot.length(); ++j) {
      buf.setCharAt(i, annot.charAt(j));
      ++i;
    }
    while (i < buf.length()) {
      buf.setCharAt(i++, ' ');
    }
    System.out.println("  " + buf);
  }

  private static <E> void highlightPositions(
    List<Integer> pos, E[] a, int toIndex) {
    highlightPositions(pos, a, toIndex, annotateChar);
  }

  private static <E> void printArraySection(
    E[] a, int fromIndex, int toIndex, String prefix) {
    printArraySection(a, fromIndex, toIndex, prefix, "");
  }

  private static <E> void printArraySection(
    E[] a, int fromIndex, int toIndex, String prefix,
    String suffix) {
    int prelen = Arrays.toString(Arrays.copyOfRange(a, 0, fromIndex)).length();
    if (fromIndex == 0) {
      prelen -= 2;
    }
    String stuff = prefix + repeat(" ", prelen) + Arrays.toString(Arrays.copyOfRange(a, fromIndex, toIndex));

    int diff = 0;
    if (arrayStrLen > 0) {
      diff = arrayStrLen + 3 - stuff.length();
    }
    String extra = "";
    if (diff > 0) {
      extra = repeat(" ", diff);
    }
    System.out.println(stuff + extra + suffix);
  }
  private static List<Integer> pos = new LinkedList<Integer>();

  public static <E> void swap(E[] a, int i, int j) {
    E tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  // selectionSort
  public static <E> void selectionSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    for (int i = fromIndex; i < toIndex - 1; ++i) {
      pos.clear();
      pos.add(i);
      highlightPositions(pos, a, toIndex);
      int selected_index = i;
      for (int j = i + 1; j < toIndex; ++j) {
        if (c.compare(a[j], a[selected_index]) < 0) {
          selected_index = j;
        }
      }
      if (selected_index != i) {
        swap(a, selected_index, i);
      }
      printArraySection(a, fromIndex, toIndex, "=>");
    }
  }

  public static <E> void selectionSort(E[] a, Comparator<? super E> c) {
    selectionSort(a, 0, a.length, c);
  }

  public static void selectionSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    selectionSort(a, fromIndex, toIndex, c);
  }

  public static void selectionSort(Object[] a) {
    selectionSort(a, 0, a.length);
  }
  private static boolean showInsertionSort = true;

  // insertionSort
  public static <E> void insertionSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    for (int i = fromIndex + 1; i < toIndex; ++i) {
      E insert_value = a[i];
      if (showInsertionSort) {
        String str = String.valueOf(insert_value);
        highlightPositionWith(i, a, repeat("-", str.length()));
        highlightPositionWith(i, a, str);
      }
      int j;
      for (j = i; j > fromIndex; --j) {
        if (c.compare(a[j - 1], insert_value) > 0) {
          a[j] = a[j - 1];
        } else {
          break;
        }
        if (showInsertionSort) {
          printArraySection(a, fromIndex, toIndex, "  ");
        }
      }
      if (j != i) {
        a[j] = insert_value;
      }
      if (showInsertionSort) {
        printArraySection(a, fromIndex, toIndex, "=>");
      }
    }
  }

  public static <E> void insertionSort(E[] a, Comparator<? super E> c) {
    insertionSort(a, 0, a.length, c);
  }

  public static void insertionSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    insertionSort(a, fromIndex, toIndex, c);
  }

  public static void insertionSort(Object[] a) {
    insertionSort(a, 0, a.length);
  }
  // shellSort
  // permit us to specify the shell sort increments externally 
  private static LinkedList<Integer> shellSortIncrements = null;

  public static void setShellSortIncrements(
    LinkedList<Integer> shellSortIncrements) {
    ShowAlgorithms.shellSortIncrements = shellSortIncrements;
  }

  public static <E> void shellSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    int size = toIndex - fromIndex;
    if (shellSortIncrements == null) {
      // set increments to the default
      shellSortIncrements = new LinkedList<Integer>();
      for (int inc = 1; inc < size; inc = 2 * (inc + 1) - 1) {
        shellSortIncrements.add(inc);
      }
    }
    Iterator<Integer> iter = shellSortIncrements.descendingIterator();
    while (iter.hasNext()) {
      int gap = iter.next();
      for (int k = 0; k < gap; ++k) {
        if (fromIndex + k + gap >= toIndex) {
          // there will be nothing to do
          break;
        }
        pos.clear();
        int cur = fromIndex + k;
        do {
          pos.add(cur);
          cur += gap;
        } while (cur < toIndex);
        highlightPositions(pos, a, toIndex);
        // insertionSort on ( a[fromIndex+k], a[fromIndex+k+gap], ...  )
        for (int i = fromIndex + k + gap; i < toIndex; i += gap) {
          E insert_value = a[i];
          int j = i;
          for (; j >= fromIndex + k + gap; j -= gap) {
            if (c.compare(a[j - gap], insert_value) > 0) {
              a[j] = a[j - gap];
            } else {
              break;
            }
          }
          if (j != i) {
            a[j] = insert_value;
          }
        }
        if (k == gap - 1) {
          System.out.println();
        }
        printArraySection(a, fromIndex, toIndex, "=>");
      }
    }
  }

  public static <E> void shellSort(E[] a, Comparator<? super E> c) {
    shellSort(a, 0, a.length, c);
  }

  public static void shellSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    shellSort(a, fromIndex, toIndex, c);
  }

  public static void shellSort(Object[] a) {
    shellSort(a, 0, a.length);
  }

  // quickSort
  private static <E> E medianOf3(
    E a[], int left, int right, Comparator<? super E> c) {
    int center = (left + right) / 2;
    // do insertionsort on a[left], a[center], a[right]
    if (c.compare(a[left], a[center]) > 0) {
      swap(a, left, center);
    }
    // now left <= center
    E insert = a[right];
    if (c.compare(a[center], insert) > 0) {
      a[right] = a[center];
      if (c.compare(a[left], insert) > 0) {
        a[center] = a[left];
        a[left] = insert;
      } else {
        a[center] = insert;
      }
    }
    return a[center];
  }
  private static int arrayStrLen = 0;
  private static int QUICKSORT_CUTOFF = 5;

  public static void setQuicksortCutoff(int cutoff) {
    QUICKSORT_CUTOFF = cutoff;
  }

  public static <E> void quickSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    setAnnotateChar('_');
    showInsertionSort = false;
    arrayStrLen = Arrays.toString(a).length();
    _quickSort(a, fromIndex, toIndex, c);
  }
  
  private static boolean technically_correct = false;

  private static <E> void _quickSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    System.out.println( "quickSort(" + fromIndex + "," + toIndex + ")");

    if (toIndex - fromIndex <= QUICKSORT_CUTOFF) {
      insertionSort(a, fromIndex, toIndex, c);
    } else {
      // choose the pivot element as median-of-three
      pos.clear();
      pos.add(fromIndex);
      pos.add(toIndex - 1);
      pos.add((fromIndex + toIndex - 1) / 2);
      highlightPositions(pos, a, toIndex, '^');

      E pivot = medianOf3(a, fromIndex, toIndex - 1, c);
      printArraySection(a, fromIndex, toIndex, "  ", " mOf3: pivot=" + pivot);
      int i = fromIndex, j = toIndex - 1;
      while (true) {
        while (c.compare(a[++i], pivot) < 0) {
        }
        while (c.compare(pivot, a[--j]) < 0) {
        }
        if (i < j) {
          pos.clear();
          pos.add(i);
          pos.add(j);
          highlightPositions(pos, a, toIndex, '_');
          printArraySection(a, fromIndex, toIndex, "  ", " before swap");
          swap(a, i, j);
        } else {              // swap, then advance both
          break;
        }
      }
      pos.clear();
      pos.add(i);
      highlightPositions(pos, a, toIndex);
      printArraySection(a, fromIndex, toIndex, "=>");
      
      if (technically_correct) {
        if (i - fromIndex <= toIndex - i) {
          _quickSort(a, fromIndex, i, c);
          _quickSort(a, i, toIndex, c);
        } 
        else {
          _quickSort(a, i, toIndex, c);
          _quickSort(a, fromIndex, i, c);
        }
      } else {
        _quickSort(a, fromIndex, i, c);
        _quickSort(a, i, toIndex, c);
      }
    }
  }

  public static <E> void quickSort(E[] a, Comparator<? super E> c) {
    quickSort(a, 0, a.length, c);
  }

  public static void quickSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    quickSort(a, fromIndex, toIndex, c);
  }

  public static void quickSort(Object[] a) {
    quickSort(a, 0, a.length);
  }

  // mergeSort
  public static <E> void mergeSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
    E[] b = (E[]) new Object[a.length];

    boolean merge_b_to_a = true;  // merge direction: final merge b => a

    mergeSort(a, b, merge_b_to_a, fromIndex, toIndex, c);
  }

  // private helper function
  private static <E> void mergeSort(
    E[] a, E[] b, boolean merge_b_to_a, int fromIndex, int toIndex,
    Comparator<? super E> c) {
    if (toIndex - fromIndex == 0) {
      return;
    } else if (toIndex - fromIndex == 1) {
      if (!merge_b_to_a) { // must end up in b
        b[fromIndex] = a[fromIndex];
      }
    } else {
      // recursively sort halves merging in the opposite direction

      int middle = (toIndex + fromIndex) / 2;
      mergeSort(a, b, !merge_b_to_a, fromIndex, middle, c);
      mergeSort(a, b, !merge_b_to_a, middle, toIndex, c);

      // merge in the direction indicated by merge_b_to_a

      E[] from, to;
      if (merge_b_to_a) {
        from = b;
        to = a;
      } else {
        from = a;
        to = b;
      }

      int i = fromIndex, j = middle, // source indices in from array
        k = fromIndex;             // target index in to array

      while (i < middle || j < toIndex) {
        if (i == middle) {
          to[k++] = from[j++];
        } else if (j == toIndex) {
          to[k++] = from[i++];
        } else {
          if (c.compare(from[i], from[j]) <= 0) { // "<=" gives stability
            to[k++] = from[i++];
          } else {
            to[k++] = from[j++];
          }
        }
      }
      if (merge_b_to_a) {
        printArraySection(a, fromIndex, toIndex, "a:");
      } else {
        printArraySection(b, fromIndex, toIndex, "b:");
      }
    }
  }

  public static <E> void mergeSort(E[] a, Comparator<? super E> c) {
    mergeSort(a, 0, a.length, c);
  }

  public static void mergeSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    mergeSort(a, fromIndex, toIndex, c);
  }

  public static void mergeSort(Object[] a) {
    mergeSort(a, 0, a.length);
  }

  // heapSort
  public static <E> void heapSort(
    E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {

    class ShowHeap {
      int fromIndex;
      E[] data;
      Integer markedPos;

      public void setMarkedPos(Integer markedPos) {
        this.markedPos = markedPos;
      }

      ShowHeap(E[] data, int fromIndex) {
        this.data = data;
        this.fromIndex = fromIndex;
      }
      private String indentString = "   ";

      public void setIndentString(String indentString) {
        this.indentString = indentString;
      }

      private String repeat(String s, int times) {
        String output = "";
        for (int i = 0; i < times; ++i) {
          output += s;
        }
        return output;
      }

      public void reverseInorderOutput(int upTo) {
        reverseInorderOutput(fromIndex, upTo, 0);
      }

      private void reverseInorderOutput(int pos, int upTo, int level) {
        if (pos <= upTo) {
          int nodePos = pos - fromIndex + 1;
          int lchildPos = 2 * nodePos + fromIndex - 1;
          int rchildPos = 2 * nodePos + fromIndex;
          reverseInorderOutput(rchildPos, upTo, level + 1);
          System.out.print(repeat(indentString, level) + data[pos]);
          if (markedPos != null && pos == markedPos) {
            System.out.print("*");
            markedPos = null;
          }
          System.out.println();
          reverseInorderOutput(lchildPos, upTo, level + 1);
        }
      }
    }

    ShowHeap showheap = new ShowHeap(a, fromIndex);

    //showheap.reverseInorderOutput(toIndex-1);

    int start = (toIndex - fromIndex) / 2;
    showheap.setMarkedPos(fromIndex + start - 1);
    showheap.reverseInorderOutput(toIndex - 1);
    while (start > 0) {
      System.out.println("-----------------------------------");
      int heapInd = start;
      int par = fromIndex + heapInd - 1;
      E insert = a[par];
      int j = toIndex;
      int lchild = par + heapInd;
      int rchild = lchild + 1;
      while (true) {
        if (lchild > j - 1) { // par is a leaf
          break;
        }
        int child;  // child with the largest value

        if (lchild == j - 1) {
          // i has only a left child
          child = lchild;
          heapInd = 2 * heapInd;
        } else {
          if (c.compare(a[lchild], a[rchild]) >= 0) {
            // 2 children with bigger or equal left
            child = lchild;
            heapInd = 2 * heapInd;
          } else {
            // 2 children with smaller right
            child = rchild;
            heapInd = 2 * heapInd + 1;
          }
        }
        if (c.compare(insert, a[child]) >= 0) {
          break;
        } else {
          a[par] = a[child];  // shift child up
        }
        par = fromIndex + heapInd - 1;
        lchild = par + heapInd;
        rchild = lchild + 1;
      }
      a[par] = insert;
      --start;
      showheap.setMarkedPos(fromIndex + start - 1);
      showheap.reverseInorderOutput(toIndex - 1);
    }

    System.out.println("\n------------- buildHeap complete --------------\n");

    // move the heap top a[fromIndex] (greatest element)
    // into position a[j] and reinsert a[j]

    for (int j = toIndex - 1; j > fromIndex; --j) {
      E insert = a[j];
      a[j] = a[fromIndex];
      int heapInd = 1;

      int par = fromIndex + heapInd - 1;
      int lchild = par + heapInd;
      int rchild = lchild + 1;
      while (true) {
        if (lchild > j - 1) { // par is a leaf
          break;
        }
        int child;  // child with the largest value

        if (lchild == j - 1) {
          // i has only a left child
          child = lchild;
          heapInd = 2 * heapInd;
        } else {
          if (c.compare(a[lchild], a[rchild]) >= 0) {
            // 2 children with bigger or equal left
            child = lchild;
            heapInd = 2 * heapInd;
          } else {
            // 2 children with smaller right
            child = rchild;
            heapInd = 2 * heapInd + 1;
          }
        }
        if (c.compare(insert, a[child]) >= 0) {
          break;
        } else {
          a[par] = a[child];  // shift child up
        }
        par = fromIndex + heapInd - 1;
        lchild = par + heapInd;
        rchild = lchild + 1;
      }
      a[par] = insert;


      printArraySection(a, fromIndex, toIndex, "=>");
      pos.clear();
      pos.add(j);
      highlightPositions(pos, a, toIndex, '^');

      showheap.reverseInorderOutput(j - 1);
    }
  }

  public static <E> void heapSort(E[] a, Comparator<? super E> c) {
    heapSort(a, 0, a.length, c);
  }

  public static void heapSort(Object[] a, int fromIndex, int toIndex) {
    Comparator<Object> c = new Comparator<Object>() {
      @Override
      public int compare(Object lhs, Object rhs) {
        return ((Comparable) lhs).compareTo(rhs);
      }
    };
    heapSort(a, fromIndex, toIndex, c);
  }

  public static void heapSort(Object[] a) {
    heapSort(a, 0, a.length);
  }
}
