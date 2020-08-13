/**
 * The second program plays in the midgame/endgame phase. We request that you call it MiniMaxGame.
For example, the input can be:(you type:) board3.txt board4.txt 3
(the program replies:) Board Position: xxxxxxxxWWWxWWxBBBBxxxx.
Positions evaluated by static estimation: 125.
MINIMAX estimate: 9987. Here it is assumed that the le board3.txt exists and its content is:
xxxxxxxxxxWWxWWxBBBxxxx The file board4.txt is created by the program, and its content is: xxxxxxxxWWWxWWxBBBBxxxx
(The position and the numbers above may not be correct. They are given just to illustrate the format.)
 */
package sxb180026;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Surajit
 *
 */
public class MiniMaxGame {
	private static int position_evaluated = 0;
	private static int minimax_estimate = 0;

	/**
	 * @param b,board
	 * @param depth
	 * @return the board position after max's play
	 */
	public char[] maxMin(char[] b, int depth) {
		if (depth == 0) {
			position_evaluated++;
		}else {
			char[] max_option = new char[b.length];
			char[] min_option;
			ArrayList<char[]> wChildren = new ArrayList<char[]>();
			wChildren = MorrisUtils.generateMovesMidgameEndgame(b);
			int v = Integer.MIN_VALUE;
			for (int i = 0; i < wChildren.size(); i++) {
				min_option = minMax(wChildren.get(i), depth-1);
				int sEstimation=MorrisUtils.staticEstimationMidEnd(min_option);
				if (v < sEstimation) {
					v = sEstimation;
					minimax_estimate = v;
					max_option = wChildren.get(i);
					}
			}
			return max_option;
		}
		return b;
	}

	/**
	 * Method minMax
	 * @param x
	 * @param depth
	 * @return return board's position after min's play
	 */
	public char[] minMax(char[] b, int depth) {
		if (depth == 0) {
			position_evaluated++;
		}else {
			
			char[] min_option = new char[b.length];
			char[] max_option;
			ArrayList<char[]> bchildren = new ArrayList<char[]>();
			bchildren = MorrisUtils.generateBlackMovesMidEnd(b);
			int v = Integer.MAX_VALUE;
			for (int i = 0; i < bchildren.size(); i++) {
				max_option = maxMin(bchildren.get(i), depth-1);
				int sEstimation=MorrisUtils.staticEstimationMidEnd(max_option);
				if ( sEstimation<v) {
					v =sEstimation;
					min_option = bchildren.get(i);
				}
			}
			return min_option;
		}
		return b;
	}

	

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		/*File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		int depth = Integer.parseInt(args[2]);
		FileInputStream fis = new FileInputStream(inputFile);
		PrintWriter out = new PrintWriter(new FileWriter(outputFile));
		Scanner sc = new Scanner(fis);

		while (sc.hasNextLine()) {
			String str = sc.next();
			char[] board = str.toCharArray();
			MiniMaxGame m = new MiniMaxGame();
			System.out.println("given board : " + new String(board));
			//first the white turn
			char[] maxT= m.maxMin(board, depth);
			//second the black turn by flipping the board
			//char[] minT=MorrisUtils.flipBoard(m.maxMin(MorrisUtils.flipBoard(maxT), depth));
			System.out.println("output Board:::"+new String(maxT));
			out.println("Board Position : " + new String(maxT));
			out.println("Positions evaluated by static estimation : " + m.position_evaluated);
			out.println("MiniMax estimate : " + m.minimax_estimate);
			out.println();
		}
		fis.close();
		out.close();
*/
		String str = "xxBBBBxBxWBxxxWBxxBxxBx";
		char[] board = str.toCharArray();
		MiniMaxGame m = new MiniMaxGame();
		System.out.println("given board : " + new String(board));
		char[] d = m.maxMin(board, 4);
		//out.println("Board Position : " + new String(d));
		System.out.println("Output of Minimax opening:::"+new String(d));
	}

}
