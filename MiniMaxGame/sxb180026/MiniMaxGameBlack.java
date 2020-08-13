/**
 * Write the same programs as in Part I, but the computed move should be Black's move instead of White's
move. We request that you call these program MiniMaxGameBlack.
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
public class MiniMaxGameBlack {
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
				int sEstimation=MorrisUtils.staticEstimationMidEnd(b);
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
			bchildren =MorrisUtils.generateBlackMovesMidEnd(b);
			int v = Integer.MAX_VALUE;
			for (int i = 0; i < bchildren.size(); i++) {
				max_option = maxMin(bchildren.get(i), depth-1);
				int sEstimation=MorrisUtils.staticEstimationMidEnd(b);
				if (sEstimation<v) {
					v = sEstimation;
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
		Scanner sc = new Scanner(fis);*/

		/*while (sc.hasNextLine()) {
			String str = sc.next();
			char[] board = str.toCharArray();*/
			MiniMaxGameBlack mb = new MiniMaxGameBlack();
			String str = "xxxWWWBWxWBBWxWBWxWxxxx";
			char[] board = str.toCharArray();
			
			System.out.println("given board : " + new String(board));
			//char[] d = mb.maxMin(board, 4);
			//out.println("Board Position : " + new String(d));
			
				char[] d = MorrisUtils.flipBoard(mb.maxMin(MorrisUtils.flipBoard(board), 3));
				System.out.println("Output of Minimax opening:::"+new String(d));
			/*System.out.println("given board : " + new String(board));
			char[] d = MorrisUtils.flipBoard(mb.maxMin(MorrisUtils.flipBoard(board), depth));
			out.println("Board Position : " + new String(d));
			out.println("Positions evaluated by static estimation : " + mb.position_evaluated);
			out.println("MiniMax estimate : " + mb.minimax_estimate);
			out.println();
		}
		fis.close();
		out.close();*/

	}


}
