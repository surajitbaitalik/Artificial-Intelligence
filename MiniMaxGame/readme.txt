Command for compilation:
Go to the folder sxb180026
Then compile all java files by the command: javac *.java
All 9 files are compiled successfully, and class files have been generated.
Results with execution steps
MiniMaxOpening:   java MiniMaxOpening board1.txt board2.txt 2
           Input:    xxxxxxxxxWxxxxxxBxxxxxx
                         xWWxxxxxxWxxxxxxBxxxxxx
           Output:  Board Position : WxxxxxxxxWxxxxxxBxxxxxx
                         Positions evaluated by static estimation : 420
                         MiniMax estimate : 0
                       Board Position : WWWxxxxxxWxxxxxxxxxxxxx
                         Positions evaluated by static estimation : 763
                         MiniMax estimate : 3
MiniMaxGame:   java MiniMaxGame board3.txt board4.txt 3
           Input:   xxxxxxxxxxWWxWWxBBBxxxx
                    xxxxxxxxxWWxxWxBxBxxBxx
           Output:      Board Position : xxxxxxWxxxxWxWWxBBBxxxx
                        Positions evaluated by static estimation : 3244
                        MiniMax estimate : 953
                        Board Position : WxxxxxxxxxWxxWxBxBxxBxx
                        Positions evaluated by static estimation : 129448
                        MiniMax estimate : -50

ABOpening : java ABOpening board1.txt board2.txt 2

           Input:   xxxxxxxxxWxxxxxxBxxxxxx
                    xWWxxxxxxWxxxxxxBxxxxxx
           Output:       Board Position : WxxxxxxxxWxxxxxxBxxxxxx
                         Positions evaluated by static estimation : 40
                         MiniMax estimate : 0
                         Board Position : WWWxxxxxxWxxxxxxxxxxxxx
                         Positions evaluated by static estimation : 77
                         MiniMax estimate : 3
ABGame : java ABGame board3.txt board4.txt 3
     Input:   xxxxxxxxxxWWxWWxBBBxxxx
                    xxxxxxxxxWWxxWxBxBxxBxx	
    Output:     Board Position : xxxxxxWxxxxWxWWxBBBxxxx
                       Positions evaluated by static estimation : 333
                       MiniMax estimate : 953
                       Board Position : WxxxxxxxxxWxxWxBxBxxBxx
                       Positions evaluated by static estimation : 4002
                       MiniMax estimate : -49 
MiniMaxOpeningBlack : java MiniMaxOpeningBlack board1.txt board2.txt 2
         Input: xxxxxxxxxWxxxxxxBxxxxxx
                       xWWxxxxxxWxxxxxxBxxxxxx 
         Output:      Board Position : BxxxxxxxxWxxxxxxBxxxxxx
                             Positions evaluated by static estimation : 420
                             MiniMax estimate : 0
                             Board Position : BWWxxxxxxWxxxxxxBxxxxxx
                             Positions evaluated by static estimation : 780
                             MiniMax estimate : -2
MiniMaxGameBlack :  java MiniMaxGameBlack board3.txt board4.txt 3
                 Input: xxxxxxxxxxWWxWWxBBBxxxx
                        xxxxxxxxxWWxxWxBxBxxBxx	
                 Output:       Board Position : BxxxxxxxxxWWxWWxxBBxxxx
                               Positions evaluated by static estimation : 18159
                               MiniMax estimate : -1009
                               Board Position : BxxxxxxxxWWxxWxxxBxxBxx
                               Positions evaluated by static estimation : 143987
                               MiniMax estimate : -50			   
MiniMaxOpeningImproved: java ABOpeningImproved board1.txt board2.txt 2
                 Input: xxxWWxxxxWxxxxxxBxBBxxx
                        xWWxxxxxxWxxxxxxBWxxxxx	
                 Output:      Board Position : xxxWWWxxxWxxxxxxxxxxxxx
                              Positions evaluated by static estimation : 399
                              MiniMax estimate : 6
                              Board Position : WWWxxxxxxWxxxxxxxWxxxxx
                              Positions evaluated by static estimation : 717
                              MiniMax estimate : 7
MiniMaxOpening: java ABOpening board1.txt board2.txt 2
                 Input: xxxWWxxxxWxxxxxxBxBBxxx
                        xWWxxxxxxWxxxxxxBWxxxxx	    
                 Output:      Board Position : xxxWWWxxxWxxxxxxxxxxxxx
                                     Positions evaluated by static estimation : 399
                                    MiniMax estimate : 3 
                              Board Position : WWWxxxxxxWxxxxxxxWxxxxx
                              Positions evaluated by static estimation : 717
                              MiniMax estimate : 4 
MiniMaxGame:   java MiniMaxGame board3.txt board4.txt 3
	 Input: WxWxBWxWWWWxBWxBxBBxBxx 
                 Output:     Board Position : xWWxBWxWWWWxBWxBxBBxBxx
                             Positions evaluated by static estimation : 485
                             MiniMax estimate : 1992
MiniMaxGameImproved :  java MiniMaxGameImproved board3.txt board4.txt 3
                Input: WxWxBWxWWWWxBWxBxBBxBxx	 
                Output  : Board Position : WWxxBWxWWWWxBWxBxBBxBxx
                             Positions evaluated by static estimation : 485
                             MiniMax estimate : -1008	
