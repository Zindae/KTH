import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * Sorts the Grey scale Image based on the color.
 * 
 */
public class ImageSorter extends JFrame
{
	/**
	 * Default constructor
	 */
	public ImageSorter()
	{
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel unsortedImagePanel = new JPanel();
		unsortedImagePanel.setOpaque(false);
		unsortedImagePanel.setBorder(new EmptyBorder(0, 50, 0, 0));
		panel.add(unsortedImagePanel);
		unsortedImagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Unsorted Grayscale Image");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 17));
		unsortedImagePanel.add(lblNewLabel, BorderLayout.NORTH);

		JLabel unsortedImage = new JLabel("");
		unsortedImage.setHorizontalAlignment(SwingConstants.CENTER);
		unsortedImagePanel.add(unsortedImage, BorderLayout.CENTER);

		JPanel sortedImagePanel = new JPanel();
		sortedImagePanel.setOpaque(false);
		sortedImagePanel.setBorder(new EmptyBorder(0, 50, 0, 0));
		panel.add(sortedImagePanel);
		sortedImagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("Sorted Grayscale Image");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 18));
		sortedImagePanel.add(lblNewLabel_3, BorderLayout.NORTH);

		JLabel sortedImage = new JLabel("");
		sortedImage.setHorizontalAlignment(SwingConstants.CENTER);
		sortedImagePanel.add(sortedImage, BorderLayout.CENTER);
		int[] unsortedShadesArray = createUnsortedArrayBetweenRange(0, 255);
		unsortedImage.setIcon(new ImageIcon(
				createGreyScaleImage(unsortedShadesArray)));
		// Now sort the image colors
		// 0 is white .....255 is darkest.
		sort(unsortedShadesArray);
		sortedImage.setIcon(new ImageIcon(
				createGreyScaleImage(unsortedShadesArray)));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2955919451961597203L;
	/**
	 * Launch method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		ImageSorter is = new ImageSorter();
		is.setSize(500, 400);
		is.setVisible(true);
	}
	/**
	 * Creates a unsorted array between the given range.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] createUnsortedArrayBetweenRange(int start, int end)
	{
		List<Integer> integerList = new ArrayList<Integer>();
		for (int i = start; i <= end; i++)
		{
			integerList.add(i);
		}
		Collections.shuffle(integerList);
		return toIntArray(integerList);
	}
	/**
	 * Converts the List of Integer to int primitive array.
	 * 
	 * @param list
	 * @return
	 */
	public static int[] toIntArray(List<Integer> list)
	{
		int[] ret = new int[list.size()];
		int i = 0;
		for (Integer e : list)
			ret[i++] = e.intValue();
		return ret;
	}

	/**
	 * Creates the GreyScale image.
	 * 
	 * @return
	 */
	public static Image createGreyScaleImage(int[] colors)
	{
		BufferedImage buffImage = new BufferedImage(colors.length, 100,
				BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < colors.length; i++)
		{
			Color color = new Color(colors[i], colors[i], colors[i]);
			for (int j = 0; j < 100; j++)
			{
				buffImage.setRGB(i, j, color.getRGB());
			}
		}
		return buffImage;
	}

	/**
	 * Sort algorithm is executed here.
	 * 
	 * @param array
	 */
	static void sort(int[] array)
	{
		int tmp = 0;
		for (int i = 0; i < array.length - 1; i++)
		{
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[i] < array[j])
				{
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

}
