import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	public void menu() {
		System.out.println("=================");
		System.out.println("|  Tic-Jag-Toe  |");
		System.out.println("| 1. Login      |");
		System.out.println("| 2. Register   |");
		System.out.println("| 3. Exit       |");
		System.out.println("=================");
		System.out.print("Choose [1-3] >>");

	}
	public void gamemenu() {
		System.out.println("==================");
		System.out.println("|  Tic-Jag-Toe   |");
		System.out.println("| 1. Play        |");
		System.out.println("| 2. Scoreboard  |");
		System.out.println("| 3. Back        |");
		System.out.println("==================");
		System.out.print("Choose [1-3] >>");

	}
	public void playmenu(String name1,int score) {
		System.out.println("=================");
		System.out.println("|  PLAYER DETAIL  |");
		System.out.println("=================");
		System.out.printf("|   Name: %s      |\n",name1);
		System.out.printf("|   Score %d      |\n",score);
		System.out.println("=================");
		System.out.println("|  1. Easy        |");
		System.out.println("|  2. Hard        |");
		System.out.println("|  3. PvP         |");
		System.out.println("|  4. Back        |");
		System.out.println("=================");
		System.out.print("Choose [1-3] >>");

	}
	public void reset(char[]board) {
		 board[0]='1';
		 board[1]='2';
		 board[2]='3';
		 board[3]='4';
		 board[4]='5';
		 board[5]='6';
		 board[6]='7';
		 board[7]='8';
		 board[8]='9';
	}
	 static void ticjagtoe(char[] board)
	    {
	        System.out.println("|   |   |   |");
	        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
	        System.out.println("|-----------|");
	        System.out.println("| " + board[3] + " | "
	                           + board[4] + " | " + board[5]
	                           + " |");
	        System.out.println("|-----------|");
	        System.out.println("| " + board[6] + " | "
	                           + board[7] + " | " + board[8]
	                           + " |");
	        System.out.println("|   |   |   |");
	    }
	 static char checkwin(char[] board) {
		 for(int i=0;i<9;i=i+3) {
			 if(board[i]==board[i+1]&& board[i]==board[i+2]) {
				return board[i]; 
			 }
		 }
		 for(int j=0;j<3;j++) {
			 if(board[j]==board[j+3]&& board[j]==board[j+6]) {
				return board[j]; 
			 }
		 }
		 if(board[0]==board[4]&& board[0]==board[8]) {
			 return board[0];
		 }
		 if(board[2]==board[4]&& board[2]==board[6]) {
			 return board[2];
		 }
		 return ' ';
		 }
	static int checkfreespace(char[] board) {
		for(int i=0;i<9;i++) {
			if(board[i]!='X' && board[i]!='O') {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Main obj= new Main();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> pass = new ArrayList<String>();
		ArrayList<Integer> score = new ArrayList<Integer>();
		String name1;
		String pass1;
		String name2;
		String pass2;
		Integer a;
		int zeros=0;
		int totalname=0;
		String zero="0";
		int score1=0;
		char[] board= {'1','2','3','4','5','6','7','8','9'};

		int indexlogin=0;
		int indexloginpvp=0;
		do {
		int menuz=0;
		obj.menu();
		a= scan.nextInt();
		scan.nextLine();
		if(a==1) {
			int correct=0;
			do {
			System.out.print("Input name [type '0' to go back]: ");
			name1=scan.nextLine();
			
			System.out.print("Input password [type '0' to go back]: ");
			pass1 = scan.nextLine();
			
			if(name1.equals(zero)||pass1.equals(zero)){
				menuz=1;
				break;
			}
			for(int i=0;i<totalname;i++) {
				if(name.get(i).equals(name1) && pass.get(i).equals(pass1)) {
					correct=1;
					indexlogin=i;
				}	
			}
			}while(correct==0);
			if(menuz==0){
			correct=0;
			int menucheck=0;
			do {
			menucheck=0;
			obj.gamemenu();
			int b= scan.nextInt();
			scan.nextLine();
			int p;
			if(b==1) {
				obj.playmenu(name1,score1);
				p=scan.nextInt();
				scan.nextLine();
				if(p==1) {
					obj.reset(board);
					int choose=0;
					ticjagtoe(board);
					System.out.println("Your Moves: ");				
					double rand=0;
					int nel=0;
					do {
					if(nel==0) {
					rand=Math.floor(Math.random()*(10-1+1)+1);
					}
					nel++;
					if(checkfreespace(board)==1||checkwin(board)!=' ') {
						break;
					}
					if(rand>5) {
						//player move
						do {
						System.out.print("Choose [1-9] >> ");
						choose=scan.nextInt();
						scan.nextLine();
						 if(board[choose-1]=='O' || board[choose-1]=='X') {
							 choose=0;
						 }
						}while(choose<1 ||choose>9);
						board[choose-1]='X';
						rand=1.0;

					}else {
						double rand1=0;
						int rand1a=0;
						do {
						rand1=Math.floor(Math.random()*(9-1+1)+1);
						rand1a=(int)rand1;
						}while(board[rand1a-1]=='O' || board[rand1a-1]=='X');
						board[rand1a-1]='O';
						rand=9.0;
						System.out.println(checkfreespace(board));
					}
					ticjagtoe(board);
					}while(checkwin(board)==' '&&checkfreespace(board)==0);
					if(checkwin(board)=='X') {
						score.set(indexlogin, score.get(indexlogin)+10);
						System.out.println("[*]Player Wins!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)=='O'){
						System.out.println("You lose!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)==' '){
						System.out.println("TIE!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}
				}else if(p==2) {
					obj.reset(board);
					int chooseh=0;
					ticjagtoe(board);
					System.out.println("Your Moves: ");				
					double randh=0;
					int nelh=0;
					do {
					if(nelh==0) {
					randh=Math.floor(Math.random()*(10-1+1)+1);
					}
					nelh++;
					if(checkfreespace(board)==1||checkwin(board)!=' ') {
						break;
					}
					if(randh>5) {
						//player move
						do {
						System.out.print("Choose [1-9] >> ");
						chooseh=scan.nextInt();
						scan.nextLine();
						 if(board[chooseh-1]=='O' || board[chooseh-1]=='X') {
							 chooseh=0;
						 }
						}while(chooseh<1 ||chooseh>9);
						board[chooseh-1]='X';
						randh=1.0;
						if(checkfreespace(board)==1||checkwin(board)!=' ') {
							break;
						}
					}else {
						int donez=0;
						if(nelh==1) {
							double randh1=0;
							randh1 = Math.floor(Math.random()*(20-1+1)+1);
							if(randh1<6) {
								board[0]='O';
								donez=1;
							}else if(randh1<11) {
								board[2]='O';
								donez=1;
							}else if(randh1<16) {
								board[6]='O';
								donez=1;
							}else{
								board[8]='O';
								donez=1;
							}
						}
				
						
						//ke2
						if(nelh==2) {
							if(board[4]!='X') {
								board[4]='O';
								donez=1;
							}
						}
						//jika lain
						//attack
						//horizontal
						if(donez==0) {
						for(int i=0;i<9;i=i+3) {
						 if(board[i]==board[i+1]&& board[i]=='O' &&board[i+2]!='X') {
							board[i+2]='O';
							donez=1;
						 }else if(board[i]==board[i+2]&& board[i]=='O'&&board[i+1]!='X') {
							 board[i+1]='O';
							 donez=1;
						 }else if(board[i+1]==board[i+2]&& board[i+1]=='O'&&board[i]!='X') {
							 board[i]='O';
							 donez=1;
						 }
						}
						}
		
					
//						vertikal bermasalah
						if(donez==0) {
							for(int i=0;i<3;i++) {
							 if(board[i]==board[i+3]&& board[i]=='O' &&board[i+6]!='X') {
								board[i+6]='O';
								donez=1;
							 }else if(board[i]==board[i+6]&& board[i]=='O'&&board[i+3]!='X') {
								 board[i+3]='O';
								 donez=1;
							 }else if(board[i+3]==board[i+6]&& board[i+3]=='O'&&board[i]!='X') {
								 board[i]='O';
								 donez=1;
							 }
							}
						}
				
						//diagonal
						if(donez==0) {
						 if(board[0]==board[4]&& board[0]=='O'&& board[8]!='X') {
							 //diag kanan
							 board[8]='O';
							 donez=1;
						 }else if(board[0]==board[8]&& board[0]=='O'&& board[4]!='X') {
							 board[4]='O';
							 donez=1;
						 }else if(board[4]==board[8]&& board[0]=='O'&& board[0]!='X') {
							 board[0]='O';
							 donez=1;
						 }else if(board[2]==board[4]&&board[2]=='O'&& board[6]!='X') {
							 //diag kiri
							board[6]='O';
							donez=1;
						 }else if(board[2]==board[6]&&board[2]=='O'&& board[4]!='X') {
							board[4]='O';
							donez=1;
						 }else if(board[6]==board[4]&&board[4]=='O'&& board[2]!='X') {
							 board[2]='O';		
							 donez=1;
						 }
						}
					
						//defend
						//horizontal
						if(donez==0) {
						for(int i=0;i<9;i=i+3) {
						 if(board[i]==board[i+1]&& board[i]=='X' &&board[i+2]!='O') {
							board[i+2]='O';
							donez=1;
						 }else if(board[i]==board[i+2]&& board[i]=='X'&&board[i+1]!='O') {
							 board[i+1]='O';
							 donez=1;
						 }else if(board[i+1]==board[i+2]&& board[i+1]=='X'&&board[i]!='O') {
							 board[i]='O';
							 donez=1;
						 }
						}
						}
					
						//vertikal
						if(donez==0) {
						for(int i=0;i<3;i++) {
						 if(board[i]==board[i+3]&& board[i]=='X' &&board[i+6]!='O') {
							board[i+6]='O';
							donez=1;
						 }else if(board[i]==board[i+6]&& board[i]=='X'&&board[i+3]!='O') {
							 board[i+3]='O';
							 donez=1;
						 }else if(board[i+3]==board[i+6]&& board[i+3]=='X'&&board[i]!='O') {
							 board[i]='O';
							 donez=1;
						 }
						}							
						}
						//diagonal
						if(donez==0) {
						 if(board[0]==board[4]&& board[0]=='X'&& board[8]!='O') {
						 //diag kanan
							 board[8]='O';
							 donez=1;
						 }else if(board[0]==board[8]&& board[0]=='X'&& board[4]!='O') {
							 board[4]='O';
							 donez=1;
						 }else if(board[4]==board[8]&& board[4]=='X'&& board[0]!='O') {
							 board[0]='O';
							 donez=1;
						 }else if(board[2]==board[4]&&board[2]=='X'&& board[6]!='O') {
							 //diag kiri
							board[6]='O';
							 donez=1;
						 }else if(board[2]==board[6]&&board[2]=='X'&& board[4]!='O') {
							board[4]='O';
							 donez=1;
						 }else if(board[6]==board[4]&&board[4]=='X'&& board[2]!='O') {
							 board[2]='O';
							 donez=1;
						 }
						}

						if(donez==0) {
							double rand2=0;
							int rand2a=0;
							do {
								rand2=Math.floor(Math.random()*(9-1+1)+1);
								rand2a=(int)rand2;
							}while(board[rand2a-1]=='O' || board[rand2a-1]=='X');
							board[rand2a-1]='O';
						}
						randh=9.0;
						if(checkfreespace(board)==1||checkwin(board)!=' ') {
							break;
						}

					}
					ticjagtoe(board);
					}while(checkwin(board)==' '&&checkfreespace(board)==0);
					if(checkwin(board)=='X') {
						score.set(indexlogin, score.get(indexlogin)+100);
						System.out.println("[*]Player Wins!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)=='O'){
						if((score.get(indexlogin)-10)>0) {
						score.set(indexlogin, score.get(indexlogin)-10);
						}else {
							score.set(indexlogin, 0);
						}
						System.out.println("You lose!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)==' '){
						System.out.println("TIE!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}
				}else if(p==3) {
					//LOGIN
					obj.reset(board);
					do {
						System.out.print("Input name [type '0' to go back]: ");
						name2=scan.nextLine();
						
						System.out.print("Input password [type '0' to go back]: ");
						pass2 = scan.nextLine();
						
						if(name2.equals(zero)||pass2.equals(zero)){
							break;
						}
						for(int i=0;i<totalname;i++) {
							if(name.get(i).equals(name2) && pass.get(i).equals(pass2)&&name.get(i).equals(name1)==false) {
								correct=1;
								indexloginpvp=i;
							}	
						}
						}while(correct==0);
						if(name2.equals(zero)||pass2.equals(zero)){
							break;
						}
						correct=0;
						int choosep=0;
						ticjagtoe(board);
						//play
						int ganti=0;
						double randz=0;
						do {
							if(ganti==0) {
							randz=Math.floor(Math.random()*(10-1+1)+1);
							}
							ganti++;
							if(checkfreespace(board)==1||checkwin(board)!=' ') {
								break;
							}
							if(randz>5) {
								//name1 move
								do {
									System.out.printf("%s turn\n",name1);
								System.out.print("Choose [1-9] >> ");
								choosep=scan.nextInt();
								scan.nextLine();
								 if(board[choosep-1]=='O' || board[choosep-1]=='X') {
									 choosep=0;
								 }
								}while(choosep<1 ||choosep>9);
								board[choosep-1]='X';
								randz=1.0;
								if(checkfreespace(board)==1||checkwin(board)!=' ') {
									break;
								}
							}else {
								do {
									System.out.printf("%s turn\n",name2);
									System.out.print("Choose [1-9] >> ");
									choosep=scan.nextInt();
									scan.nextLine();
									 if(board[choosep-1]=='O' || board[choosep-1]=='X') {
										 choosep=0;
									 }
									}while(choosep<1 ||choosep>9);
									board[choosep-1]='O';
									randz=9.0;
									if(checkfreespace(board)==1||checkwin(board)!=' ') {
										break;
									}
							}
							ticjagtoe(board);

							}while(checkwin(board)==' '&&checkfreespace(board)==0);
					if(checkwin(board)=='X') {
						if((score.get(indexloginpvp)-10)>0) {
							score.set(indexloginpvp, score.get(indexloginpvp)-10);
						}else {
							score.set(indexloginpvp, 0);
						}
						score.set(indexlogin, score.get(indexlogin)+10);
						System.out.printf("[*]%s Wins!\n",name1);
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)=='O'){
						if((score.get(indexlogin)-10)>0) {
							score.set(indexlogin, score.get(indexlogin)-10);
						}else {
							score.set(indexlogin, 0);
						}
						score.set(indexloginpvp, score.get(indexloginpvp)+10);
						
						System.out.printf("[*]%s Wins!\n",name2);
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}else if(checkwin(board)==' '){
						System.out.println("TIE!");
						System.out.print("Press Enter to continue");
						scan.nextLine();
					}
				}
			}else if(b==2) {
				System.out.println("Name  |  Score");
				for(int j=0;j<totalname;j++) {
				System.out.print(name.get(j));
				System.out.print(" | ");
				System.out.println(score.get(j));
				}
			}else if(b==3) {
				menucheck=1;
			}
			}while(menucheck==0);
			}
		}else if(a==2) {
			String s1;
			String s2;
			int length1=0;
			int length2=0;
			do {
				System.out.print("Input name to play[more than 3 and less than 15 characters]: ");
				s1 = scan.nextLine();
				
				length1 = s1.length();
			}while(length1<=3 || length1>=15);
			name.add(s1);
			do {
				System.out.print("Input password[more than 5 characters]: ");
				s2 = scan.nextLine();
				length2 = s2.length();
				}while(length2<5);
			pass.add(s2);
			score.add(zeros);
			
			totalname+=1;
			System.out.println("[*] Successfully registered an account");
			System.out.print("Press enter to continue...");
			scan.nextLine();

		}else if(a==3) {
			System.out.println("Thankyou for playing");
			System.exit(0);
		}
	}while(a!=3);
	}//penutup 2

}//penutup1
