/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corridadegrilo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Eliseu, Lucas, Marcelino
 */
public class CorridaDeGrilo {
    
    public static class Equipe{
        int id;
	int distanciaPercorrida;
	int totalPulos;
    }

    public static void main(String[] args) {
        
        Equipe[] equipes;
        //pegando os inputs
            //pegando a quantidade de grilos
        System.out.print("Quantos grilos devem correr? ");
        Scanner scan = new Scanner(System.in);
        int quantGrilos = scan.nextInt();
            //pegando a posição da linha de chegada
        System.out.print("Qual a distancia para a chegada? ");
        int distanciaTotal = scan.nextInt();
        
        int grilosPorEquipe = 3;
        int quantEquipes = quantGrilos / grilosPorEquipe;

        equipes = new Equipe[quantEquipes];

        for (int i = 0; i < quantEquipes; i++)
        {
            equipes[i] = new Equipe();
            equipes[i].id = i;
        }
        
        //instanciando os grilos e armazenando em um array
        Grilo[] grilos = new Grilo[quantGrilos];
        for (int i = 0; i < quantGrilos; i++)
        {
            grilos[i] = new Grilo((i+1), distanciaTotal);
        }
        
        //executando as threads
        for (Grilo g : grilos)
            g.start();
        
        //aguardando as threads terminarem
        for (Grilo g : grilos)
        {
            try {
                g.join();
            } catch (InterruptedException ex) {
                System.out.println("Deu merda no join das threads.");
            }
        }
        
        //imprimindo o resultado final
        for (int i = 0; i < quantGrilos; i++)
		{
			idEquipe = grilo[i].id;
			equipe[idEquipe].distanciaPercorrida += grilo[i].getPosicao();
			equipe[idEquipe].totalPulos += grilo[i].getPulos();
		}
		
		for (int i = 0; i < quantEquipes; i++)
		{
			System.out.println(“Time “ + (i + 1) + “: Total de Pulos: “ + equipe[i].totalPulos + “ -   
                                   Distancia percorrida: “ + equipe[i].distanciaPercorrida);
		}
		
		int equipeVencedora;
		for(int i = 0; i < quantGrilos; i++){
			if (grilo.posicaoChegada == 1)
					equipeVencedora = equipes[ grilo[i].idEquipe ]
		}
		
		System.out.println(“Time “ + equipeVencedora + “ foi o vencedor.”);
    }
}
