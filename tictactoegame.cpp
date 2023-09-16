#include <stdio.h>

struct data{
	char name[50];
};
char board[4][4];
	int win=0;
	
void reset();
void munculkan();
void player1();
void player2();
int checkFreeSpaces();
char checkwin();

int main(){
	char y;
	struct data data[5];
	FILE *fp=fopen("testdata.txt","w+");
	int count=0;
	do{
		printf("Multiplayer TIC TAC TOE!\n");
		count++;
		printf("Input your name (Player 1): ");
		scanf("%[^\n]",data[1].name);
		getchar();
		printf("Input your name (Player 2): ");
		scanf("%[^\n]",data[2].name);
		getchar();
		printf("Hi %s and %s!, Enjoy the game!\n\n",data[1].name,data[2].name);
		char winner= ' ';
		reset();	
		do{
			munculkan();
			printf("%s = X, %s = O\n",data[1].name,data[2].name);
			printf("Tempat yang kosong: %d\n",checkFreeSpaces());
			player1();
			winner = checkwin();
			if(winner != ' '||checkFreeSpaces() == 0){
				break;
			}
			munculkan();
			player2();
			winner = checkwin();
			if(winner != ' '||checkFreeSpaces() == 0){
				break;
			}
		}while(checkFreeSpaces != 0 || winner != ' ');
		
		fprintf(fp,"%d. %s ",count,data[1].name);
		if(checkwin()== 'X'){
			printf("Congrats %s, You win\n",data[1].name);
			fprintf(fp,"- win\n%s - lose\n",data[2].name);
		}
		else if(checkwin() == 'O'){
			printf("Congrats %s, You win\n",data[2].name);
			fprintf(fp,"- lose\n%s - win\n",data[2].name);
		}
		else{
			printf("TIE!\n");
			fprintf(fp,"- tie\n%s - tie\n",data[2].name);
		}
		//new game
		printf("New Game \? (Y/N)  ");
		scanf("%c",&y);
		getchar();
		if(y>='a' && y<='z'){
			y=y-32;
		}
	}while(y== 'Y');
	
	printf("Thankyou!\n");
	fclose(fp);
	return 0;
}
	
void reset(){
	board[1][1]='1';
	board[1][2]='2';
	board[1][3]='3';
	board[2][1]='4';
	board[2][2]='5';
	board[2][3]='6';
	board[3][1]='7';
	board[3][2]='8';
	board[3][3]='9';
}
void munculkan(){
	printf(" %c | %c | %c ",board[1][1],board[1][2],board[1][3]);
	printf("\n---|---|---\n");
	printf(" %c | %c | %c ",board[2][1],board[2][2],board[2][3]);
	printf("\n---|---|---\n");
	printf(" %c | %c | %c ",board[3][1],board[3][2],board[3][3]);
	printf("\n");
}

void player1(){
	char a;
	int i,j,h=0;
	do{
		printf("Pilih sebuah angka (Player 1): ",player1);
		scanf("%c",&a);
		getchar();
		for(i=1;i<=3;i++){
			for(j=1;j<=3;j++){
				if(a==board[i][j]){
					h=1;
					break;	
				}
			}
			if(h==1){
				break;
			}
		}
		if(h==0){
			printf("Input angka yang tersedia!\n");
		}	
	}while(h==0);
	//check apakah sudah ada atau tidak
    board[i][j]='X';
}
  


void player2(){
	char a;
	int i,j,h=0;
	do{
		printf("Pilih sebuah angka (Player 2): ",player2);
		scanf("%c",&a);
		getchar();
		for(i=1;i<=3;i++){
			for(j=1;j<=3;j++){
				if(a==board[i][j]){
					h=1;
					break;	
				}
			}
			if(h==1){
				break;
			}
		}
		if(h==0){
			printf("Input angka yang tersedia!\n");
		}	
	}while(h==0);
	//check apakah sudah ada atau tidak
    board[i][j]='O';
}
	
int checkFreeSpaces(){
	int freeSpaces = 9;
	for(int i = 1; i <= 3; i++){
    	for(int j = 1; j <= 3; j++){
        	if(board[i][j]=='X' || board[i][j]=='O'){
            	freeSpaces--;
         	}
      	}
   	}
   	return freeSpaces;
}

char checkwin(){
   //check rows
	for(int i = 1; i <= 3; i++){
		if(board[i][1] == board[i][2] && board[i][1] == board[i][3]){
        	return board[i][1];
      	}
   	}
   //check columns
	for(int i = 1; i <= 3; i++){
    	if(board[1][i] == board[2][i] && board[1][i] == board[3][i]){
         return board[1][i];
    	}
	}
   //check diagonals
	if(board[1][1] == board[2][2] && board[1][1] == board[3][3]){
    	return board[1][1];
	}
	if(board[1][3] == board[2][2] && board[1][3] == board[3][1]){
    	return board[1][3];
	}
	return ' ';
}

