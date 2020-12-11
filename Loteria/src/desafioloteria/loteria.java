package desafioloteria;

import java.util.Scanner;

public class loteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a quantidade de n�meros que deseja apostar (6-10):");
		int qtd = sc.nextInt();
		int tentativas = 0;
		int numerosIguais = 0;
		int qtdAposta = 0;
		
		int[] arrayApostado = new int[qtd]; 
		int[] arrayTentativas = new int[qtd];
		
		if (qtd < 6 || qtd > 10) {
			System.out.println("Voc� n�o pode sortear "+qtd+" n�meros.");
		} else {
			for(int i = 0; i < qtd; i++) {
				System.out.println("Informe o "+(i+1)+"� n�mero(1-60):");
				arrayApostado[i] = sc.nextInt();
				
				//checa se o n�mero digitado j� foi informado ou n�o est� no intervalo de 1-60
				for (int j = 0; j < i; j++) {
					if (arrayApostado[i] == arrayApostado[j]) {
						System.out.println("N�mero j� informado, informe o "+(i+1)+"� n�mero novamente:");
						arrayApostado[i] = sc.nextInt();
					}
					if (arrayApostado[i] <= 0 || arrayApostado[i] > 60) {
						System.out.println("Informe somente n�meros de 1 a 60. Digite o "+(i+1)+"� n�mero novamente:");
						arrayApostado[i] = sc.nextInt();
					}
				}
			}
		}
			
		System.out.println("Sua aposta:");
		
		for (int i = 0; i < arrayApostado.length; i++) {
			System.out.print(arrayApostado[i]+".");
		}
			
		System.out.println();
		System.out.println("Deseja testar quantos n�meros? (4-10)");
		qtdAposta = sc.nextInt();
			
		//checa se � possivel testar a quantidade de n�meros que o usu�rio deseja
		if (qtdAposta < 4 || qtdAposta > 10) {
			System.out.println("Voc� s� pode testar entre (4-10). Digite novamente:");
			qtdAposta = sc.nextInt();
		}
		if (qtdAposta > qtd) {
			System.out.println("A sua aposta tem "+qtd+" n�meros. Informe um n�mero menor:");
			qtdAposta = sc.nextInt();
		}
			
		int acertos[] = new int[qtd];
			
		System.out.println();
			
		do {
			//zera as var�aveis que amarzenam os n�meros acertados e a quantidade de acertos das tentativas anteriores
			numerosIguais = 0;
			
			for (int i = 0; i < acertos.length; i++) {
				acertos[i] = 0;
			}
				
			for(int i = 0; i < qtd; i++) {
				arrayTentativas[i] = (int) (Math.random() * 59) + 1;
					
				for (int j = 0; j < i; j++) {
					//checa se o n�mero j� foi sorteado e se sim, sorteia novamente
					if (arrayTentativas[i] == arrayTentativas[j]) {
						arrayTentativas[i] = (int) (Math.random() * 59) + 1;
					}
				}
			}
			for(int i = 0; i < arrayTentativas.length; i++) {
				System.out.print(arrayTentativas[i]+".");		
			}
				
			System.out.println();
							
			for (int i = 0; i < arrayApostado.length; i++) {
				for (int j = 0; j < arrayTentativas.length; j++) {
					//armazena todos os n�meros iguais ao n�mero apostado em um array para exibir ao final
					if (arrayApostado[i] == arrayTentativas[j]) {
						numerosIguais++;
						acertos[i] = arrayTentativas[j];
					}
				}
			}
			
			tentativas++;
							
		} while (numerosIguais != qtdAposta);
		
		System.out.println();
		
		//exibe o n�mero que o usu�rio apostou
		System.out.println("N�mero Apostado:");
		for (int i = 0; i < arrayApostado.length; i++) {
			System.out.print(arrayApostado[i]+".");
		}
		
		System.out.println();
		System.out.println();
		
		//exibe o n�mero sorteado pelo programa que tem a quantidade de acertos que o usu�rio determinou
		System.out.println("N�mero Sorteado:");
		for (int i = 0; i < arrayTentativas.length; i++) {
			System.out.print(arrayTentativas[i]+".");
		}
		
		System.out.println();
		System.out.println();
		
		//exibe os n�meros iguais do sorteio e da aposta
		System.out.println("Acertos:");
		for (int i = 0; i < acertos.length; i++) {
			if (acertos[i] != 0) {
				System.out.print(acertos[i]+".");
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Quantidade de tentativas: "+tentativas);
		
	}

}
