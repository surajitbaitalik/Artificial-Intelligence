/**
 * Util class for reusable components
 */
package sxb180026;

import java.util.ArrayList;

/**
 * @author Surajit
 *
 */
public class MorrisUtils {

	/**
	 * @param b,board
	 * @return
	 */
	public static ArrayList<char[]> generateAdd(char[] b) {
		ArrayList<char[]> gaList = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'x') {
				char[] copy_Of_Board = b.clone();
				copy_Of_Board[i] = 'W';
				// check for closeMill
				if (closeMill(i, copy_Of_Board)) {
					gaList = generateRemove(copy_Of_Board, gaList);
				} else {
					gaList.add(copy_Of_Board);
				}
			}
		}
		return gaList;
	}

	/**
	 * @param x
	 * @return
	 */
	public static ArrayList<char[]> generateHopping(char[] b) {
		ArrayList<char[]> ghList = new ArrayList<char[]>();

		char[] copy_Of_Board;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				for (int j = 0; j < b.length; j++) {
					if (b[j] == 'x') {
						copy_Of_Board = b.clone();
						copy_Of_Board[i] = 'x';
						copy_Of_Board[j] = 'W';
						if (closeMill(j, copy_Of_Board)) {
							generateRemove(copy_Of_Board, ghList);
						} else {
							ghList.add(copy_Of_Board);
						}
					}
				}
			}
		}
		return ghList;
	}

	/**
	 * @param x
	 * @return
	 */
	public static ArrayList<char[]> generateMove(char[] b) {
		ArrayList<char[]> gmList = new ArrayList<char[]>();

		char copy_Of_Board[];
		int[] nlist;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				nlist = neighbours(i);
				for (int j : nlist) {
					if (b[j] == 'x') {
						copy_Of_Board = b.clone();
						copy_Of_Board[i] = 'x';
						copy_Of_Board[j] = 'W';
						if (closeMill(j, copy_Of_Board)) {
							generateRemove(copy_Of_Board, gmList);
						} else {
							gmList.add(copy_Of_Board);
						}
					}
				}
			}
		}
		return gmList;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public static ArrayList<char[]> generateMovesMidgameEndgame(char[] b) {
		ArrayList<char[]> gmmeList = new ArrayList<char[]>();
		int wCount = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				wCount++;
			}
		}
		if (wCount == 3) {
			gmmeList = generateHopping(b);
			return gmmeList;
		} else {
			gmmeList = generateMove(b);
			return gmmeList;
		}
	}

	/**
	 * @param j
	 * @return
	 */
	public static int[] neighbours(int j) {
		int[] neighbor;

		switch (j) {
		case 0:
			neighbor = new int[] { 1, 3, 8 };
			return neighbor;
		case 1:
			neighbor = new int[] { 0, 4, 2 };
			return neighbor;
		case 2:
			neighbor = new int[] { 1, 5, 13 };
			return neighbor;
		case 3:
			neighbor = new int[] { 0, 6, 4, 9 };
			return neighbor;
		case 4:
			neighbor = new int[] { 1, 3, 5 };
			return neighbor;
		case 5:
			neighbor = new int[] { 2, 4, 7, 12 };
			return neighbor;
		case 6:
			neighbor = new int[] { 3, 7, 10 };
			return neighbor;
		case 7:
			neighbor = new int[] { 5, 6, 11 };
			return neighbor;
		case 8:
			neighbor = new int[] { 0, 9, 20 };
			return neighbor;
		case 9:
			neighbor = new int[] { 3, 8, 10, 17 };
			return neighbor;
		case 10:
			neighbor = new int[] { 6, 9, 14 };
			return neighbor;
		case 11:
			neighbor = new int[] { 7, 12, 16 };
			return neighbor;
		case 12:
			neighbor = new int[] { 11, 5, 13, 19 };
			return neighbor;
		case 13:
			neighbor = new int[] { 2, 12, 22 };
			return neighbor;
		case 14:
			neighbor = new int[] { 10, 15, 17 };
			return neighbor;
		case 15:
			neighbor = new int[] { 14, 16, 18 };
			return neighbor;
		case 16:
			neighbor = new int[] { 11, 15, 19 };
			return neighbor;
		case 17:
			neighbor = new int[] { 9, 14, 18, 20 };
			return neighbor;
		case 18:
			neighbor = new int[] { 15, 17, 19, 21 };
			return neighbor;
		case 19:
			neighbor = new int[] { 12, 16, 18, 22 };
			return neighbor;
		case 20:
			neighbor = new int[] { 8, 17, 21 };
			return neighbor;
		case 21:
			neighbor = new int[] { 18, 20, 22 };
			return neighbor;
		case 22:
			neighbor = new int[] { 13, 19, 21 };
			return neighbor;
		default:
			return null;
		}

	}

	/**
	 * @param      b,board
	 * @param list
	 * @return board after removing black
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<char[]> generateRemove(char[] b, ArrayList<char[]> list) {
		ArrayList<char[]> grList = (ArrayList<char[]>) list.clone();
		char[] copy_Of_Board ;
		for (int j = 0; j < b.length; j++) {
			if (b[j] == 'B') {
				if (!(closeMill(j, b))) {
                    copy_Of_Board=b.clone();
					copy_Of_Board[j] = 'x';
					grList.add(copy_Of_Board);
				} else {
                    copy_Of_Board=b.clone();
					grList.add(copy_Of_Board);
				}
			}
		}
		return grList;
	}
	/**
	 * Method to perform black moves by swapping the white to black and black to
	 * white
	 * 
	 * @param b,board
	 * @return
	 */
	public static ArrayList<char[]> generateBlackMovesOpening(char[] b) {
		ArrayList<char[]> gbmList = new ArrayList<char[]>();
		ArrayList<char[]> gbmswapList = new ArrayList<char[]>();
		// clone the char array
		char[] tmp = b.clone();
		/*for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == 'W') {
				tmp[i] = 'B';
			} else if (tmp[i] == 'B') {
				tmp[i] = 'W';
			}
		}*/
       tmp=flipBoard(tmp);
		gbmList = generateAdd(tmp);
		for (char[] gb : gbmList) {
		/*	for (int i = 0; i < gb.length; i++) {
				if (gb[i] == 'W') {
					gb[i] = 'B';

				} else if (gb[i] == 'B') {
					gb[i] = 'W';
				}
			}*/
			
			gbmswapList.add(flipBoard(gb));
		}
		return gbmswapList;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public static ArrayList<char[]> generateBlackMovesMidEnd(char[] b) {
		ArrayList<char[]> gbmList = new ArrayList<char[]>();
		ArrayList<char[]> gbmswapList = new ArrayList<char[]>();
		// clone the char array
		char[] tmp = b.clone();
		/*for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == 'W') {
				tmp[i] = 'B';
			} else if (tmp[i] == 'B') {
				tmp[i] = 'W';
			}
		}*/
		tmp=flipBoard(tmp);
		gbmList = generateMovesMidgameEndgame(tmp);

		for (char[] gb : gbmList) {
		/*	for (int i = 0; i < gb.length; i++) {
				if (gb[i] == 'W') {
					gb[i] = 'B';

				} else if (gb[i] == 'B') {
					gb[i] = 'W';
				}
			}*/
			gbmswapList.add(flipBoard(gb));
		}

		return gbmswapList;
	}

	/**
	 * @param b, board
	 * @return differences of whiteCount and blackCount
	 */
	public static int staticEstimationOpening(char[] b) {
		int wCount = 0;
		int bCount = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				wCount++;
			} else if (b[i] == 'B') {
				bCount++;
			}
		}
		return wCount - bCount;
	}

	/**
	 * Improves static estimation function for opening
	 * 
	 * @param b, board
	 * @return differences of whiteCount and blackCount
	 */
	public static int staticEstimationOpeningImproved(char[] b) {
		int wCount = 0;
		int bCount = 0;
		int millCount = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				wCount++;
			} else if (b[i] == 'B') {
				bCount++;
			}
		}
		// check for mill count
		for (int i = 0; i < b.length; i++) {
			if (closeMill(i, b)) {
				millCount++;
			}
		}

		return wCount+millCount-bCount;
	}

	/**
	 * Static estimation function
	 * 
	 * @param board b
	 * @return
	 */
	public static int staticEstimationMidEnd(char[] b) {
		int wcount = 0;
		int bcount = 0;
		ArrayList<char[]> bmList = new ArrayList<char[]>();
		bmList = generateBlackMovesMidEnd(b);
		int bMoveCount = bmList.size();
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				wcount++;
			} else if (b[i] == 'B') {
				bcount++;
			}
		}

		if (bcount <= 2) {
			return 10000;
		} else if (wcount <= 2) {
			return -10000;
		} else if (bMoveCount == 0) {
			return 10000;
		} else {
			return ((1000 * (wcount - bcount)) - bMoveCount);
		}

	}

	/**
	 * Static estimation function
	 * 
	 * @param board b
	 * @return
	 */
	public static int staticEstimationMidEndImproved(char[] b) {
		int wcount = 0;
		int bcount = 0;

		ArrayList<char[]> bmList = new ArrayList<char[]>();
		bmList = generateBlackMovesMidEnd(b);
		int bMoveCount = bmList.size();
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				wcount++;
			} else if (b[i] == 'B') {
				bcount++;
			}
		}
		int millCount = 0;
		// check for mill count
		for (int i = 0; i < b.length; i++) {
			if (closeMill(i, b)) {
				millCount++;
			}
		}

		if (bcount <= 2) {
			return 10000;
		} else if (wcount <= 2) {
			return -10000;
		} else if (bMoveCount == 0) {
			return 10000;
		} else {
			return ((1000 * (wcount - bcount-millCount)) - bMoveCount);
		}

	}

	/**
	 * @param j, position of the board
	 * @param b, board
	 * @return true if it closes the mill, else return false
	 */
	public static boolean closeMill(int j, char[] b) {
		char c = b[j];
		if (c == 'W' || c == 'B') {
			switch (j) {
			// mill positions starting with a0
			case 0:
				if ((b[1] == c && b[2] == c) || (b[3] == c && b[6] == c) || (b[8] == c && b[20] == c)) {
					return true;
				} else {
					return false;
				}

				// mill position for d0
			case 1:
				if (b[0] == c && b[2] == c) {
					return true;
				} else {
					return false;
				}

				// mill position for g0
			case 2:
				if ((b[5] == c && b[7] == c) || (b[13] == c && b[22] == c) || (b[1] == c && b[0] == c)) {
					return true;
				} else {
					return false;
				}

				// mill position for b1
			case 3:
				if ((b[0] == c && b[6] == c) || (b[4] == c && b[5] == c) || (b[9] == c && b[17] == c)) {
					return true;
				} else {
					return false;
				}

				// mill position for d1
			case 4:
				if (b[3] == c && b[5] == c) {
					return true;
				} else {
					return false;
				}
				// mill for f1 position
			case 5:
				if ((b[3] == c && b[4] == c) || (b[12] == c && b[19] == c) || (b[2] == c && b[7] == c)) {
					return true;
				} else {
					return false;
				}

				// mill for c2
			case 6:
				if ((b[3] == c && b[0] == c) || (b[10] == c && b[14] == c)) {
					return true;
				} else {
					return false;
				}
				// mill for e2 position
			case 7:
				if ((b[5] == c && b[2] == c) || (b[11] == c && b[16] == c)) {
					return true;
				} else {
					return false;
				}
				// for a3 position
			case 8:
				if ((b[0] == c && b[20] == c) || (b[9] == c && b[10] == c)) {
					return true;
				} else {
					return false;
				}
				// for b3 position
			case 9:
				if ((b[8] == c && b[10] == c) || (b[3] == c && b[17] == c)) {
					return true;
				} else {
					return false;
				}
				// for c3 position
			case 10:
				if ((b[6] == c && b[14] == c) || (b[8] == c && b[9] == c)) {
					return true;
				} else {
					return false;
				}
				// for e3 position
			case 11:
				if ((b[7] == c && b[16] == c) || (b[12] == c && b[13] == c)) {
					return true;
				} else {
					return false;
				}
				// for f3 position
			case 12:
				if ((b[5] == c && b[19] == c) || (b[11] == c && b[13] == c)) {
					return true;
				} else {
					return false;
				}
				// for g3 position
			case 13:
				if ((b[2] == c && b[22] == c) || (b[11] == c && b[12] == c)) {
					return true;
				} else {
					return false;
				}
				// for c4 position
			case 14:
				if ((b[10] == c && b[6] == c) || (b[15] == c && b[16] == c) || (b[17] == c && b[20] == c)) {
					return true;
				} else {
					return false;
				}
				// for d4 position
			case 15:
				if ((b[14] == c && b[16] == c) || (b[18] == c && b[21] == c)) {
					return true;
				} else {
					return false;
				}
				// for e4 position
			case 16:
				if ((b[14] == c && b[15] == c) || (b[19] == c && b[22] == c) || (b[11] == c && b[7] == c)) {
					return true;
				} else {
					return false;
				}
				// for b5
			case 17:
				if ((b[14] == c && b[20] == c) || (b[18] == c && b[19] == c) || (b[3] == c && b[9] == c)) {
					return true;
				} else {
					return false;
				}
				// for d5
			case 18:
				if ((b[17] == c && b[19] == c) || (b[15] == c && b[21] == c)) {
					return true;
				} else {
					return false;
				}
				// for f5
			case 19:
				if ((b[17] == c && b[18] == c) || (b[16] == c && b[22] == c) || (b[12] == c && b[5] == c)) {
					return true;
				} else {
					return false;
				}
				// for a6
			case 20:
				if ((b[8] == c && b[0] == c) || (b[21] == c && b[22] == c) || (b[17] == c && b[14] == c)) {
					return true;
				} else {
					return false;
				}
				// for d6
			case 21:
				if ((b[20] == c && b[22] == c) || (b[18] == c && b[15] == c)) {
					return true;
				} else {
					return false;
				}
				// for g6
			case 22:
				if ((b[20] == c && b[21] == c) || (b[13] == c && b[2] == c)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * This method will flip the board
	 * by converting  black to white and vice-versa
	 * 
	 * @param x
	 * @return
	 */
	public static char[] flipBoard(char[] b) {
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 'W') {
				b[i] = 'B';
			} else if (b[i] == 'B') {
				b[i] = 'W';
			}
		}
		return b;
	}

}
