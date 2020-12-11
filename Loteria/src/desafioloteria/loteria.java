package desafioloteria;

import java.util.Scanner;

public class loteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a quantidade de números que deseja apostar (6-10):");
		int qtd = sc.nextInt();
		int tentativas = 0;
		int numerosIguais = 0;
		int qtdAposta = 0;
		
		int[] arrayApostado = new int[qtd]; 
		int[] arrayTentativas = new int[qtd];
		
		if (qtd < 6 || qtd > 10) {
			System.out.println("Você não pode sortear "+qtd+" números.");
		} else {
			for(int i = 0; i < qtd; i++) {
				System.out.println("Informe o "+(i+1)+"º número(1-60):");
				arrayApostado[i] = sc.nextInt();
				
				//checa se o número digitado já foi informado ou não está no intervalo de 1-60
				for (int j = 0; j < i; j++) {
					if (arrayApostado[i] == arrayApostado[j]) {
						System.out.println("Número já informado, informe o "+(i+1)+"º número novamente:");
						arrayApostado[i] = sc.nextInt();
					}
					if (arrayApostado[i] <= 0 || arrayApostado[i] > 60) {
						System.out.println("Informe somente números de 1 a 60. Digite o "+(i+1)+"º número novamente:");
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
		System.out.println("Deseja testar quantos números? (4-10)");
		qtdAposta = sc.nextInt();
			
		//checa se é possivel testar a quantidade de números que o usuário deseja
		if (qtdAposta < 4 || qtdAposta > 10) {
			System.out.println("Você só pode testar entre (4-10). Digite novamente:");
			qtdAposta = sc.nextInt();
		}
		if (qtdAposta > qtd) {
			System.out.println("A sua aposta tem "+qtd+" números. Informe um número menor:");
			qtdAposta = sc.nextInt();
		}
			
		int acertos[] = new int[qtd];
			
		System.out.println();
			
		do {
			//zera as varíaveis que amarzenam os números acertados e a quantidade de acertos das tentativas anteriores
			numerosIguais = 0;
			
			for (int i = 0; i < acertos.length; i++) {
				acertos[i] = 0;
			}
				
			for(int i = 0; i < qtd; i++) {
				arrayTentativas[i] = (int) (Math.random() * 59) + 1;
					
				for (int j = 0; j < i; j++) {
					//checa se o número já foi sorteado e se sim, sorteia novamente
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
					//armazena todos os números iguais ao número apostado em um array para exibir ao final
					if (arrayApostado[i] == arrayTentativas[j]) {
						numerosIguais++;
						acertos[i] = arrayTentativas[j];
					}
				}
			}
			
			tentativas++;
							
		} while (numerosIguais != qtdAposta);
		
		System.out.println();
		
		//exibe o número que o usuário apostou
		System.out.println("Número Apostado:");
		for (int i = 0; i < arrayApostado.length; i++) {
			System.out.print(arrayApostado[i]+".");
		}
		
		System.out.println();
		System.out.println();
		
		//exibe o número sorteado pelo programa que tem a quantidade de acertos que o usuário determinou
		System.out.println("Número Sorteado:");
		for (int i = 0; i < arrayTentativas.length; i++) {
			System.out.print(arrayTentativas[i]+".");
		}
		
		System.out.println();
		System.out.println();
		
		//exibe os números iguais do sorteio e da aposta
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
